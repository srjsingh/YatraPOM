package com.yatra.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.yatra.qa.util.TestUtil;
import com.yatra.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		
		try {
			
			prop = new Properties();
			FileInputStream io = new FileInputStream("C:\\Users\\Suraj\\git\\YatraPOM\\YatraTest\\src\\main\\java\\com\\yatra\\qa\\config\\config.properties");
			prop.load(io);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		
		if (browsername.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Chrome Driver\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();

	        prefs.put("profile.default_content_setting_values.notifications", 2);

	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);
			
			driver = new ChromeDriver(options);
			
		}
		
		else if(browsername.contains("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Suraj\\Desktop\\Selenium Jar\\Firefox Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		             // fire event
		
		e_driver = new EventFiringWebDriver(driver); 
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
					// fire event
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		String url = prop.getProperty("url");
		
		driver.get(url);
		
	}

}
