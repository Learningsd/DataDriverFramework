package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Takesscreenshots 
{

	public static String Sceenshots(WebDriver driver,String testname)
	{
         File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String ScreenshotFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png";
		
		
		try {
			FileHandler.copy(src, new File(ScreenshotFilePath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return ScreenshotFilePath;
		
		
		
	}
}
