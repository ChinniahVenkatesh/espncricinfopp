package Amazon.Selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extent;

	public static ExtentReports ExtentReports()
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Report of Espncricnfo");
		 extent =new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Chinniah");
			return extent;
		
	}

}
