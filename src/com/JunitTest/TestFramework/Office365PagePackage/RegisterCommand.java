package com.JunitTest.TestFramework.Office365PagePackage;

import com.JunitTest.TestFramework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterCommand {
    private String appName;

    public RegisterCommand Register()
    {
        return this;
    }

    public void WithAppName(String name) throws InterruptedException
    {
        this.appName = name;
        WebElement appNameInput = Browser.getDriver().findElement(By.id("appNameField"));
        appNameInput.sendKeys(appName);
        Browser.Wait((long)0.5);

        WebElement registerBtn = Browser.getDriver().findElement(By.id("register-button"));
        Browser.click(registerBtn);
        Browser.Wait(2);
    }

}
