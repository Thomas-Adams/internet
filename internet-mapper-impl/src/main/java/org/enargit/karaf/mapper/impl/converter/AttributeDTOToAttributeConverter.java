package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.AttributeDTO;
import org.enargit.karaf.core.entities.Attribute;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class AttributeDTOToAttributeConverter extends AbstractConverter<AttributeDTO, Attribute> {

    private int level;

    public AttributeDTOToAttributeConverter(int level) {
        this.level = level;
    }

    public AttributeDTOToAttributeConverter() {
        this.level = 0;
    }

    @Override
    protected Attribute convert(AttributeDTO source) {
        Attribute.AttributeBuilder builder = Attribute.builder()
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
        if (this.level == 0) {
            builder.category(new CategoryDTOToCategoryConverter(this.level + 1).convert(source.getCategory()));
        }
        return builder.build();

    }
}
