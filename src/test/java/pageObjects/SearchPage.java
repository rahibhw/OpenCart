package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	// @FindBy(xpath="//input[@placeholder='Search']") WebElement search_box;

	// @FindBy(xpath="//button[contains(@class,'btn-lg')]//i[@class='fa
	// fa-search']") WebElement btn_search;

	// @FindBy(xpath="//div[@class='image']//img") List<WebElement> product_list;

	// @FindBy(xpath="//*[@id='content']/div[3]//img") List<WebElement>
	// product_list;

	@FindBy(xpath = "//div[@class='caption']/h4/a")
	List<WebElement> product_list;
	
	@FindBy(xpath="//input[@id='input-quantity']") WebElement txt_quantity;
	
	@FindBy(xpath="//button[@id='button-cart']") WebElement btn_cart;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]") WebElement txt_success;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']") WebElement link_shoppingCart;

	public boolean isProductVisible(String productName) {

		boolean target = false;
		try {

			for (WebElement prod : product_list) {
				// if (prod.getAttribute("title").equalsIgnoreCase(productName))

				if (prod.getText().equals(productName)) {
					target = true;
					Assert.assertTrue(true);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		return target;

	}

	public void clickProduct(String productName) {

		for (WebElement prod : product_list) {
			try {
				// if(prod.getAttribute("title").equalsIgnoreCase(productName))
				if (prod.getText().equals(productName)) {
					prod.click();
					break;
				}

			} catch (Exception e) {
				Assert.assertTrue(false);
			}
		}

	}
	
	public void addQuantity(String quantity)
	{
		txt_quantity.clear();
		txt_quantity.sendKeys(quantity);
	}
	
	public void addToCart()
	{
		btn_cart.click();
	}
	
	public boolean isProductAddedToCart()
	{
		boolean target=false;
		
		if(txt_success.isDisplayed())
		{
			target=true;
		}
		
		return target;
	}
	
	public ShoppingCartPage clickShoppingCartLink()
	{
		ShoppingCartPage sh = new ShoppingCartPage(driver) ;
		link_shoppingCart.click();
		return  sh;
	}

}
