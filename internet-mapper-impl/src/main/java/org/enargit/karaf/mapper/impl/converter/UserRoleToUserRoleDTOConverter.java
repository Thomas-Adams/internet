package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.entities.UserRole;
import org.modelmapper.AbstractConverter;

public class UserRoleToUserRoleDTOConverter extends AbstractConverter<UserRole, UserRoleDTO> {

    private int level;

    public UserRoleToUserRoleDTOConverter(int level) {
        this.level = level;
    }

    public UserRoleToUserRoleDTOConverter() {
        this.level = 0;
    }

    @Override
    protected UserRoleDTO convert(UserRole source) {
        UserRoleDTO.UserRoleDTOBuilder builder = UserRoleDTO.builder()
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.role(new RoleToRoleDTOConverter(this.level + 1).convert(source.getRole()))
                    .user(new UserToUserDTOConverter(this.level + 1).convert(source.getUser()));

        }
        return builder.build();
    }
}
