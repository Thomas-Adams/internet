package org.enargit.karaf.mapper.api;

import org.enargit.karaf.data.dto.MapBlogTagsDto;
import org.enargit.karaf.data.entities.MapBlogTags;
import org.mapstruct.Mapper;

@Mapper
public interface MapBlogTagsMapper extends BaseMapper<MapBlogTags, MapBlogTagsDto, Long> {

    MapBlogTags convertToEntity(MapBlogTagsDto dto);

    MapBlogTagsDto convertToDTO(MapBlogTags entity);

}
