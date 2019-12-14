package org.enargit.karaf.mapper.impl;


import org.enargit.karaf.core.dto.TagDto;
import org.enargit.karaf.core.entities.Tag;
import org.enargit.karaf.mapper.api.TagMapper;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component(service = TagMapper.class, immediate = true, name = "TagMapper")
public class TagMapperImpl implements TagMapper {

    @Override
    public List<Tag> convertToEntityList(List<TagDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Tag> list = new ArrayList<Tag>( dtoList.size() );
        for ( TagDto tagDto : dtoList ) {
            list.add( convertToEntity( tagDto ) );
        }

        return list;
    }

    @Override
    public List<TagDto> convertToDTOList(List<Tag> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TagDto> list = new ArrayList<TagDto>( entityList.size() );
        for ( Tag tag : entityList ) {
            list.add( convertToDTO( tag ) );
        }

        return list;
    }

    @Override
    public Set<Tag> convertToEntitySet(Set<TagDto> dtoSet) {
        if ( dtoSet == null ) {
            return null;
        }

        Set<Tag> set = new HashSet<Tag>( Math.max( (int) ( dtoSet.size() / .75f ) + 1, 16 ) );
        for ( TagDto tagDto : dtoSet ) {
            set.add( convertToEntity( tagDto ) );
        }

        return set;
    }

    @Override
    public Set<TagDto> convertToDTOSet(Set<Tag> entitySet) {
        if ( entitySet == null ) {
            return null;
        }

        Set<TagDto> set = new HashSet<TagDto>( Math.max( (int) ( entitySet.size() / .75f ) + 1, 16 ) );
        for ( Tag tag : entitySet ) {
            set.add( convertToDTO( tag ) );
        }

        return set;
    }

    @Override
    public Tag convertToEntity(TagDto dto) {
        if ( dto == null ) {
            return null;
        }

        Tag.TagBuilder<?, ?> tag = Tag.builder();

        tag.id( dto.getId() );
        tag.version( dto.getVersion() );
        tag.created( dto.getCreated() );
        tag.modified( dto.getModified() );
        tag.createdBy( dto.getCreatedBy() );
        tag.modifiedBy( dto.getModifiedBy() );
        tag.name( dto.getName() );

        return tag.build();
    }

    @Override
    public TagDto convertToDTO(Tag entity) {
        if ( entity == null ) {
            return null;
        }

        TagDto.TagDtoBuilder<?, ?> tagDto = TagDto.builder();

        tagDto.id( entity.getId() );
        tagDto.version( entity.getVersion() );
        tagDto.created( entity.getCreated() );
        tagDto.modified( entity.getModified() );
        tagDto.createdBy( entity.getCreatedBy() );
        tagDto.modifiedBy( entity.getModifiedBy() );
        tagDto.name( entity.getName() );

        return tagDto.build();
    }
}
