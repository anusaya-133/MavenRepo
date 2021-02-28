package pfPack.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LoginPage extends BasePage {
	
	@FindBy(id="login_id") 
	public WebElement eMail;
	
	@FindBy(id="nextbtn")
	public WebElement next;
	
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(className="sign_agree")
	public WebElement iAgree;
	
	@FindBy(css="#nextbtn > span")
	public WebElement signIn;
	
public LoginPage(WebDriver driver, ExtentTest eTest)
	{
		this.driver = driver;
		this.eTest = eTest;
	}
	//Reusable methods of the LoginPage
	public boolean doLogin()
	{
		eMail.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO, "Username entered");
		
		next.click();
		
		password.sendKeys(Constants.PASSWORD);
		eTest.log(LogStatus.INFO, "Entered Password successfully");
		
		signIn.click();
		eTest.log(LogStatus.INFO, "Signin button clicked");
		
		HomePage homePage = new HomePage(driver, eTest);
		PageFactory.initElements(driver, homePage);
		
		boolean loginStatus = homePage.verifyDisplayOfHomePage();
		return loginStatus;
	}
	

}
