package pageobjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@FindBy(css = ".lucide.lucide-clock.min-h-5.min-w-5.h-5.w-5")
	WebElement clock;
	
	
	@FindBy(xpath = "//div[text()='Search Client']")
	WebElement searchclient;
	
	
	@FindBy(css = ".select__input-container")
	WebElement activatedropdown;
	
	@FindBy(css = "input.select__input")
	WebElement inputelement;
	
	
	@FindBy(id = "radix-:re:")
	WebElement export;
	
	@FindBy(xpath="//div[text()='Summary']")
	WebElement summary;

	public void Clockin(String clientName) throws InterruptedException {
		
	clock.click();
	
	
	Thread.sleep(5000);
	
	
	// Step 1: Click on the input container to activate the dropdown
	
	WebElement inputContainer = wait.until(ExpectedConditions.elementToBeClickable(activatedropdown));
	inputContainer.click();

	    // Step 2: Find the input element and type the client name
	WebElement inputField = inputelement;
	inputField.sendKeys(clientName);
	Thread.sleep(5000);

	    
	    // Step 4: Click on the matching option
	inputField.sendKeys(Keys.ENTER);
	
	
	export.click();
	
	
	summary.click();
	}
}

