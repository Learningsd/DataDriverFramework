package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentReporter;
import utils.Takesscreenshots;

public class Mylistener implements ITestListener
{
	ExtentReports reports=null;
	ExtentTest extentTest=null;
	String testname=null;
	
	@Override
	public void onStart(ITestContext context) 
	{
	    reports = ExtentReporter.GetExtentReports();
	    
	    
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		testname=result.getName();
		extentTest = reports.createTest(testname);
		extentTest.log(Status.INFO, result.getName()+" test execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.log(Status.PASS, testname+" test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		
		WebDriver driver=null;
		
		try {
		     driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Throwable e) {
			
			e.printStackTrace();
		} 
		
		String ScreenshotFilePath=Takesscreenshots.Sceenshots(driver, result.getTestName());
		
		extentTest.addScreenCaptureFromPath(ScreenshotFilePath);
		
		extentTest.log(Status.FAIL, testname+" test got Failed");
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		extentTest.log(Status.SKIP, testname+" test got Skipped");
	}

	

	@Override
	public void onFinish(ITestContext context) 
	{
		reports.flush();
		
		try {
			String ExtentReportFilepath=System.getProperty("user.dir")+"\\Screenshots\\extent.html";
			File ExtentReportFile=new File(ExtentReportFilepath);
			Desktop.getDesktop().browse(ExtentReportFile.toURI());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
