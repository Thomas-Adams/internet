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
public class SubscriptionAttributesDTO extends BasicDTO<Long> {

    @JsonBackReference("subscription-subscription-attributes-dto")
    private SubscriptionDTO subscription;

    private AttributeDTO attribute;

    private Date dateValue;

    private Float floatValue;

    private Long longValue;

    private String stringValue;

    private Boolean booleanValue;
}
