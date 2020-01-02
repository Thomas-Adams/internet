package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.ObjectTypes;
import org.enargit.karaf.core.enums.ValueTypes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class AttributeDTO extends BasicDTO<Long> {

    @NotNull
    @Size(min=1, max=50)
    private String name;

    @Size(max = 50)
    private String title;

    @Size(max=10485760)
    private String description;



    @NotNull
    private ObjectTypes type;


    @NotNull
    private ValueTypes valueType;

    @NotNull
    @JsonBackReference("category-attribute-dto")
    private CategoryDTO category;


    @Builder.Default
    @JsonManagedReference("attribute-selection-list-dto")
    private List<SelectionListDTO> selectionLists = new ArrayList<>(0);


    @Builder.Default
    @JsonManagedReference("attribute-form-field-mapping-dto")
    private List<FormFieldMappingDTO> formFieldMappings = new ArrayList<>(0);

}
