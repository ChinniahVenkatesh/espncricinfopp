package Object;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TrumpObject {
	
	public TrumpObject(ChromeDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='ds-grow ds-overflow-y-auto ds-p-4']/p")
	List<WebElement> trumpPopupText;
	
	public List<WebElement> trumpPopupText()
	{
		return trumpPopupText;
	}
	
	
	@FindBy(xpath="//div[@class='ds-text-compact-m ds-ml-2']")
	List<WebElement> Trumpinfo;
	
	public List<WebElement> Trumpinfo()
	{
		return Trumpinfo;
	}
	
	
	@FindBy(css="button[class*='focus:ds-ring-button-primary']")
	WebElement LetsplayButton;
	
	public WebElement LetsplayButton()
	{
		return LetsplayButton;
	}
			
	@FindBy(xpath="//div[@class='wzrk-alert wiz-show-animate']/div[@class='wzrk-button-container']/button[1]")
	WebElement alert;
	
	public WebElement alert()
	{
		return alert;
	}
	
	@FindBy(xpath ="//div[@class='ds-h-[64px] ds-py-2 ds-text-right']/p")
	List<WebElement> playerInfo;
	
	public List<WebElement> playerInfo()
	{
		return playerInfo;
	}
	
	@FindBy(css="div[class*='ci-player-stat-value']")
	List<WebElement> TrumpOptions;
	
	public List<WebElement> TrumpOptions(){
		return TrumpOptions;
	}
	
	@FindBy(xpath="//i[@class='icon-cancel-filled ds-text-icon']")
	WebElement cancel;
	
	public WebElement cancel()
	{
		return cancel;
	}
	
	@FindBy(css="button[class*='ci-trump-share-button']")
	WebElement share;
	
	public WebElement share()
	{
		return share;
	}
	
	@FindBy(xpath="//span[@class='ds-text-tight-l ds-font-bold ds-text-raw-white']")
	WebElement scorecard;
	
	public WebElement scorecard()
	{
		return scorecard;
	}
	
	@FindBy(xpath="//div[@class='ds-flex ds-items-end ds-relative']/p")
	List<WebElement> summaryScore;
	
	public List<WebElement> summaryScore()
	{
		return summaryScore;
	}
	


}
