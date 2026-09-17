package Test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;   // Data in excell sheet
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;      // Data in excell sheet

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

public class DemoR_D2 extends Base {
	
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

/*    //URL increase (Using For Loop(Exception Handle) - Working)===========================================	
    @Test
    public void OrderUrlChange() throws InterruptedException {
log.info("========== Order URL launched ==========");

	landingpage.LoginLink().click();
	
	loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
log.info("========== User Email Entered ==========");
	loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
log.info("========== User Password Entered ==========");
	Thread.sleep(20000);
	loginPage.SignInButton().click();
log.info("========== Login Button Clicked ==========");

    //URL increase (Using For Loop with Exception Handling)===========================================		
		for (int order_id = 74942; order_id <= 74948; order_id++) {
			try {
				driver.get("https://www.poscentral.biz/index.php?dispatch=orders.details&order_id=" + order_id);
				Thread.sleep(1000);

				if (myorderpage.CustomerInfoHeader().isDisplayed()) {
					System.out.println("Invoice List clicked for Order ID: " + order_id + " -- Pass ✔✔✔✔✔");
log.info(order_id + "========== order ID Pass==========");
					myorderpage.InvoiceList().click();
				}
			} catch (NoSuchElementException e) {
				System.out.println("Order not found for : " + order_id + " -- Fail ❌❌❌❌❌ ( Skipping this order.)");
log.info(order_id + "========== order ID Skipped==========");
			} catch (Exception e) {
				System.out.println("Order ID = " + order_id + " Error: " + e.getMessage());
			}
		}*/


//URL increase (Using For Loop reault in excell sheet- Working)===========================================	
    @Test
    public void OrderUrl_Condition() throws InterruptedException {
log.info("========== Order URL launched ==========");

	landingpage.LoginLink().click();
	
	loginPage.UserEmail().sendKeys(prop.getProperty("useremail"));
log.info("========== User Email Entered ==========");
	loginPage.UserPassword().sendKeys(prop.getProperty("c_password"));
log.info("========== User Password Entered ==========");
	Thread.sleep(20000);
	loginPage.SignInButton().click();
log.info("========== Login Button Clicked ==========");

    //URL increase (Using For Loop with Exception Handling)===========================================		
		// Excel Workbook & Sheet Setup
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Order Report");

		// Header Styling (Bold)
		CellStyle headerStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerStyle.setFont(headerFont);

		// Create Header Row
		Row headerRow = sheet.createRow(0);
		String[] headers = { "Order ID", "Status", "Message" };
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(headerStyle);
		}

		int rowNum = 1;

		for (int order_id = 74942; order_id <= 74950; order_id++) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(order_id);

			try {
				driver.get("https://www.poscentral.biz/index.php?dispatch=orders.details&order_id=" + order_id);
				log.info("========== Order ID Successfully incremented Order ID by +1. ==========");
				Thread.sleep(1000);

				if (myorderpage.CustomerInfoHeader().isDisplayed()) {
					System.out.println("Invoice List clicked for Order ID: " + order_id + " -- Pass ✔✔✔✔✔");
					log.info(order_id + "========== Order ID Pass==========");
					myorderpage.InvoiceList().click();
					log.info("========== InvoiceList Link Clicked Successfully==========");

					row.createCell(1).setCellValue("Pass");
					row.createCell(2).setCellValue("Invoice List clicked for Order ID: " + order_id + " -- Pass");
				}
			} catch (NoSuchElementException e) {
				System.out.println("Order not found for : " + order_id + " -- Fail ❌❌❌❌❌ ( Skipping this order.)");
				log.info(order_id + "========== Order ID Skipped==========");

				row.createCell(1).setCellValue("Fail");
				row.createCell(2).setCellValue("Order not found for : " + order_id + " -- Fail (Skipping this order.)");
			} catch (Exception e) {
				System.out.println("Order ID = " + order_id + " Error: " + e.getMessage());

				row.createCell(1).setCellValue("Error");
				row.createCell(2).setCellValue("Error: " + e.getMessage());
			}
		}

		// Adjust Column Widths
		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write to Excel file
		String excelFilePath = System.getProperty("user.dir") + "\\Order_Status_Report.xlsx";
		try (FileOutputStream fos = new FileOutputStream(excelFilePath)) {
			workbook.write(fos);
			System.out.println("Order status report written to Excel: " + excelFilePath);
			log.info("Order status report written to Excel: " + excelFilePath);
		} catch (IOException e) {
			log.error("Failed to write to Excel file: " + e.getMessage(), e);
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				log.error("Failed to close workbook: " + e.getMessage(), e);
			}
		}









    }
} 
  