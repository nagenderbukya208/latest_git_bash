package practice.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.HomePage;

public class SampleTestwithPom {
	@FindBy(name="user_name")
	WebElement ele1;
	@FindBy(name="user_password")
	WebElement ele2;
	@FindBy(id="submitButton")
	WebElement ele3;
	
//	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login']")})
//	 private WebElement ele3;
//	@FindBys({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login']")})
//	private WebElement ele3;
//	
	@Test
	public void sample() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		SampleTestwithPom s=PageFactory.initElements( driver,SampleTestwithPom.class);
	HomePage hp=new HomePage(driver);
	System.out.println(hp.getOrgLink().getText());
		s.ele1.sendKeys("admin");
		s.ele2.sendKeys("root");
		
		s.ele3.click();
	}
	
	

}
