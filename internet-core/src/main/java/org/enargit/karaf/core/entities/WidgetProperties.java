package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.DataTypes;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "widget_properties")
public class WidgetProperties extends BasicEntity<Long> {

    @JsonBackReference("widget-widget-properties")
    @ManyToOne
    private Widget widget;

    @Column(nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    @Type( type = "org.hibernate.type.StringType" )
    @Column(nullable = false, name="DATA_TYPE", length = 20)
    private DataTypes dataType;

    @Column(nullable = true)
    private String value;

}
