package com.elpisor.hq.manager;

import com.elpisor.hq.model.UserLogin;
import lombok.NoArgsConstructor;
import org.openqa.selenium.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.stream.Collectors;

@NoArgsConstructor
public class HelperBase {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;


    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        String existingText = driver.findElement(locator).getAttribute("value");
        if (!existingText.equals(text)) {
            click(locator);
            clear(locator);
            sendKeys(locator, text);
        }
    }

    protected void sendKeys(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


    public String getAlertText() {
        try {
            return driver.switchTo().alert().getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public Iterator<Object[]> getDataFromFile(String fileName) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines().map(line -> line.split(";"))
                    .map(split -> new Object[]{new UserLogin(split[0], split[1])})
                    .collect(Collectors.toList()).iterator();
        }
    }



}
