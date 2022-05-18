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

import org.openqa.selenium.devtools.v101.emulation.Emulation;
import org.openqa.selenium.devtools.v101.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v101.emulation.model.ScreenOrientation;

import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.Response;
import org.openqa.selenium.devtools.v101.page.model.Viewport;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


import Object.streakgameObject;
import base.browser;

public class streakTest extends browser{
	Properties prop;
	FileInputStream fis;
	public ChromeDriver driver;
	public Logger log = LogManager.getLogger(streakTest.class);
	
	@Test(priority = 0)
	public void browserIniziate() throws IOException
	{
		prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Object\\properties.prop";
		fis = new FileInputStream(path);
		prop.load(fis);
		driver = browserInstallation();
		driver.get(prop.getProperty("domainUrl"));
		driver.getTitle();
	}
	
	@Test(priority = 1)
	public void navigateStreakurl()
	{
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		driver.navigate().to("https://pp.espncricinfo.com/game/daily-streak");
		devtools.send(Emulation.setDeviceMetricsOverride(375, 667 , 75, true, Optional.<Number> empty(),
	            Optional.<Integer> empty(), Optional.<Integer> empty(), Optional.<Integer> empty(), 
	            Optional.<Integer> empty(), Optional.<Boolean> empty(), Optional.<ScreenOrientation> empty(), 
	            Optional.<Viewport> empty(), Optional.<DisplayFeature> empty()));
	String pageTitle =driver.getTitle();
	Assert.assertEquals(pageTitle, "Daily cricket streak game | Online cricket games");
	streakgameObject ob = new streakgameObject(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	ob.alert().click();
	}
	
	@Test(priority=2)
	public void backendTest() throws IOException
	{
		System.out.println("Backend Test");
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		devtools.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
			
			//System.out.println(res.getStatus());
			if(res.getStatus() == 404)
			{
				log.info(res.getUrl());
				log.info(res.getStatusText());
			}
			
		});
		driver.navigate().refresh();
			
		}
	
	@Test(priority = 3)
	public void playGame() throws InterruptedException, IOException
	{ 
		int i = 0;
		int count =0;
		streakgameObject ob = new streakgameObject(driver);
		do
		{
			count = count + i;
			System.out.println(i);
			Thread.sleep(20);
			if(i == 3 || i == 6 || i == 9)
			{
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				ob.MyScore().click();
				File src1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src1, new File("Screenshot//streakinfo"+i+".png"));
				Reporter.log("<img src=\'C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\Screenshot\\streakinfo"+i+".png\"'/>");
				ob.closeicon().click();
			}
		
		String question = ob.streakquestion().getText();
		System.out.println(question);
	
		Thread.sleep(2000);
		List<WebElement> streakOptions =ob.streakOptions();
		for(WebElement option : streakOptions)
		{
			String answers = option.getText();
			System.out.println(answers);
			log.info(answers);
			if(answers.contains(answers))
			{
				ob.selectOption().click();	
			}
			System.out.println(ob.Answerpopup().getText());
			Thread.sleep(1000);
			ob.next().click();
			 break;
			}
			i++;
		}while(i < 10);
	}
	
	@Test(priority = 4)
	public void statusinfo()
	{
		streakgameObject ob = new streakgameObject(driver);
		String status = ob.statusinfo().getText();
		System.out.println(status);
		
	}

	@Test(priority = 6)
	public void gameresultcard() throws InterruptedException, IOException
	{
		streakgameObject ob = new streakgameObject(driver);
		Thread.sleep(1000);
		List<WebElement> links = ob.finshedlinks();
		for(int i = 0; i< links.size();i++)
		{
			String linkText = links.get(i).getText();
			if(linkText.equalsIgnoreCase("My Score"))
			{
			links.get(i).click();
			Thread.sleep(10);
			File src1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("Screenshot//streakgame.png"));
			Reporter.log("<img src=\'C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\Screenshot\\streakgame.png\'/>");
			}
		}
	}
	
@Test(priority = 5)
	public void todaysquiz() throws InterruptedException
	{
		streakgameObject ob = new streakgameObject(driver);
		ob.todaysquiz().click();
		int i =0;
		do
		{
			i = 0 + i;
			if(i==0)
			{
			ob.Next().click();
			}
			else
			{
				ob.nextone().click();
				Thread.sleep(1000);
			}
			i++;
		}while(i < 10);
	}
	
	@Test(priority = 7)
	public void streakinfoText() throws InterruptedException
	{
		streakgameObject ob = new streakgameObject(driver);
		String streakText = ob.streakinfoText().getText();
		log.info( streakText);
		if(streakText.equalsIgnoreCase("Oops!"))
		{
			log.info(ob.shareinfo().isEnabled());
			Thread.sleep(1000);
			
			ob.shareclose().click();
		}

	}
}
	

	
	

