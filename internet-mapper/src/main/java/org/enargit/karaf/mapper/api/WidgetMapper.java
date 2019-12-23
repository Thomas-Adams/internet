package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.WidgetDTO;
import org.enargit.karaf.core.entities.Widget;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface WidgetMapper extends BaseMapper  {

        List<Widget> convertToEntityList(List<WidgetDTO> dtoList);

        List<WidgetDTO> convertToDTOList(List<Widget> entityList);

        Set<Widget> convertToEntitySet(Set<WidgetDTO> dtoSet);
        
        Set<WidgetDTO> convertToDTOSet(Set<Widget> entitySet);

        Widget convertToEntity(WidgetDTO dto);

        WidgetDTO convertToDTO(Widget entity);

        Page<Widget> convertToEntityPage(Page<WidgetDTO> dtoPage);

        Page<WidgetDTO> convertToDTOPage(Page<Widget> entityPage);

}
