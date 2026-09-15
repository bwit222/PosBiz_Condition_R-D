package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
	
	WebDriver driver;
	
	public ResetPasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  
	}
	
	@FindBy(xpath="//input[@id='login_id']")
	private WebElement emailfield;

	@FindBy(xpath="//button[normalize-space()='Reset password']")
	private WebElement resetpasswordbutton;
	
	@FindBy(xpath="//div[@class='cm-notification-content notification-content alert-error']")
	private WebElement errormessage;
	
	@FindBy(xpath="//div[@class='cm-notification-content notification-content cm-auto-hide alert-success']")
	private WebElement successmessage;
	
	public WebElement EmailField() {
		return emailfield;
	}
	
	public WebElement ResetPasswordButton() {
		return resetpasswordbutton;
	}
	
	public WebElement ErrorMessage() {
		return errormessage;
	}
	
	public WebElement SuccessMessage() {
		return successmessage;
	}
}
