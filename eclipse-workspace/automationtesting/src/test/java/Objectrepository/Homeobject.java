package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homeobject {
	
	WebDriver driver;
	
	public Homeobject(WebDriver driver) {
		this.driver = driver;
	}
	
	By HSB = By.cssSelector("div[class='ci-hsb-carousel'] a");
	
	
	public WebElement HSB()
	{
	return driver.findElement(HSB);
	}
}
