package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.entities.FormFieldMapping;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.FormFieldMappingMapper;
import org.enargit.karaf.mapper.impl.converter.FormFieldMappingDTOToFormFieldMappingConverter;
import org.enargit.karaf.mapper.impl.converter.FormFieldMappingToFormFieldMappingDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = FormFieldMappingMapper.class, name = "FormFieldMappingMapper", immediate = true)
public class FormFieldMappingMapperImpl implements FormFieldMappingMapper {

    @Override
    public List<FormFieldMapping> convertToEntityList(List<FormFieldMappingDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<FormFieldMappingDTO> convertToDTOList(List<FormFieldMapping> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<FormFieldMapping> convertToEntitySet(Set<FormFieldMappingDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<FormFieldMappingDTO> convertToDTOSet(Set<FormFieldMapping> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public FormFieldMapping convertToEntity(FormFieldMappingDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<FormFieldMappingDTO, FormFieldMapping> map = modelMapper.createTypeMap(FormFieldMappingDTO.class, FormFieldMapping.class);
        map.addMappings(mapper -> {
            mapper.using(new FormFieldMappingDTOToFormFieldMappingConverter());
        });
        return modelMapper.map(dto, FormFieldMapping.class);
    }

    @Override
    public FormFieldMappingDTO convertToDTO(FormFieldMapping entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<FormFieldMapping, FormFieldMappingDTO> map = modelMapper.createTypeMap(FormFieldMapping.class, FormFieldMappingDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new FormFieldMappingToFormFieldMappingDTOConverter());
        });
        return modelMapper.map(entity, FormFieldMappingDTO.class);
    }

    @Override
    public Page<FormFieldMapping> convertToEntityPage(Page<FormFieldMappingDTO> dtoPage) {
        List<FormFieldMapping> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<FormFieldMapping>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<FormFieldMappingDTO> convertToDTOPage(Page<FormFieldMapping> entityPage) {
        List<FormFieldMappingDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<FormFieldMappingDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
