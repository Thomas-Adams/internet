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
public class WidgetDTO extends BasicDTO<Long> {

    private String name;

    private String description;

    @Builder.Default
    @JsonManagedReference("widget-widget-properties-dto")
    private List<WidgetPropertiesDTO> widgetProperties = new ArrayList<>(0);

    @Builder.Default
    @JsonManagedReference("widget-form-field-dto")
    private List<FormFieldDTO> formFields = new ArrayList<>(0);
}
