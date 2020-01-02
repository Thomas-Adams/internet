package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "widget")
public class Widget extends BasicEntity<Long> {


    private String name;

    private String description;

    @JsonManagedReference("widget-widget-properties")
    @OneToMany(mappedBy = "widget")
    private List<WidgetProperties> widgetProperties = new ArrayList<>(0);

    @JsonManagedReference("widget-formfields")
    @OneToMany(mappedBy = "widget")
    private List<FormField> formFields = new ArrayList<>(0);

}
