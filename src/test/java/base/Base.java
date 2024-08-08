package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base 
{
	 WebDriver driver;
	public Properties prop;
	 
	 
	 public Base() 
	 {
		 
		 try {
			 prop=new Properties();
		   File fi=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ProjectDetails.properties");
		   FileReader fr=new FileReader(fi);
			prop.load(fr);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	 
	public WebDriver openBrowserAndApplication(String browserName)
	{
		
		        if(browserName.equalsIgnoreCase("chrome"))
				{
			      driver=new ChromeDriver();
				}else if(browserName.equalsIgnoreCase("firefox"))
				{
					driver=new FirefoxDriver();
				}else if(browserName.equalsIgnoreCase("edge"))
				{
					driver=new EdgeDriver();
				}else if(browserName.equalsIgnoreCase("ie"))
				{
					driver=new InternetExplorerDriver();
				}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}

}
