package cricinfoqatest.automationtesting;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationTest {

	ExtentReports Extent;
	@Test
	public void Browser()
	{
		Extent.createTest("Browser");
		System.out.println("welcome");
		Extent.flush();
	}
	
@BeforeTest
public void config()
{
	String path =System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("AutomationTesting");
	reporter.config().setDocumentTitle("qatesting");
	
	Extent =new ExtentReports();
	Extent.attachReporter(reporter);
	Extent.setSystemInfo("Tester", "chinniah");
}

	
}
