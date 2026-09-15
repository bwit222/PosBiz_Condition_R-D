package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObject.ContactUsFormPage;
import PageObject.LandingPage;
import Resources.Base;

public class TestContactUsForm extends Base {

	Logger log;
	public WebDriver driver;
	
	@Test
	public void TestcontactUsForm() throws Exception {
		log.info("========== Starting Contact Us Form Test ==========");
		


	
	
		
		try {
			log.info("Creating LandingPage object");
			LandingPage landingPage = new LandingPage(driver);
			
			log.info("Clicking on Contact Us Link");
			landingPage.ContactUsLink().click();
			log.info("Contact Us Link clicked successfully");

			log.info("Creating ContactUsForm object");
			ContactUsFormPage contactUsForm = new ContactUsFormPage(driver);
			
			log.debug("Entering First Name: " + prop.getProperty("contactfirstname"));
			contactUsForm.FirstName().sendKeys(prop.getProperty("contactfirstname"));
			
			log.debug("Entering Last Name: " + prop.getProperty("contactlastname"));
			contactUsForm.LastName().sendKeys(prop.getProperty("contactlastname"));
			
			log.debug("Entering Company Name: " + prop.getProperty("contactcompanyname"));
			contactUsForm.CompanyName().sendKeys(prop.getProperty("contactcompanyname"));
			
			log.debug("Entering Email: " + prop.getProperty("contactemail"));
			contactUsForm.Email().sendKeys(prop.getProperty("contactemail"));
			
			log.debug("Entering Phone: " + prop.getProperty("contactphone"));
			contactUsForm.Phone().sendKeys(prop.getProperty("contactphone"));
			
			log.debug("Entering Subject: " + prop.getProperty("contactsubject"));
			contactUsForm.Subject().sendKeys(prop.getProperty("contactsubject"));
			
			log.debug("Entering Message: " + prop.getProperty("contactmessage"));
			contactUsForm.Message().sendKeys(prop.getProperty("contactmessage"));

			
			log.debug("Clicking on Submit Button");
			//contactUsForm.SubmitButton().click();
			
			log.info("All Contact Us form fields filled successfully");
			
			Thread.sleep(2000);
			log.info("========== Contact Us Form Test Completed Successfully ==========");
		} catch (Exception e) {
			log.error("Error occurred during Contact Us Form Test: " + e.getMessage(), e);
			throw e;
		}
	}
		
	@BeforeMethod
	public void openURL() throws IOException {
		log = LogManager.getLogger(TestContactUsForm.class.getName());
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
		log.info("========== Test Cleanup Completed ==========");
	}

}
