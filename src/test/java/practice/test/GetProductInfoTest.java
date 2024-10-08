package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName,String productName) {
		WebDriver driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		//search product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		
		//capture product info
		
String price=driver.findElement(By.xpath
("//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[2]/div/a/span[1]")).getText();
System.out.println(price);
		driver.quit();
		
		
	}
	@DataProvider
	public Object[][]getData() throws Throwable{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount=eLib.getRowcount("product");
		
		Object[][] data=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			data[i][0]=eLib.getDataFromExcel("product", i+1, 0);
			data[i][1]=eLib.getDataFromExcel("product", i+1, 1);
		}
		
		return data;
	}

}
