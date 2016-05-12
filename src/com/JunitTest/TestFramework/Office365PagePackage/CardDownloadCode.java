package com.JunitTest.TestFramework.Office365PagePackage;

import com.JunitTest.TestFramework.BasePage;
import com.JunitTest.TestFramework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CardDownloadCode extends BasePage {
    public void DownloadCode()
    {
    	WebElement downloadBtn = Browser.getDriver().findElement(By.id("downloadCodeSampleButton"));
        Browser.click(downloadBtn);

        // When the card indicates all thing is done is displayed, the click event can be considered as finished.
        Browser.wait(By.id("AllSet"));
    }

    public boolean IsCodeDownloaded()
    {
    	WebElement downloadResult = Browser.getDriver().findElement(By.id("post-download-instructions"));
        return downloadResult.isDisplayed();
    }
}
