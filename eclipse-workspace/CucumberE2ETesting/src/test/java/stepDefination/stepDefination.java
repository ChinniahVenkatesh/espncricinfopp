package stepDefination;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ESPNcricinfo.CucumberE2ETesting.Browser;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;





public class stepDefination 
{
    @Given("Access the url domain url")
    public void access_the_url_domain_url() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\VENKATEC\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com");
    	throw new PendingException();
}
}



