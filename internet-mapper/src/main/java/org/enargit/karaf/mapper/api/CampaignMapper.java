package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.CampaignDTO;
import org.enargit.karaf.core.entities.Campaign;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface CampaignMapper extends BaseMapper  {

        List<Campaign> convertToEntityList(List<CampaignDTO> dtoList);

        List<CampaignDTO> convertToDTOList(List<Campaign> entityList);

        Set<Campaign> convertToEntitySet(Set<CampaignDTO> dtoSet);
        
        Set<CampaignDTO> convertToDTOSet(Set<Campaign> entitySet);

        Campaign convertToEntity(CampaignDTO dto);

        CampaignDTO convertToDTO(Campaign entity);

        Page<Campaign> convertToEntityPage(Page<CampaignDTO> dtoPage);

        Page<CampaignDTO> convertToDTOPage(Page<Campaign> entityPage);

}
