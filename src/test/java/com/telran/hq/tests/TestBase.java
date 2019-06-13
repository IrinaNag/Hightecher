package com.telran.hq.tests;

import com.telran.hq.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        applicationManager.start();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        applicationManager.stop();
    }

}
