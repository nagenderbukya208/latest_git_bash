package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * 
 * @author RAGHAVAMMA
 * Contains Login page elements & business library
 * 
 */
//1.create a separate java class
public class LoginPage extends WebDriverUtility {
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//2.Object creation
	@FindBy(name="user_name")
   private	WebElement usernameEdt;
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//3.Object Initialization
	
	//4.Object Enacapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	/**
	 * 
	 * login to applicstion based on username,password,url
	 * @param Url
	 * @param Username
	 * @param Password
	 */
	//5.we can provide Action
	public void loginToapp(String Url,String Username,String Password) {
		waitForPageToLoad(driver);
		driver.get(Url);
		driver.manage().window().maximize();
		
		usernameEdt.sendKeys(Username);
		passwordEdt.sendKeys(Password);
		loginBtn.click();
	}
	
	
}
