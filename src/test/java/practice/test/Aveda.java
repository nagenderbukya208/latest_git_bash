package practice.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Aveda {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get("https://www.aveda.de/");
		 
//		 WebElement hair=	 driver.findElement(By.xpath("(//a[text()='HAARE & KOPFHAUT'])[2]"));
//	       hair.click();
	        driver.findElement(By.id("onetrust-reject-all-handler")).click();
	        
	        Thread.sleep(1000);
	         WebElement hair=	 driver.findElement(By.xpath("(//a[@aria-label=\"STYLING\"])[2]"));
	         Actions act=new Actions(driver);
	         act.moveToElement(hair).perform();

		 System.out.println("clicking");
		  List<WebElement> list=driver.findElements(By.xpath("//a[@class='js-nav-link-trigger js-track-sub-category-link ']"));
		  for(WebElement link:list) {
			  System.out.println(link.getText());
		  }
		 driver.close();
	}

}//class="js-nav-link-trigger js-track-sub-category-link "
//(//a[text()='HAARE & KOPFHAUT'])[2]
//class="menu__item menu__item--lvl-4 menu__item--category js-menu-item-category no-active"

//(//a[@href=\"/products/17976/best-sellers\"]/parent::li/following-sibling::li/child::a[@aria-label=\"HAIR & SCALP\"])[2]
////a[@class=\"js-nav-link-trigger js-track-sub-category-link \"]


//li[@class=\"menu__item menu__item--lvl-4 menu__item--category js-menu-item-category no-active\"]
