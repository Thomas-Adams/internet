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
@Table(name = "validation_rule")
public class ValidationRule extends BasicEntity<Long> {

	private static final long serialVersionUID = 1L;

	@JsonBackReference("form-validation-rules")
	@ManyToOne(optional = true)
	private FormDefinition formDefinition;

	@JsonBackReference("formfield-validation-rules")
	@ManyToOne(optional = true)
	private FormField formField;

	private String validatorClassName;

	private String annotationClassName;

	private Integer min;

	private Integer max;

	private Integer minLength;

	private Integer maxLength;

	private String pattern;

	private Boolean email;

	private Boolean url;

	private Boolean ipAddress;

}
