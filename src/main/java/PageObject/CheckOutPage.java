package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
	WebDriver driver;	
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}	
	
	@FindBy(xpath="//h1[normalize-space()='Checkout']")	
	private WebElement checkoutpagetitle;
	
	@FindBy(xpath="//a[normalize-space()='Add new address']")	
	private WebElement addnewaddresslink;
	
	@FindBy(css="#coupon_field")	
	private WebElement couponinputfield;
	
	@FindBy(xpath="//button[normalize-space()='Apply']")	
	private WebElement applycouponbutton;
	
	@FindBy(xpath="label[for='sh_0_13']")	
	private WebElement standardshipping;
	
	@FindBy(xpath="label[for='sh_0_6']")	
	private WebElement expressdelovery;
	
	@FindBy(css="#payments_14")
	private WebElement banktransfer;
	
	@FindBy(css="#payments_34")
	private WebElement creditcard;  
	
	@FindBy(xpath="//label[normalize-space()='Newsletter Subscribers']")
	private WebElement newslettersub;  
	
	@FindBy(xpath="//input[@type='checkbox' and starts-with(@id,'id_accept_terms')]")
	private WebElement termcondition;  
	//label[contains(text(),'Select this check box to accept the')]
	//label[contains(., 'Select this check box to accept the')]
	//input[@type='hidden' and @name='accept_terms']/following-sibling::input[@type='checkbox']
	//input[@type='checkbox' and starts-with(@id,'id_accept_terms')]
	
	
	@FindBy(css="##litecheckout_place_order")
	private WebElement placeorder; 
	
	
	//Payment Gateway========================iFrame================CardNumber=======
	@FindBy(css="iframe[title='Secure card number input frame']")
	private WebElement cardNumberFrame; 
	
	@FindBy(css="input[name='cardnumber']")
	private WebElement cardNumberinput; 
	
	//Payment Gateway========================iFrame================ExpiryDate=======
	@FindBy(css="iframe[title='Secure expiration date input frame']")
	private WebElement expiryDateFrame; 
	
	@FindBy(css="input[name='exp-date']")
	private WebElement expiryDateinput; 
	
	//Payment Gateway========================iFrame================CVV=======
	@FindBy(css="iframe[title='Secure CVC input frame']")
	private WebElement cvvFrame; 
	
	@FindBy(css="input[name='cvc']")
	private WebElement cvvinput; 
	
	@FindBy(css="#credit_card_name")
	private WebElement cardHolderName; 
	
	
	
	public WebElement PlaceOrder() {
		return placeorder;
	}
	
	public WebElement ExpiryDateFrame() {
		return expiryDateFrame;
	}
	public WebElement ExpiryDateInput() {
		return expiryDateinput;
	}
	public WebElement CvvFrame() {
		return cvvFrame;
	}
	public WebElement CvvInput() {
		return cvvinput;
	}
	public WebElement CardHolderName() {
		return cardHolderName;
	}
	
	public WebElement CardNumberFrame() {
		return cardNumberFrame;
	}
	
	public WebElement CardNumberInput() {
		return cardNumberinput;
	}	
	
	public WebElement CheckOutPageTitle() {
		return checkoutpagetitle;
	}
		
	public WebElement AddNewAddressLink() {
		return addnewaddresslink;
	}
	
	public WebElement CouponInputField() {
		return couponinputfield;
	}
	
	public WebElement ApplyCouponButton() {
		return applycouponbutton;
	}
	
	public WebElement StandardShipping() {
		return standardshipping;
	}
	
	public WebElement ExpressDelovery() {
		return expressdelovery;
	}
	
	public WebElement BankTransfer() {
		return banktransfer;
	}
	
	public WebElement CreditCard() {
		return creditcard;
	}
	
	public WebElement NewsLetterSub() {
		return newslettersub;
	}
	
	public WebElement TermCondition() {
		return termcondition;
	}
	
		
		

}
