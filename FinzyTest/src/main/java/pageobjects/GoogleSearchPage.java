package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleSearchPage {

	WebDriver driver;

	public  GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	
}
 By SearchTextBox = By.xpath("//input[@name='q']");
	By SearchBox = By.xpath ("//ul[@role='listbox']//li/descendant::div[@class='sbtc']"); 
	By Searchbox2 = By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']");
	By SearchBox3 = By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbtc");
			
			
	
	//create a method
		public WebElement LaunchGoogle()
		{
		
		 return driver.findElement(SearchTextBox);
	
		 
		}

		public List<WebElement> googlesearch ()
		{
			return driver.findElements(SearchBox);
			
		}
}