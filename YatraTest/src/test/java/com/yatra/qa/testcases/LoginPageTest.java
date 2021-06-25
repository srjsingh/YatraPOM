package com.yatra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yatra.qa.base.TestBase;
import com.yatra.qa.pages.HomePage;
import com.yatra.qa.pages.LogInPage;
import com.yatra.qa.pages.WelcomePage;

public class LoginPageTest extends TestBase{
	
	LogInPage loginPage;
	HomePage homePage;
	WelcomePage welcomePage;
	public LoginPageTest() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		
		welcomePage = new WelcomePage();
		
		loginPage =  welcomePage.navigateToLogin();
		
	}
	
	@Test(priority = 1)
	public void loginPageHeaderTest() {
	
	String header =	loginPage.loginPageHeader();
	
	Assert.assertEquals(header, "Welcome to Yatra!");
		
	}
	
	@Test(priority = 2)
	public void loginTest() {
		
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority = 3)
	public void usernameTest() {
	
		String username =  loginPage.userNameValidation(prop.getProperty("username"), prop.getProperty("password"));
		
		System.out.println(username);
		
		Assert.assertEquals(username, "Hi Suraj");
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	
	
}