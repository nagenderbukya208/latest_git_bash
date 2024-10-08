package com.comcast.crm.baseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SS {
	WebDriver driver;
	@Test
	public void dataFromBefore(String Url,String Username,String Password) {
		HomePage hp=new HomePage(driver);
		//hp.getOrgLink();
		System.out.println(hp.getOrgLink().getText());
		
//		System.out.println(Url);
//		System.out.println(Username);
//		System.out.println(Password);
	}

}
