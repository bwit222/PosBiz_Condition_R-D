package Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import PageObject.ResetPasswordPage;
import Resources.Base;

public class TestResetPassword extends Base {
	
	Logger log;
	public WebDriver driver;
	
	@BeforeMethod
	public void openURL() throws Exception {
		log = LogManager.getLogger(TestResetPassword.class.getName());
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
	log.info("========== Ending Login Test ==========");
}

	@Test
	public void ValidResetEmail() {
		log.info("========== Starting Reset Password Test ==========");
		
		
		try {
			// Implement the test steps for Reset Password functionality here
			//log.info("Reset Password Test executed successfully");
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.debug("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.ForgotPasswordLink().click();
			
			log.info("Creating ResetPasswordPage object");
			ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			resetPasswordPage.EmailField().sendKeys(prop.getProperty("useremail"));
			
			Thread.sleep(20000); // Wait for 20 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Reset Button");	
			resetPasswordPage.ResetPasswordButton().click();
			
			// ASSERT: test passes only if SuccessMessage() is displayed, otherwise fail
			boolean successVisible = resetPasswordPage.SuccessMessage().isDisplayed();
			Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Reset Password Test: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Reset Password Test: " + e.getMessage(), e);
		}
	}
	
	@Test	
	public void InvalidResetEmail() {
		log.info("========== Starting Invalid Reset Password Test ==========");
		
		try {
			// Implement the test steps for Invalid Reset Password functionality here
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.debug("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			loginPage.ForgotPasswordLink().click();
			
			ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
			
			log.info("Entering Invalid User Email: " + prop.getProperty("invalidemail"));
			resetPasswordPage.EmailField().sendKeys(prop.getProperty("invalidemail"));
			
			Thread.sleep(20000); // Wait for 20 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Reset Button");	
			resetPasswordPage.ResetPasswordButton().click();
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = resetPasswordPage.ErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is displayed - invalid email may not have been handled correctly");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Invalid Reset Password Test: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Invalid Reset Password Test: " + e.getMessage(), e);
		}

	}
}
