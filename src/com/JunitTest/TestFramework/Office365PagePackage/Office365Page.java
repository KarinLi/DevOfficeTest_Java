package com.JunitTest.TestFramework.Office365PagePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.JunitTest.TestFramework.Browser;

public class Office365Page {
    public CardSetupPlatform CardSetupPlatform()
    {
        return new CardSetupPlatform();
    }

    public CardTryItOut CardTryItOut()
    {
        return new CardTryItOut();
    }

    public CardRegisterApp CardRegisterApp()
    {
        return new CardRegisterApp(); 
    }

    public CardDownloadCode CardDownloadCode()
    {
        return new CardDownloadCode();
    }

    public boolean IsAtOffice365Page()
    {
        return Browser.getTitle().contains("Getting started with Office 365 REST APIs");
    }

    public boolean OnlyDefaultCardsDisplayed()
    {
        List<WebElement> elements = Browser.getDriver().findElements(By.className("card"));
        if (elements.size() > 0)
        {
            for (WebElement item : elements)
            {
                String itemId = item.getAttribute("id");
                if ((itemId.equals("intro") || itemId.equals("try-it-out") || itemId.equals("setup")) && !item.isDisplayed())
                {
                    return false;
                }

                if (!itemId.equals("intro") && !itemId.equals("try-it-out") && !itemId.equals("setup") && item.isDisplayed())
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean IsCardDisplayed(String CardId)
    {
        if (CardId.contains("AllSet"))
        {
        	WebElement element = Browser.getDriver().findElement(By.id("AllSet"));
            return element.isDisplayed();
        }
        else
        {
        	List<WebElement> elements = Browser.getDriver().findElements(By.className("card"));
            if (elements.size() > 0)
            {
                for (WebElement item : elements)
                {
                    String itemId = item.getAttribute("id");
                    if (itemId.equals(CardId))
                    {
                        return item.isDisplayed();
                    }
                }

                return false;
            }
            else
            {
                return false;
            }
        }
    }
}
