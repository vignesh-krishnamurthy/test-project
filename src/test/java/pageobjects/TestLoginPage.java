package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLoginPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/vignesh/Downloads/chromedriver-mac-x64 2/chromedriver");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		
		driver.get("https://portal.cleantasker.com/login");
		
		LoginPage test=new LoginPage(driver);
		test.loginpages("demo.admin", "Welcome123$");
		
		Thread.sleep(5000);
		HomePage hp= new HomePage(driver);
		hp.Clockin("Seven");
	}
}