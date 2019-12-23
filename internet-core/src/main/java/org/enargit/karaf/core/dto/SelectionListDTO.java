package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.DataTypes;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SelectionListDTO extends BasicDTO<Long> {

    @NotNull
    @Size(min = 1, max=50)
    private String name;

    @JsonBackReference("attribute-selection-list-dto")
    private AttributeDTO attribute;

    private DataTypes listType;

    @Builder.Default
    @JsonManagedReference("selection-list-selection-list-values-dto")
    private List<SelectionListValuesDTO> selectionListValues = new ArrayList<>(0);

}
