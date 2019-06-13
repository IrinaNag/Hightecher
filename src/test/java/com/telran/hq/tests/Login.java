package com.telran.hq.tests;

import com.telran.hq.model.User;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void testLogin() throws Exception {
        applicationManager.getNavigationHelper().gotoLogin();
        applicationManager.getSessionHelper().fillLoginForm(User.builder().email("ghgdhd@hjhkj.com").password("1asdfghA#").build());
        applicationManager.getSessionHelper().submitLogin();
    }
}
