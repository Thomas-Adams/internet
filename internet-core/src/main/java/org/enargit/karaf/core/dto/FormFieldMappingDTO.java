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
public class FormFieldMappingDTO extends BasicDTO<Long> {

    @JsonBackReference("form-field-form-field-mapping-dto")
    private FormFieldDTO formField;

    @JsonBackReference("attribute-form-field-mapping-dto")
    private AttributeDTO attribute;
}
