package com.telran.hq.manager;

import org.openqa.selenium.*;

public class HelperBase {
    protected WebDriver driver;
    private boolean acceptNextAlert = true;


    public HelperBase(WebDriver driver) {
        this.driver=driver;
    }

    protected void type(By locator, String str) {
        click(locator);
        clear(locator);
        sendKeys(locator, str);
    }

    private void sendKeys(By locator, String str) {
        driver.findElement(locator).sendKeys(str);
    }

    private void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
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


}
