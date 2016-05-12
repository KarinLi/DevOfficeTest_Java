package com.JunitTest.TestFramework.Office365PagePackage;

import com.JunitTest.TestFramework.BasePage;
import com.JunitTest.TestFramework.Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardTryItOut extends BasePage {
    private static boolean isParameterValueContained = false;
    private static ServiceToTry currentSerivce = ServiceToTry.GetMessages;

    public void ChooseService(ServiceToTry serviceToTry)
    {
        if (!Browser.getUrl().contains("/getting-started/office365apis"))
        {
            Browser.Goto(Browser.BaseAddress + "/getting-started/office365apis#try-it-out");
        }

        int serviceIndex = serviceToTry.getIndex();
        WebElement service = Browser.getDriver().findElement(By.id("serviceOption"+serviceIndex));
        Browser.click(service);
        currentSerivce = serviceToTry;
    }
	
    public boolean ChooseServiceValue(Object value)
    {
        String serviceValue = null;
        switch (currentSerivce)
        {
            case GetMessages:
                {
                    switch ((GetMessagesValue)value)
                    {
                        case Inbox:
                        case Drafts:
                        case DeletedItems:
                        case SentItems:
                            serviceValue = value.toString();
                            break;
                        default:
                            serviceValue = null;
                            break;
                    }
                    break;
                }
            case GetFiles:
                {
                    switch ((GetFilesValue)value)
                    {
                        case drive_root_children:
                            serviceValue = "drive/root/children";
                            break;
                        case me_drive:
                            serviceValue = "me/drive";
                            break;
                        default:
                            serviceValue = null;
                            break;
                    }
                    break;
                }
            case GetContacts:
            case GetEvents:
            default:
                serviceValue = null;
                break;
        }

        if (serviceValue != null)
        {
            Browser.SelectElement(Browser.getDriver().findElement(By.id("valueSelection"))).selectByVisibleText(serviceValue);
            isParameterValueContained = Browser.getDriver().findElement(By.id("urlValue")).getText().contains(serviceValue);
            return true;
        }
        else
        {
            return false;
        }
    }

    public void ClickTry()
    {
    	WebElement tryBtn = Browser.getDriver().findElement(By.id("invokeurlBtn"));
        Browser.click(tryBtn);

        //if (Browser.getDriver().FindElement(By.Id("responseBody")) != null)
        //{
        //    Browser.Wait(TimeSpan.FromSeconds(3));
        //}
        // var wait = new WebDriverWait(Browser.getDriver() as IWebDriver, TimeSpan.FromSeconds(5));
        //wait.Until(d => d.FindElement(By.Id("response-container")));
        //WebDriverWait wait = new WebDriverWait((Browser.getDriver() as IWebDriver), TimeSpan.FromSeconds(10));
        //IWebElement responseContainer = wait.Until(d =>
        //{
        //    return d.FindElement(By.Id("response-container"));
        //});

        try
        {
        	Actions action = new Actions((WebDriver)Browser.getDriver());
        	WebElement responseContainer = Browser.getDriver().findElement(By.id("response-container"));
            action.moveToElement(responseContainer);
            action.perform();
        }
        catch (Exception e)
        {
            { }
            throw e;
        }
    }

    public boolean CanGetResponse(Object value)
    {
    	WebElement responseBody = Browser.getDriver().findElement(By.id("responseBody"));
        //String responseText = responseBody.getText().toLowerCase();
        String textToBePresent = "";
        int serviceIndex = currentSerivce.getIndex();
        switch (serviceIndex)
        {
            case (0):
                switch ((GetMessagesValue)value)
                {
                    case Inbox:
                        textToBePresent = "/mailFolders('Inbox')/messages";
                        break;
                    case Drafts:
                        textToBePresent = "/mailFolders('Drafts')/messages";
                        break;
                    case DeletedItems:
                        textToBePresent = "/mailFolders('DeletedItems')/messages";
                        break;
                    case SentItems:
                        textToBePresent = "/mailFolders('SentItems')/messages";
                        break;
                    default:
                        break;
                }
                break;
            case (1):
                textToBePresent = "/events";
                break;
            case (2):
                textToBePresent = "/contacts";
                break;
            case (3):
                switch ((GetFilesValue)value)
                {
                    case drive_root_children:
                        textToBePresent = "https://graph.microsoft.com/v1.0/$metadata#drive/root/children";
                        break;
                    case me_drive:
                        textToBePresent = "https://graph.microsoft.com/v1.0/$metadata#drives/$entity";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

        WebDriverWait wait = new WebDriverWait((WebDriver)Browser.getDriver(), 30);
        wait.until(ExpectedConditions.textToBePresentInElement(responseBody, textToBePresent));

        return true; 
    }

    public boolean UrlContainsServiceName()
    {
        if (IsParameterTableDisplayed())
        {
            switch (currentSerivce)
            {
                case GetMessages:
                case GetEvents:
                case GetContacts:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains(ServiceToTry.getDescription(currentSerivce));
                case GetFiles:
                case GetUsers:
                case GetGroups:
                    return isParameterValueContained;
                default:
                    return false;
            }
        }
        else
        {
            switch (currentSerivce)
            {
                case GetMessages:
                case GetEvents:
                case GetContacts:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains(ServiceToTry.getDescription(currentSerivce));
                case GetFiles:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains("drive/root/children");
                case GetUsers:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains("me");
                case GetGroups:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains("me/memberOf");
                default:
                    return false;
            }
        }
    }

    public boolean UrlContainsParameterValue()
    {
        if (IsParameterTableDisplayed())
        {
            return isParameterValueContained;
        }
        else
        {
            switch (currentSerivce)
            {
                case GetMessages:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains(GetMessagesValue.Inbox.toString());
                case GetFiles:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains("drive/root/children");
                case GetUsers:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains("me");
                case GetGroups:
                    return Browser.getDriver().findElement(By.id("urlValue")).getText().contains("me/memberOf");
                default:
                    return false;
            }
        }
    }

    public boolean IsParameterTableDisplayed()
    {
        WebElement parameterDetail = Browser.getDriver().findElement(By.id("parameterDetails"));
        return parameterDetail.getText() != null && parameterDetail.getText() != "";
    }

}
