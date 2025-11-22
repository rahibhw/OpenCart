package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;

public class TC005_SelectProduct extends BaseClass {
	
	@Test(groups="Sanity")
	public void selectProduct() 
	{
	  logger.info("Test execution started for TC005_SelectProduct");
		try {
		HomePage hp=new HomePage(driver);
		hp.productSearch(prop.getProperty("product"));
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		boolean status = sp.isProductVisible(prop.getProperty("product"));
		
		Assert.assertEquals(status, true);
		sp.clickProduct(prop.getProperty("product"));
		sp.addQuantity(prop.getProperty("quantity"));
		Thread.sleep(1000);
		sp.addToCart();
		
		boolean flag = sp.isProductAddedToCart();
		
		Assert.assertEquals(flag, true);
		Thread.sleep(1000);
		
		ShoppingCartPage sh= sp.clickShoppingCartLink();
		logger.info("Clicked on Shopping cart link");
		
		boolean flag1 = sh.comparePrices(prop.getProperty("productPrice"));
		Assert.assertEquals(flag1, true);
		
		logger.info("Item price has been compared successfully");
		sh.clickOnCheckOut();
		
		logger.info("Clicked on checkout button successfully");
		
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
		logger.info("Test execution completed for TC005_SelectProduct");
		
	
	  

}
}
