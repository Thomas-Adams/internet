package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.UserRoleDTO;
import org.enargit.karaf.core.entities.UserRole;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface UserRoleMapper extends BaseMapper  {

        List<UserRole> convertToEntityList(List<UserRoleDTO> dtoList);

        List<UserRoleDTO> convertToDTOList(List<UserRole> entityList);

        Set<UserRole> convertToEntitySet(Set<UserRoleDTO> dtoSet);
        
        Set<UserRoleDTO> convertToDTOSet(Set<UserRole> entitySet);

        UserRole convertToEntity(UserRoleDTO dto);

        UserRoleDTO convertToDTO(UserRole entity);

        Page<UserRole> convertToEntityPage(Page<UserRoleDTO> dtoPage);

        Page<UserRoleDTO> convertToDTOPage(Page<UserRole> entityPage);

}
