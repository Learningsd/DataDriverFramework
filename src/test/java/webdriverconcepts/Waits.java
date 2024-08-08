package webdriverconcepts;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Waits {

	public static void main(String[] args) 
	{
		
		ChromeDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://omayo.blogspot.com/");
		
		
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//		WebElement flipkart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Flipkart']")));
//		
		 //driver.findElement(By.xpath("//a[normalize-space()='Flipkart']"));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30L))
			       .pollingEvery(Duration.ofSeconds(5L))
			       .ignoring(NoSuchElementException.class);

			   WebElement flipkart = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return driver.findElement(By.xpath("//a[normalize-space()='Flipkart']"));
			     }
			   });
		
		flipkart.click();
		

	}

}
