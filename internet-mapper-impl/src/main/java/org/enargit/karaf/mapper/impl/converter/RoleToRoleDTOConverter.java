package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.entities.Role;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class RoleToRoleDTOConverter extends AbstractConverter<Role, RoleDTO> {

    private int level;

    public RoleToRoleDTOConverter(int level) {
        this.level = level;
    }

    public RoleToRoleDTOConverter() {
        this.level = 0;
    }

    @Override
    protected RoleDTO convert(Role source) {
        return RoleDTO.builder()
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
