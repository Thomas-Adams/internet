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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode
@Audited
@Entity
@Table(name = "selection_list")
public class SelectionList extends BasicEntity<Long> {


    @NotNull
    @Size(min = 1, max=50)
    @Column(nullable = false, length = 50)
    private String name;

    @JsonBackReference("selection-list-attribute")
    @ManyToOne
    private Attribute attribute;

    @Enumerated(EnumType.STRING)
    @Type( type = "org.hibernate.type.StringType" )
    @Column(nullable = false, name="LIST_TYPE", length = 20)
    private DataTypes listType;

    @JsonManagedReference("selection-list-selection-list-values")
    @OneToMany(mappedBy = "selectionList")
    private List<SelectionListValues> selectionListValues = new ArrayList<>(0);
}
