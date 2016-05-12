package com.JunitTest.TestFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
	private static String PageTitle = "Office Dev Center - Office Dev Center";

	public boolean IsAt()
    {
        return Browser.getTitle().equalsIgnoreCase(PageTitle);
    }


    public boolean CanLoadImages(HomePageImages image)
    {
        switch (image)
        {
            case Banner:
            	List<WebElement> elements = Browser.getDriver().findElements(By.cssSelector("#banner-image"));
                for (WebElement item : elements)
                {
                    String Url = item.getAttribute("style");
                    Url = Browser.BaseAddress + Url.substring(Url.indexOf('/'), Url.lastIndexOf('\"'));
                    if (!Utility.ImageExist(Url))
                    {
                        return false;
                    }
                }

                return true;
            case Icons:
                elements = Browser.getDriver().findElements(By.cssSelector("img"));
                for (WebElement item : elements)
                {
                    String Url = item.getAttribute("src");
                    if (!Utility.ImageExist(Url))
                    {
                        return false;
                    }
                }

                return true;
            default:
                return false;
        }
    }
}
