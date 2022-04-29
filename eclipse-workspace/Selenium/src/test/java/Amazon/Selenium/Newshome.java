package Amazon.Selenium;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectRepository.News_Home;

public class Newshome extends Browser {
	
	public WebDriver driver ;
	
	public static Logger log = LogManager.getLogger(Newshome.class.getName());
	
	@Test
	public void newsHome() throws IOException, InterruptedException
	{
		driver = BrowserInstallation();
		driver.get("https://www.espncricinfo.com/latest-cricket-news");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scroll(0,500)");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.findElement(By.cssSelector("div[class*='wzrk-alert'] div button[id='wzrk-cancel']")).click();
		News_Home nh = new News_Home(driver);
		nh.home();
		int count;
		int i=0;
		int passcount = 0;
		int failcount =0;
		String page = nh.pagecount().getText();
		String[] page1 = page.split("of");
		String pageCount = page1[1];
		String pageNum = pageCount.trim();
		int indexno = Integer.parseInt(pageNum);  
		//System.out.println(indexno);
		log.info(indexno);
		do
		{
			count=0;
			
		 List<WebElement> pageNo=nh.pageno();
		//System.out.println(pageNo.size());
		List<WebElement> url = driver.findElements(By.cssSelector("div[class='ds-p-0'] a"));
		//System.out.println(url.size());
		for(WebElement storyurl : url)
		{
			String newsUrl = storyurl.getAttribute("href");
			HttpsURLConnection prop =  (HttpsURLConnection)new URL(newsUrl).openConnection();
			
			prop.setRequestMethod("GET");
			int statuscode = prop.getResponseCode();
			if(statuscode == 400)
			{
			System.out.println("Page url is:"+newsUrl+"and"+statuscode);
			failcount = failcount+1;
			}
			else
			{
				passcount = passcount+1;	
			}
			count = count+1;
			Thread.sleep(1000);
			if(count == 20)
			{
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/section[1]/div[5]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[3]/i[1]")).click();
				Thread.sleep(10000);
			}
		}
		
		i++;
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(200));
		
} while(i<indexno);
		System.out.println("passcount =" + passcount);
		System.out.println("passcount =" + failcount);
		}

	@Test
	public void newsHomeRhs() throws IOException
	{
		driver = BrowserInstallation();
		driver.get("https://www.espncricinfo.com/latest-cricket-news");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scroll(0,500)");
		driver.manage().window().maximize();
		News_Home nh = new News_Home(driver);
		List<WebElement> lhsContent = nh.Lhs();
		int passcount =0;
		int failcount =0;
		for(WebElement LHS : lhsContent)
		{
			String LhsStoryUrl = LHS.getAttribute("href");
			HttpsURLConnection lhsurl = (HttpsURLConnection)new URL(LhsStoryUrl).openConnection();
			lhsurl.setRequestMethod("GET");
			int lhsStoryStatuscode = lhsurl.getResponseCode();
	
			if(lhsStoryStatuscode == 200)
			{
				passcount = passcount+1;
				log.info("Story page url is "+lhsurl+"Story headline is:"+LHS.getText()+"status code is"+lhsStoryStatuscode);
			}
			else
			{
				failcount = failcount+1;
			}
		}
	 System.out.println("Passed Url"+passcount);

	}
			}




