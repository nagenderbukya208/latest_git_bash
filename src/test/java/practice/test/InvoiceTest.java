package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.comcast.crm.baseutility.BaseClass1;
//@Listeners(com.comcast.crm.listennerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass1{
   @Test
   public void createInvoicetest() {
	   System.out.println("execute createInvoicetest");
	  String actTitle= driver.getTitle();
	  Assert.assertEquals(actTitle, "Login");
	  System.out.println("step-1");
	  System.out.println("step-2");
	  System.out.println("step-3");
	  System.out.println("step-4");
	  
   }
   @Test
   public void crateInvoicewithConatactTest() {
	   System.out.println("execute crateInvoicewithConatactTest");
	   System.out.println("step-1");
		  System.out.println("step-2");
		  System.out.println("step-3");
		  System.out.println("step-4");
   }
}
