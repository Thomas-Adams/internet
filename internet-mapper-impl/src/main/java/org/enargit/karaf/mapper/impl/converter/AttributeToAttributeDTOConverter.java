package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.entities.Attribute;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class AttributeToAttributeDTOConverter extends AbstractConverter<Attribute, AttributeDTO> {

    private int level;

    public AttributeToAttributeDTOConverter(int level) {
        this.level = level;
    }

    public AttributeToAttributeDTOConverter() {
        this.level =0;
    }

    @Override
    protected AttributeDTO convert(Attribute source) {
        AttributeDTO.AttributeDTOBuilder builder = AttributeDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .formFieldMappings(new ArrayList<>())
                .selectionLists(new ArrayList<>())
                .valueType(source.getValueType())
                .type(source.getType())
                .title(source.getTitle())
                .version(source.getVersion());
        if(this.level==0) {
            builder.category(new CategoryToCategoryDTOConverter(this.level+1).convert(source.getCategory()));
        }

        return builder.build();

    }
}
