package webdriverconcepts;

import org.openqa.selenium.chrome.ChromeDriver;

public class Attribute {

	public static void main(String[] args) 
	{
      ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
		
		String actualtext = driver.getTitle();
		
		String exptext="Your Store";
		
		if(actualtext.equals(exptext))
		{
			System.out.println("test passed");
		}else
		{
			System.out.println("test failed");
		}
		

	}

}
