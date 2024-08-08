package webdriverconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendkeysdemo {

	public static void main(String[] args) {
		
       ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
		
	 WebElement search = driver.findElement(By.name("search"));
	 search.sendKeys("hp");
	 search.sendKeys(Keys.ENTER);
	 
		
	}

}
