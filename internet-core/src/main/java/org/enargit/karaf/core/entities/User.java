package org.enargit.karaf.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;
import org.joda.time.Days;
import org.joda.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "users")
public class User extends BasicEntity<Long>  {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private static final int CREDENTIAL_EXPIRATION_IN_DAYS = 90;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @JsonIgnore
    @NotNull
    @Size(min = MINIMUM_PASSWORD_LENGTH, max = 255)
    @Column(nullable = false, length = 255)
    private String password;

    @NotNull
    @Size(min = 1, max = 100)
    @Email
    @Column(nullable = false, length = 100)
    private String email;

    @Size(max = 30)
    @Column(nullable = true, length = 30)
    private String mobile;

    @NotNull
    @Column(nullable = false)
    private boolean enabled;

    @NotNull
    @Column(nullable = false)
    private boolean locked;

    @NotNull
    @Column(nullable = false)
    private boolean expired;

    @Column(nullable = true, length = 255)
    private String accessToken;

    @Column(nullable = true, length = 255)
    private String refreshToken;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date lastChangeCredentials;

    @Column(nullable = true)
    private Date lastLogin;

    @Override
    @PrePersist
    public void prePersist() {
        if (lastChangeCredentials == null) {
            lastChangeCredentials = new Date();
        }
        super.prePersist();

    }

    @JsonManagedReference("user-profile")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private Profile profile;

    @JsonManagedReference("user-user-roles")
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserRole> userRoles = new ArrayList<>(0);




    public boolean isAccountNonExpired() {
        return !expired;
    }

    public boolean isAccountNonLocked() {
        return !locked;
    }

    public boolean isCredentialsNonExpired() {
        return lastChangeCredentials !=
                null && Days.daysBetween(new Instant(lastChangeCredentials.getTime()) ,Instant.now()).isGreaterThan(Days.days(CREDENTIAL_EXPIRATION_IN_DAYS)) ;
    }
}
