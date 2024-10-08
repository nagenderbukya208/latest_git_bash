package practice.testng;

import org.testng.annotations.Test;

public class ContactTestwithDependOn {
	
	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest-->HDFC");
		
	}
    @Test(dependsOnMethods="createContactTest")
	public void modifyContactTest(){
		
		System.out.println("execute modifyContactTest-->HDFC->ICICI");
		
	}
    @Test(dependsOnMethods="modifyContactTest")
    public void deleteContactTest() {
    	System.out.println("execute deleteContactTest ICICI");
    }
	
	
	
}
