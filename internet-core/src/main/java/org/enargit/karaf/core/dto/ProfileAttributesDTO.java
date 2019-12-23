package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ProfileAttributesDTO extends BasicDTO<Long> {



    @JsonBackReference("profile-profile-attributes-dto")
    private ProfileDTO profile;

    private AttributeDTO attribute;

    private Date dateValue;

    private Float floatValue;

    private Long longValue;

    private String stringValue;

    private Boolean booleanValue;

}
