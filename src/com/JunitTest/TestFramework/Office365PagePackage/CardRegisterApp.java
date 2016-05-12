package com.JunitTest.TestFramework.Office365PagePackage;

import com.JunitTest.TestFramework.BasePage;
import com.JunitTest.TestFramework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardRegisterApp extends BasePage {
    public SigninCommand SigninAs(String userName)
    {
        if (!Browser.getUrl().contains("/getting-started/office365apis"))
        {
            Browser.Goto(Browser.BaseAddress + "/Getting-Started/office365Apis#register-app");
        }

        return new SigninCommand(userName);
    }

    public RegisterCommand Register()
    {
        return new RegisterCommand();
    }

    /// <summary>
    /// Choose to sign in later in the register app card
    /// </summary>
    public void SigninLater()
    {
    	WebElement signedinLater = Browser.getDriver().findElement(By.id("app-reg-signin-later"));
        Browser.click(signedinLater);
    }

    public boolean IsSignedin(String userName) throws InterruptedException
    {
        Browser.Wait(2);
        WebElement registrationForm = Browser.getDriver().findElement(By.id("registration-form"));
        return registrationForm.isDisplayed();
    }

    public boolean IsRegistered() throws InterruptedException
    {
        Browser.Wait(2);
        WebElement registrationResult = Browser.getDriver().findElement(By.id("registration-result"));
        WebElement resultText = registrationResult.findElement(By.tagName("div"));
        return (registrationResult.isDisplayed() && resultText.getText().equals("Registration Successful!"));
    }

}
