package com.JunitTest.TestFramework;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public BasePage() {
		PageFactory.initElements(Browser.webDriver, this);
	}

}
