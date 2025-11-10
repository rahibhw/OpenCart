package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']") WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Register']") WebElement register;
	
	@FindBy(xpath="//a[text()='Login']") WebElement link_login;
	
	
	public void clickAccount()
	{
		myAccount.click();
		
	}
	
	public void clickRegistration()
	{
		register.click();
	}
	
	public void clickLogin()
	{
		link_login.click();
	}

}
