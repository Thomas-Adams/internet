package org.enargit.karaf.mapper.api;

import org.enargit.karaf.data.dto.BlogDto;
import org.enargit.karaf.data.entities.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BlogMapper extends BaseMapper<Blog, BlogDto, Long> {

    @Mapping(ignore = true, target = "blogTags")
    Blog convertToEntity(BlogDto dto);

    @Mapping(ignore = true, target = "blogTags")
    BlogDto convertToDTO(Blog entity);
}
