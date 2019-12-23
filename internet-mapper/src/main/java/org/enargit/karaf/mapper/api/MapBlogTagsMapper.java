package org.enargit.karaf.mapper.api;

import org.enargit.karaf.core.dto.MapBlogTagsDTO;
import org.enargit.karaf.core.entities.MapBlogTags;
import org.enargit.karaf.core.pagination.Page;

import java.util.List;
import java.util.Set;

public interface MapBlogTagsMapper extends BaseMapper  {

        List<MapBlogTags> convertToEntityList(List<MapBlogTagsDTO> dtoList);

        List<MapBlogTagsDTO> convertToDTOList(List<MapBlogTags> entityList);

        Set<MapBlogTags> convertToEntitySet(Set<MapBlogTagsDTO> dtoSet);
        
        Set<MapBlogTagsDTO> convertToDTOSet(Set<MapBlogTags> entitySet);

        MapBlogTags convertToEntity(MapBlogTagsDTO dto);

        MapBlogTagsDTO convertToDTO(MapBlogTags entity);

        Page<MapBlogTags> convertToEntityPage(Page<MapBlogTagsDTO> dtoPage);

        Page<MapBlogTagsDTO> convertToDTOPage(Page<MapBlogTags> entityPage);

}
