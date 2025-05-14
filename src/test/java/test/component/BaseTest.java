package test.component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
	
	public static WebDriver driver;
	
	public void inializeDriver() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("/Users/vignesh/eclipse-workspace/test-project/src/main/java/GlobalData/resources/GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/vignesh/Downloads/chromedriver-mac-x64 2/chromedriver");
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
			
		}
		
		driver.manage().window().maximize();
		
	}

}
