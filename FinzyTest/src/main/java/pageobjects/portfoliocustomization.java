package pageobjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import pageresources.Basetest;

public class portfoliocustomization extends Basetest {

	WebDriver driver;

	public portfoliocustomization(WebDriver driver) {
		this.driver = driver;

	}

	By CustomizeEdit = By.linkText("Customise");
	By Slider = By.cssSelector(
			"div.main-content-wrapper:nth-child(3) div.page-content.content section.content.explore-portfolio-page div.container div.panel.panel-default.row.portfolio-constituents div.col-md-12 div.row.constituent-category-list:nth-child(3) div.col-md-12 div.row.constituent-row.vertical-align:nth-child(2) div.col-md-3:nth-child(2) div.col-md-9 > input:nth-child(1)");
	By Rebalance = By.linkText("Rebalance");

	public WebElement edit() {
		return driver.findElement(CustomizeEdit);
	}

	public WebElement Slide() throws MoveTargetOutOfBoundsException {
		return driver.findElement(Slider);
	}

	public WebElement balance() {
		return driver.findElement(Rebalance);
	}

}
