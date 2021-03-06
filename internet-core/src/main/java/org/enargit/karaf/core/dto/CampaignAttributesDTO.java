package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.json.JodaDateTimeSerializer;

import java.util.Date;




@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class CampaignAttributesDTO extends BasicDTO<Long> {


    @JsonBackReference("campaign-campaign-attributes-dto")
    private CampaignDTO campaign;

    private AttributeDTO attribute;

    @JsonSerialize(using = JodaDateTimeSerializer.class)
    private Date dateValue;

    private Float floatValue;

    private Long longValue;

    private String stringValue;

    private Boolean booleanValue;

}
