package webdriverconcepts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthenticationAlerts {

	public static void main(String[] args) 
	{
		    ChromeOptions co=new ChromeOptions();
		    co.addArguments("--disable-notifications");
		    ChromeDriver driver = new ChromeDriver(co);
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			
			//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		    
		    driver.get("https://www.justdial.com/");
			
			
			
			
			
			
		

	}

}
