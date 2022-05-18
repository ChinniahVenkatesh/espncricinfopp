package Object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class streakgameObject {
	
	public ChromeDriver driver;
	
	
	public streakgameObject(ChromeDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'ds-text-center']/div[1]")
	WebElement streakquestion;
	
	public WebElement streakquestion()
	{
	return streakquestion;
	}
	
	@FindBy(xpath = "//div[@class='ds-text-center']/div[2]/div/div/div")
	List<WebElement> streakOptions;
	
	public List<WebElement> streakOptions()
	{
		return streakOptions;
	}
	
	@FindBy(xpath = "//div[@class='ds-text-center']/div[2]/div/div[1]")
	WebElement selectOption;
	
	public WebElement selectOption()
	{
		return selectOption;
	}
	
	@FindBy(css="span[class*='ds-text-ui-typo-error']")
	WebElement Validationerror;
	
	public WebElement Validationerror()
	{
		return Validationerror;
	}
	
	@FindBy(css = "div[class*='ds-text-ui-typo-mid'] span ")
	WebElement Answerpopup;
	
	public WebElement Answerpopup()
	{
		return Answerpopup;
	}
	
	@FindBy(css = "div[class*='ds-text-ui-typo ds-mb-2']")
	WebElement Answer;
	
	public WebElement Answer()
	{
		return Answer;
	}
	
	@FindBy(xpath = "//span[@class='ds-cursor-pointer ds-text-ui-typo-primary hover:ds-text-ui-typo-primary-hover ds-block']")
	WebElement next;
	
	public WebElement next()
	{
		return next;
	}
	
	@FindBy(xpath="//div[@class='wzrk-alert wiz-show-animate']/div[@class='wzrk-button-container']/button[1]")
	WebElement alert;
	
	public WebElement alert()
	{
		return alert;
	}
	
	@FindBy(css = "span[class*='ds-text-ui-typo-success']")
	WebElement validationcorrect;
	
	public WebElement validationcorrect()
	{
		return validationcorrect;
	}
	
	@FindBy(xpath="//span[@class='ds-text-compact-xs']")
	List<WebElement> finishedlinks;
	
	public List<WebElement> finshedlinks()
	{
		return finishedlinks;
	}
	
	@FindBy(css = "span[class*='ds-text-compact-s']")
	WebElement streakinfoText;
	
	public WebElement streakinfoText()
	{
		return streakinfoText;
	}
	
	@FindBy(css = "button[class*='ds-text-ui-typo-primary']:nth-child(1)")
	WebElement shareinfo;
	
	public WebElement shareinfo()
	{
		return shareinfo;
	}
	
	@FindBy(xpath = "//span[text()='Rules']")
	WebElement rules;
	
	public WebElement rules()
	{
	return rules;
	}
	
	@FindBy(xpath = "//div[@class='ds-text-compact-xs ds-font-medium ds-flex ds-items-center']")
	WebElement statusinfo;
	
	public WebElement statusinfo()
	{
		return statusinfo;
	}
	
	@FindBy(xpath = "//span[@class='ds-text-compact-xs']")
	WebElement todaysquiz;
	
	public WebElement todaysquiz()
	{
		return todaysquiz;
	}
	
	//span[@class='ds-cursor-pointer ds-text-ui-typo hover:ds-text-ui-typo-primary ds-block']
	@FindBy(xpath="//span[@class='ds-cursor-pointer ds-text-ui-typo hover:ds-text-ui-typo-primary ds-block']")
	WebElement nextone;
	
	public WebElement nextone()
	{
		return nextone;
	}
	
	
	@FindBy(xpath="//i[@class='icon-close-filled ds-text-icon ds-absolute ds-right-2 ds-cursor-pointer ds-top-3 ds-text-icon-light hover:ds-text-icon']")
	WebElement shareclose;
	
	public WebElement shareclose()
	{
		return shareclose;
	}
	
	@FindBy(xpath="//span[@class='ds-text-compact-xs']")
	WebElement MyScore;
	
	public WebElement MyScore()
	{
		return MyScore;
	}
	
	@FindBy(css="div[class*='ds-text-compact-s']")
	List<WebElement> streakinfo;
	
	public List<WebElement> streakinfo()
	{
		return streakinfo;
	}
	
	@FindBy(css="i[class*='icon-close-filled ds-text-icon ds-absolute ds-right-2 ds-cursor-pointer ds-top-3 ds-text-icon-light hover:ds-text-icon']")
	WebElement closeicon;
	
	public WebElement closeicon()
	{
		return closeicon;
	}
	
	@FindBy(xpath="//span[@class='ds-cursor-pointer ds-text-ui-typo hover:ds-text-ui-typo-primary ds-block']")		  
	WebElement Next;
	
	public WebElement Next()
	{
		return Next;
	}
}



