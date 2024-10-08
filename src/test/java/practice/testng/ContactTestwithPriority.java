package practice.testng;

import org.testng.annotations.Test;

public class ContactTestwithPriority {
	
	@Test(priority=1)
	public void createContactTest() {
		System.out.println("execute createContactTest");
		
	}
    @Test(priority=2)
	public void modifyContactTest(){
		
		System.out.println("execute modifyContactTest");
		
	}
    @Test(priority=3)
    public void deleteContactTest() {
    	System.out.println("execute deleteContactTest");
    }
	
	
	
}
