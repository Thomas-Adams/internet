package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.FormFieldDTO;
import org.enargit.karaf.core.entities.FormField;
import org.modelmapper.AbstractConverter;

import java.util.ArrayList;

public class FormFieldDTOToFormFieldConverter extends AbstractConverter<FormFieldDTO, FormField> {

    private int level;

    public FormFieldDTOToFormFieldConverter(int level) {
        this.level = level;
    }

    public FormFieldDTOToFormFieldConverter() {
        this.level = 0;
    }

    @Override
    protected FormField convert(FormFieldDTO source) {
        FormField.FormFieldBuilder builder = FormField.builder()
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
            builder.formDefinition(new FormDefinitionDTOToFormDefinitionConverter(this.level + 1).convert(source.getFormDefinition()));
        }
        return builder.build();

    }
}
