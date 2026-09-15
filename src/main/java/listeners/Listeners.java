package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {
	
	WebDriver driver = null;
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
//===================	
/*		String testName = result.getName();		
		extentTest = extentReport.createTest(testName);
		extentTestThread.set(extentTest);  // Store the ExtentTest object in ThreadLocal for thread safety
*/
//===================	
	    String testName = result.getName();
	    String className = result.getTestClass().getRealClass().getSimpleName();
	   // String methodName = result.getMethod().getMethodName();
	    
	    // Create test with class name and method name
	    String testDescription = className + " :: " + testName;
	    extentTest = extentReport.createTest(testDescription);   
	    extentTestThread.set(extentTest);
	}
		

	@Override
	public void onTestSuccess(ITestResult result) {
		
		WebDriver driver = null;
		
		String testName = result.getName();
		
		extentTestThread.get().log(Status.PASS,testName+" Got Passed");  // Use ThreadLocal to get the correct ExtentTest object for the current thread
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String screenshotFilePath = takeScreenshot(testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);  // Screenshot added to the report
		} catch (Exception e) {
			e.printStackTrace();
		}

//==========================	
// For successful tests, we can log the success in the report. If you want to take a screenshot for successful tests as well, you can uncomment the above code.
/*		String testName = result.getName();
		
		//extentTest.log(Status.PASS,testName+" Got Passed");
		extentTestThread.get().log(Status.PASS,testName+" Got Passed");  // Use ThreadLocal to get the correct ExtentTest object for the current thread
	*/	
//========================== 
	}
				
	@Override
	public void onTestFailure(ITestResult result) {
			
		String testMethodName = result.getName();
		
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());  // Use ThreadLocal to get the correct ExtentTest object for the current thread
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			String screenshotFilePath = takeScreenshot(testMethodName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName);  // Screenshot added to the report
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();  //Important to flush the report after all tests are done, otherwise the report will not be generated properly.
	}
		

}
