package com.JunitTest.TestFramework.Office365PagePackage;

import com.JunitTest.TestFramework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SigninCommand {
    private final String userName;
    private String password;

    public SigninCommand(String userName)
    {
        this.userName = userName;
    }

    public SigninCommand WithPassword(String password)
    {
        this.password = password;
        return this;
    }

    public void Signin() throws InterruptedException
    {
    	WebElement signinGoBtn = Browser.getDriver().findElement(By.id("app-reg-signin"));
        Browser.click(signinGoBtn);
        Browser.Wait(1);

        WebElement signinInput = Browser.getDriver().findElement(By.name("login"));
        signinInput.sendKeys(userName);
        WebElement passwordInput = Browser.getDriver().findElement(By.name("passwd"));
        passwordInput.sendKeys(password);
        WebElement signinBtn = Browser.getDriver().findElement(By.id("cred_sign_in_button"));
        Browser.Wait(1);

        Browser.click(signinBtn);
    }

}
