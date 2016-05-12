package com.JunitTest.TestSuite;

import com.JunitTest.TestFramework.*;
//import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HomePageTest {

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
	public void BVT_S03_TC01_CanGoToHomePage() {
		Assert.assertTrue(Pages.getHomePage().IsAt());
	}

	@Test
	public void BVT_S03_TC02_CanLoadHomePageImages() {
        for (HomePageImages item : HomePageImages.values())
        {
            Assert.assertTrue(Pages.getHomePage().CanLoadImages(item));
        }
	}

}
