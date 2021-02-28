package pfPack.tests;import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pfPack.page.LaunchPage;
import pfPack.tests.base.BaseTest;
import pfPack.util.Constants;

	public class LoginTest extends BaseTest
		{
			@Test
			public void testLogin()
				{
				eTest = eRep.startTest("LoginTest");
				eTest.log(LogStatus.INFO, "Starting test here");
					
					openBrowser(Constants.BROWSER_TYPE);
					LaunchPage launchPage = new LaunchPage(driver, eTest);
					PageFactory.initElements(driver, launchPage);
					
					boolean loginStatus = launchPage.goToLoginPage();
					if(loginStatus)
					{
						reportPass("Test case passed");
					}else
					{
						reportFail("Test case failed");
					}
				}  
			@AfterMethod
			public void testClosure()
			{
				if(eRep!=null)
				{
					eRep.endTest(eTest);
					eRep.flush();
				}
				if(driver!=null)
				{
					driver.quit();
				}
			}
		}