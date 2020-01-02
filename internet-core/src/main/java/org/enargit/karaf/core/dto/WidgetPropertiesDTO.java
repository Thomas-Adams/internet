package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.DataTypes;



@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class WidgetPropertiesDTO extends BasicDTO<Long> {

    @JsonBackReference("widget-widget-properties-dto")
    private WidgetDTO widget;

    private String name;

    private DataTypes dataType;

    private String value;
}
