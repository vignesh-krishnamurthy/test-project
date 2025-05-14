package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver driver;
	    
	    
	    @FindBy(name="username")
	    WebElement names;
	    
	    
	    @FindBy(name="password")
	    WebElement passwords;
	    
	    
	    @FindBy(xpath="//button[text()='Sign In']")
	    WebElement submit;
	    
	    
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	    
	    public void loginpages(String name, String password)
	    {
	    	names.sendKeys(name);
	    	passwords.sendKeys(password);
	    	submit.click();
}
	    
}
