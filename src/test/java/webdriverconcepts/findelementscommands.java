package webdriverconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findelementscommands {

	public static void main(String[] args) 
	{
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.manage().window().maximize();
		
		WebElement emailfield = driver.findElement(By.id("input-email"));

		emailfield.sendKeys("syedalthaf456@gmail.com");
		emailfield.clear();
		emailfield.sendKeys("syed3u42938@gmail.com");
		
	}

}
