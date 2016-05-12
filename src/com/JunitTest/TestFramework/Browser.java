package com.JunitTest.TestFramework;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

//import org.openqa.selenium.ie.InternetExplorerDriver;

@SuppressWarnings("deprecation")
public class Browser {
	static WebDriver webDriver;
    static String defaultTitle;
    static String defaultHandle;
    static String homeTitle;

    static {
    	InitializeBrowser();
    }
    
	public static void Initialize()
    {
    	BaseAddress = Utility.GetConfigurationValue("BaseAddress");
    	BaseAddress = BaseAddress.endsWith("/") ? BaseAddress.substring(0, BaseAddress.length() - 1) : BaseAddress;
    	try {
            webDriver.navigate().to(BaseAddress);
    	}
    	catch (SessionNotFoundException e) {
    		InitializeBrowser();
            webDriver.navigate().to(BaseAddress);
    	}
        defaultTitle = getTitle();
        homeTitle = defaultTitle;
    	
    }
    
    public static void Initialize(String postfix)
    {
    	BaseAddress = Utility.GetConfigurationValue("BaseAddress");
    	BaseAddress = BaseAddress.endsWith("/") ? BaseAddress.substring(0, BaseAddress.length() - 1) : BaseAddress;
        String address = BaseAddress;
        if (!postfix.equals(""))
        {
            address = BaseAddress + "/" + postfix;
        }
    	try {
            webDriver.navigate().to(address);
    	}
    	catch (SessionNotFoundException e) {
    		InitializeBrowser();
            webDriver.navigate().to(address);
    	}
        defaultTitle = getTitle();
        homeTitle = defaultTitle;
    	
    }
    
    public static void Goto(String url)
    {
        try
        {
            webDriver.navigate().to(url);
        }
        catch (TimeoutException e)
        {
            webDriver.navigate().refresh();
        }
        
        defaultTitle = getTitle();
    }

    public static void Close()
    {
        webDriver.quit();
        //webDriver.close();
    }
    
    //public static SearchContext Driver = (SearchContext)webDriver;
    public static SearchContext getDriver()
    {
    	return (SearchContext)webDriver;
    }

    public static String getTitle()
    {
    	return webDriver.getTitle();
    }
    public static String getUrl()
    {
    	return webDriver.getCurrentUrl();
    }
    public static String BaseAddress;
	public static void click(WebElement element) {
        try
        {
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", element);
        }
        catch (TimeoutException e)
        {
            webDriver.navigate().refresh();
        }
	}

    public static void Wait(long waitTime) throws InterruptedException
    {
        // need to replace with Framework wait methods: implicit wait, explicit wait
        Thread.sleep((long)waitTime * 1000);
    }

	public static void wait(By by) {
		WebDriverWait wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static Select SelectElement(WebElement findElement) {
        return new Select(findElement);
	}
	
	private static void InitializeBrowser() {
        switch (Utility.GetConfigurationValue("Browser"))
        {
            case ("Chrome"):
            	//ChromeOptions options = new ChromeOptions();
                //String temp = System.getProperty("user.dir");                
            	//options.setBinary(new File(System.getProperty("user.dir") + "/Drivers/"));
            	//options.setBinary(System.getProperty("user.dir") + "/src/Drivers/chromedriver");
                //webDriver = new ChromeDriver(options);
            	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/Drivers/chromedriver");
                webDriver = new ChromeDriver();
                break;
            case ("IE32"):
                //webDriver = new InternetExplorerDriver(System.IO.Directory.GetCurrentDirectory() + @"/Drivers/IE32/");
                //break;
            case ("IE64"):
                //webDriver = new InternetExplorerDriver(System.IO.Directory.GetCurrentDirectory() + @"/Drivers/IE64/");
                break;
            case ("Firefox"):
            default:
                webDriver = new FirefoxDriver();
                break;
        }

        defaultHandle = webDriver.getWindowHandle();
		
	}

}
