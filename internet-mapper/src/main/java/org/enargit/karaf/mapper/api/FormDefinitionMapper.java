package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.FormDefinitionDTO;
import org.enargit.karaf.core.entities.FormDefinition;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface FormDefinitionMapper extends BaseMapper  {

        List<FormDefinition> convertToEntityList(List<FormDefinitionDTO> dtoList);

        List<FormDefinitionDTO> convertToDTOList(List<FormDefinition> entityList);

        Set<FormDefinition> convertToEntitySet(Set<FormDefinitionDTO> dtoSet);
        
        Set<FormDefinitionDTO> convertToDTOSet(Set<FormDefinition> entitySet);

        FormDefinition convertToEntity(FormDefinitionDTO dto);

        FormDefinitionDTO convertToDTO(FormDefinition entity);

        Page<FormDefinition> convertToEntityPage(Page<FormDefinitionDTO> dtoPage);

        Page<FormDefinitionDTO> convertToDTOPage(Page<FormDefinition> entityPage);

}
