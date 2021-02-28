 package pfPack.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import pfPack.base.BasePage;

public class HomePage extends BasePage {
	@FindBy(css="span[class^='_logo-books']")
	public WebElement books;
	
	@FindBy(css="span[class^='_logo-calendar']")
	public WebElement calendar;
	
	@FindBy(css="span[class^='_logo-campaigns']")
	public WebElement Campaigns;
	
	@FindBy(css="span[class^='_logo-chat']")
	public WebElement chats;
	
	public HomePage(WebDriver driver, ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}
	public boolean verifyDisplayOfHomePage()
	{
		return(isElementPresent(calendar));
	}
	
}
