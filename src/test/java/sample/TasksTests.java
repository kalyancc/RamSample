package sample;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TasksTests {

	@Test
	public void createCustomerTest() {
		System.out.println("********************************************************************************************8");
		Common lib = new Common();
		WebDriver dr = lib.OpenBrowser("Chrome");
		lib.Login(dr);
		lib.CreateNewCustomer(dr);
		///test
	}
	
}
