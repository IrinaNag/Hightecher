package com.telran.hq.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void gotoRegistration() {
        click(By.linkText("Registration"));
    }

    public void gotoLogin() {
        click(By.linkText("Login"));
    }
}
