package pfPack.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LaunchPage extends BasePage{
	
	@FindBy(className="zh-customers")
	public WebElement customers;
	 
	 @FindBy(className="zh-login")
	 public WebElement login;
	 
	 @FindBy(className="zh-support")
	 public WebElement support;
	 
	 @FindBy(className="zh-contact")
	 public WebElement contact;
	 
	 @FindBy(className="zgh-localSelect")
	 public WebElement language;
	 
	 public LaunchPage(WebDriver driver, ExtentTest eTest)
	 {
		 this.driver = driver;
		 this.eTest = eTest;
		 
	 }
	 
	 public boolean goToLoginPage()
	 {
		 driver.get(Constants.APP_URL);
		 eTest.log(LogStatus.INFO, "Application url"+Constants.APP_URL+"got opened");
		 login.click();
		 eTest.log(LogStatus.INFO, "Navigation successful");
		 
		 LoginPage loginPage = new LoginPage(driver, eTest);
			PageFactory.initElements(driver, loginPage);
			
			boolean loginStatus=loginPage.doLogin();
		 return loginStatus;
	 }
	 
	

}
