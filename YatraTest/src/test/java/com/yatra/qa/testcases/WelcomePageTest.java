package com.yatra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.LogInPage;
import com.yatra.qa.pages.WelcomePage;

public class WelcomePageTest extends TestBase{
	
	WelcomePage welcomePage;
	LogInPage loginPage;
	public WelcomePageTest() {
	
		super();
	
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		welcomePage = new WelcomePage();
		
	}
	
	@Test(priority = 1)
	public void welcomePageTitleTest() {
		
		String title = welcomePage.validateWelcomepageTitle();
		
		System.out.println(title);
		
		Assert.assertEquals(title, "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		
	}
	
	@Test(priority = 2)
	public void welcomePageLogoTest() {
		
		boolean flag =  welcomePage.validateWelcomepageLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority = 3)
	public void navigateToLoginPageTest() {
		
		loginPage = welcomePage.navigateToLogin();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	

}
