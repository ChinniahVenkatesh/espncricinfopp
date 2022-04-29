package Amazon.Selenium;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listners extends Browser implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReport.ExtentReports();
	
	
	ThreadLocal<ExtentTest>extentTest = new ThreadLocal<ExtentTest>();
		
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			test= extent.createTest(result.getMethod().getMethodName());
			extentTest.set(test);
	
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) 
	{
		/*extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
	
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		 
		}catch(Exception e) 
		{
			e.printStackTrace();	
		}
		 try {
			
			extentTest.get().addScreenCaptureFromPath(getScreenshotpath(testMethodName,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		
		String Name = extentTest.get().getClass().getName();
		System.out.println(Name);
		
	}

	
	

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
