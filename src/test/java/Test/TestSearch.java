package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.SearchPage;
import Resources.Base;

public class TestSearch extends Base {

	Logger log;
	public WebDriver driver;
	
	@BeforeMethod
	public void openURL() throws IOException {
		log = LogManager.getLogger(TestSearch.class.getName());
		log.info("========== Starting Test Setup ==========");
		
		driver = intializeDriver();
		log.info("Browser got launched successfully");
		
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
	log.info("========== Ending search Test ==========");
}
	
	@Test
	public void ValidProductName() {
	    log.info("========== Starting Valid Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("validproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — valid product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a valid product");
	        log.info("========== Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Search Test: " + e.getMessage(), e);
	    }
	}

	@Test
	public void ExactProductName() {
	    log.info("========== Starting Exact Product Name Search Test ==========");
	    
	    	      
	    
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering exact product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("exactproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — exact product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for an exact product name");
	        log.info("========== Exact Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Exact Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Exact Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void SKUNumber() {
	    log.info("========== Starting SKU Number Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering SKU number in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("skunumber"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — product with SKU was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a valid SKU number");
	        log.info("========== SKU Number Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during SKU Number Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during SKU Number Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test
	public void PartialProductName() {
	    log.info("========== Starting Partial Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering partial product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("partialproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — partial product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a partial product name");
	        log.info("========== Partial Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Partial Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Partial Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void BrandName() {
	    log.info("========== Starting Brand Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering brand name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("brandname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — brand name was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a valid brand name");
	        log.info("========== Brand Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Brand Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Brand Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test
	public void LowerCaseProductName() {
	    log.info("========== Starting Lowercase Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering lowercase product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("lowercaseproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — lowercase product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a lowercase product name");
	        log.info("========== Lowercase Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Lowercase Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Lowercase Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void UpperCaseProductName() {
	    log.info("========== Starting Uppercase Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering uppercase product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("uppercaseproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — uppercase product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for an uppercase product name");
	        log.info("========== Uppercase Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Uppercase Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Uppercase Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void MixcaseProductName() {
	    log.info("========== Starting Mixcase Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering mixcase product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("mixcaseproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — mixcase product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a mixcase product name");
	        log.info("========== Mixcase Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Mixcase Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Mixcase Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void SpecialCharacterProductName() {
	    log.info("========== Starting Special Character Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering special character product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("specialcharacterproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — special character product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a special character product name");
	        log.info("========== Special Character Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Special Character Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Special Character Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test
	public void DiscontinuedProductName() {
	    log.info("========== Starting Discontinued Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering discontinued product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("discontinuedproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — discontinued product was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a discontinued product name");
	        log.info("========== Discontinued Product Name Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Discontinued Product Name Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Discontinued Product Name Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void DiscontinuedProductSku() {
	    log.info("========== Starting Discontinued Product SKU Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering discontinued product SKU in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("discontinuedproductsku"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
	        boolean productNotFoundVisible = false;
	        try {
	            productNotFoundVisible = searchPage.ProductNotFoundMessage().isDisplayed();
	            log.info("Product not found message is visible");
	        } catch (NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
	            // Element not found = product WAS found = this is EXPECTED for valid product
	            log.info("Product not found message is NOT visible — discontinued product SKU was found successfully");
	            productNotFoundVisible = false;
	        }
	        
	        // Test FAILS if "not found" message is visible (product search failed)
	        // Test PASSES if "not found" message is NOT visible (product search succeeded)
	        Assert.assertFalse(productNotFoundVisible, "Product NOT found message should not be visible for a discontinued product SKU");
	        log.info("========== Discontinued Product SKU Search Test Passed ==========");
	        
	    } catch (Exception e) {
	        log.error("Error occurred during Discontinued Product SKU Search Test: " + e.getMessage(), e);
	        Assert.fail("Exception during Discontinued Product SKU Search Test: " + e.getMessage(), e);
	    }
	}
	
	@Test	
	public void InvalidProductName() {
	    log.info("========== Starting Invalid Product Name Search Test ==========");
	    
	    try {
	        log.info("Creating LandingPage object");
	        LandingPage landingPage = new LandingPage(driver);
	        
	        log.info("Entering invalid product name in search field");
	        landingPage.SearchField().sendKeys(prop.getProperty("invalidproductname"));
	        
	        log.info("Clicking on Search Button");
	        landingPage.SearchButton().click();
	        
	        Thread.sleep(3000); // Wait for search results to load
	        
	        log.info("Creating SearchPage object");
	        SearchPage searchPage = new SearchPage(driver);
	        
			// ASSERT: test passes only if SuccessMessage() is displayed, otherwise fail
			boolean successVisible = searchPage.ProductNotFoundMessage().isDisplayed();
			Assert.assertTrue(successVisible, "Product not found message is displayed - Search may have failed");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test: " + e.getMessage(), e);
		}
	}
			

}

