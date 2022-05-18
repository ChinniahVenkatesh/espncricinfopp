package espncricinfo.testing;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.browser;


public class Gamepage extends browser{

	public ChromeDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	@Test(priority = 1)
	public void gamePage() throws IOException
	{
		prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Object\\properties.prop";
		fis = new FileInputStream(path);
		prop.load(fis);
		driver = browserInstallation();
		driver.get(prop.getProperty("domainUrl"));
		driver.navigate().to("https://pp.espncricinfo.com/game");
		
	}
	
	@Test(priority = 2)
	public void backendTest()
	{
		
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		devtools.addListener(Network.responseReceived(), response -> 
		{
			
			Response res = response.getResponse();
			if(res.getStatus() == 400 || res.getStatus() == 404)
			{
			System.out.println(res.getUrl());
			System.out.println(res.getStatus());
			}
			else
			{
			String pageTitle = driver.getTitle();
			Assert.assertEquals(pageTitle, "Cricket games, Trump cards games, daily cricket streak games, cricket quiz games");
			}
		});
		
		driver.navigate().refresh();	
	}
}
