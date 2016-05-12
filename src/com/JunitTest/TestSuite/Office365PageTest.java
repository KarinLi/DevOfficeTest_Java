package com.JunitTest.TestSuite;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.JunitTest.TestFramework.Browser;
import com.JunitTest.TestFramework.Pages;
import com.JunitTest.TestFramework.Office365PagePackage.GetMessagesValue;
import com.JunitTest.TestFramework.Office365PagePackage.Platform;
import com.JunitTest.TestFramework.Office365PagePackage.ServiceToTry;

public class Office365PageTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Browser.Initialize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Browser.Close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Acceptance_S04_TC01_CanGoThroughO365API() throws InterruptedException {
        Pages.getOfficeGettingStartedPage().Office365APIGetStarted();
        Assert.assertTrue("Failed to open Office 365 APIs Getting started page.", Pages.getOffice365Page().IsAtOffice365Page());
        Assert.assertTrue("Cards in Office 365 page are not displayed correctly.", Pages.getOffice365Page().OnlyDefaultCardsDisplayed());

        Pages.getOffice365Page().CardTryItOut().ChooseService(ServiceToTry.GetMessages);
        Pages.getOffice365Page().CardTryItOut().ClickTry();
        Assert.assertTrue("Failed to get the response for the serivce to try.", Pages.getOffice365Page().CardTryItOut().CanGetResponse(GetMessagesValue.Inbox));

        Platform platform = Platform.Node;
        Pages.getOffice365Page().CardSetupPlatform().ChoosePlatform(platform);
        Assert.assertTrue("Failed to choose platform " + platform.toString(), Pages.getOffice365Page().CardSetupPlatform().IsShowingPlatformSetup(platform));
        Assert.assertFalse("Card with id 'setup-project' in Office 365 page is not displayed correctly.", Pages.getOffice365Page().IsCardDisplayed("setup-project"));
        Assert.assertFalse("Card with id 'next-step' in Office 365 page is not displayed correctly.", Pages.getOffice365Page().IsCardDisplayed("next-step"));

        Pages.getOffice365Page().CardRegisterApp().SigninLater();
        Assert.assertTrue("Card with id 'setup-project' in Office 365 page is not displayed correctly.", Pages.getOffice365Page().IsCardDisplayed("setup-project"));
        Assert.assertTrue("Card with id 'next-step' in Office 365 page is not displayed correctly.", Pages.getOffice365Page().IsCardDisplayed("next-step"));
        Assert.assertFalse("Card with id 'AllSet' in Office 365 page is not displayed correctly.", Pages.getOffice365Page().IsCardDisplayed("AllSet"));
        Pages.getOffice365Page().CardDownloadCode().DownloadCode(); 
        Assert.assertTrue("Failed to download code.", Pages.getOffice365Page().CardDownloadCode().IsCodeDownloaded());
        Assert.assertTrue("Card with id 'AllSet' in Office 365 page is not displayed correctly.", Pages.getOffice365Page().IsCardDisplayed("AllSet"));
	}

}
