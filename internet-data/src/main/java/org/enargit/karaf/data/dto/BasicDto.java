package org.enargit.karaf.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
public abstract class BasicDto<ID> implements Serializable {

    protected  ID id;

    protected long version;

    protected Date created;

    protected Date modified;

    protected String createdBy;

    protected String modifiedBy;

}
