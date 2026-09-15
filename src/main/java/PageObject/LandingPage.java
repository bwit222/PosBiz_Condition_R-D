package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='Contact Us']")
	private WebElement contactuslink;
	
	@FindBy(xpath="//a[@href='https://www.poscentral.biz/index.php?dispatch=auth.login_form']")
	private WebElement loginlink;
	
	@FindBy(id="search_input25037")
	private WebElement searchfield;
	
	@FindBy(xpath="//div[contains(@class,'text-right')]//button[contains(@title,'Search')]")
	private WebElement searchbutton;
	
	@FindBy(css="div[id='sw_dropdown_25026'] a")
	private WebElement cartlink;
	
	
	public WebElement CartLink() {
		return cartlink;
	}	
	
	public WebElement ContactUsLink() {
		return contactuslink;
	}
	
	public WebElement LoginLink() {
		return loginlink;
	}
	
	public WebElement SearchField() {
		return searchfield;
	}
	
	public WebElement SearchButton() {
		return searchbutton;
	}

}
