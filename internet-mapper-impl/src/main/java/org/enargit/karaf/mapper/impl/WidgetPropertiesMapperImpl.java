package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.WidgetPropertiesDTO;
import org.enargit.karaf.core.entities.WidgetProperties;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.WidgetPropertiesMapper;
import org.enargit.karaf.mapper.impl.converter.WidgetPropertiesDTOToWidgetPropertiesConverter;
import org.enargit.karaf.mapper.impl.converter.WidgetPropertiesToWidgetPropertiesDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = WidgetPropertiesMapper.class, name = "WidgetPropertiesMapper", immediate = true)
public class WidgetPropertiesMapperImpl extends AbstractMapperImpl implements WidgetPropertiesMapper {

    @Override
    public List<WidgetProperties> convertToEntityList(List<WidgetPropertiesDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<WidgetPropertiesDTO> convertToDTOList(List<WidgetProperties> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<WidgetProperties> convertToEntitySet(Set<WidgetPropertiesDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<WidgetPropertiesDTO> convertToDTOSet(Set<WidgetProperties> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public WidgetProperties convertToEntity(WidgetPropertiesDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<WidgetPropertiesDTO, WidgetProperties> map = modelMapper.createTypeMap(WidgetPropertiesDTO.class, WidgetProperties.class);
        map.addMappings(mapper -> {
            mapper.using(new WidgetPropertiesDTOToWidgetPropertiesConverter());
        });
        return modelMapper.map(dto, WidgetProperties.class);
    }

    @Override
    public WidgetPropertiesDTO convertToDTO(WidgetProperties entity) {
        ModelMapper modelMapper = initMapper();
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setDeepCopyEnabled(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        TypeMap<WidgetProperties, WidgetPropertiesDTO> map = modelMapper.createTypeMap(WidgetProperties.class, WidgetPropertiesDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new WidgetPropertiesToWidgetPropertiesDTOConverter());
        });
        return modelMapper.map(entity, WidgetPropertiesDTO.class);
    }

    @Override
    public Page<WidgetProperties> convertToEntityPage(Page<WidgetPropertiesDTO> dtoPage) {
        List<WidgetProperties> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<WidgetProperties>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<WidgetPropertiesDTO> convertToDTOPage(Page<WidgetProperties> entityPage) {
        List<WidgetPropertiesDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<WidgetPropertiesDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
