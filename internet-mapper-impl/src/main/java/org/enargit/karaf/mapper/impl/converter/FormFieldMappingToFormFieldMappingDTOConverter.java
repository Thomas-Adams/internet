package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.FormFieldMappingDTO;
import org.enargit.karaf.core.entities.FormFieldMapping;
import org.modelmapper.AbstractConverter;

public class FormFieldMappingToFormFieldMappingDTOConverter extends AbstractConverter<FormFieldMapping, FormFieldMappingDTO> {


    private int level;

    public FormFieldMappingToFormFieldMappingDTOConverter(int level) {
        this.level = level;
    }

    public FormFieldMappingToFormFieldMappingDTOConverter() {
        this.level = 0;
    }

    @Override
    protected FormFieldMappingDTO convert(FormFieldMapping source) {
        FormFieldMappingDTO.FormFieldMappingDTOBuilder builder = FormFieldMappingDTO.builder()
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.attribute(new AttributeToAttributeDTOConverter(this.level + 1).convert(source.getAttribute()))
                    .formField(new FormFieldToFormFieldDTOConverter(this.level + 1).convert(source.getFormField()));
        }
        return builder.build();
    }
}
