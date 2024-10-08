package practice.pom.repository;

import java.io.IOException;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.HomePage1;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPom  extends BaseClass{
	WebDriver driver=null;
	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException {
	
		
		System.out.println("opening");
	     //read test data from excel
	    String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
			//step2: navigate to Organisation module
//		
    HomePage1 hp=new HomePage1(driver);
          hp.getOrgLink().click();
			
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
		
		
	}


}
