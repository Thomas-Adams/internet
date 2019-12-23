package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.RoleDTO;
import org.enargit.karaf.core.entities.Role;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface RoleMapper extends BaseMapper  {

        List<Role> convertToEntityList(List<RoleDTO> dtoList);

        List<RoleDTO> convertToDTOList(List<Role> entityList);

        Set<Role> convertToEntitySet(Set<RoleDTO> dtoSet);
        
        Set<RoleDTO> convertToDTOSet(Set<Role> entitySet);

        Role convertToEntity(RoleDTO dto);

        RoleDTO convertToDTO(Role entity);

        Page<Role> convertToEntityPage(Page<RoleDTO> dtoPage);

        Page<RoleDTO> convertToDTOPage(Page<Role> entityPage);

}
