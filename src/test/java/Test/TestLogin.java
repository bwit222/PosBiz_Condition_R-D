package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.LoginPage;
import Resources.Base;

public class TestLogin extends Base {
	
	Logger log;
	public WebDriver driver; //Screenshot listener needs this driver to be public so that it can access it for taking screenshots on test failure
	
	@BeforeMethod
	public void openURL() throws IOException {
		log = LogManager.getLogger(TestLogin.class.getName());
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
	public void CorrectDetail() {
		log.info("========== Starting Login Test ==========");
				
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
			
			log.info("Entering Password: " + prop.getProperty("c_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if SuccessMessage() is displayed, otherwise fail
			boolean successVisible = loginPage.SuccessMessage().isDisplayed();
			Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test: " + e.getMessage(), e);
		}
	}
	
	@Test
	public void InvalidDetail() {
		log.info("========== Starting Login Test with Incorrect Details ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("invalidemail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("invalidemail"));
			
			log.info("Entering Password: " + prop.getProperty("w_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("w_password"));
			
			Thread.sleep(20000); // Wait for 20 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.ErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is displayed - login may have unexpectedly succeeded");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Incorrect Details: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Incorrect Details: " + e.getMessage(), e);
		}
	}
	
	@Test
	public void EmptyDetail() {
		log.info("========== Starting Login Test with Empty Details ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			//Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button without entering any details");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.BlankEmailErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is displayed - login may have unexpectedly succeeded");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Empty Details: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Empty Details: " + e.getMessage(), e);
		}
	}
	
	@Test
	public void ValidEmailInvalidPassword() {
		log.info("========== Starting Login Test with Valid Email and Invalid Password ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
			
			log.info("Entering Password: " + prop.getProperty("w_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("w_password"));
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.ErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is displayed - login may have unexpectedly succeeded");
			
			
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Valid Email and Invalid Password: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Valid Email and Invalid Password: " + e.getMessage(), e);
		} 		
	}
	
	@Test	
	public void InvalidEmail() {
		log.info("========== Starting Login Test with Invalid Email ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("invalidemail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("invalidemail"));
			
			log.info("Entering Password: " + prop.getProperty("w_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("w_password"));
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if ErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.ErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Error message is displayed - login may have unexpectedly succeeded");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Invalid Email: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Invalid Email: " + e.getMessage(), e);
		}
	}

	@Test	
	public void EmptyEmail() {
		log.info("========== Starting Login Test with Empty Email ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering Password: " + prop.getProperty("w_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("w_password"));
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if BlankEmailErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.BlankEmailErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Blank email error message is displayed - login may have unexpectedly succeeded");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Empty Email: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Empty Email: " + e.getMessage(), e);
		}
	}
	
	@Test	
	public void EmptyPassword() {
		log.info("========== Starting Login Test with Empty Password ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if BlankPasswordErrorMessage() is displayed, otherwise fail
			boolean errorVisible = loginPage.BlankPasswordErrorMessage().isDisplayed();
			Assert.assertTrue(errorVisible, "Blank password error message is displayed - login may have unexpectedly succeeded");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Empty Password: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Empty Password: " + e.getMessage(), e);
		}
	}

	@Test
	public void ValidEmailWithSpaces() {
		log.info("========== Starting Login Test with Valid Email and Spaces ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email with spaces: " + prop.getProperty("emailspace"));
			loginPage.UserEmail().sendKeys("   " + prop.getProperty("emailspace") + "   ");
			
			log.info("Entering Password: " + prop.getProperty("c_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if SuccessMessage() is displayed, otherwise fail
			boolean successVisible = loginPage.SuccessMessage().isDisplayed();
			Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Valid Email and Spaces: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Valid Email and Spaces: " + e.getMessage(), e);
		}
	}
	
	@Test
	public void RememberMe() {
		log.info("========== Starting Login Test with Remember Me functionality ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Entering User Email: " + prop.getProperty("useremail"));
			loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
			
			log.info("Entering Password: " + prop.getProperty("c_password"));
			loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
			
			log.info("Clicking on Remember Me Checkbox");
			loginPage.RememberMeCheckbox().click();
			
			Thread.sleep(20000); // Wait for 10 seconds to allow the page to process the input before clicking the button
			
			log.info("Clicking on Sign In Button");			
			loginPage.SignInButton().click();
			//Thread.sleep(5000); // Wait for 5 seconds to allow the login process to complete
			
			// ASSERT: test passes only if SuccessMessage() is displayed, otherwise fail
			boolean successVisible = loginPage.SuccessMessage().isDisplayed();
			Assert.assertTrue(successVisible, "Success message is displayed - login may have failed");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Remember Me functionality: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Remember Me functionality: " + e.getMessage(), e);
		}

	}
	
	@Test
	public void ForgotPasswordLink() {
		log.info("========== Starting Login Test with Forgot Password Link functionality ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Clicking on Forgot Password Link");
			loginPage.ForgotPasswordLink().click();
			
			// ASSERT: test passes only if the URL contains "reset-password", otherwise fail
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("auth.recover_password"), "Forgot Password link did not navigate to the expected page");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Forgot Password Link functionality: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Forgot Password Link functionality: " + e.getMessage(), e);
		}
	}
	
	@Test
	public void RegisterLink() {
		log.info("========== Starting Login Test with Register Link functionality ==========");
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Login Link");
			landingPage.LoginLink().click();
			
			log.info("Creating LoginPage object");
			LoginPage loginPage = new LoginPage(driver);
			
			log.info("Clicking on Register Link");
			loginPage.RegisterLink().click();
			
			// ASSERT: test passes only if the URL contains "register", otherwise fail
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains("profiles.add"), "Register link did not navigate to the expected page");
						
		} catch (Exception e) {
			log.error("Error occurred during Login Test with Register Link functionality: " + e.getMessage());
			// Make sure exception causes test failure
			Assert.fail("Exception during Login Test with Register Link functionality: " + e.getMessage(), e);
		}
	}
	
	

}





