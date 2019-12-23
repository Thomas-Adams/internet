package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.entities.FormFieldMapping;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface FormFieldMappingMapper extends BaseMapper  {

        List<FormFieldMapping> convertToEntityList(List<FormFieldMappingDTO> dtoList);

        List<FormFieldMappingDTO> convertToDTOList(List<FormFieldMapping> entityList);

        Set<FormFieldMapping> convertToEntitySet(Set<FormFieldMappingDTO> dtoSet);
        
        Set<FormFieldMappingDTO> convertToDTOSet(Set<FormFieldMapping> entitySet);

        FormFieldMapping convertToEntity(FormFieldMappingDTO dto);

        FormFieldMappingDTO convertToDTO(FormFieldMapping entity);

        Page<FormFieldMapping> convertToEntityPage(Page<FormFieldMappingDTO> dtoPage);

        Page<FormFieldMappingDTO> convertToDTOPage(Page<FormFieldMapping> entityPage);

}
