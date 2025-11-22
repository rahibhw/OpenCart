package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement myAccount_txt;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']") WebElement logout_link;
	
	@FindBy(xpath="//a[text()='Continue']") WebElement btn_continue;
	
	public boolean isMyAccountPageVisible() {
		try {
			return myAccount_txt.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLogout()
	{
			logout_link.click();
	}
	

	



}
