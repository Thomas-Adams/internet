package org.enargit.karaf.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Data
@Audited
@Entity
@Table(name = "form_definition")
public class FormDefinition extends BasicEntity<Long> {

	@JsonBackReference("campaign-formdefinition")
	@ManyToOne
	private Campaign campaign;

	private String name;

	private String description;

	@JsonManagedReference("form-validation-rules")
	@OneToMany(mappedBy = "formDefinition")
	private List<ValidationRule> validationRules = new ArrayList<>(0);

	@JsonManagedReference("form-formfield")
	@OneToMany(mappedBy = "formDefinition")
	private List<FormField> formFields = new ArrayList<>(0);

}
