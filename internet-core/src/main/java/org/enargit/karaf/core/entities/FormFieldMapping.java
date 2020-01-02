package org.enargit.karaf.core.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "form_field_mapping")
public class FormFieldMapping extends BasicEntity<Long> {

	@JsonBackReference("formfield-formfield-mappings")
	@ManyToOne
	private FormField formField;

	@JsonBackReference("attribute-formfield-mapping")
	@ManyToOne
	private Attribute attribute;

}
