package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.entities.Role;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class RoleDTOToRoleConverter extends AbstractConverter<RoleDTO, Role> {

    private int level;

    public RoleDTOToRoleConverter(int level) {
        this.level = level;
    }

    public RoleDTOToRoleConverter() {
        this.level = 0;
    }

    @Override
    protected Role convert(RoleDTO source) {
        return Role.builder()
                .description(source.getDescription())
                .role(source.getRole())
                .userRoles(new ArrayList<>())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion()).build();

    }
}
