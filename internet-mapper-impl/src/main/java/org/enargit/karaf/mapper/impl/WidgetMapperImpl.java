package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.WidgetDTO;
import org.enargit.karaf.core.entities.Widget;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.WidgetMapper;
import org.enargit.karaf.mapper.impl.converter.WidgetDTOToWidgetConverter;
import org.enargit.karaf.mapper.impl.converter.WidgetToWidgetDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = WidgetMapper.class, name = "WidgetMapper", immediate = true)
public class WidgetMapperImpl extends AbstractMapperImpl implements WidgetMapper {

    @Override
    public List<Widget> convertToEntityList(List<WidgetDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<WidgetDTO> convertToDTOList(List<Widget> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<Widget> convertToEntitySet(Set<WidgetDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<WidgetDTO> convertToDTOSet(Set<Widget> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public Widget convertToEntity(WidgetDTO dto) {
        ModelMapper modelMapper = initMapper();
        TypeMap<WidgetDTO, Widget> map = modelMapper.createTypeMap(WidgetDTO.class, Widget.class);
        map.addMappings(mapper -> {
            mapper.using(new WidgetDTOToWidgetConverter());
        });
        return modelMapper.map(dto, Widget.class);
    }

    @Override
    public WidgetDTO convertToDTO(Widget entity) {
        ModelMapper modelMapper = initMapper();
        TypeMap<Widget, WidgetDTO> map = modelMapper.createTypeMap(Widget.class, WidgetDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new WidgetToWidgetDTOConverter());
        });
        return modelMapper.map(entity, WidgetDTO.class);
    }

    @Override
    public Page<Widget> convertToEntityPage(Page<WidgetDTO> dtoPage) {
        List<Widget> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<Widget>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<WidgetDTO> convertToDTOPage(Page<Widget> entityPage) {
        List<WidgetDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<WidgetDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
