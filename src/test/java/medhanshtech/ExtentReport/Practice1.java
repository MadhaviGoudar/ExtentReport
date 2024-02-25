package medhanshtech.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Practice1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparktReport = new ExtentSparkReporter(file);
		extentreports.attachReporter(sparktReport);
		
		extentreports
		.createTest("Test1")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "info1")
		.log(Status.PASS, "info1")
		.log(Status.PASS, "info1")
		.log(Status.WARNING, "info1")
		.log(Status.FAIL, "info1")
		.log(Status.PASS, "info1");
		
	
		
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());;
		
	}

}
