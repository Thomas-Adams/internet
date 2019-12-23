package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.ProfileDTO;
import org.enargit.karaf.core.entities.Profile;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface ProfileMapper extends BaseMapper  {

        List<Profile> convertToEntityList(List<ProfileDTO> dtoList);

        List<ProfileDTO> convertToDTOList(List<Profile> entityList);

        Set<Profile> convertToEntitySet(Set<ProfileDTO> dtoSet);
        
        Set<ProfileDTO> convertToDTOSet(Set<Profile> entitySet);

        Profile convertToEntity(ProfileDTO dto);

        ProfileDTO convertToDTO(Profile entity);

        Page<Profile> convertToEntityPage(Page<ProfileDTO> dtoPage);

        Page<ProfileDTO> convertToDTOPage(Page<Profile> entityPage);

}
