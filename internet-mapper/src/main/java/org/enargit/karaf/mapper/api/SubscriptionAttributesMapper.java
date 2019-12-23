package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.entities.SubscriptionAttributes;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface SubscriptionAttributesMapper extends BaseMapper  {

        List<SubscriptionAttributes> convertToEntityList(List<SubscriptionAttributesDTO> dtoList);

        List<SubscriptionAttributesDTO> convertToDTOList(List<SubscriptionAttributes> entityList);

        Set<SubscriptionAttributes> convertToEntitySet(Set<SubscriptionAttributesDTO> dtoSet);
        
        Set<SubscriptionAttributesDTO> convertToDTOSet(Set<SubscriptionAttributes> entitySet);

        SubscriptionAttributes convertToEntity(SubscriptionAttributesDTO dto);

        SubscriptionAttributesDTO convertToDTO(SubscriptionAttributes entity);

        Page<SubscriptionAttributes> convertToEntityPage(Page<SubscriptionAttributesDTO> dtoPage);

        Page<SubscriptionAttributesDTO> convertToDTOPage(Page<SubscriptionAttributes> entityPage);

}
