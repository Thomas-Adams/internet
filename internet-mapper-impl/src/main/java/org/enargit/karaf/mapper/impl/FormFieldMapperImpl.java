package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.entities.FormField;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.FormFieldMapper;
import org.enargit.karaf.mapper.impl.converter.FormFieldDTOToFormFieldConverter;
import org.enargit.karaf.mapper.impl.converter.FormFieldToFormFieldDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = FormFieldMapper.class, name = "FormFieldMapper", immediate = true)
public class FormFieldMapperImpl extends AbstractMapperImpl implements FormFieldMapper {

    @Override
    public List<FormField> convertToEntityList(List<FormFieldDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<FormFieldDTO> convertToDTOList(List<FormField> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<FormField> convertToEntitySet(Set<FormFieldDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<FormFieldDTO> convertToDTOSet(Set<FormField> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public FormField convertToEntity(FormFieldDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<FormFieldDTO, FormField> map = modelMapper.createTypeMap(FormFieldDTO.class, FormField.class);
        map.addMappings(mapper -> {
            mapper.using(new FormFieldDTOToFormFieldConverter());
        });
        return modelMapper.map(dto, FormField.class);
    }

    @Override
    public FormFieldDTO convertToDTO(FormField entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<FormField, FormFieldDTO> map = modelMapper.createTypeMap(FormField.class, FormFieldDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new FormFieldToFormFieldDTOConverter());
        });
        return modelMapper.map(entity, FormFieldDTO.class);
    }

    @Override
    public Page<FormField> convertToEntityPage(Page<FormFieldDTO> dtoPage) {
        List<FormField> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<FormField>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<FormFieldDTO> convertToDTOPage(Page<FormField> entityPage) {
        List<FormFieldDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<FormFieldDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
