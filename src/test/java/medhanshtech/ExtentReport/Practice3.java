package medhanshtech.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice3 {
	
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparktReport = new ExtentSparkReporter(file);
		extentreports.attachReporter(sparktReport);
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://www.google.com/");
		
		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//System.setProperty("WebDriver.chrome.driver","");
		driver.get("https://www.google.com/");
		String base64Code = captureScreenshot();
		String path = captureScreenshot("Google.jpg");
		
		extentreports
		.createTest("ScrenShot Test 1", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(base64Code);
		
		extentreports
		.createTest("ScrenShot Test 2", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(base64Code , "Google homepage");
		
		
		extentreports
		.createTest("ScrenShot Test 3", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(path);
		
		extentreports
		.createTest("ScrenShot Test 4", "This is for attaching the screenshot to the test at test level")
		.info("This is info message")
		.addScreenCaptureFromBase64String(path , "Google homepage");
		
		
		extentreports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("report.html").toURI());;
		
	}
	public static String captureScreenshot()
	{
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		String base64Code = takescreenshot.getScreenshotAs(OutputType.BASE64);
		System.out.println("ScreenShot Saved successfully");
		return base64Code;
	}
	
	public static String captureScreenshot(String fileName)
	{
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File sourceFile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+ fileName);
		try
		{
			FileUtils.copyFile(sourceFile, destFile);
		
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("ScreenShot Saved successfully");
		return destFile.getAbsolutePath();
		
	}

}
