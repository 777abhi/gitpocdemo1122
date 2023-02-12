package com.project.automationDemoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	static ConfigFileReader configFileReader=new ConfigFileReader();
	
	public static WebDriver startApplication(WebDriver driver, String browserName,String appUrl) {
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
			// Create driver object for CHROME browser  
			driver = new ChromeDriver();  
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPath());
			// Create driver object for firefox browser  
			driver = new ChromeDriver();  
		}else {
				
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize();  
		driver.get(appUrl);
		return driver;
		
	}
	
	
}
