package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.ValidationRuleDTO;
import org.enargit.karaf.core.entities.ValidationRule;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.ValidationRuleMapper;
import org.enargit.karaf.mapper.impl.converter.ValidationRuleDTOToValidationRuleConverter;
import org.enargit.karaf.mapper.impl.converter.ValidationRuleToValidationRuleDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = ValidationRuleMapper.class, name = "ValidationRuleMapper", immediate = true)
public class ValidationRuleMapperImpl implements ValidationRuleMapper {

    @Override
    public List<ValidationRule> convertToEntityList(List<ValidationRuleDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<ValidationRuleDTO> convertToDTOList(List<ValidationRule> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<ValidationRule> convertToEntitySet(Set<ValidationRuleDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<ValidationRuleDTO> convertToDTOSet(Set<ValidationRule> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public ValidationRule convertToEntity(ValidationRuleDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<ValidationRuleDTO, ValidationRule> map = modelMapper.createTypeMap(ValidationRuleDTO.class, ValidationRule.class);
        map.addMappings(mapper -> {
            mapper.using(new ValidationRuleDTOToValidationRuleConverter());
        });
        return modelMapper.map(dto, ValidationRule.class);
    }

    @Override
    public ValidationRuleDTO convertToDTO(ValidationRule entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<ValidationRule, ValidationRuleDTO> map = modelMapper.createTypeMap(ValidationRule.class, ValidationRuleDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new ValidationRuleToValidationRuleDTOConverter());
        });
        return modelMapper.map(entity, ValidationRuleDTO.class);
    }

    @Override
    public Page<ValidationRule> convertToEntityPage(Page<ValidationRuleDTO> dtoPage) {
        List<ValidationRule> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<ValidationRule>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<ValidationRuleDTO> convertToDTOPage(Page<ValidationRule> entityPage) {
        List<ValidationRuleDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<ValidationRuleDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
