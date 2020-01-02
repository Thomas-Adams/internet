package org.enargit.karaf.core.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "category")
public class Category extends BasicEntity<Long> {

    @NotNull
    @Size(min = 1, max=50)
    @Column(nullable = false, length=50)
    private String name;

    @Size(max=10485760)
    @Column(nullable = true, length = 10485760)
    private String description;

    @JsonManagedReference("attribute-category")
    @OneToMany(mappedBy = "category")
    private List<Attribute> attributes = new ArrayList<>(0);

}
