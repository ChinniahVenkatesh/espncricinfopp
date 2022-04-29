package ESPNcricinfo.CucumberE2ETesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
		
		public WebDriver driver;
		public Properties file;
		
		public WebDriver BrowserInstallation() throws IOException
		{
		file = new Properties();
		String path = "C:\\Users\\VENKATEC\\eclipse-workspace\\Selenium\\src\\main\\java\\Amazon\\Selenium\\Basefile";
		FileInputStream fis = new FileInputStream(path);
		file.load(fis);
		//String browserName = System.getProperty("browser");
		String browserName = file.getProperty("Browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();	 
		}
		
		return driver;
		}
		


	}


