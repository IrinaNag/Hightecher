package com.telran.hq.tests;

import com.telran.hq.manager.ApplicationManager;
import com.telran.hq.model.DBase;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME
            , new DBase("mongodb://server:CjuND8hJ8L84F6N@ds349045.mlab.com:49045/?authSource=ht-profiles", "ht-profiles"));

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.start();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void logTestStart(Method method, Object[] p) {
        logger.info("Start test " + method.getName() + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method, Object[] p) {
        logger.info("Stop test " + method.getName() + Arrays.asList(p));
    }

}
