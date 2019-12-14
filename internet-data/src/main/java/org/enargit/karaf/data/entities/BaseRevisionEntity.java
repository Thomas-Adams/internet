package org.enargit.karaf.data.entities;

import org.enargit.karaf.data.listener.BaseRevisionEntityListener;
import org.hibernate.envers.DefaultRevisionEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@org.hibernate.envers.RevisionEntity(BaseRevisionEntityListener.class)
@Table(name = "rev_info")
@Entity
public class BaseRevisionEntity extends DefaultRevisionEntity {

    public BaseRevisionEntity() {
        super();
    }

    public BaseRevisionEntity(String username, String ip) {
        super();
        this.username = username;
        this.ip = ip;
    }

    @Column
    private String username;

    @Column
    private String ip;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
