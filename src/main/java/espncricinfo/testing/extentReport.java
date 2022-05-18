package espncricinfo.testing;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	static ExtentReports report;
	
	public static ExtentReports extentReport()
	{
		report = new ExtentReports();
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Streak Game");
		report.attachReporter(reporter);
		report.setSystemInfo("Tester", "Chinniah");
		report.getStats();
		report.addTestRunnerOutput("C:\\Users\\VENKATEC\\espncricinfo\\testingqa\\streakgame.log");
		return report;
	}

}
