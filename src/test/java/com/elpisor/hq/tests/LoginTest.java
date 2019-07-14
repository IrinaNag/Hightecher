package com.elpisor.hq.tests;

import com.elpisor.hq.model.UserLogin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;

public class LoginTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> loginPositiveData() throws IOException {
        return app.session().getDataFromFile("src/test/resources/loginPositiveData.csv");

    }

    @Test(dataProvider = "loginPositiveData")
    public void testLogin(UserLogin user) throws Exception {
        app.goTo().loginPage();
        app.session().login(user);
    }

}
