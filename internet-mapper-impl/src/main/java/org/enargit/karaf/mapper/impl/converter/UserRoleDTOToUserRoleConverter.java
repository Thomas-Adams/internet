package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.entities.UserRole;
import org.modelmapper.AbstractConverter;

public class UserRoleDTOToUserRoleConverter extends AbstractConverter<UserRoleDTO,UserRole> {

    private int level;

    public UserRoleDTOToUserRoleConverter(int level) {
        this.level = level;
    }

    public UserRoleDTOToUserRoleConverter() {
        this.level = 0;
    }

    @Override
    protected UserRole convert(UserRoleDTO source) {
        UserRole.UserRoleBuilder builder = UserRole.builder()
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.role(new RoleDTOToRoleConverter(this.level + 1).convert(source.getRole()))
                    .user(new UserDTOToUserConverter(this.level + 1).convert(source.getUser()));

        }
        return builder.build();
    }
}
