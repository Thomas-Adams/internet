package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.DataTypes;

import java.util.ArrayList;
import java.util.List;




@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class FormFieldDTO extends BasicDTO<Long> {

    @JsonBackReference("form-definition-form-field-dto")
    private FormDefinitionDTO formDefinition;

    private String name;

    private String helpText;

    private DataTypes dataType;

    private Boolean required;


    private Integer order;

    @JsonBackReference("widget-form-field-dto")
    private WidgetDTO widget;


    @Builder.Default
    @JsonManagedReference("form-field-validation-rule-dto")
    private List<ValidationRuleDTO> validationRules = new ArrayList<>(0);


    @Builder.Default
    @JsonManagedReference("form-field-form-field-mapping-dto")
    private List<FormFieldMappingDTO> formFieldMappings = new ArrayList<>(0);
}
