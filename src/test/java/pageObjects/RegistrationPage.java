package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txt_firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txt_lastName;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txt_pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirmPwd;
	
	@FindBy(xpath="//input[@name='agree']") WebElement chk_privacyAgreement;
	
	@FindBy(xpath="//div[@id='content']//h1") WebElement confirmation_txt;
	
	@FindBy(xpath="//input[@type='submit']") WebElement btn_submit;
	
	@FindBy(xpath="//a[text()='Continue']") WebElement btn_continue;
	
	public void setFname(String fname)
	{
		txt_firstName.sendKeys(fname);
	}
	
	public void setLname(String lname)
	{
		txt_lastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setTelephone(String number)
	{
		txt_telephone.sendKeys(number);
	}
	
	public void setPassword(String pwd)
	{
		txt_pwd.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		txt_confirmPwd.sendKeys(pwd);
	}
	
	public void clickOnPrivacyPolicy()
	{
		chk_privacyAgreement.click();
	}
	
	public void clickSubmitbtn()
	{
		btn_submit.click();
	}
	
	public String confirmationText() {
		try {
			String msg = confirmation_txt.getText();
			return msg;
		} catch (Exception e) {
			String excp = e.getMessage();
			return excp;
		}

	}
	
	public void clickContinue()
	{
		try 
		{
			btn_continue.click();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
	}

}
