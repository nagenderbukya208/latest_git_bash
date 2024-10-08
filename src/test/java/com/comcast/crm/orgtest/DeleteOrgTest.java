package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String Browser=fLib.getDataFromPropertiesFile("browser");
		String Url=fLib.getDataFromPropertiesFile("url");
		String Username=fLib.getDataFromPropertiesFile("username");
		String Password=fLib.getDataFromPropertiesFile("password");
	
		
	     //read test data from excel
	    
			String orgName=eLib.getDataFromExcel("org", 10, 2)+jLib.getRandomNum();
			
			WebDriver driver =null;
			if(Browser.equalsIgnoreCase("chrome")) {
				driver=new ChromeDriver();
			}
			else if(Browser.equalsIgnoreCase("firefox")) {
				driver=new FirefoxDriver();
				
			}
			else if(Browser.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			//login to application
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(Url);
			
			//object intialisation
			
			LoginPage lp=new LoginPage(driver);

			lp.loginToapp(Username, Password, Url);
			
		//step2: navigate to Organisation module
			HomePage hp=new  HomePage(driver);
			hp.getOrgLink().click();
			
			//click on create organisation
			
			OrganizationsPage op=new OrganizationsPage(driver);
			op.getCreateNewOrgBtn().click();
			
			//enter all the details and create new Organization
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName);
			//verify Header msg Expected result
          OrganizationInfoPage oip=new OrganizationInfoPage(driver);
   String actorgName=       oip.getHeaderMsg().getText();
          if(actorgName.contains(orgName)) {
        	  System.out.println(orgName+" name is  verified ==PASS");
          }
          else {
        	  System.out.println(orgName+" name is not verified ==FAIL");
          }
		
          //go back to Organization
         
			hp.getOrgLink().click();
          //search for organisation
			op.getSearchEdt().sendKeys(orgName);
			wLib.select(op.getSearchDD(), "Organization Name");
			op.getSearchBtn().click();
			 wLib.switchToAlertAndAccept(driver);
          //in dynamic webtable select &delete org
			driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']"));
			
          //step 5:log out
          hp.logout();
		
			driver.quit();	
	}


}
