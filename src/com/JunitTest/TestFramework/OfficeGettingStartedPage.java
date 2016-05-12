package com.JunitTest.TestFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfficeGettingStartedPage extends BasePage  {
    public void Office365APIGetStarted()
    {
    	WebElement o365GetStarted = Browser.getDriver().findElement(By.cssSelector("#body-content>div:nth-child(2)>a"));
        Browser.click(o365GetStarted);

        // When the card to choose platform is displayed, the click event can be considered as finished.
        Browser.wait(By.id("setup"));
    }

    public void OfficeAddInGetStarted()
    {
    	WebElement addinGetStarted = Browser.getDriver().findElement(By.cssSelector("#body-content>div:nth-child(3)>a"));
        Browser.click(addinGetStarted);

        // When the card to choose product is displayed, the click event can be considered as finished.
        Browser.wait(By.id("selectapp"));
    }

    public boolean CanLoadImage()
    {
        WebElement element = Browser.getDriver().findElement(By.id("banner-image"));
        String Url = element.getAttribute("style");
        Url = Browser.BaseAddress + Url.substring(Url.indexOf('/'), Url.lastIndexOf('\"'));
        return Utility.ImageExist(Url);
    }

    public OfficeGettingStartedPage()
    {
        if (!Browser.getUrl().endsWith("/getting-started"))
        {
            Browser.Goto(Browser.BaseAddress + "/getting-started");
        }
    }

}
