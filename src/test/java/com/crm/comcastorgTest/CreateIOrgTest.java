package com.crm.comcastorgTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;

public class CreateIOrgTest extends BaseClass {
	
	@Test
	public void createOrgTest() {
		System.out.println("execute createContact & verify");
	}

	
	@Test
	public void createOrgWithIndustries() {
		System.out.println("execute createContactWithDate & verify");
	}

	
}
