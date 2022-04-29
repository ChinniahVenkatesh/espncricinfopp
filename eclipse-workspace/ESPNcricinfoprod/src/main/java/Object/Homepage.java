package Object;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homepage {
	
	ChromeDriver driver;
	
	public Homepage(ChromeDriver driver)
	{
		this.driver = driver;
	}
	
	

	By HSB = By.cssSelector("div[class='slick-track'] div[class*='ds-bg-fill-hsb-scorecell'] a");
	
	public List<WebElement> HSB()
	{
		return driver.findElements(HSB);
	}
}
