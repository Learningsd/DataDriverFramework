package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;

	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement Myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Loginoption;
	
	@FindBy(linkText="Register")
	WebElement registerOption;
	
	@FindBy(name="search")
	WebElement searchBoxField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchButton;
	
	public void clickonMyaccount()
	{
		Myaccount.click();
	}
	
	public Loginpage ClickonLoginButton()
	{
		Loginoption.click();
		return new Loginpage(driver);
	}
	
	public RegisterPage selectRegisterOption() {
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterSearchText(String searchText) {
		searchBoxField.sendKeys(searchText);
	}
	
	public SearchResultPage clickOnSearchButton() {
		searchButton.click();
		return new SearchResultPage(driver);
	}
	
}
