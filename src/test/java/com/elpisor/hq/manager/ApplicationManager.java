package com.elpisor.hq.manager;

import com.elpisor.hq.model.DBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private String browser;
    protected WebDriver driver;
    public DBase usersDB;

    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private DBHelper usersDBHelper;

    /*private StringBuffer verificationErrors = new StringBuffer();*/

    public ApplicationManager(String browser, DBase usersDB) {
        this.browser = browser;
        this.usersDB = usersDB;
        properties=new Properties();
    }

    public void start() throws IOException {
        String target=System.getProperty("target","general");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        if (browser.equals(BrowserType.CHROME))
            driver = new ChromeDriver();
        else if (browser.equals(BrowserType.FIREFOX))
            driver = new FirefoxDriver();
        else if (browser.equals(BrowserType.IE))
            driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(driver);
        navigationHelper.site(properties.getProperty("web.baseUrl"));
        userHelper = new UserHelper(driver);
        sessionHelper = new SessionHelper(driver);
        usersDBHelper = new DBHelper(usersDB);

    }


    public void stop() {
        driver.quit();
        /*String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }*/
    }

    public UserHelper user() {
        return userHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper session() {
        return sessionHelper;
    }

    public DBHelper usersDB() {
        return usersDBHelper;
    }
}

