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
	
	
	
	
	
	
	
	
	// Step 3: Wait for the matching option to appear
		//WebElement desiredOption = wait.until(ExpectedConditions.elementToBeClickable(
		//By.xpath("//div[contains(@class, 'select__option') and text()='" + clientName + "']")));
	    
	
	//Actions actions = new Actions(driver);
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(searchclient));
		//actions.moveToElement(element).click().perform();
		//element.click();
	
	
	
	//WebElement searchClientElement = wait.until(ExpectedConditions.elementToBeClickable(searchclientdrop));
	//Thread.sleep(500); // Add a short delay to wait for animation to complete
	//searchClientElement.click();

	
	
	//WebElement dropdownelement = wait.until(ExpectedConditions.visibilityOf(searchclientdrop));
	//wait.until(ExpectedConditions.elementToBeClickable(dropdownelement));
	//dropdownelement.click();
	
	//WebElement dropdownelement = wait.until(ExpectedConditions.elementToBeClickable(searchclientdrop));
	//actions.moveToElement(searchclientdrop).click().perform();
	//dropdownelement.click();
	
	//WebElement dropdownelement = wait.until(ExpectedConditions.elementToBeClickable(searchclientdrop));
	//((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownelement);

	//searchclientdrop.click();
	

	//WebElement dropdown = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(searchclient));
	
	
	}
}

