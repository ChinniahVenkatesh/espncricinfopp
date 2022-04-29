package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	
	By Username = By.cssSelector("input[id='ap_email']");
	
	public Login(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement Username()
	{
		return driver.findElement(Username);
	}

	@FindBy(css="input#continue")
	WebElement click;
	
	public WebElement click()
	{
		return click;
	}
	
}
