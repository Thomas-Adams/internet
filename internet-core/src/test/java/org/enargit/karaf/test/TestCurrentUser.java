package org.enargit.karaf.test;

import org.enargit.karaf.core.audit.CurrentUser;
import org.junit.Assert;
import org.junit.Test;

public class TestCurrentUser {

    @Test
    public void testCurrentUser() {
        String currentUser = CurrentUser.getInstance().get();
        System.out.println(currentUser);
        Assert.assertNotNull(currentUser);
    }
}
