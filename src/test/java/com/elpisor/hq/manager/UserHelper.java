package com.elpisor.hq.manager;

import com.elpisor.hq.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver driver) {
        super(driver);
    }


    public void registration(User user) {
        fillRegistrationForm(user);
        submitRegistration();
    }

    public void submitRegistration() {
        click(By.xpath("//button[@class='btn btn-success']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("username"), user.getUsername());
        type(By.id("name"), user.getName());
        type(By.id("surname"), user.getSurname());
        type(By.id("email"), user.getEmail());
        type(By.id("phone"), user.getPhone());
        type(By.id("password"), user.getPassword());
        type(By.id("password_confirmation"), user.getPassword_confirmation());
    }


}