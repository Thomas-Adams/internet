package org.enargit.karaf.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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
@Table(name = "profile")
public class Profile extends BasicEntity<Long> {

    @NotNull
    @Size(min = 1, max=50)
    @Column(nullable = false, length=50)
    private String givenName;

    @NotNull
    @Size(min = 1, max=50)
    @Column(nullable = false, length=50)
    private String surName;

    @Column(nullable = true)
    private Date birthday;

    @JsonBackReference("user-profile")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @JsonManagedReference("profile-profile-attributes")
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<ProfileAttributes> attributes = new ArrayList<>(0);


}
