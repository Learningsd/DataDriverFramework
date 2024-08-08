package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{

	WebDriver driver;

	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Username;
	
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement loginPageWarning;
	
	
	public void usernameFileld(String uname)
	{
		Username.sendKeys(uname);
	}
	
	public void passwordFileld(String pword)
	{
		Password.sendKeys(pword);
	}
	
	public AccountPage clickonLogin()
	{
		LoginButton.click();
		return new AccountPage(driver);
	}
	
	public boolean loginWarningDisplayStatus() {
		boolean loginWarningDisplayStatus = loginPageWarning.isDisplayed();
		return loginWarningDisplayStatus;
	}

}
