package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.SelectionListDTO;
import org.enargit.karaf.core.entities.SelectionList;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface SelectionListMapper extends BaseMapper  {

        List<SelectionList> convertToEntityList(List<SelectionListDTO> dtoList);

        List<SelectionListDTO> convertToDTOList(List<SelectionList> entityList);

        Set<SelectionList> convertToEntitySet(Set<SelectionListDTO> dtoSet);
        
        Set<SelectionListDTO> convertToDTOSet(Set<SelectionList> entitySet);

        SelectionList convertToEntity(SelectionListDTO dto);

        SelectionListDTO convertToDTO(SelectionList entity);

        Page<SelectionList> convertToEntityPage(Page<SelectionListDTO> dtoPage);

        Page<SelectionListDTO> convertToDTOPage(Page<SelectionList> entityPage);

}
