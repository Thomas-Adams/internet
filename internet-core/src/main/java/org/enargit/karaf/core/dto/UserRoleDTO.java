package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class UserRoleDTO extends BasicDTO<Long> {


    @JsonBackReference("role-user-role-dto")
    private RoleDTO role;

    @JsonBackReference("user-user-roles-dto")
    private UserDTO user;

}
