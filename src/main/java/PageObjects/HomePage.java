package PageObjects;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.project.automationDemoProject.ConfigFileReader;

public class HomePage {
	
	WebDriver driver;
	ConfigFileReader configFileReader;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
	}
	
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']") 
    WebElement searchText;
	
	@FindBy(how = How.CSS, using = "#nav-search-submit-button") 
    WebElement search_submit;
	
	@FindBy(xpath = "//span[contains(text(),\"Apple iPhone 1\")]") 
    WebElement firstItem;
	
	
	public void Search_Item(String item) {
		searchText.sendKeys(item);
		search_submit.click();
	}

	public void verifyFirstItem(String item) {
		String text=firstItem.getText();
		System.out.println(text);
		Assert.assertTrue(text.toLowerCase().contains(item), "Item not match");
	}
	
}
