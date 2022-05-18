package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class browser {
	
	Properties prop;
	FileInputStream fis;
	public ChromeDriver driver ;

	
	public ChromeDriver browserInstallation() throws IOException
	{
		prop =  new Properties();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Object\\properties.prop";
		fis = new FileInputStream(path);
		prop.load(fis);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		return driver;
	}

}

