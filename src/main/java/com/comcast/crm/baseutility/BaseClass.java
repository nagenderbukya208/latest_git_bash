package com.comcast.crm.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
public	DatabaseUtility dLib=new DatabaseUtility();
public FileUtility fLib=new FileUtility();
public	ExcelUtility eLib=new ExcelUtility();
public	JavaUtility jLib=new JavaUtility();
public	WebDriverUtility wLib=new WebDriverUtility();
public	WebDriver driver=null;

	@BeforeSuite(groups = {"smokeTest","RegressionTest"})
	public void configBS() throws SQLException {
		System.out.println("==connect to DB ,Report Config==");
		dLib.getDbConnection();
	}
	@Parameters("Browser")
	@BeforeClass(groups = {"smokeTest","RegressionTest"})
	public void configBC(String browser) throws IOException {
		System.out.println("==Launch the Browser==");
      String Browser=	fLib.getDataFromPropertiesFile("browser");
      WebDriver driver =null;
		//String Browser=browser;
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
		
	}
	
	@BeforeMethod(groups = {"smokeTest","RegressionTest"})
	public void configBM() throws IOException {
		System.out.println("==Login==");
		LoginPage lp=new LoginPage(driver);
		String Url=fLib.getDataFromPropertiesFile("url");
		String Username=fLib.getDataFromPropertiesFile("username");
		String Password=fLib.getDataFromPropertiesFile("password");
		
	lp.loginToapp(Url,  Username,  Password);
		
	}
	@AfterMethod(groups = {"smokeTest","RegressionTest"})
	public void configAM() {
		System.out.println("==logOut==");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	
	@AfterClass(groups = {"smokeTest","RegressionTest"})
	public void configAC() throws SQLException {
		System.out.println("==Close the Browser==");
		driver.quit();
		
	}
	@AfterSuite(groups = {"smokeTest","RegressionTest"})
	public void configAS() throws SQLException {
		System.out.println("==close DB,Report backUP==");
		dLib.closeDbConnection();
		 
	}

}
