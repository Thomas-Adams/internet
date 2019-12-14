package org.enargit.karaf.mapper.api;


import org.enargit.karaf.core.dto.TagDto;
import org.enargit.karaf.core.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TagMapper extends BaseMapper<Tag, TagDto, Long> {

    @Mapping(ignore = true, target = "blogTags")
    Tag convertToEntity(TagDto dto);

    @Mapping(ignore = true, target = "blogTags")
    TagDto convertToDTO(Tag entity);

}
