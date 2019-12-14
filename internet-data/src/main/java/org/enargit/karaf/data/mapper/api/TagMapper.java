package org.enargit.karaf.data.mapper.api;

import org.enargit.karaf.data.dto.TagDto;
import org.enargit.karaf.data.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TagMapper extends BaseMapper<Tag, TagDto, Long> {

    @Mapping(ignore = true, target = "blogTags")
    Tag convertToEntity(TagDto dto);

    @Mapping(ignore = true, target = "blogTags")
    TagDto convertToDTO(Tag entity);

}
