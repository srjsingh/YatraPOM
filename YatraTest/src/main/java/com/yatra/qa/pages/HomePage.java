package com.yatra.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.yatra.qa.base.TestBase;

public class HomePage extends TestBase{
	
	String dateVal = prop.getProperty("deptdate");
	
	@FindBy(id = "booking_engine_flights")
	WebElement flightTab;
	
	@FindBy(xpath = "//a[@title='One Way']")
	WebElement oneWayTripOption;
	
	@FindBy(xpath = "//li[@class='initial-tab flex1 safariFix__field']")
	WebElement deptLabel;
	
	@FindBy(xpath = "//i[@title='Swap Origin City and Destination City' and @tabindex= '-1']")
	WebElement swapButton;
	
	@FindBy(id = "BE_flight_origin_date")
	WebElement deptDate;
	
	@FindBy(id = "BE_flight_flsearch_btn")
	WebElement submitButton;
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
	}

	public FlightBookingPage searchFlight(String departureCity, String arrCity, String departureDate) throws InterruptedException{
		
		deptLabel.click();
		
		Thread.sleep(2000);
		
		WebElement ele=driver.findElement(By.xpath("//p[@class='ac_cityname'][text()='"
				+ departureCity
				+ " ']/../.."));
        ele.click();
        driver.findElement(By.xpath("//p[@class='ac_cityname'][text()='"
        		+ arrCity
        		+ " ']/../..")).click();
        
        Thread.sleep(2000);
        
        deptDate.click();
		
       driver.findElement(By.xpath("//td[@id='"+dateVal+"']")).click();
       
       submitButton.click();
    	   
       
       return new FlightBookingPage();
		
	}
	
}
