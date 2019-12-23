package org.enargit.karaf.mapper.impl.converter;

import org.enargit.karaf.core.dto.ValidationRuleDTO;
import org.enargit.karaf.core.entities.ValidationRule;
import org.modelmapper.AbstractConverter;

public class ValidationRuleToValidationRuleDTOConverter extends AbstractConverter<ValidationRule, ValidationRuleDTO> {


    private int level;

    public ValidationRuleToValidationRuleDTOConverter(int level) {
        this.level = level;
    }

    public ValidationRuleToValidationRuleDTOConverter() {
        this.level = 0;
    }

    @Override
    protected ValidationRuleDTO convert(ValidationRule source) {
        ValidationRuleDTO.ValidationRuleDTOBuilder builder = ValidationRuleDTO.builder()
                .annotationClassName(source.getAnnotationClassName())
                .email(source.getEmail())
                .ipAddress(source.getIpAddress())
                .max(source.getMax())
                .maxLength(source.getMaxLength())
                .min(source.getMin())
                .minLength(source.getMinLength())
                .pattern(source.getPattern())
                .url(source.getUrl())
                .validatorClassName(source.getValidatorClassName())
                .id(source.getId())
                .created(source.getCreated())
                .createdBy(source.getCreatedBy())
                .modified(source.getModified())
                .modifiedBy(source.getModifiedBy())
                .version(source.getVersion());
        if (this.level == 0) {
            builder.formDefinition(new FormDefinitionToFormDefinitionDTOConverter(this.level+1).convert(source.getFormDefinition()))
                    .formField(new FormFieldToFormFieldDTOConverter(this.level+1).convert(source.getFormField()));

        }
        return builder.build();
    }
}
