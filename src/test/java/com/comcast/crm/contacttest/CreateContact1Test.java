package com.comcast.crm.contacttest;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.baseutility.BaseClass1;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContact1Test extends BaseClass1{

	@Test(groups = "smokeTest")
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
String actLastName=  cip.getLastNameTxt().getText();
      if(actLastName.equals(lastName)) {
    	  System.out.println(lastName+" information  is  verified ==PASS");
      }
      else {
    	  System.out.println(lastName+" information is not verified ==FAIL");
      }
	}


}
