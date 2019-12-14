package org.enargit.karaf.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.enargit.karaf.data.audit.CurrentUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@SuperBuilder
@Data
@MappedSuperclass
public abstract class BasicEntity<ID> implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected  ID id;

    @Version
    protected long version;

    @Column(nullable = false, updatable = false)
    protected Date created;

    @Column(nullable = true, updatable = true)
    protected Date modified;

    @Column(nullable = false, updatable = false)
    protected String createdBy;

    @Column(nullable = true, updatable = true)
    protected String modifiedBy;

    @PrePersist
    public void prePersist() {
        String currentUser = CurrentUser.getInstance().get();
        if(created==null) {
            created = new Date();
            createdBy = currentUser;
        } else {
            modified = new Date();
            modifiedBy = currentUser;
        }
    }

}
