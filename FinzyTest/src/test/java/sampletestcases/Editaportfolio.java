package sampletestcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageobjects.portfoliocustomization;
import pageresources.Basetest;

public class Editaportfolio extends Basetest  {

@Test
	
	public void extendslider () throws IOException, InterruptedException
	{
		driver = initializebroswer();
driver.get("https://sfo-demo.herokuapp.com/explore_portfolio/1");
	
	
portfoliocustomization pc = new portfoliocustomization(driver);
pc.edit().click();
try {
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("scroll(), scroll (0,650)");
Actions actions = new Actions(driver);
 actions.click(pc.Slide()).moveByOffset(310, 483).release().perform();
actions.moveToElement(pc.Slide());
 pc.Slide().click();
}

finally {
	System.out.println("e");
}
}


  	}

/*@AfterTest
public void teardown()
{
	
	driver.close();
	
}*/





