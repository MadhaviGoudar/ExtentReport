package medhanshtech.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Practice4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparktReport = new ExtentSparkReporter(file);
		sparktReport.config().setTheme(Theme.DARK);
		sparktReport.config().setReportName("Report Name");
		sparktReport.config().setDocumentTitle("TestCase Design");
		extentreports.attachReporter(sparktReport);
		
		extentreports
		.createTest("Test1")
		.assignAuthor("Madhavi")
		.assignCategory("Regration")
		.assignDevice("google")
		.pass("This is passed test cases");
		
		extentreports
		.createTest("Test2")
		.assignAuthor("Kiran")
		.assignCategory("Integration")
		.assignDevice("FireFox")
		.pass("This is passed test cases");
		
		extentreports
		.createTest("Test1")
		.assignAuthor("Medhansh")
		.assignCategory("UAT")
		.assignDevice("google")
		.pass("This is passed test cases");
		
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());;
		
	}

}
