package org.enargit.karaf.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.DataTypes;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "form_field")
public class FormField extends BasicEntity<Long> {

    @JsonBackReference("form-formfield")
    @ManyToOne
    private FormDefinition formDefinition;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String helpText;

    @Enumerated(EnumType.STRING)
    @Type(type = "org.hibernate.type.StringType")
    @Column(nullable = false, name = "data_type", length = 20)
    private DataTypes dataType;

    @Column(nullable = false)
    private Boolean required;

    @Column(name = "field_order", nullable = false)
    private Integer order;

    @JsonBackReference("widget-formfields")
    @ManyToOne
    private Widget widget;

    @JsonManagedReference("formfield-validation-rules")
    @OneToMany(mappedBy = "formField")
    private List<ValidationRule> validationRules = new ArrayList<>(0);

    @JsonManagedReference("formfield-formfield-mappings")
    @OneToMany(mappedBy = "formField")
    private List<FormFieldMapping> formFieldMappings = new ArrayList<>(0);

}
