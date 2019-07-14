package com.elpisor.hq.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void site(String url) {
        driver.get(url);
    }

    public void registrationPage() {
        click(By.linkText("Registration"));
    }

    public void loginPage() {
        click(By.linkText("Login"));
    }
}