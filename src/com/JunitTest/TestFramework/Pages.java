package com.JunitTest.TestFramework;

public class Pages {
	static { }
	public static HomePage getHomePage() {
		return new HomePage();
	}
	public static OfficeGettingStartedPage getOfficeGettingStartedPage() {
		return new OfficeGettingStartedPage();
	}
	public static com.JunitTest.TestFramework.Office365PagePackage.Office365Page getOffice365Page() {
		return new com.JunitTest.TestFramework.Office365PagePackage.Office365Page();
	}

}
