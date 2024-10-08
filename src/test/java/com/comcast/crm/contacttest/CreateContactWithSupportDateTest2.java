package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDateTest2 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		
		String Browser=fLib.getDataFromPropertiesFile("browser");
		String Url=fLib.getDataFromPropertiesFile("url");
		String Username=fLib.getDataFromPropertiesFile("username");
		String Password=fLib.getDataFromPropertiesFile("password");
     
     //read test data from excel
     String lastName=eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNum();
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
		//step2: navigate to Contacts module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...'])")).click();
		
		String startDate=jLib.getSystemDateYYYYDDMM();
		String endDate=jLib.getRequiredDateYYYYDDMM(30);
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
		//verify Header msg Expected result

	//verify header orgname info expected result
String actstartdate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
if(actstartdate.equals(startDate)) {
	System.out.println(startDate+" information is verified==PASS");
}
else {
	System.out.println(startDate+" information is not verified==FAIL");
}
String actenddate=driver.findElement(By.id("dtlview_Support End Date")).getText();
if(actenddate.equals(endDate)) {
	System.out.println(endDate+" information is verified==PASS");
}
else {
	System.out.println(endDate+" information is not verified==FAIL");
}
	driver.quit();

}}
