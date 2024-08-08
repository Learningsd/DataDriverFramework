package tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageFactory.Homepage;
import PageFactory.SearchResultPage;
import base.Base;
import utils.DataUtil;
import utils.MyXLSReader;

public class SearchTest  extends Base
{
public WebDriver driver;
MyXLSReader myXLSReader = null;
Homepage hm;
SearchResultPage sr;

public SearchTest()
{
	super();
}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	@Test(dataProvider = "searchdata")
	public void VerifySearchFunctionality(HashMap<String, String> hMap) throws InterruptedException
	{
		
		
		
		
		driver=openBrowserAndApplication(hMap.get("Browser"));
		
		hm=new Homepage(driver);
		hm.enterSearchText(hMap.get("SearchText"));
		sr=hm.clickOnSearchButton();
		
		sr.getResultedProductName();
		sr.getResultedMessage();
		
		
//		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(hMap.get("SearchText"));
//		
//		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		//Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']")).isDisplayed());
		
		if(hMap.get("ExpectedResult").equals("Success")) {
			
			   String expectedProduct = hMap.get("ExpectedProduct");
			   Assert.assertEquals(sr.getResultedProductName(), expectedProduct);
				
			}else if(hMap.get("ExpectedResult").equals("Failure")){
				String expectedProduct = hMap.get("ExpectedProduct");
				Assert.assertEquals(sr.getResultedMessage(), expectedProduct);
			}
		
		
	}
	
	
	@DataProvider(name="searchdata")
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
			data = DataUtil.getTestData(myXLSReader,"SearchTest","Data");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	

}
