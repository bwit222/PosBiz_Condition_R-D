package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login_main_login")
	private WebElement useremail;
	
	@FindBy(id="psw_main_login")
	private WebElement password;
	
	@FindBy(css="form[name='main_login_form'] div[class='ty-float-right'] button[name='dispatch[auth.login]']")
	private WebElement signinnbutton;

	@FindBy(linkText="Forgot your password?")
	private WebElement forgotpasswordlink;
	
	@FindBy(xpath="//label[@for='remember_me_main_login']")
	private WebElement remembermecheckbox;
	
	@FindBy(linkText="Register for a new account")
	private WebElement registerlink;
	
	@FindBy(xpath="//div[@class='cm-notification-content notification-content cm-auto-hide alert-success']")
	private WebElement successmessage;
	
	@FindBy(xpath="//button[normalize-space()='×']")
	private WebElement successmessageclosebutton;
	
	@FindBy(xpath="//div[@class='cm-notification-content notification-content alert-error']")
	private WebElement errormessage;
	
	@FindBy(xpath="//button[normalize-space()='×']")
	private WebElement errormessageclosebutton;
	
	@FindBy(xpath="//span[@id='login_main_login_error_message']//p[contains(text(),'The')]")	
	private WebElement blankemailerrormessage;
	
	@FindBy(xpath="//span[@id='psw_main_login_error_message']//p[contains(text(),'The')]")
	private WebElement blankpassworderrormessage;
	
	
	
	public WebElement UserEmail() {
		return useremail;
	}
	
	public WebElement UserPassword() {
		return password;
	}
	
	public WebElement SignInButton() {
		return signinnbutton;
	}
	
	public WebElement ForgotPasswordLink() {
		return forgotpasswordlink;
	}
	
	public WebElement RememberMeCheckbox() {
		return remembermecheckbox;
	}
	
	public WebElement RegisterLink() {
		return registerlink;
	}
	
	public WebElement SuccessMessage() {
		return successmessage;
	}
	
	public WebElement SuccessMessageCloseButton() {
		return successmessageclosebutton;
	}
	
	public WebElement ErrorMessage() {
		return errormessage;
	}
	
	public WebElement ErrorMessageCloseButton() {
		return errormessageclosebutton;
	}
	
	public WebElement BlankEmailErrorMessage() {
		return blankemailerrormessage;
	}
	
	public WebElement BlankPasswordErrorMessage() {
		return blankpassworderrormessage;
	}
}
