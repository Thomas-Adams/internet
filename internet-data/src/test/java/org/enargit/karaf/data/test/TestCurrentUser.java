package org.enargit.karaf.data.test;

import org.enargit.karaf.data.audit.CurrentUser;
import org.junit.Assert;
import org.junit.Test;

public class TestCurrentUser {

    @Test
    public void TestCurrentUser() {
        String currentUser = CurrentUser.getInstance().get();
        System.out.println(currentUser);
        Assert.assertNotNull(currentUser);
    }
}
