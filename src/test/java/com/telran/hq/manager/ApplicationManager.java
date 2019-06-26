package com.telran.hq.manager;

import com.telran.hq.model.DBase;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private String browser;
    protected WebDriver driver;
    public DBase usersDB;

    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private DBHelper usersDBHelper;

    private StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager(String browser, DBase usersDB) {
        this.browser = browser;
        this.usersDB = usersDB;
    }

    public void start() {
        if (browser.equals(BrowserType.CHROME))
            driver = new ChromeDriver();
        else if (browser.equals(BrowserType.FIREFOX))
            driver = new FirefoxDriver();
        else if (browser.equals(BrowserType.IE))
            driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(driver);
        navigationHelper.site("https://hightecher.com/");
        userHelper = new UserHelper(driver);
        sessionHelper = new SessionHelper(driver);
        usersDBHelper = new DBHelper(usersDB);

    }


    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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

