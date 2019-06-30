package com.elpisor.hq.manager;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;
    private String browser;
    protected WebDriver driver;
    /*public DBase usersDB;*/
    MongoClient mongoUser;
    MongoClient mongoSkills;

    private UserHelper userHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private DBHelper usersDBHelper;
   /* private DBHelper skillsDBHelper;*/

    /*private StringBuffer verificationErrors = new StringBuffer();*/

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties=new Properties();
        String target=System.getProperty("target","general");
        try {
            properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mongoUser= MongoClients.create(properties.getProperty("usersDatabase.uri"));
    }

    public void start() throws IOException {

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
        /*usersDBHelper = new DBHelper(new DBase(properties.getProperty("usersDatabase.uri"),properties.getProperty("usersDatabase.name")));*/

        usersDBHelper = new DBHelper(mongoUser);
        /*skillsDBHelper = new DBHelper(new DBase(properties.getProperty("skillsDatabase.uri"),properties.getProperty("skillsDatabase.name")));*/
        /*mongoSkills= MongoClients.create(properties.getProperty("skillsDatabase.uri"));
        skillsDBHelper = new DBHelper(mongoSkills);*/

    }


    public void stop() {
        driver.quit();
        mongoUser.close();
        /*mongoSkills.close();*/
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

    public Properties getProperties() {
        return properties;
    }

    public MongoClient getMongoUser() {
        return mongoUser;
    }
}

