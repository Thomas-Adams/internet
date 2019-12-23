package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class UserDTO extends BasicDTO<Long> {


    @NotNull
    @Size(min = 1, max=100)
    private String username;

    @NotNull
    @Size(min = 8, max=36)
    private String password;

    @NotNull
    @Size(min = 1, max=100)
    @Email
    private String email;

    @Size(max=30)
    private String mobile;

    @NotNull
    private boolean enabled;

    @NotNull
    private boolean locked;

    @NotNull
    private boolean expired;

    private String accessToken;

    private String refreshToken;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangeCredentials;


    private ProfileDTO profile;

    @Builder.Default
    @JsonManagedReference("user-user-roles-dto")
    private List<UserRoleDTO> userRoles = new ArrayList<>(0);
}
