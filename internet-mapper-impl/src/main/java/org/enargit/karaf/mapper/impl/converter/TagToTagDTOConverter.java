package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.TagDTO;
import org.enargit.karaf.core.entities.Tag;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class TagToTagDTOConverter extends AbstractConverter<Tag, TagDTO> {

    private int level;

    public TagToTagDTOConverter(int level) {
        this.level = level;
    }

    public TagToTagDTOConverter() {
        this.level = 0;
    }

    @Override
    protected TagDTO convert(Tag source) {
        return TagDTO.builder()
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
