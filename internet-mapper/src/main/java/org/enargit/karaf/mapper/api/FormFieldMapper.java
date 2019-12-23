package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.entities.FormField;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface FormFieldMapper extends BaseMapper  {

        List<FormField> convertToEntityList(List<FormFieldDTO> dtoList);

        List<FormFieldDTO> convertToDTOList(List<FormField> entityList);

        Set<FormField> convertToEntitySet(Set<FormFieldDTO> dtoSet);
        
        Set<FormFieldDTO> convertToDTOSet(Set<FormField> entitySet);

        FormField convertToEntity(FormFieldDTO dto);

        FormFieldDTO convertToDTO(FormField entity);

        Page<FormField> convertToEntityPage(Page<FormFieldDTO> dtoPage);

        Page<FormFieldDTO> convertToDTOPage(Page<FormField> entityPage);

}
