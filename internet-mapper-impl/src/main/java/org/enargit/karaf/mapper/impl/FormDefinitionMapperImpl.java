package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.FormDefinitionDTO;
import org.enargit.karaf.core.entities.FormDefinition;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.FormDefinitionMapper;
import org.enargit.karaf.mapper.impl.converter.FormDefinitionDTOToFormDefinitionConverter;
import org.enargit.karaf.mapper.impl.converter.FormDefinitionToFormDefinitionDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = FormDefinitionMapper.class, name = "FormDefinitionMapper", immediate = true)
public class FormDefinitionMapperImpl extends AbstractMapperImpl implements FormDefinitionMapper {

    @Override
    public List<FormDefinition> convertToEntityList(List<FormDefinitionDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<FormDefinitionDTO> convertToDTOList(List<FormDefinition> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<FormDefinition> convertToEntitySet(Set<FormDefinitionDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<FormDefinitionDTO> convertToDTOSet(Set<FormDefinition> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public FormDefinition convertToEntity(FormDefinitionDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<FormDefinitionDTO, FormDefinition> map = modelMapper.createTypeMap(FormDefinitionDTO.class, FormDefinition.class);
        map.addMappings(mapper -> {
            mapper.using(new FormDefinitionDTOToFormDefinitionConverter());
        });
        return modelMapper.map(dto, FormDefinition.class);
    }

    @Override
    public FormDefinitionDTO convertToDTO(FormDefinition entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<FormDefinition, FormDefinitionDTO> map = modelMapper.createTypeMap(FormDefinition.class, FormDefinitionDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new FormDefinitionToFormDefinitionDTOConverter());
        });
        return modelMapper.map(entity, FormDefinitionDTO.class);
    }

    @Override
    public Page<FormDefinition> convertToEntityPage(Page<FormDefinitionDTO> dtoPage) {
        List<FormDefinition> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<FormDefinition>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<FormDefinitionDTO> convertToDTOPage(Page<FormDefinition> entityPage) {
        List<FormDefinitionDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<FormDefinitionDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
