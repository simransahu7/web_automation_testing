package objectRepository;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "login1")
	@CacheLookup
	WebElement username;
	
	@FindBy(name = "passwd")
	@CacheLookup
	WebElement password;
	
	@FindBy(className  = "signinbtn")
	@CacheLookup
	WebElement signInButton;
	
	@FindBy(linkText = "Forgot Password?")
	@CacheLookup
	WebElement forgotPasswordLink;
	
	@FindBy(partialLinkText = "Create a new")
	@CacheLookup
	WebElement createAnewAccLink;
	
	@FindBy(linkText = "Logout")
	@CacheLookup
	WebElement logoutLink;
	
	public LoginPage(WebDriver driver1)
	{
		driver = driver1;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUsername(String un)
	{
		username.sendKeys(un);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickButton()
	{
		signInButton.click();
	}
	
	public boolean isForgotPwdLinkDisplayed()
	{
		try
		{
		boolean status = forgotPasswordLink.isDisplayed();
		return status;
		}catch(NoSuchElementException e)
		{
			System.out.println("Forgot password link is not displayed in Login Page");
			return false;
		}
	}
	
	public boolean isCreateAnewAccLinkDisplayed()
	{
		try
		{
		boolean status = createAnewAccLink.isDisplayed();
		return status;
		}catch(NoSuchElementException e)
		{
			System.out.println("Forgot password link is not displayed in Login Page");
			return false;
		}
	}
	
	public boolean isLogoutLinkDisplayed()
	{
		try
		{
		boolean status = logoutLink.isDisplayed();
		return status;
		}catch(NoSuchElementException e)
		{
			System.out.println("Forgot password link is not displayed in Login Page");
			return false;
		}
	}
	
	
	

}
