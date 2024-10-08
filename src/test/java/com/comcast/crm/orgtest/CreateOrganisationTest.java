package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

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

public class CreateOrganisationTest {
	public static void main(String[] args) throws IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		
		String Browser=fLib.getDataFromPropertiesFile("browser");
		String Url=fLib.getDataFromPropertiesFile("url");
		String Username=fLib.getDataFromPropertiesFile("username");
		String Password=fLib.getDataFromPropertiesFile("password");
		//generate random number
		Random random=new Random();
	     int randomInt =random.nextInt(1000);
	     //read test data from excel
	    
			String orgName=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
			
			WebDriver driver =null;
			if(Browser.equals("chrome")) {
				driver=new ChromeDriver();
			}
			else if(Browser.equals("firefox")) {
				driver=new FirefoxDriver();
				
			}
			else if(Browser.equals("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			
			driver.get(Url);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			driver.findElement(By.name("user_password")).sendKeys(Password);
			driver.findElement(By.id("submitButton")).click();
			//step2: navigate to Organisation module
			driver.findElement(By.linkText("Organizations")).click();
			System.out.println("=========");
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			//verify Header msg Expected result
	String headerinfo=		driver.findElement(By.className("dvHeaderText")).getText();
	if(headerinfo.contains(orgName)) {
		System.out.println(orgName+" is created==PASS");
	}
	else {
		System.out.println(orgName+" is not created==FAIL");
	}
		
	//navigate to Contact module
	
		driver.quit();	
	}

}
