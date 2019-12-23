package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.ValidationRuleDTO;
import org.enargit.karaf.core.entities.ValidationRule;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface ValidationRuleMapper extends BaseMapper  {

        List<ValidationRule> convertToEntityList(List<ValidationRuleDTO> dtoList);

        List<ValidationRuleDTO> convertToDTOList(List<ValidationRule> entityList);

        Set<ValidationRule> convertToEntitySet(Set<ValidationRuleDTO> dtoSet);
        
        Set<ValidationRuleDTO> convertToDTOSet(Set<ValidationRule> entitySet);

        ValidationRule convertToEntity(ValidationRuleDTO dto);

        ValidationRuleDTO convertToDTO(ValidationRule entity);

        Page<ValidationRule> convertToEntityPage(Page<ValidationRuleDTO> dtoPage);

        Page<ValidationRuleDTO> convertToDTOPage(Page<ValidationRule> entityPage);

}
