package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
	@Test(dataProvider="getData1")
	public void createContact(String firstname,String lastname,long phoneno) {
		System.out.println("Firstname:"+firstname+",Lastname:"+lastname+",PhoneNo:"+phoneno);
		
	}

	@DataProvider(name="getData1")
	public Object[][]getData1(){
		Object[][] data=new Object[3][3];
		data[0][0]="Deepak";
		data[0][1]="HR";
		data[0][2]="234567865l";
		
		data[1][0]="Sam";
		data[1][1]="HD";
		data[1][2]="234534865l";
		
		data[2][0]="Jhon";
		data[2][1]="MD";
		data[2][2]="234567995l";
		return data;
	}
	
}
