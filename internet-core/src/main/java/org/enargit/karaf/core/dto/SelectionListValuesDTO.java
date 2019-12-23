package org.enargit.karaf.core.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class SelectionListValuesDTO extends BasicDTO<Long> {

    @JsonBackReference("selection-list-selection-list-values-dto")
    private SelectionListDTO selectionList;

    private String label;

    private String description;

    private Integer integerValue;

    private Long longValue;

    private Boolean booleanValue;

    private String stringValue;

    private Timestamp dateTimeValue;

    private Date dateValue;

    private Float floatValue;

    private Double doubleValue;

    private BigDecimal bigDecimalValue;
}
