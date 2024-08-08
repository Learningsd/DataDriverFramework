package tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.AccountPage;
import PageFactory.Homepage;
import PageFactory.Loginpage;
import base.Base;
import utils.DataUtil;
import utils.MyXLSReader;

public class LoginTest  extends Base
{
	public WebDriver driver;
	MyXLSReader myXLSReader = null;
	//Homepage hp;
	
	Homepage Hm;
	Loginpage lp;
	AccountPage ap;
	
	public LoginTest()
	{
		super();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		if(driver!=null) {
			driver.quit();
		}
		
	}
	
	@Test(dataProvider = "data")
	public void VerifyLoginWithValidCred(HashMap<String,String> hMap) 
	{
//          if(!DataUtil.isRunnable(myXLSReader,"LoginTest","testcases") || hMap.get("RunMode").equals("N")) {
//			
//			throw new SkipException("Run mode is set to N in excel file, hence not executed");
//			
//		}
//		
          
          driver=openBrowserAndApplication(hMap.get("Browser"));
          
          Hm=new Homepage(driver);
          Hm.clickonMyaccount();
         lp = Hm.ClickonLoginButton();
          
          
          lp.usernameFileld(hMap.get("UserName"));
          lp.passwordFileld(hMap.get("Password"));
           ap= lp.clickonLogin();
          
          
		
//		WebElement Myaccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
//		
//		Myaccount.click();
//		
//		WebElement Loginoption=driver.findElement(By.xpath("//a[normalize-space()='Login']"));
//		
//		Loginoption.click();
		
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(hMap.get("UserName"));
//		
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(hMap.get("Password"));
//		
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		
		//Thread.sleep(2000);
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		
		//driver.quit();
          
          
          if(hMap.get("ExpectedResult").equals("Success")) {
  			Assert.assertTrue(ap.LoginStatus());
  		}else if(hMap.get("ExpectedResult").equals("Failure")){
  			Assert.assertFalse(lp.loginWarningDisplayStatus());
  		}
		
		
	}
	
	@DataProvider(name="data")
	public Object[][] setOfData()
	{
//		Object[][] data= {  {"jhoni@gmail.com","abc@123"},
//				            {"subbunaidu@gmail.com","abc@123"},
//				             {"kphb@gmail.com","abc@123"}      };
//		
//		return data;
		
		
     String xlsxFilePath = System.getProperty("user.dir")+prop.getProperty("excelfilepath");
		
		try {
			myXLSReader = new MyXLSReader(xlsxFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object[][] data = null;
		
		try {
			data = DataUtil.getTestData(myXLSReader,"LoginTest","Data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	

}
