package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_Login() {
		logger.info("****TC_002_Login Test is started*****");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clickLoginButton();

			MyAccountPage ap = new MyAccountPage(driver);

			boolean targetPage = ap.isMyAccountPageVisible();

			// Assert.assertEquals(targetPage, true, "Login is failed");
			Assert.assertTrue(targetPage);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Test execution for TC002_login Test is completed");

	}

}
