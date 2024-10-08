package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass1;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for create contact
 * @author RAGHAVAMMA
 * 
 */

public class SearchContactTest extends BaseClass1 {
	/**
	 * Scenario:login()==> navigateContact==>createcontact()==verify
	 */
	@Test
	public void searchcontact() {
		/*step-1: login to app*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("url", "username", "password");
	}

}
