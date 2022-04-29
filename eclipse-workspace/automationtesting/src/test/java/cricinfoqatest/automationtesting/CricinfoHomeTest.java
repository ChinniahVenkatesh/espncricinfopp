package cricinfoqatest.automationtesting;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CricinfoHomeTest {
	
	String siteurl = "https://qa.espncricinfo.com/?hsci=true";
	SoftAssert a = new SoftAssert();
	
	
	@Test
	public void HSB() throws MalformedURLException, IOException
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(siteurl);
		driver.manage().window().maximize();
		List<WebElement> HSB =driver.findElements(By.cssSelector("div[class='ci-hsb-carousel'] a"));
		for(WebElement HS:HSB)
		{
			String Hsurl = HS.getAttribute("href");
			HttpsURLConnection connect =(HttpsURLConnection)new URL(Hsurl).openConnection();
			connect.setRequestMethod("GET");
			connect.connect();
			int Statuscode = connect.getResponseCode();
			a.assertFalse(Statuscode == 400, "The page is breaking with status code"+Statuscode+"URL is"+HS.getAttribute("href"));
		}
		a.assertAll();
		
	
	}
	
}
