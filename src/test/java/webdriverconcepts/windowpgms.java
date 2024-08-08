package webdriverconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowpgms {

	public static void main(String[] args) 
	{
		 ChromeDriver driver = new	ChromeDriver();
		  
		  driver.manage().window().maximize();
		  
		  driver.get("https://omayo.blogspot.com/");
		  
		  String parentwindow = driver.getWindowHandle();
		  
		 // driver.findElement(By.xpath(parentwindow))
		  
		  driver.findElement(By.linkText("Open a popup window")).click();
		  
		

	}

}
