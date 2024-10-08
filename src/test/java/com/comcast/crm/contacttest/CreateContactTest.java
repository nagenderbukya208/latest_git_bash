package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseutility.BaseClass1;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass1 {
	
	
	@Test
	public void createContactTest()throws Throwable{
		String lastName =eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNum();
		
		
		//step2: navigate to Contact module
		
		
		HomePage hp=new  HomePage(driver);
		hp.getContactLink().click();
		
		//click on create conatct button
		
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
		
		//enter all the details and create new Organization
	CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
	ccp.createContact(lastName);
		//verify Header msg Expected result
    ContactInfoPage cip=new ContactInfoPage(driver);
    
    String actHeader=driver.findElement(By.className("dvHeaderText")).getText();
    boolean status=actHeader.contains(lastName);
    Assert.assertEquals(status, true);
    
    
String actLastName=  cip.getLastNameTxt().getText();
      SoftAssert soft=new SoftAssert();
      soft.assertEquals(actLastName, lastName);
	}

   @Test
public void createContactWithSupportDateTest() throws EncryptedDocumentException, IOException {
	   
	   //read testscript data from excel
	   String lastName=eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNum();
	   //navigate to contact module
	   HomePage hp=new HomePage(driver);
	   hp.getContactLink().click();
	   //click on create contact button
	   ContactPage cp=new ContactPage(driver);
	   cp.getCreateNewContactBtn().click();
	   
	   //enter all the details &create new Contact
	   
	   String startDate=jLib.getSystemDateYYYYDDMM();
		String endDate=jLib.getRequiredDateYYYYDDMM(30);
		
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
	   ccp.createContactWithSupportDate(lastName, startDate, endDate);

	   //verify Header phone number info expected result
	   ContactInfoPage cip=new ContactInfoPage(driver);
	   String actStartDate=cip.getSupportStartDateInfo().getText();
	   Assert.assertEquals(actStartDate.trim(), startDate);
	   
	   String actendDate=cip.getSupportEndDateInfo().getText();
	   Assert.assertEquals(actendDate.trim(), endDate);
		}
   
   @Test
   public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
	   //read testScript data from Excel file
	   String orgName =eLib.getDataFromExcel("conatct", 7, 2)+jLib.getRandomNum();
	   String conatctLastName =eLib.getDataFromExcel("conatct", 7, 3)+jLib.getRandomNum();
	   //navigate to Organisation module
	   HomePage hp=new HomePage(driver);
	   // click on  create organisation
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();
		
		//enter all the details and create new Organization
	CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
	cop.createOrg(orgName);
	//verify Header
	String actOrgName=       driver.findElement(By.id("mouseArea_Organization Name")).getText();
    if(actOrgName.trim().equals(orgName)) {
  	  System.out.println(orgName+" information  is  verified ==PASS");
    }
    else {
  	  System.out.println(orgName+" information is not verified ==FAIL");
    }
   hp.getContactLink().click();
   ContactPage cp=new ContactPage(driver);
   cp.getCreateNewContactBtn();
   CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
    ccp.getContactWithOrg(conatctLastName,orgName);
    
  //verify Header
  	String actOrgName1=       driver.findElement(By.id("mouseArea_Organization Name")).getText();
      if(actOrgName1.trim().equals(orgName)) {
    	  System.out.println(orgName+" information  is  verified ==PASS");
      }
      else {
    	  System.out.println(orgName+" information is not verified ==FAIL");
      }
    
    
   }
}
