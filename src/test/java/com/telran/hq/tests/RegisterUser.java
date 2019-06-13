package com.telran.hq.tests;

import com.telran.hq.model.User;
import org.testng.annotations.Test;

public class RegisterUser extends TestBase {

    @Test
    public void testRegisterUser() throws Exception {
        applicationManager.getNavigationHelper().gotoRegistration();
        applicationManager.getUserHelper().fillRegistrationForm(User.builder().username("asdfg").name("hgfhgfh").surname("ffhgfhd")
                .email("ghgdhd@hjhkj.com").phone("0549874567").password("1asdfghA#").password_confirmation("1asdfghA#").build());
        applicationManager.getUserHelper().submitRegistration();
    }

}
