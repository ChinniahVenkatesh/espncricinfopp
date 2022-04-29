package ESPNcricinfo.ESPNcricinfoprod;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	ChromeDriver driver;

	Properties prop;
	public ChromeDriver Initiatebrowser() throws IOException {
		// TODO Auto-generated method stub
		 prop = new Properties();
		String path = "C:\\Users\\VENKATEC\\eclipse-workspace\\ESPNcricinfoprod\\src\\main\\java\\ESPNcricinfo\\ESPNcricinfoprod\\Browser";
		FileInputStream fis = new FileInputStream(path);
		
		prop.load(fis);
	
		System.out.println(prop.getProperty("Browser"));
		
		if(prop.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		return driver;
	}

	
}
