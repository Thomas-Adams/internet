package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class FormDefinitionDTO extends BasicDTO<Long> {

    private CampaignDTO campaign;

    private String name;

    private String description;

    @Builder.Default
    @JsonManagedReference("form-definition-validation-rule-dto")
    private List<ValidationRuleDTO> validationRules = new ArrayList<>(0);

    @Builder.Default
    @JsonManagedReference("form-definition-form-field-dto")
    private List<FormFieldDTO> formFields = new ArrayList<>(0);
}
