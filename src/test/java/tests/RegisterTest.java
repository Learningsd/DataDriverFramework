package tests;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.Homepage;
import PageFactory.RegisterPage;
import base.Base;
import utils.DataUtil;
import utils.MyXLSReader;

public class RegisterTest extends Base
{
	public WebDriver driver;

	MyXLSReader myXLSReader = null;
	Homepage Hm;
	RegisterPage rp;
	
	public RegisterTest()
	{
		super();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		if(driver!=null)
		{
		driver.close();
		}
	}
	
	@Test(dataProvider = "data")
	public void VerifyRegisterBydata(HashMap<String,String> hMap) throws InterruptedException
	{
//           if(!DataUtil.isRunnable(myXLSReader,"RegisterTest","testcases") || hMap.get("RunMode").equals("N")) 
//           {
//			
//			throw new SkipException("Run mode is set to N in excel file, hence not executed");
//			
//		
//           }
		
		
		driver=openBrowserAndApplication(hMap.get("Browser"));
		
		Hm=new Homepage(driver);
		Hm.clickonMyaccount();
		rp=Hm.selectRegisterOption();
		
		rp.enterFirstName(hMap.get("FirstName"));
		rp.enterLastName(hMap.get("LastName"));
		rp.enterEmailAddress(generategmail());
		rp.enterTelephoneNumber(hMap.get("Telephone"));
		rp.enterPassword(hMap.get("Password"));
		rp.enterConfirmationPassword(hMap.get("Passwordconfirm"));
		rp.optForNewsletter();
		rp.selectPrivacyPolicy();
		rp.clickOnContinueButton();
		
//		WebElement Myaccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
//		
//		Myaccount.click();
//		
//		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
//
//		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys();
//		
//		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(hMap.get("LastName"));
//		
//		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(generategmail());
//		
//		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(hMap.get("Telephone"));
//		
//		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(hMap.get("Password"));
//		
//		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(hMap.get("Passwordconfirm"));
//		
//		driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
//		
//		driver.findElement(By.xpath("//input[@name='agree']")).click();
//		
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
        String expectedResult = hMap.get("ExpectedResult");
		
		String expectedPageTitle = "Register Account";
		
		if(expectedResult.equals("Success")) {
			Assert.assertEquals(driver.getTitle(),expectedPageTitle);
		}else if(expectedResult.equals("Failure")) {
			Assert.assertEquals(driver.getTitle(),"Register Account");
		}
		
	
}
	
	public String generategmail()
	{
		Date d=new Date();
		
		return d.toString().replace(" ", " ").replace(";", "_")+"@gmail.com";
		
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
			data = DataUtil.getTestData(myXLSReader,"RegisterTest","Data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	
}
