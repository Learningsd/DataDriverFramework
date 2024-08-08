package webdriverconcepts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators_xpath {

	public static void main(String[] args) 
	
	{
	  ChromeDriver driver = new	ChromeDriver();
	  
	  driver.manage().window().maximize();
	  
	  driver.get("https://omayo.blogspot.com/");
	  
	  String parentwindow = driver.getWindowHandle();
	  
	  driver.findElement(By.linkText("Open a popup window")).click();
	  
	  Set<String> windowsids = driver.getWindowHandles();
	  
	  for(String windowid:windowsids)
	  {
		  if(!windowid.equals(parentwindow))
		  {
			 driver.switchTo().window(windowid);
			 String windowdata= driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
			 System.out.println(windowdata);
			 driver.close();
			 break;
		  }
	  }
	  
	  driver.switchTo().window(parentwindow);
	  
	  driver.findElement(By.id("ta1")).sendKeys("syed althaf");
	  
	  driver.close();
	  
	  
		
		

	}

}
