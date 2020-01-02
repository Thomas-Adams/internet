package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode
@Audited
@Entity
@Table(name = "selection_list_values")
public class SelectionListValues extends BasicEntity<Long> {

    @JsonBackReference("selection-list-selection-list-values")
    @ManyToOne
    private SelectionList selectionList;

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
