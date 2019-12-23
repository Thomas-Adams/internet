package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.entities.Attribute;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.AttributeMapper;
import org.enargit.karaf.mapper.impl.converter.AttributeDTOToAttributeConverter;
import org.enargit.karaf.mapper.impl.converter.AttributeToAttributeDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = AttributeMapper.class, name = "AttributeMapper", immediate = true)
public class AttributeMapperImpl extends AbstractMapperImpl implements AttributeMapper {

    @Override
    public List<Attribute> convertToEntityList(List<AttributeDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<AttributeDTO> convertToDTOList(List<Attribute> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Attribute> convertToEntitySet(Set<AttributeDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<AttributeDTO> convertToDTOSet(Set<Attribute> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Attribute convertToEntity(AttributeDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<AttributeDTO, Attribute> map = modelMapper.createTypeMap(AttributeDTO.class, Attribute.class);
        map.addMappings(mapper -> {
            mapper.using(new AttributeDTOToAttributeConverter());
        });
        return modelMapper.map(dto, Attribute.class);
    }

    @Override
    public AttributeDTO convertToDTO(Attribute entity) {
        ModelMapper modelMapper = initMapper();;
        TypeMap<Attribute, AttributeDTO> map = modelMapper.createTypeMap(Attribute.class, AttributeDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new AttributeToAttributeDTOConverter());
        });
        return modelMapper.map(entity, AttributeDTO.class);
    }

    @Override
    public Page<Attribute> convertToEntityPage(Page<AttributeDTO> dtoPage) {
        List<Attribute> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Attribute>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<AttributeDTO> convertToDTOPage(Page<Attribute> entityPage) {
        List<AttributeDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<AttributeDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
