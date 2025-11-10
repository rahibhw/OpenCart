package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="loginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String password, String exp)
	{
		logger.info("TC_003_LoginDDT Test execution is started");
		try
		{
		HomePage hm=new HomePage(driver);
		hm.clickAccount();
		hm.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLoginButton();
		
		MyAccountPage macc= new MyAccountPage(driver);
		boolean targetPage= macc.isMyAccountPageVisible();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
				
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
				
		}
	}
		catch(Exception e)
		{
			logger.info("Test Failed");
			Assert.fail("An exception occurred "+e.getMessage());
		}
	
       logger.info("***Test execution of TC_003_LoginDDT has been completed");
   }
}
