package com.yatra.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.qa.base.TestBase;

public class LogInPage extends TestBase{
	
	WelcomePage welcomepage = new WelcomePage();
	
	@FindBy(xpath = "//div[@id='login-form-container']/section[@class='pageheadings-block']/p[@class='main-title']")
	WebElement pageHeading;
	
	@FindBy(xpath = "//input[@id='login-input']")
	WebElement userNameField;
	
	@FindBy(xpath = "//button[@id='login-continue-btn']")
	WebElement continueButton;
	
	@FindBy(xpath = "//input[@id='login-password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[@id='login-submit-btn']")
	WebElement loginButton;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle loginUserName']")
	WebElement userName;

	public LogInPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String loginPageHeader() {
		
		return pageHeading.getText();
		
	}
	
	public HomePage Login(String username, String password) {
		
		userNameField.clear();
		userNameField.sendKeys(username);
		continueButton.click();
		passwordField.clear();
		passwordField.sendKeys(password);
		loginButton.click();
		
		return new HomePage();
	}
	
	public String userNameValidation(String username, String password) {
		
		Login(username, password);
		return userName.getText();
		
	}

}
