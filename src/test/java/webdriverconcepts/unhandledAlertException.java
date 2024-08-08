package webdriverconcepts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class unhandledAlertException {

	public static void main(String[] args) {
            ChromeDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		
	
		WebElement button=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		button.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Alert alert = driver.switchTo().alert();
		
		//String textofalert=alert.getText();
		
		//System.out.println(textofalert);
		
		//alert.accept();
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

	}

}
