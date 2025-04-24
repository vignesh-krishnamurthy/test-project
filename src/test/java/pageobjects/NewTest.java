package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class NewTest {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","/Users/vignesh/Downloads/chromedriver-mac-x64 2/chromedriver");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(ops);
		driver.get("https://portal.cleantasker.com/login");
	}
	
  @Test
  public void correctLogin() throws InterruptedException {
	  
		driver.findElement(By.name("username")).sendKeys("demo.admin");
		driver.findElement(By.name("password")).sendKeys("Welcome123$");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Thread.sleep(5000);
  }
  
  @Test
  public void wronglogin() throws InterruptedException
  {
	  driver.findElement(By.name("username")).sendKeys("wrong.user");
      driver.findElement(By.name("password")).sendKeys("wrongpass123");
      driver.findElement(By.xpath("//button[text()='Sign In']")).click();
      Thread.sleep(5000);
      String errorMsg= driver.findElement(By.xpath("//p[contains(text(),'Invalid login credentials')]")).getText();
      System.out.println("Error message: " + errorMsg);
      Assert.assertEquals(errorMsg, "Invalid login credentials");
  }
  
  @Test
 public void clockin() throws InterruptedException {
	  
	  Thread.sleep(5000);
	  
	  correctLogin();
	  
	  Thread.sleep(5000);
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement clockLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/clockin-report')]")));
	  clockLink.click();
	  
	  Thread.sleep(5000);
	  
	  WebElement activatedropdown = driver.findElement(By.cssSelector(".select__input-container"));
	  WebElement inputContainer = wait.until(ExpectedConditions.elementToBeClickable(activatedropdown));
	  inputContainer.click();
	  
	  Thread.sleep(5000);
	  
	  
	  WebElement inputelement = driver.findElement(By.cssSelector("input.select__input"));
	  inputelement.sendKeys("Seven");
	  
	  Thread.sleep(5000);
	  
	  inputelement.sendKeys(Keys.ENTER);
	  
	  Thread.sleep(5000);
	  
	  WebElement export = driver.findElement(By.id("radix-:re:"));
	  export.click();
	  
	  Thread.sleep(5000);
	  
	  WebElement summary = driver.findElement(By.xpath("//div[text()='Summary']"));
	  summary.click();
	  
	  Thread.sleep(5000);
	  
  }
  
  
  @AfterMethod
  public void closebrowser()
  {
	  driver.quit();
  }
}
