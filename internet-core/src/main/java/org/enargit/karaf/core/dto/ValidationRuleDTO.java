package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ValidationRuleDTO extends BasicDTO<Long> {

    @JsonBackReference("form-definition-validation-rule-dto")
    private FormDefinitionDTO formDefinition;

    @JsonBackReference("form-field-validation-rule-dto")
    private FormFieldDTO formField;

    private String validatorClassName;

    private String annotationClassName;

    private Integer min;

    private Integer max;

    private Integer minLength;

    private Integer maxLength;

    private String pattern;

    private Boolean email;

    private Boolean url;

    private Boolean ipAddress;
}
