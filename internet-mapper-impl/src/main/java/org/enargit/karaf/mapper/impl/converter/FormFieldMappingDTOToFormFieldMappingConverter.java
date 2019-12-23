package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.entities.FormFieldMapping;
import org.modelmapper.AbstractConverter;

public class FormFieldMappingDTOToFormFieldMappingConverter extends AbstractConverter<FormFieldMappingDTO,FormFieldMapping> {


    private int level;

    public FormFieldMappingDTOToFormFieldMappingConverter(int level) {
        this.level = level;
    }

    public FormFieldMappingDTOToFormFieldMappingConverter() {
        this.level = 0;
    }

    @Override
    protected FormFieldMapping convert(FormFieldMappingDTO source) {
        FormFieldMapping.FormFieldMappingBuilder builder = FormFieldMapping.builder()
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.attribute(new AttributeDTOToAttributeConverter(this.level + 1).convert(source.getAttribute()))
                    .formField(new FormFieldDTOToFormFieldConverter(this.level + 1).convert(source.getFormField()));
        }
        return builder.build();
    }
}
