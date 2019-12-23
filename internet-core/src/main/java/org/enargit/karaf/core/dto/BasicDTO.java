package org.enargit.karaf.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class BasicDTO<ID> implements Serializable {

	private  ID id;

    private long version;

    private Date created;

    private Date modified;

    private String createdBy;

    private String modifiedBy;
}
