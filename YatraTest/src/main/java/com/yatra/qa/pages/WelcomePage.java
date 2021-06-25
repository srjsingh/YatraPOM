package com.yatra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.qa.base.TestBase;

public class WelcomePage extends TestBase{
	
	@FindBy(xpath = "//a[@class='dropdown-toggle' and text()='My Account']")
	WebElement myAccountdrp;
	
	@FindBy(id = "signInBtn")
	WebElement signInbtn;
	
	@FindBy(id = "SignUpBtn")
	WebElement signUpbtn;
	
	@FindBy(xpath = "//a[@class='logo']/i")
	WebElement yatraLogo;
	
	public WelcomePage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String validateWelcomepageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean validateWelcomepageLogo() {
		
		return yatraLogo.isDisplayed();
		
	}
	
	public LogInPage navigateToLogin() {
		
		myAccountdrp.click();
		
		signInbtn.click();
		
		return new LogInPage();
		
	}

}
