package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationWithIndustriesTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./ConfigureAPPData/cdata.properties");
		Properties p =new Properties();
		p.load(fis);
		String Browser=p.getProperty("browser");
		String Url=p.getProperty("url");
		String Username=p.getProperty("username");
		String Password=p.getProperty("password");
		//generate random number
		Random random=new Random();
	     int randomInt =random.nextInt(1000);
	     //read test data from excel
	     FileInputStream fis1=new FileInputStream("./TestData/testscriptdata.xlsx");
			//step-2:open workbook in read mood
			Workbook wb=WorkbookFactory.create(fis1);
			//step-3:get the control of the "org" sheet
			Sheet sh=wb.getSheet("org");
			//step-4:get the control of 1st row
			Row row =sh.getRow(4);
		String orgName=row.getCell(2).toString()+randomInt;
		String industry=row.getCell(3).toString();
		String type=row.getCell(4).toString();
			
			wb.close();
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
			driver.findElement(By.xpath("//img[@title='Create Organization'])")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			WebElement I=driver.findElement(By.name("industry"));
			Select sel=new Select(I);
			sel.selectByVisibleText(industry);
			WebElement T=driver.findElement(By.name("industry"));
			Select sel1=new Select(T);
			sel1.selectByVisibleText(type);
			
			
			driver.findElement(By.name("//input[@title='Save[Alt+S]']")).click();
			//verify Header msg Expected result
	String actIndustries=		driver.findElement(By.id("dtlview_Industry")).getText();
	if(actIndustries.contains(industry)) {
		System.out.println(industry+" information is verified==PASS");
	}
	else {
		System.out.println(industry+" information is verified==FAIL");
	}
		//verify header orgname info expected result
	String actType=driver.findElement(By.id("dtlview_Type")).getText();
	if(actType.equals(type)) {
		System.out.println(type+" information is verified==PASS");
	}
	else {
		System.out.println(type+" information is verified==FAIL");
	}
			
	}

}
