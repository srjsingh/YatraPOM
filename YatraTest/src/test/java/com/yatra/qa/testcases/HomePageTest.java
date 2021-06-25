package com.yatra.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.FlightBookingPage;
import com.yatra.qa.pages.HomePage;
import com.yatra.qa.pages.LogInPage;
import com.yatra.qa.pages.WelcomePage;

public class HomePageTest extends TestBase{
	
	WelcomePage welcomePage;
	LogInPage logInPage;
	HomePage homePage;
	FlightBookingPage flightBookingPage;
	
	public HomePageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		welcomePage = new WelcomePage();
		logInPage = welcomePage.navigateToLogin();
		homePage = logInPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void searchFlightTest() throws InterruptedException{
				
		flightBookingPage =	homePage.searchFlight(prop.getProperty("departure"), prop.getProperty("arrival"), prop.getProperty("deptdate"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
