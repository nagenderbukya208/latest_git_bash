package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test {
	
	@Test(dataProvider = "getData")
	public void CreateContact(String firstName,String lastName) {
		System.out.println("FirstName:"+firstName+",LastName:"+lastName);
		
	}
	
@DataProvider
public Object[][] getData(){
	Object[][] data =new Object[3][2];
	data[0][0]="Deepak";
	data[0][1]="HR";
	
	data[1][0]="Sam";
	data[1][1]="HD";
	
	data[2][0]="Jhon";
	data[2][1]="MD";
	return data;
	
}
}
