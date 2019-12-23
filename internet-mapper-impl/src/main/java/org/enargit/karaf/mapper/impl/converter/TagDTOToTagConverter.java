package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.core.entities.Tag;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class TagDTOToTagConverter extends AbstractConverter<TagDTO, Tag> {

    private int level;

    public TagDTOToTagConverter(int level) {
        this.level = level;
    }

    public TagDTOToTagConverter() {
        this.level = 0;
    }

    @Override
    protected Tag convert(TagDTO source) {
        return Tag.builder()
                .blogTags(new ArrayList<>())
                .name(source.getName())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion()).build();
    }
}
