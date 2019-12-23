package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.SubscriptionAttributesDTO;
import org.enargit.karaf.core.entities.SubscriptionAttributes;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.SubscriptionAttributesMapper;
import org.enargit.karaf.mapper.impl.converter.SubscriptionAttributesDTOToSubscriptionAttributesConverter;
import org.enargit.karaf.mapper.impl.converter.SubscriptionAttributesToSubscriptionAttributesDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = SubscriptionAttributesMapper.class, name = "SubscriptionAttributesMapper", immediate = true)
public class SubscriptionAttributesMapperImpl implements SubscriptionAttributesMapper {

    @Override
    public List<SubscriptionAttributes> convertToEntityList(List<SubscriptionAttributesDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<SubscriptionAttributesDTO> convertToDTOList(List<SubscriptionAttributes> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<SubscriptionAttributes> convertToEntitySet(Set<SubscriptionAttributesDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<SubscriptionAttributesDTO> convertToDTOSet(Set<SubscriptionAttributes> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public SubscriptionAttributes convertToEntity(SubscriptionAttributesDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<SubscriptionAttributesDTO, SubscriptionAttributes> map = modelMapper.createTypeMap(SubscriptionAttributesDTO.class, SubscriptionAttributes.class);
        map.addMappings(mapper -> {
            mapper.using(new SubscriptionAttributesDTOToSubscriptionAttributesConverter());
        });
        return modelMapper.map(dto, SubscriptionAttributes.class);
    }

    @Override
    public SubscriptionAttributesDTO convertToDTO(SubscriptionAttributes entity) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<SubscriptionAttributes, SubscriptionAttributesDTO> map = modelMapper.createTypeMap(SubscriptionAttributes.class, SubscriptionAttributesDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new SubscriptionAttributesToSubscriptionAttributesDTOConverter());
        });
        return modelMapper.map(entity, SubscriptionAttributesDTO.class);
    }

    @Override
    public Page<SubscriptionAttributes> convertToEntityPage(Page<SubscriptionAttributesDTO> dtoPage) {
        List<SubscriptionAttributes> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<SubscriptionAttributes>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<SubscriptionAttributesDTO> convertToDTOPage(Page<SubscriptionAttributes> entityPage) {
        List<SubscriptionAttributesDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<SubscriptionAttributesDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
