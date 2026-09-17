package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.ContactUsFormPage;
import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.MyorderPage;
import PageObject.ResetPasswordPage;
import PageObject.SearchPage;
import Resources.Base;

public class DemoR_D extends Base {
	
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
	MyorderPage myorderpage;
	
		
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
		myorderpage = new MyorderPage(driver);
		
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
	      
    @Test
    public void testStep7_CheckoutPageValidation() throws InterruptedException {
log.info("========== STEP 1: CHECKOUT PAGE VALIDATION TEST STARTED ==========");



	landingpage.LoginLink().click();
	
	loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
	loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
	Thread.sleep(20000);
	loginPage.SignInButton().click();
	
	//Search for a Product===========================
	//landingpage.SearchField().sendKeys(prop.getProperty("skunumber"));
	//landingpage.SearchButton().click();
	
	/*  //Add Product to Cart===========================
	searchpage.AddToCartButton().click();
	Thread.sleep(5000);
	searchpage.ContinueShoppingButton().click();
	landingpage.CartLink().click();
	searchpage.ViewCartButton().click();
	
	//Checkout Page Verify===========================
	cartpage.ProceedToCheckoutButton().click();            */
	
	//Search value increase (Using For Loop)===========================================
	/*	for (int i = 201; i <= 205; i++) {

	    landingpage.SearchField().clear();
	    landingpage.SearchField().sendKeys(String.valueOf(i));
	
	    // If search happens by pressing Enter
	    landingpage.SearchField().sendKeys(Keys.ENTER);
	
	    //Thread.sleep(500);
	    
	    //searchpage.ProductFoundMessage().isDisplayed();
	    
	    if (searchpage.ProductFoundMessage().isDisplayed()) {
	        System.out.println(i + " Test PASS - Product found");
	    } else {
	        System.out.println(i + " Test FAIL - Product not found");
	    }
    }*/

	//URL increase (Using For Loop)===========================================		
	/*	for (int order_id = 74945; order_id <= 74948; order_id++) {
		
	
		driver.get("https://www.poscentral.biz/index.php?dispatch=orders.details&order_id=" + order_id);		
		
		if(myorderpage.CustomerInfoHeader().isDisplayed()) {
		
		System.out.println("Invoice List clicked for Order ID: " + order_id + " -- Pass ✔✔✔✔✔");
		myorderpage.InvoiceList().click();
		
		}else {
		
		System.out.println("Invoice List not found for Order ID: " + order_id + " -- Fail ❌❌❌❌❌");
	

			}				
		
		Thread.sleep(2000);
	
	}*/


	//URL increase (Using For Loop(With Exception Handling) - Working)===========================================
   	/* for(int order_id=74943; order_id<=74946; order_id++) {
	
		try {
		driver.get("https://www.poscentral.biz/index.php?dispatch=orders.details&order_id=" + order_id);
		
	    Thread.sleep(2000);	       
	    
		if(myorderpage.CustomerInfoHeader().isDisplayed()) {
			
			System.out.println("Invoice List clicked for Order ID: " + order_id + " -- Pass ✔✔✔✔✔");
			myorderpage.InvoiceList().click();
		}
		
		}catch (NoSuchElementException e) {
		
			System.out.println("Order not found for : " + order_id + " -- Fail ❌❌❌❌❌ ( Skipping this order.)");
	
			} catch (Exception e) {
			
			System.out.println("Order ID = " + order_id	+ " Error: " + e.getMessage()); 
			
			}
	
		}*/
		
			
  
  
  
  
  
	

    
  
  
  
    }
} 
  
