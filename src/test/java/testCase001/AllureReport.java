package testCase001;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import basePage.BasePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import new_car_insurance_input.Login;
//import new_car_insurance_input.New_car_input_page;
import utility.Constant;
import utility.Log;

public class AllureReport extends BasePage {
	public int iTestCaseRow3 = 3;
	public static ExtentReports extent;
	public static ExtentTest test;
	Login login;

	@BeforeSuite
	public void beforeSuite() {// extent = new
								// ExtentReports("C:\\Users\\shree\\Downloads\\PolicybossCar\\test-output\\MyExtentReport.html",true);
		extent = new ExtentReports(Constant.Path_ExtentReport, true);
		extent.loadConfig(new File(Constant.Path_ExtentReport_Config));
		
	}
	
	

	@BeforeMethod
	public void abeforeMethod(Method method) throws Exception {
		openBrowser();
		login = new Login();
		login.checkLogin(prop.getProperty("UserName1"),prop.getProperty("Password1"));
		// prop = getprop();
		 test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),method.getName());
		 test.assignAuthor("Vijay Chetgiri");
		 test.assignCategory("SmokeReport--Prod");
	}

	
	@Test(priority = 1, description = "verifying login page title test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void verifyLogintext() throws Exception {
		final Logger logger = Log.getLogData(Log.class.getName());
		String loginName = login.verifyLoginSuccess();
		Assert.assertEquals(loginName, "Sarah Shaikh");
		logger.info("login is successfull");
	}

	@Test(priority = 2, description = "verifying login page title test")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case Description: Verify login page title test on Login Page")
	@Story("Story Name: To check login page title")
	public void verifyLogintextfail() throws Exception {
		final Logger logger = Log.getLogData(Log.class.getName());
		String loginName = login.verifyLoginSuccess();
		Assert.assertEquals(loginName, "Sarah Shaikh no");
		logger.info("login is Failed");
	}

	

	@AfterMethod // AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result) {
		// using ITestResult.FAILURE is equals to result.getStatus then it enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				// Call method to capture screenshot
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				String failureImageFileName = result.getMethod().getMethodName()
						+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
				File failureImageFile = new File(
						System.getProperty("user.dir") + "\\screenshots\\" + failureImageFileName);
				// Copy files to specific location
				// result.getName() will return name of test case so that screenshot name will
				// be same as test case name
				FileUtils.copyFile(src, failureImageFile);
				System.out.println("Successfully captured a screenshot");
				driver.close();
				extent.endTest(test);
				extent.flush();
			} catch (Exception e) {
				System.out.println("Exception while taking screenshot " + e.getMessage());
			}
		} else {
			driver.close();
			extent.endTest(test);
			extent.flush();
		}
	}

	

}
