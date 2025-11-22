package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import pageObjects.SearchPage;

public class TC004_SearchProduct extends BaseClass {
	
	@Test(groups="Sanity")
	public void productSearch() throws InterruptedException
	{
	
		try {
		HomePage hp=new HomePage(driver);
		hp.productSearch(prop.getProperty("product"));
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		boolean status = sp.isProductVisible(prop.getProperty("product"));
		
		Assert.assertEquals(status, true);
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		
	
	  

}
}
