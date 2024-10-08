package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass1;

public class InvoiceTest1 extends BaseClass1 {
	@Test(retryAnalyzer = com.comcast.crm.listennerutility.RetryListenerImp.class)
	   public void createInvoicetest() {
		   System.out.println("execute createInvoicetest");
		  
		  Assert.assertEquals("Home", "Home");
		  System.out.println("step-1");
		  System.out.println("step-2");
		  System.out.println("step-3");
		  System.out.println("step-4");
		  
	   }
}
