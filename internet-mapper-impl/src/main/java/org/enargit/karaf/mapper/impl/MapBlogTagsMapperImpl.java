package org.enargit.karaf.mapper.impl;


import org.enargit.karaf.core.dto.MapBlogTagsDto;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.mapper.api.MapBlogTagsMapper;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component(service = MapBlogTagsMapper.class, immediate = true, name="MapBlogTagsMapper")
public class MapBlogTagsMapperImpl implements MapBlogTagsMapper {

    @Override
    public List<MapBlogTags> convertToEntityList(List<MapBlogTagsDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MapBlogTags> list = new ArrayList<MapBlogTags>( dtoList.size() );
        for ( MapBlogTagsDto mapBlogTagsDto : dtoList ) {
            list.add( convertToEntity( mapBlogTagsDto ) );
        }

        return list;
    }

    @Override
    public List<MapBlogTagsDto> convertToDTOList(List<MapBlogTags> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MapBlogTagsDto> list = new ArrayList<MapBlogTagsDto>( entityList.size() );
        for ( MapBlogTags mapBlogTags : entityList ) {
            list.add( convertToDTO( mapBlogTags ) );
        }

        return list;
    }

    @Override
    public Set<MapBlogTags> convertToEntitySet(Set<MapBlogTagsDto> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<MapBlogTags> set = new HashSet<MapBlogTags>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( MapBlogTagsDto mapBlogTagsDto : dtoSet ) {
            set.add( convertToEntity( mapBlogTagsDto ) );
        }

        return set;
    }

    @Override
    public Set<MapBlogTagsDto> convertToDTOSet(Set<MapBlogTags> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<MapBlogTagsDto> set = new HashSet<MapBlogTagsDto>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( MapBlogTags mapBlogTags : entitySet ) {
            set.add( convertToDTO( mapBlogTags ) );
        }

        return set;
    }

    @Override
    public MapBlogTags convertToEntity(MapBlogTagsDto dto) {
        if ( dto == null ) {
            return null;
        }

        MapBlogTags.MapBlogTagsBuilder<?, ?> mapBlogTags = MapBlogTags.builder();

        mapBlogTags.id( dto.getId() );
        mapBlogTags.version( dto.getVersion() );
        mapBlogTags.created( dto.getCreated() );
        mapBlogTags.modified( dto.getModified() );
        mapBlogTags.createdBy( dto.getCreatedBy() );
        mapBlogTags.modifiedBy( dto.getModifiedBy() );
        mapBlogTags.blog( dto.getBlog() );
        mapBlogTags.tag( dto.getTag() );

        return mapBlogTags.build();
    }

    @Override
    public MapBlogTagsDto convertToDTO(MapBlogTags entity) {
        if ( entity == null ) {
            return null;
        }

        MapBlogTagsDto.MapBlogTagsDtoBuilder<?, ?> mapBlogTagsDto = MapBlogTagsDto.builder();

        mapBlogTagsDto.id( entity.getId() );
        mapBlogTagsDto.version( entity.getVersion() );
        mapBlogTagsDto.created( entity.getCreated() );
        mapBlogTagsDto.modified( entity.getModified() );
        mapBlogTagsDto.createdBy( entity.getCreatedBy() );
        mapBlogTagsDto.modifiedBy( entity.getModifiedBy() );
        mapBlogTagsDto.blog( entity.getBlog() );
        mapBlogTagsDto.tag( entity.getTag() );

        return mapBlogTagsDto.build();
    }
}
