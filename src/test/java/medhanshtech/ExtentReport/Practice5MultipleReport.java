package medhanshtech.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Practice5MultipleReport {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparktReport_all = new ExtentSparkReporter("AllTest.html");
		ExtentSparkReporter sparktReport_fail = new ExtentSparkReporter("FailedTests.html");
		sparktReport_fail.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		ExtentSparkReporter sparktReport_skipAndWarning = new ExtentSparkReporter("SkipandWarningTest.html");
		
		sparktReport_fail.filter().statusFilter().as(new Status[] {
				Status.SKIP,
				Status.WARNING
				
		}).apply();
		extentreports.attachReporter(sparktReport_all,sparktReport_fail,sparktReport_skipAndWarning);
		
		extentreports
		.createTest("Test1")
		.assignAuthor("Madhavi")
		.assignCategory("Regration")
		.assignDevice("google")
		.pass("This is passed test cases");
		
		extentreports
		.createTest("Test1")
		.assignAuthor("Druva")
		.assignCategory("Regration")
		.assignDevice("google")
		.pass("This is passed test cases");
		
		extentreports
		.createTest("Test2")
		.assignAuthor("Kiran")
		.assignCategory("Integration")
		.assignDevice("FireFox")
		.fail("Failed Test Case");
		
		extentreports
		.createTest("Test3")
		.assignAuthor("Ramya")
		.assignCategory("Integration")
		.assignDevice("FireFox")
		.fail("Failed Test Case");
		
		extentreports
		.createTest("Test1")
		.assignAuthor("Medhansh")
		.assignCategory("UAT")
		.assignDevice("google")
		.warning("Its warning");
		
		extentreports
		.createTest("Test1")
		.assignAuthor("Medhansh")
		.assignCategory("UAT")
		.assignDevice("google")
		.skip("Its Skipped test case");
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("AllTest.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("SkipandWarningTest.html").toURI());
		
	}

}
