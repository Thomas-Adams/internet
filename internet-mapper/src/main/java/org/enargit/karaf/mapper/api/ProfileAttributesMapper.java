package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.ProfileAttributesDTO;
import org.enargit.karaf.core.entities.ProfileAttributes;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface ProfileAttributesMapper extends BaseMapper  {

        List<ProfileAttributes> convertToEntityList(List<ProfileAttributesDTO> dtoList);

        List<ProfileAttributesDTO> convertToDTOList(List<ProfileAttributes> entityList);

        Set<ProfileAttributes> convertToEntitySet(Set<ProfileAttributesDTO> dtoSet);
        
        Set<ProfileAttributesDTO> convertToDTOSet(Set<ProfileAttributes> entitySet);

        ProfileAttributes convertToEntity(ProfileAttributesDTO dto);

        ProfileAttributesDTO convertToDTO(ProfileAttributes entity);

        Page<ProfileAttributes> convertToEntityPage(Page<ProfileAttributesDTO> dtoPage);

        Page<ProfileAttributesDTO> convertToDTOPage(Page<ProfileAttributes> entityPage);

}
