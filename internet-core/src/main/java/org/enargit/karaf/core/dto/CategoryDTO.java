package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;




@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class CategoryDTO extends BasicDTO<Long> {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @Size(max = 10485760)
    private String description;


    @Builder.Default
    @JsonManagedReference("category-attribute-dto")
    private List<AttributeDTO> attributes = new ArrayList<>(0);

}
