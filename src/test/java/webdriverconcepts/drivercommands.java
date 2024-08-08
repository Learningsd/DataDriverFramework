package webdriverconcepts;

import org.openqa.selenium.chrome.ChromeDriver;

public class drivercommands {

	public static void main(String[] args) 
	{
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
		
		driver.manage().window().minimize();
		
		driver.quit();

	}

}
