package espncricinfo.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.console.Console;
import org.openqa.selenium.devtools.v101.emulation.Emulation;
import org.openqa.selenium.devtools.v101.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v101.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.Response;
import org.openqa.selenium.devtools.v101.page.model.Viewport;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Object.TrumpObject;
import base.browser;

public class trumpGame extends browser {
	
	public ChromeDriver driver;
	Properties prop;
	FileInputStream fis;
	public static Logger log = LogManager.getLogger(trumpGame.class);
	
	@Test(priority = 1)
	public void TrumpWelcomeNotes() throws IOException
	{
		prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Object\\properties.prop";
		fis = new FileInputStream(path);
		prop.load(fis);
		driver = browserInstallation(); 
		driver.get(prop.getProperty("domainUrl"));
		driver.navigate().to("https://pp.espncricinfo.com/game/trump");
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Emulation.setDeviceMetricsOverride(600, 1400 , 75, true, Optional.<Number> empty(),
	            Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
	            Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
	            Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));
		String pageTitle =driver.getTitle();
		
		Assert.assertEquals(pageTitle, "Cricket trump card game | Online cricket games");
		TrumpObject To = new TrumpObject(driver);
		
		List<WebElement>TrumpPopupTexts = To.trumpPopupText();
		for(WebElement popupText: TrumpPopupTexts)
		{
			System.out.println(popupText.getText());
		}
		List<WebElement> rules = To.Trumpinfo();
		for(WebElement rule: rules)
		{
			System.out.println(rule.getText());
		}
	}
	
	@Test(priority = 2)
	public void playinfo()
	{
		TrumpObject To = new TrumpObject(driver);
		To.LetsplayButton().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		To.alert().click();
	}
	
	@Test(priority = 3)
	public void playerinfo()
	{
		TrumpObject To = new TrumpObject(driver);
		List<WebElement> playersinfo = To.playerInfo();
		Reporter.log("Playing Rules");
		for(WebElement playerinfo : playersinfo)
		{
			log.info(playerinfo.getText());
		}
	}	
	
	@Test(priority = 4)
	public void backendTest()
	{
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		devtools.addListener(Network.responseReceived(), response -> 
		{
		Response res = response.getResponse();
		if(res.getStatus() == 404)
		{
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
		}
		});
	}
	@Test(priority = 5)
	public void playGame() throws InterruptedException, IOException
	{
		Reporter.log("Started Playing Game");
		TrumpObject To = new TrumpObject(driver);
		List<WebElement> trumpOptions = To.TrumpOptions();
		int i = 0;
		do
		{
			i = 0+i;
			System.out.println(i);
		for(WebElement trumpOption: trumpOptions)
		{
			if(i == 4)
			{
				Reporter.log("Ad card close");
				Thread.sleep(6);
				To.cancel().click();
			}
			trumpOption.click();
			break;
		}
		driver.navigate().refresh();
		i++;
	}while(i < 10);
		File src1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1,new File("Screenshot//trumpgame.png"));
		Reporter.log("<img src=\"C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\Screenshot\\trumpgame.png\"/>");
	}
	
	@Test(priority = 6)
	
	public void share()
	{
		TrumpObject To = new TrumpObject(driver);
		To.share().isEnabled();
		List<WebElement> summaryScore = To.summaryScore();
		for(WebElement summary: summaryScore)
		{
			System.out.println(summary.getText());
		}
	}
	
	@Test(priority = 7)
	
	public void Scorecard() throws IOException
	{
		TrumpObject To = new TrumpObject(driver);
		To.scorecard().click();
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("Screenshot//scorecard.png"));
		Reporter.log("<img src=\'C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\Screenshot\\scorecard.png\'/>");
		
	}
	}
	
	
	
