package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC001_validateAccountRegistration extends BaseClass {

	@Test(groups={"Regression", "Master"})
	public void testRegistration() {
		
		logger.info("Test execution started for TC001_Account Registration");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickAccount();
		logger.info("clicked on myaccount link");
		hp.clickRegistration();
		logger.info("clicked on registration link");

		RegistrationPage reg = new RegistrationPage(driver);
		logger.info("providing customer details");
		reg.setFname(randomString().toUpperCase());
		reg.setLname(randomString().toUpperCase());
		reg.setEmail(randomString().toLowerCase() + "@gmail.com");
		reg.setTelephone(randomNumber());
		String pwd = randomPwd();
		reg.setPassword(pwd);
		reg.setConfirmPassword(pwd);
		reg.clickOnPrivacyPolicy();
		reg.clickSubmitbtn();
		logger.info("Validating registration success message now");

		String confirmation_msg = reg.confirmationText();

		if(confirmation_msg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("Test TC001_AccountRegistration  is passed");
		}
		else 
		{
			 logger.error("Test Failed");
			 logger.debug("Debug logs..");
			 Assert.assertTrue(false);
		}
		
		}
		catch (Exception e)
		{
		
		 Assert.fail();
		}
		
		logger.info("Finished Execution of TC001_Account Registration");
		}

}
