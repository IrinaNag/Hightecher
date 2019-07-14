package com.elpisor.hq.manager;

import com.elpisor.hq.model.User;
import com.elpisor.hq.model.UserLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(UserLogin user) {
        fillLoginForm(user);
        submitLogin();
    }

    public void fillLoginForm(UserLogin user) {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[@class='btn btn-success']"));
    }
}