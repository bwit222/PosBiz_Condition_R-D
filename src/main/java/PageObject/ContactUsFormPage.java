package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsFormPage {
	
	WebDriver driver;
	
	public ContactUsFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="elm_2")
	private WebElement firstname;
	
	@FindBy(id="elm_3")
	private WebElement lastname;
	
	@FindBy(id="elm_29")
	private WebElement companyname;
	
	@FindBy(id="elm_4")
	private WebElement email;
	
	@FindBy(id="elm_13")
	private WebElement phone;
	
	@FindBy(id="elm_318")
	private WebElement subject;
	
	@FindBy(id="elm_7")
	private WebElement message;
	
	@FindBy(name="dispatch[pages.send_form]")
	private WebElement submitbutton;
	
	
	public WebElement FirstName() {
		return firstname;
	}
	
	public WebElement LastName() {
		return lastname;
	}
	
	public WebElement CompanyName() {
		return companyname;
	}
	
	public WebElement Email() {
		return email;
	}
	
	public WebElement Phone() {
		return phone;
	}
	
	public WebElement Subject() {
		return subject;
	}
	
	public WebElement Message() {
		return message;
	}
	
	public WebElement SubmitButton() {
		return submitbutton;
	}
	
}
