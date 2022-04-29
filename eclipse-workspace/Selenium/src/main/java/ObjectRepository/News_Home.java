package ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class News_Home {
	
	WebDriver driver;
	
	public News_Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(className="ds-p-0")
	WebElement home;
	
	public WebElement home()
	{
		return home;
	}

	@FindBy(xpath="//p[@class='ds-text-compact-xs ds-text-center ds-text-typo-paragraph ds-mt-2']")
	WebElement pagecount;
	
	public WebElement pagecount()
	{
		return pagecount;
	}
	
	@FindBy(xpath="//span[@class='ds-border-r ds-border-line ds-flex ds-flex-row ds-px-0.5 ds-space-x-1 sm:ds-space-x-3 sm:ds-px-3']/a")
	List<WebElement> pageno;
	
	public List<WebElement> pageno()
	{
		return pageno;
		
	}
	
	By Lhs = By.xpath("//div[@class='ds-p-0 ds-flex ds-flex-col ds-py-2']/div/a");
	
	public List <WebElement> Lhs()
	{
		return driver.findElements(Lhs);
	}
}


