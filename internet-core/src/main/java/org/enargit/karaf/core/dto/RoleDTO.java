package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;




@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class RoleDTO extends BasicDTO<Long> {


    @NotNull
    @Size(min = 1, max=60)
    @Pattern(regexp = "^ROLE_.*")
    private String role;

    @Size(max=10485760)
    private String description;


    @Builder.Default
    @JsonManagedReference("role-user-role-dto")
    private List<UserRoleDTO> userRoles = new ArrayList<>(0);


}
