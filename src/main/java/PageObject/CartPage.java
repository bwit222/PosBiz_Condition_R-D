package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}	
	
	@FindBy(css="div[class='buttons-container ty-cart-content__top-buttons clearfix'] a[class='ty-btn ty-btn__primary ']")	
	private WebElement proceedtocheckoutbutton;	
	
	@FindBy(css="div[class='buttons-container ty-cart-content__bottom-buttons clearfix'] a[class='ty-btn ty-btn__secondary ']")	
	private WebElement continueshoppingbutton;	
	
	@FindBy(id="coupon_field")
	private WebElement couponinputfield;
	
	@FindBy(css="button[title='Apply']")
	private WebElement applycouponbutton;

	@FindBy(xpath="//a[normalize-space()='Clear cart']")
	private WebElement clearcartbutton;
	
	@FindBy(xpath="//div[@class='cm-notification-content notification-content alert alert-success cm-auto-hide']")
	private WebElement quantityupdateconfirmationmessage;
	
	@FindBy(xpath="//tbody/tr[1]/td[2]/a[2]/span[1]")
	private WebElement deleteproducticon;
	
	@FindBy(xpath="//h1[normalize-space()='Cart contents']")
	private WebElement cartpagetitle;
	
	@FindBy(xpath="//a[normalize-space()='+']")
	private WebElement quantityaddicon;
	
	@FindBy(xpath="//a[contains(text(),'−')]")
	private WebElement quantityminusicon;
	
	
	
	
	public WebElement QuantityAddIcon() {
		return quantityaddicon;
	}
	
	public WebElement QuantityMinusIcon() {
		return quantityminusicon;
	}
	
	public WebElement ProceedToCheckoutButton() {
		return proceedtocheckoutbutton;
	}
	
	public WebElement ContinueShoppingButton() {
		return continueshoppingbutton;
	}
	
	public WebElement CouponField() {
		return couponinputfield;
	}
	
	public WebElement ApplyCouponButton() {
		return applycouponbutton;
	}
	
	public WebElement ClearCartButton() {
		return clearcartbutton;
	}
	
	public WebElement QuantityUpdateConfirmationMessage() {
		return quantityupdateconfirmationmessage;
	}
	
	public WebElement DeleteProductIcon() {
		return deleteproducticon;
	}
	
	public WebElement CartPageTitle() {
		return cartpagetitle;
	}
	
		
	
}
