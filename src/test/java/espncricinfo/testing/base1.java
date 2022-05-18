package espncricinfo.testing;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v101.network.Network;
import org.openqa.selenium.devtools.v101.network.model.Request;
import org.openqa.selenium.devtools.v101.network.model.Response;
import org.testng.annotations.Test;

public class base1 {

	@Test
	public  void backendtest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		
		/*devtools.addListener(Network.requestWillBeSent() , request -> 
		{
			Request req = request.getRequest();
			//System.out.println(req.getUrl());
		});*/
		
		devtools.addListener(Network.responseReceived(), response ->
		{
			Response res = response.getResponse();
			
			//System.out.println(res.getStatus());
			if(res.getStatus() == 404)
			{
				System.out.println(res.getUrl());
				System.out.println(res.getStatus());
			}
			
		});
		
		driver.get("https://pp.espncricinfo.com/?hsci=true");
		
	driver.navigate().to("https://pp.espncricinfo.com/game/daily-streak");
		
		
		
		
	}

}
