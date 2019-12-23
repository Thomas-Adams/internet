package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.CampaignAttributesDTO;
import org.enargit.karaf.core.entities.CampaignAttributes;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface CampaignAttributesMapper extends BaseMapper  {

        List<CampaignAttributes> convertToEntityList(List<CampaignAttributesDTO> dtoList);

        List<CampaignAttributesDTO> convertToDTOList(List<CampaignAttributes> entityList);

        Set<CampaignAttributes> convertToEntitySet(Set<CampaignAttributesDTO> dtoSet);
        
        Set<CampaignAttributesDTO> convertToDTOSet(Set<CampaignAttributes> entitySet);

        CampaignAttributes convertToEntity(CampaignAttributesDTO dto);

        CampaignAttributesDTO convertToDTO(CampaignAttributes entity);

        Page<CampaignAttributes> convertToEntityPage(Page<CampaignAttributesDTO> dtoPage);

        Page<CampaignAttributesDTO> convertToDTOPage(Page<CampaignAttributes> entityPage);

}
