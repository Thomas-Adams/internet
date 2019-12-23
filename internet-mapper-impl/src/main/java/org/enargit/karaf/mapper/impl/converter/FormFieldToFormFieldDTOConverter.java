package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.entities.FormField;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class FormFieldToFormFieldDTOConverter extends AbstractConverter<FormField, FormFieldDTO> {

    private int level;

    public FormFieldToFormFieldDTOConverter(int level) {
        this.level = level;
    }

    public FormFieldToFormFieldDTOConverter() {
        this.level = 0;
    }

    @Override
    protected FormFieldDTO convert(FormField source) {
        FormFieldDTO.FormFieldDTOBuilder builder = FormFieldDTO.builder()
                .dataType(source.getDataType())
                .formFieldMappings(new ArrayList<>())
                .helpText(source.getHelpText())
                .name(source.getName())
                .order(source.getOrder())
                .required(source.getRequired())
                .validationRules(new ArrayList<>())
                .widget(null)
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.formDefinition(new FormDefinitionToFormDefinitionDTOConverter(this.level + 1).convert(source.getFormDefinition()));
        }
        return builder.build();

    }
}
