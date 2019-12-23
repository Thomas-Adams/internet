package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.entities.WidgetProperties;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface WidgetPropertiesMapper extends BaseMapper  {

        List<WidgetProperties> convertToEntityList(List<WidgetPropertiesDTO> dtoList);

        List<WidgetPropertiesDTO> convertToDTOList(List<WidgetProperties> entityList);

        Set<WidgetProperties> convertToEntitySet(Set<WidgetPropertiesDTO> dtoSet);
        
        Set<WidgetPropertiesDTO> convertToDTOSet(Set<WidgetProperties> entitySet);

        WidgetProperties convertToEntity(WidgetPropertiesDTO dto);

        WidgetPropertiesDTO convertToDTO(WidgetProperties entity);

        Page<WidgetProperties> convertToEntityPage(Page<WidgetPropertiesDTO> dtoPage);

        Page<WidgetPropertiesDTO> convertToDTOPage(Page<WidgetProperties> entityPage);

}
