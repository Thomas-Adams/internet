package org.enargit.karaf.data.listener;


import org.enargit.karaf.data.audit.CurrentIpAddress;
import org.enargit.karaf.data.audit.CurrentUser;
import org.enargit.karaf.data.entities.BaseRevisionEntity;
import org.hibernate.envers.RevisionListener;

public class BaseRevisionEntityListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        BaseRevisionEntity customBaseRevisionEntity = (BaseRevisionEntity) revisionEntity;
        customBaseRevisionEntity.setUsername(CurrentUser.getInstance().get());
        customBaseRevisionEntity.setIp(CurrentIpAddress.INSTANCE.get());
    }

    public BaseRevisionEntityListener() {
    }
}
