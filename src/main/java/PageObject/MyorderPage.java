package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyorderPage {
	
	WebDriver driver;	
	
	public MyorderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//h3[normalize-space()='Customer information']")	
	private WebElement customerinfoheader;	
	
	@FindBy(xpath="//a[normalize-space()='Invoice List']")	
	private WebElement invoicelist;	
	
	
	public WebElement CustomerInfoHeader() {
		return customerinfoheader;
	}
	
	public WebElement InvoiceList() {
		return invoicelist;
	}
	

}
