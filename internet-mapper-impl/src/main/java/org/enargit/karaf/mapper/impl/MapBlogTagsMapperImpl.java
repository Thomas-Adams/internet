package org.enargit.karaf.mapper.impl;

import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.core.pagination.Page;
import org.enargit.karaf.core.pagination.PageImpl;
import org.enargit.karaf.core.pagination.PageRequest;
import org.enargit.karaf.mapper.api.MapBlogTagsMapper;
import org.enargit.karaf.mapper.impl.converter.MapBlogTagsDTOToMapBlogTagsConverter;
import org.enargit.karaf.mapper.impl.converter.MapBlogTagsToMapBlogTagsDTOConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Component(service = MapBlogTagsMapper.class, name = "MapBlogTagsMapper", immediate = true)
public class MapBlogTagsMapperImpl extends AbstractMapperImpl implements MapBlogTagsMapper {

    @Override
    public List<MapBlogTags> convertToEntityList(List<MapBlogTagsDTO> dtoList) {
        return dtoList.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toList());
    }

    @Override
    public List<MapBlogTagsDTO> convertToDTOList(List<MapBlogTags> entityList) {
        return entityList.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toList());
    }

    @Override
    public Set<MapBlogTags> convertToEntitySet(Set<MapBlogTagsDTO> dtoSet) {
        return dtoSet.stream().map(dto -> convertToEntity(dto)).collect(Collectors.toSet());
    }

    @Override
    public Set<MapBlogTagsDTO> convertToDTOSet(Set<MapBlogTags> entitySet) {
        return entitySet.stream().map(entity -> convertToDTO(entity)).collect(Collectors.toSet());
    }

    @Override
    public MapBlogTags convertToEntity(MapBlogTagsDTO dto) {
        ModelMapper modelMapper =initMapper();
        TypeMap<MapBlogTagsDTO, MapBlogTags> map = modelMapper.createTypeMap(MapBlogTagsDTO.class, MapBlogTags.class);
        map.addMappings(mapper -> {
            mapper.using(new MapBlogTagsDTOToMapBlogTagsConverter());
        });
        return modelMapper.map(dto, MapBlogTags.class);
    }

    @Override
    public MapBlogTagsDTO convertToDTO(MapBlogTags entity) {
        ModelMapper modelMapper =initMapper();
        TypeMap<MapBlogTags, MapBlogTagsDTO> map = modelMapper.createTypeMap(MapBlogTags.class, MapBlogTagsDTO.class);
        map.addMappings(mapper -> {
            mapper.using(new MapBlogTagsToMapBlogTagsDTOConverter());
        });
        return modelMapper.map(entity, MapBlogTagsDTO.class);
    }

    @Override
    public Page<MapBlogTags> convertToEntityPage(Page<MapBlogTagsDTO> dtoPage) {
        List<MapBlogTags> entityList = convertToEntityList(dtoPage.getContent()); 
        return new PageImpl<MapBlogTags>(entityList, PageRequest.of(dtoPage.getNumber(), dtoPage.getSize()), dtoPage.getTotalElements());
    }

    @Override
    public Page<MapBlogTagsDTO> convertToDTOPage(Page<MapBlogTags> entityPage) {
        List<MapBlogTagsDTO> dtoList = convertToDTOList(entityPage.getContent());
        return new PageImpl<MapBlogTagsDTO>(dtoList, PageRequest.of(entityPage.getNumber(), entityPage.getSize()), entityPage.getTotalElements());
    }
}                                                                
