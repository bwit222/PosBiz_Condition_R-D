package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ContactUsFormPage;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.ResetPasswordPage;
import PageObject.SearchPage;
import Resources.Base;

public class EndToEndPurchaseTest extends Base {
	
	Logger log;
	public WebDriver driver;
	
//Object Creation==================
	CartPage cartpage;
	ContactUsFormPage contactusformpage;
	LandingPage landingpage;
	LoginPage loginPage;
	ResetPasswordPage resetpasswordpage;
	SearchPage searchpage;
	CheckOutPage checkoutpage;
	
		
	@BeforeMethod
	public void openURL() throws IOException {
		log = LogManager.getLogger(TestCartPage.class.getName());
		log.info("========== Starting Test Setup ==========");
		
		driver = intializeDriver();
		log.info("Browser got launched successfully");
		
		cartpage = new CartPage(driver);
		contactusformpage = new ContactUsFormPage(driver);
		landingpage = new LandingPage(driver);
		loginPage = new LoginPage(driver);
		resetpasswordpage = new ResetPasswordPage(driver);
		searchpage = new SearchPage(driver);
		checkoutpage = new CheckOutPage(driver);
		
		driver.get(prop.getProperty("url"));
		log.info("Navigate to the application URL: " + prop.getProperty("url"));
		log.info("========== Test Setup Completed ==========");
	}
	
	@AfterMethod
	public void closer() {
		log.info("========== Starting Test Cleanup ==========");
		try {
			driver.close();
			log.info("Browser closed successfully");
		} catch (Exception e) {
			log.error("Error closing browser: " + e.getMessage(), e);
		}
		log.info("========== Ending Cart Page Test ==========");
	
}
	
//Test Start From Here===============	
	
	//@Test
	public void testStep1_ValidateHomepageLoading() {
log.info("========== STEP 1: HOMEPAGE VALIDATION TEST STARTED ==========");	
	try {	     	
		driver.get(prop.getProperty("url"));
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, "https://www.poscentral.biz/", "FAILED : Login page URL mismatch");
		     
	} catch (Exception e) {
		log.error("Error during homepage validation: " + e.getMessage(), e);		
		}
	}
	
	
	//@Test
    public void testStep2_UserLogin() {
log.info("========== STEP 2: USER LOGIN TEST STARTED ==========");
	try {
		landingpage.LoginLink().click();
		
		loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
		loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
		Thread.sleep(20000);
		loginPage.SignInButton().click();
		
		boolean successVisible = loginPage.SuccessMessage().isDisplayed();
		Assert.assertTrue(successVisible, "FAILED : Login success message not displayed");
	} catch (Exception e) {
		log.error("Error occurred during Login Test: " + e.getMessage());
		// Make sure exception causes test failure
		Assert.fail("Exception during Login Test: " + e.getMessage(), e);
		}
    }
	
	//@Test
    public void testStep3_SearchProduct() {
log.info("========== STEP 3: PRODUCT SEARCH TEST STARTED ==========");
	try {
		landingpage.LoginLink().click();
		
		loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
		loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
		Thread.sleep(20000);
		loginPage.SignInButton().click();
		
		//Search for a Product
		landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
		landingpage.SearchButton().click();
		
		boolean successVisible = searchpage.ProductFoundMessage().isDisplayed();
		Assert.assertTrue(successVisible, "FAILED : Product search success message not displayed");
		} catch(Exception e){
			log.error("Error occurred during Login Test: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			}
    }
	
	//@Test
    public void testStep4_AddProductToCart() {
log.info("========== STEP 4: ADD PRODUCT TO CART TEST STARTED ==========");
	try {
		landingpage.LoginLink().click();
		
		loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
		loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
		Thread.sleep(20000);
		loginPage.SignInButton().click();
		
		//Search for a Product
		landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
		landingpage.SearchButton().click();
		
		//Add Product to Cart
		searchpage.AddToCartButton().click();
		searchpage.ContinueShoppingButton().click();
	
	boolean successVisible = searchpage.ContinueShoppingButton().isDisplayed();
	Assert.assertTrue(successVisible, "FAILED : Product search success message not displayed");
	} catch(Exception e){
		log.error("Error occurred during Login Test: " + e.getMessage());
		// Make sure exception causes test failure
		Assert.fail("Exception during Login Test: " + e.getMessage(), e);
		}
}
   
	//@Test
    public void testStep5_ValidateCart() {
log.info("========== STEP 5: CART VALIDATION TEST STARTED ==========");
try {
	landingpage.LoginLink().click();
	
	loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
	loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
	Thread.sleep(20000);
	loginPage.SignInButton().click();
	
	//Search for a Product===========================
	landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
	landingpage.SearchButton().click();
	
	//Add Product to Cart===========================
	searchpage.AddToCartButton().click();
	searchpage.ContinueShoppingButton().click();
	landingpage.CartLink().click();
	searchpage.ViewCartButton().click();

	
	boolean successVisible = cartpage.CartPageTitle().isDisplayed();
	Assert.assertTrue(successVisible, "FAILED : Product search success message not displayed");
	} catch(Exception e){
		log.error("Error occurred during Login Test: " + e.getMessage());
		// Make sure exception causes test failure
		Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			}
}
    
    //@Test
    public void testStep6_QuantityAndPromoCode() {
log.info("========== STEP 6: QUANTITY AND PROMO CODE TEST STARTED ==========");
	try {
		landingpage.LoginLink().click();
		
		loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
		loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
		Thread.sleep(20000);
		loginPage.SignInButton().click();  
		
		//Search for a Product===========================
		landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
		landingpage.SearchButton().click();
		
		//Add Product to Cart===========================
		searchpage.AddToCartButton().click();
		searchpage.ContinueShoppingButton().click();
		landingpage.CartLink().click();
		searchpage.ViewCartButton().click();
			
		//Apply Coupon Code===========================
		cartpage.CouponField().sendKeys(prop.getProperty("promocode"));
		cartpage.ApplyCouponButton().click();
		Thread.sleep(5000);

		// Update Quantity click "+" icon multiple times (e.g., 4 times)
        int AddclickCount = 4; // change this to however many times you need
        for (int i = 0; i < AddclickCount; i++) {
        	cartpage.QuantityAddIcon().click();
            //Thread.sleep(1000); // small pause so the UI/cart total updates before next click
        }
        log.info("Quantity increased by " + AddclickCount + " using the '+' icon");
		Thread.sleep(2000);
        
		// Update Quantity click "-" icon multiple times (e.g., 3 times)
        int MinusclickCount = 3; // change this to however many times you need
        for (int i =0; i < MinusclickCount; i++) {
        	cartpage.QuantityMinusIcon().click();
            //Thread.sleep(1000); // small pause so the UI/cart total updates before next click
        }
        log.info("Quantity decreased by " + MinusclickCount + " using the '-' icon");
        

	boolean successVisible = cartpage.QuantityUpdateConfirmationMessage().isDisplayed();
	Assert.assertTrue(successVisible, "FAILED : Product search success message not displayed");
	} catch(Exception e){
		log.error("Error occurred during Login Test: " + e.getMessage());
		// Make sure exception causes test failure
		Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			}
}
        
    //@Test
    public void testStep7_CheckoutPageValidation() {
log.info("========== STEP 7: CHECKOUT PAGE VALIDATION TEST STARTED ==========");
try {
	landingpage.LoginLink().click();
	
	loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
	loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
	Thread.sleep(20000);
	loginPage.SignInButton().click();
	
	//Search for a Product===========================
	landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
	landingpage.SearchButton().click();
	
	//Add Product to Cart===========================
	searchpage.AddToCartButton().click();
	searchpage.ContinueShoppingButton().click();
	landingpage.CartLink().click();
	searchpage.ViewCartButton().click();
	
	//Checkout Page Verify===========================
	cartpage.ProceedToCheckoutButton().click();
	
	boolean successVisible = checkoutpage.CheckOutPageTitle().isDisplayed();
	Assert.assertTrue(successVisible, "FAILED : Product search success message not displayed");
	} catch(Exception e){
		log.error("Error occurred during Login Test: " + e.getMessage());
		// Make sure exception causes test failure
		Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			}

}
    
    @Test
	public void testStep8_PlaceOrderAndValidateConfirmation() {
log.info("========== STEP 8: PLACE ORDER AND ORDER CONFIRMATION TEST STARTED ==========");
		
try {
	landingpage.LoginLink().click();
	
	loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
	loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
	Thread.sleep(20000);
	loginPage.SignInButton().click();
	
	//Search for a Product===========================
	landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
	landingpage.SearchButton().click();
	
	//Add Product to Cart===========================
	searchpage.AddToCartButton().click();
	searchpage.ContinueShoppingButton().click();
	landingpage.CartLink().click();
	searchpage.ViewCartButton().click();
	
	//Checkout Page Verify===========================
	cartpage.ProceedToCheckoutButton().click();
	Thread.sleep(5000);
	
	//Payment Gateway================================	
	WebElement cardframe = checkoutpage.CardNumberFrame();
	
	driver.switchTo().frame(cardframe);
	checkoutpage.CardNumberInput().sendKeys(prop.getProperty("cardnumber"));
	driver.switchTo().defaultContent();
	log.info("========== Card Number Entered ==========");
	
	WebElement cvvframe = checkoutpage.CvvFrame();
	driver.switchTo().frame(cvvframe);
	checkoutpage.CvvInput().sendKeys(prop.getProperty("cvv"));
	driver.switchTo().defaultContent();
	log.info("========== CVV Entered ==========");
	
	WebElement expiryframe = checkoutpage.ExpiryDateFrame();
	driver.switchTo().frame(expiryframe);
	checkoutpage.ExpiryDateInput().sendKeys(prop.getProperty("expiry"));
	log.info("========== Expiry Number Entered ==========");
	driver.switchTo().defaultContent();
	
	checkoutpage.CardHolderName().sendKeys(prop.getProperty("cardholdername"));
	log.info("========== CardHolder Name Entered ==========");
	Thread.sleep(5000);
	
	//checkoutpage.NewsLetterSub().click();
	//log.info("========== Newsletter Checked ==========");
	
	//Select Term and Condition===========================
	checkoutpage.TermCondition().click();
	

	
	log.info("========== Term and Condition Checked ==========");
	Thread.sleep(5000);
	//Checkout Button Clicked================================
	checkoutpage.PlaceOrder().click();
	log.info("========== Order Placed ==========");
	

	
	
	
	
	boolean successVisible = checkoutpage.CheckOutPageTitle().isDisplayed();
	Assert.assertTrue(successVisible, "FAILED : Product search success message not displayed");
	} catch(Exception e){
		log.error("Error occurred during Login Test: " + e.getMessage());
		// Make sure exception causes test failure
		Assert.fail("Exception during Login Test: " + e.getMessage(), e);
			}

}
	



    
    }
    
    
    
    
  
