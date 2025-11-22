package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShoppingCartPage extends BasePage {
	
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='table-responsive']//tbody//tr//td[5]") WebElement unitPrice;
	@FindBy(xpath="//div[@class='table-responsive']//tbody//tr//td[6]") WebElement totalPrice;
	@FindBy(xpath="//a[text()='Checkout']") WebElement btn_checkout;
	
	public boolean comparePrices(String price)
	{
		boolean target=false;
		if(totalPrice.getText().equals(price))
				{
			       target=true;
			       Assert.assertTrue(true);
				}
		return target;
	}
	
	public void clickOnCheckOut()
	{
		btn_checkout.click();
	}

}
