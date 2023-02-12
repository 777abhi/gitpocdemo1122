package com.project.automationDemoProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;

public class TC_01_Amazon_ItemTest extends BaseTest{
	
	   public WebDriver driver ;  
	   ConfigFileReader configFileReader=new ConfigFileReader();
	
		@Test             
		public void TC_01_Amazon_ItemTest() {      
		driver=startApplication(driver,"chrome",ConfigFileReader.getApplicationUrl());
		String URL= driver.getCurrentUrl();  
		System.out.print(URL);  
		//get the title of the page  
		String title = driver.getTitle();                  
		System.out.println(title);  
		HomePage homepage=new HomePage(driver);
		homepage.Search_Item("iphone");
		homepage.verifyFirstItem("iphone");
		}     
		@BeforeTest  
		public void beforeTest() {    
		System.out.println("before test");  
		}     
		@AfterTest  
		public void afterTest() {  
		driver.quit();  
		System.out.println("after test");  
		}         
	}  

