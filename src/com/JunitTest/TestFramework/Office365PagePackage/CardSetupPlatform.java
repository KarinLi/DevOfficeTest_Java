package com.JunitTest.TestFramework.Office365PagePackage;

import com.JunitTest.TestFramework.BasePage;
import com.JunitTest.TestFramework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardSetupPlatform extends BasePage {
    public void ChoosePlatform(Platform platformName) throws InterruptedException
    {
        if (!Browser.getTitle().contains("/getting-started/office365apis"))
        {
            Browser.Goto(Browser.BaseAddress + "/getting-started/office365apis#setup");
        }

        WebElement platform = Browser.getDriver().findElement(By.id("option-"+platformName.toString().toLowerCase()));
        Browser.click(platform);

        // Need refactor: Sometimes case failed for the platform setup text is not changed in time
        Browser.Wait(2);
    }

    public boolean IsShowingPlatformSetup(Platform platformName)
    {
    	WebElement setupPlatformDoc = Browser.getDriver().findElement(By.cssSelector("#ShowDocumentationDiv>h1"));
        String platformDescription = Platform.getDescription(platformName).toLowerCase();
        return setupPlatformDoc.getText().toLowerCase().contains(platformDescription);
    }
}
