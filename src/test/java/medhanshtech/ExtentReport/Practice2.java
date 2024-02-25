package medhanshtech.ExtentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Practice2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExtentReports extentreports = new ExtentReports();
		File file = new File("report.html");
		ExtentSparkReporter sparktReport = new ExtentSparkReporter(file);
		extentreports.attachReporter(sparktReport);
		
		extentreports
		.createTest("Text Based Test")
		.log(Status.INFO, "info1")
		.log(Status.INFO, "<b>info1</b>")
		.log(Status.INFO, "<i>info1</i>")
		.log(Status.INFO, "<b><i>info1</i></b>");
		
		String xmlData = "<menu id=\"file\" value=\"File\">\r\n"
				+ "		  <popup>\r\n"
				+ "		    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "		    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "		    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "		  </popup>\r\n"
				+ "		</menu> ";
		
	String jsonData = "{\"menu\": {\r\n"
			+ "  \"id\": \"file\",\r\n"
			+ "  \"value\": \"File\",\r\n"
			+ "  \"popup\": {\r\n"
			+ "    \"menuitem\": [\r\n"
			+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
			+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
			+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
			+ "    ]\r\n"
			+ "  }\r\n"
			+ "}}";
	
	extentreports
	.createTest("XMLData based test")
	.info(MarkupHelper.createCodeBlock(xmlData,CodeLanguage.XML));
	
	extentreports
	.createTest("JSONDATA based test")
	.info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
	
	List<String> listData = new ArrayList<>();
	listData.add("Kiran");
	listData.add("Madhavi");
	listData.add("Medhansh");
	
	
	Map<Integer , String> mapData = new HashMap<>();
	mapData.put(001, "Kiran");
	mapData.put(002, "Madhavi");
	mapData.put(003, "Medhansh");
	
	Set<Integer> setData = mapData.keySet();
	
	
	extentreports
	.createTest("ListData based test")
	.info(MarkupHelper.createOrderedList(listData))
	.info(MarkupHelper.createUnorderedList(listData));
	
	
	extentreports
	.createTest("MapData based test")
	.info(MarkupHelper.createOrderedList(mapData))
	.info(MarkupHelper.createUnorderedList(mapData));
	
	extentreports
	.createTest("SetData based test")
	.info(MarkupHelper.createOrderedList(setData))
	.info(MarkupHelper.createUnorderedList(setData));
	
	
		
		extentreports.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());;
		
	}

}
