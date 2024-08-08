package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter 
{
	
	public  static ExtentReports GetExtentReports()
	{
	ExtentReports extentreport=new ExtentReports();
	
	String ReportPath=System.getProperty("user.dir")+"\\Reports\\extent.html";
	
	ExtentSparkReporter Es=new ExtentSparkReporter(ReportPath);
	
	Es.config().setReportName("DDF - Extent Report Demo Name");
	Es.config().setDocumentTitle("DDF - Extent Report Demo Title");
	
	extentreport.attachReporter(Es);
	extentreport.setSystemInfo("Operating System",System.getProperty("os.name"));
	extentreport.setSystemInfo("Java Version",System.getProperty("java.version"));
	extentreport.setSystemInfo("Selenium Java Version","4.22.0");
	extentreport.setSystemInfo("Exectued By",System.getProperty("user.name"));
	
	return extentreport;
	
	}
	
	

}
