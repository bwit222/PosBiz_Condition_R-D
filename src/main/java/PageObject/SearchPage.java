package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(text(),'No products found matching the search criteria')]")
	private WebElement productnotfoundmessage;
	
	@FindBy(id="products_search_total_found_19")	
	private WebElement productfoundmessage;	
	
	@FindBy(xpath="//button[@id='button_cart_54778']")
	private WebElement addtocartbutton;
	
	@FindBy(xpath="//a[normalize-space()='Continue shopping']")
	private WebElement continueshoppingbutton;
	
	@FindBy(css="div[id='dropdown_25026'] a[class='ty-btn ty-btn__secondary']")
	private WebElement viewcartbutton;
	
	@FindBy(xpath="//div[@class='ty-product-list__item-name']")
	private WebElement productnamelink;
	
	
	
	public WebElement ProductNameLink() {
		return productnamelink;
	}
	
	public WebElement ContinueShoppingButton() {
		return continueshoppingbutton;
	}
	
	public WebElement ViewCartButton() {
		return viewcartbutton;
	}
		
	public WebElement AddToCartButton() {
		return addtocartbutton;
	}
	
	public WebElement ProductNotFoundMessage() {
		return productnotfoundmessage;
	}
	
	public WebElement ProductFoundMessage() {
		return productfoundmessage;
	}	
	
	
}
