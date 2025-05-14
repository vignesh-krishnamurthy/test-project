package pageobjects;
import java.io.IOException;

import test.component.BaseTest;
public class TestLoginPage extends BaseTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		BaseTest c= new BaseTest();
		c.inializeDriver();
		
		driver.get("https://portal.cleantasker.com/login");
		
		LoginPage test=new LoginPage(driver);
		test.loginpages("demo.admin", "Welcome123$");
		
		Thread.sleep(5000);
		HomePage hp= new HomePage(driver);
		hp.Clockin("Seven");
	}
}