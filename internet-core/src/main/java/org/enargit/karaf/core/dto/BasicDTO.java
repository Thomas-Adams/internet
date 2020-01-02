package org.enargit.karaf.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.core.json.JodaDateTimeSerializer;

import java.io.Serializable;
import java.util.Date;




@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class BasicDTO<ID> implements Serializable {

	private  ID id;

    private long version;


    @JsonSerialize(using = JodaDateTimeSerializer.class)
    private Date created;

    @JsonSerialize(using = JodaDateTimeSerializer.class)
    private Date modified;

    private String createdBy;

    private String modifiedBy;
}
