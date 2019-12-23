package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.SubscriptionDTO;
import org.enargit.karaf.core.entities.Subscription;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface SubscriptionMapper extends BaseMapper  {

        List<Subscription> convertToEntityList(List<SubscriptionDTO> dtoList);

        List<SubscriptionDTO> convertToDTOList(List<Subscription> entityList);

        Set<Subscription> convertToEntitySet(Set<SubscriptionDTO> dtoSet);
        
        Set<SubscriptionDTO> convertToDTOSet(Set<Subscription> entitySet);

        Subscription convertToEntity(SubscriptionDTO dto);

        SubscriptionDTO convertToDTO(Subscription entity);

        Page<Subscription> convertToEntityPage(Page<SubscriptionDTO> dtoPage);

        Page<SubscriptionDTO> convertToDTOPage(Page<Subscription> entityPage);

}
