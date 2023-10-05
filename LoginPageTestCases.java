package testCasePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import objectRepository.LoginPage;

public class LoginPageTestCases {
	
	WebDriver driver;
	
	LoginPage obj;
	@Parameters({"browser"})
	@BeforeMethod
	public void launchApplication(String browser) throws InterruptedException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "D:\\Software\\chromedriver-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		if(browser.equalsIgnoreCase("safari"))
		{
			System.setProperty("webdriver.safari.driver", "D:\\Software\\chromedriver-win64\\safaridriver.exe");
			driver = new SafariDriver();
		}
		
		Thread.sleep(3000);
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		obj = new LoginPage(driver);
		
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredential()
	{
		obj.enterUsername("satishgangwani19");
		obj.enterPassword("Sati1234$");
		obj.clickButton();
		boolean flag = obj.isLogoutLinkDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 2)
	public void LoginWithVldUNInvPWD()
	{
		obj.enterUsername("satishgangwani19");
		obj.enterPassword("Sati1234");
		obj.clickButton();
		boolean flag = obj.isForgotPwdLinkDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 3)
	public void LoginWithIvnUNVldPWD()
	{
		obj.enterUsername("sdkjvsdv");
		obj.enterPassword("Sati1234$");
		obj.clickButton();
		boolean flag = obj.isForgotPwdLinkDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 4)
	public void verifyForgotPassword()
	{
		boolean flag = obj.isForgotPwdLinkDisplayed();
		Assert.assertEquals(flag, true);
	}

	@Test(priority = 5)
	public void verifyCreateNewAcc()
	{
		boolean flag = obj.isCreateAnewAccLinkDisplayed();
		Assert.assertEquals(flag, true);
	}

}
