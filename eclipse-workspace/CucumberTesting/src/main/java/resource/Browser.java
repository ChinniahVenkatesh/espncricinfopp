package resource;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	public WebDriver driver;
	
	public WebDriver browser() throws IOException
	{
		Properties prop = new Properties();
		
		String path = "C:\\Users\\VENKATEC\\eclipse-workspace\\CucumberTesting\\src\\main\\java\\resource\\base";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String name = prop.getProperty("browser");
		if(name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
		
	}

}
