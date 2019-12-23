package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.SelectionListValuesDTO;
import org.enargit.karaf.core.entities.SelectionListValues;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface SelectionListValuesMapper extends BaseMapper  {

        List<SelectionListValues> convertToEntityList(List<SelectionListValuesDTO> dtoList);

        List<SelectionListValuesDTO> convertToDTOList(List<SelectionListValues> entityList);

        Set<SelectionListValues> convertToEntitySet(Set<SelectionListValuesDTO> dtoSet);
        
        Set<SelectionListValuesDTO> convertToDTOSet(Set<SelectionListValues> entitySet);

        SelectionListValues convertToEntity(SelectionListValuesDTO dto);

        SelectionListValuesDTO convertToDTO(SelectionListValues entity);

        Page<SelectionListValues> convertToEntityPage(Page<SelectionListValuesDTO> dtoPage);

        Page<SelectionListValuesDTO> convertToDTOPage(Page<SelectionListValues> entityPage);

}
