package org.enargit.karaf.core.listener;


import org.enargit.karaf.core.audit.CurrentIpAddress;
import org.enargit.karaf.core.audit.CurrentUser;
import org.enargit.karaf.core.entities.BaseRevisionEntity;
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
