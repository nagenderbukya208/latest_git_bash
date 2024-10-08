package com.comcast.crm.orgtest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.baseutility.BaseClass1;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listennerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.HomePage1;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
//@Listeners( com.comcast.crm.listennerutility.ListenerImpClass.class)
public class CreateOrganization1Test extends BaseClass1{
	
	@Test(groups ="smokeTest")
	public void createOrgTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
				/*read testscript data from Excel*/
		String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
		/*navigate to Organisation module*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		/*3.click on create organisation*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organisation page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		/*4.enter all the details and create new Organization*/
		UtilityClassObject.getTest().log(Status.INFO, "Create org");
	CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
	cop.createOrg(orgName);
	UtilityClassObject.getTest().log(Status.INFO, orgName+"org created");
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
	
	@Test(groups = "RegressionTest")
	public void createOrgWithIndustries() throws EncryptedDocumentException, IOException {	
		String orgName=eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNum();
		String industry=eLib.getDataFromExcel("org", 4, 3);
		//String type=eLib.getDataFromExcel("org", 4, 4);
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		/*enter all the details and create new Organization*/
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		
		cop.createOrg(orgName, industry);
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
	@Test(groups="RegressionTest")
	public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException {
		String orgName=eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNum();
		String phoneNo=eLib.getDataFromExcel("org", 7, 3);
		//String type=eLib.getDataFromExcel("org", 4, 4);
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		/*enter all the details and create new Organization*/
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.getOrgNameEdt().sendKeys(orgName);
		cop.getPhoneNoEdt().sendKeys(phoneNo);
		cop.getSaveBtn().click();
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
