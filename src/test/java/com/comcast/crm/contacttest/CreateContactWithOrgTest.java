package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {
	public static void main(String[] args) throws IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		String Browser=fLib.getDataFromPropertiesFile("browser");
		String Url=fLib.getDataFromPropertiesFile("url");
		String Username=fLib.getDataFromPropertiesFile("username");
		String Password=fLib.getDataFromPropertiesFile("password");
		//read data from Excel file
		
		String orgName=eLib.getDataFromExcel("contact", 7, 2)+jLib.getRandomNum();
	String contactLastName=eLib.getDataFromExcel("contact", 7, 3);

//		
		
		
			WebDriver driver=null;
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
			wLib.waitForPageToLoad(driver);
			
			
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			//step2: navigate to Organisation module
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization'])")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
			//verify Header msg Expected result
	String headerinfo=		driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(orgName)) {
		System.out.println(orgName+" is created==PASS");
	}
	else {
		System.out.println(orgName+" is not created==FAIL");
	}
		//verify header orgname info expected result
	String actorgname=driver.findElement(By.id("dtlview_Organization")).getText();
	if(actorgname.equals(orgName)) {
		System.out.println(orgName+" is created==PASS");
	}
	else {
		System.out.println(orgName+" is not created==FAIL");
	}
	
	//step2: navigate to Contacts module
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@title='Create Contact...'])")).click();
			
			driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			//switch to child window
		wLib.switchToTabOnUrl(driver, "module=Accounts");
		
			driver.findElement(By.name("search_text")).sendKeys(orgName);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).sendKeys(contactLastName);
			
			//switch to parent window
			wLib.switchToTabOnUrl(driver, "Contacts&action");
			
			driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
			//verify Header msg Expected result

		//verify header orgname info expected result
			String actlastname=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actlastname.trim().equals(contactLastName)) {
				System.out.println(contactLastName+" is created==PASS");
			}
			else {
				System.out.println(contactLastName+" is not created==FAIL");
			}
		driver.quit();
	}

}
