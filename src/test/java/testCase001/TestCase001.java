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
import com.relevantcodes.extentreports.LogStatus;

import basePage.BasePage;
import new_car_insurance_input.Login;
import new_car_insurance_input.New_car_input_page;
import utility.Constant;
import utility.Log;

//@Listeners(utility.TestNgListners.class)
public class TestCase001 extends BasePage {
	// public WebDriver driver;
	// public BasePage basepage;
	// public Properties prop;
	// public int iTestCaseRow = 1;
	// public int iTestCaseRow1 = 2;
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
	
	/*
	 * @BeforeTest public void beforeTest() throws Exception { openBrowser(); prop =
	 * getprop(); //EU = new ExcelUtils();
	 * //ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,
	 * "Sheet1"); //System.out.println("sssttttaaarrrttt"); //Login lg = new
	 * Login(driver); //lg.checkLogin(); }
	 */

	@BeforeMethod
	// public void beforeMethod(Method method) throws Exception {
	public void abeforeMethod(Method method) throws Exception {
		openBrowser();
		login = new Login();
		login.checkLogin(prop.getProperty("UserName1"),prop.getProperty("Password1"));
		// prop = getprop();
		 test = extent.startTest((this.getClass().getSimpleName() + " :: " + method.getName()),method.getName());
		 test.assignAuthor("Vijay Chetgiri");
		 test.assignCategory("SmokeReport--Prod");
	}

	/*
	 * @Test public void Test0001() throws Exception { New_car_input_page car = new
	 * New_car_input_page(driver); //Log.startLog(Class.forName(TestCase001));
	 * car.enterVehicleDetail(); test.log(LogStatus.INFO,
	 * "Vehicle details entered Successfully"); car.enterPolicyDetail();
	 * test.log(LogStatus.INFO, "Policy details entered Successfully");
	 * car.enterPsnlDetail(); test.log(LogStatus.INFO,
	 * "Psnl details entered Successfully"); QuotePage quote = new
	 * QuotePage(driver); quote.getCrn(); quote.getQuoteDetails();
	 * quote.getNoOfInsurers(); quote.getIdv(); quote.getPremium();
	 * quote.getDataMap(); Map<Integer, Map<Integer, List<String>>> abcmap =
	 * quote.getDataMap(); ExcelUtils.writeToExcel(abcmap); test.log(LogStatus.INFO,
	 * "Data written successfully in Excel"); //boolean vrcrn = quote.verifyCrn();
	 * System.out.println("insurer given is present or not "+quote.ifInsurerPresent(
	 * )); quote.buyInsurer(); ProposalPage pb = new ProposalPage(driver);
	 * pb.enterContact(); Assert.assertTrue(quote.verifyCrn());
	 * //Assert.assertTrue(false); }
	 */

	@Test
	public void verifyTPText() throws Exception {
		final Logger logger = Log.getLogData(Log.class.getName());
		New_car_input_page car1 = new New_car_input_page();
		car1.selectRenewsec();
		Thread.sleep(5000);
		String verifyTPtext = car1.verifyTPText();
		System.out.println(verifyTPtext);
		if(verifyTPtext.equalsIgnoreCase("T.P. Only (1 Yr)")) {
			Assert.assertEquals(verifyTPtext, "T.P. Only (1 Yr)");
			test.log(LogStatus.PASS, "TP Text Verified successfully");
			logger.info("TP Text test cassed Passed");
		}else {
			test.log(LogStatus.FAIL, "TP Text Verified Failed");
			logger.info("TP Text test cassed Failed");
		}
		
	}

	@Test
	public void verifyODText() throws Exception {
		final Logger logger = Log.getLogData(Log.class.getName());
		New_car_input_page car1 = new New_car_input_page();
		car1.selectRenewsec();
		String verifyODtext = car1.verifyODText();
		System.out.println(verifyODtext);
		//Assert.assertEquals(verifyODtext, "O.D. Only (1 Yr)");
		//test.log(LogStatus.INFO, "TP Text Verified successfully");
		if(verifyODtext.equalsIgnoreCase("O.D. Only (1 Yr)")) {
			Assert.assertEquals(verifyODtext, "O.D. Only (1 Yr)");
			test.log(LogStatus.PASS, "OD Only Text Verified successfully");
			logger.info("OD Only test cassed Passed");
		}else {
			test.log(LogStatus.FAIL, "OD Only Text Verified Failed");
			logger.info("OD Only test cassed Failed");
		}
		
	}

	@Test
	public void verifyComprehensiveText() {
		final Logger logger = Log.getLogData(Log.class.getName());
		New_car_input_page car1 = new New_car_input_page();
		car1.selectRenewsec();
		String verifyComptext = car1.verifyCompText();
		System.out.println(verifyComptext);
		//Assert.assertEquals(verifyComptext, "Comprehensive Plan (1 Yr)");
		//test.log(LogStatus.INFO, "Comp Text Verified successfully");
		if(verifyComptext.equalsIgnoreCase("Comprehensive Plan (1 Yr)")) {
			Assert.assertEquals(verifyComptext, "Comprehensive Plan (1 Yr)");
			test.log(LogStatus.PASS, "Comp Only Text Verified successfully");
			logger.info("Comprehensive test cassed passed");
		}else {
			test.log(LogStatus.FAIL, "Comp Only Text Verified Failed");
			logger.info("Comprehensive test cassed Failed");
		}
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

	/*
	 * @AfterTest public void afterTest() { driver.close(); }
	 */

	/*
	 * @AfterTest public void afterSuite() throws Exception { extent.flush();
	 * Thread.sleep(5000); extent.close(); }
	 */

}
