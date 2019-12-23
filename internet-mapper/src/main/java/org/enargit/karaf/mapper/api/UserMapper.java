package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.UserDTO;
import org.enargit.karaf.core.entities.User;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface UserMapper extends BaseMapper  {

        List<User> convertToEntityList(List<UserDTO> dtoList);

        List<UserDTO> convertToDTOList(List<User> entityList);

        Set<User> convertToEntitySet(Set<UserDTO> dtoSet);
        
        Set<UserDTO> convertToDTOSet(Set<User> entitySet);

        User convertToEntity(UserDTO dto);

        UserDTO convertToDTO(User entity);

        Page<User> convertToEntityPage(Page<UserDTO> dtoPage);

        Page<UserDTO> convertToDTOPage(Page<User> entityPage);

}
