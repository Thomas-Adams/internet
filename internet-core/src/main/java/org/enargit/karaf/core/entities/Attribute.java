package org.enargit.karaf.core.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.enums.ObjectTypes;
import org.enargit.karaf.core.enums.ValueTypes;
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
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "attribute")
public class Attribute extends BasicEntity<Long> {

	@NotNull
	@Size(min = 1, max = 50)
	@Column(nullable = false, length = 50)
	private String name;

	@Size(max = 50)
	@Column(nullable = true, length = 50)
	private String title;

	@Size(max = 10485760)
	@Column(nullable = true, length = 10485760)
	private String description;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Type( type = "org.hibernate.type.StringType" )
	@Column(nullable = false, name = "object_type", length = 20)
	private ObjectTypes type;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Type( type = "org.hibernate.type.StringType" )
	@Column(nullable = false, name = "value_type", length = 20)
	private ValueTypes valueType;

	@JsonBackReference("attribute-category")
	@NotNull
	@ManyToOne
	private Category category;

	@JsonManagedReference("selection-list-attribute")
	@OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
	private List<SelectionList> selectionLists = new ArrayList<>(0);

	@JsonManagedReference("attribute-formfield-mapping")
	@OneToMany(mappedBy = "attribute")
	private List<FormFieldMapping> formFieldMappings = new ArrayList<>(0);

}
