package testCase001;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import basePage.BasePage;
import new_car_insurance_input.New_car_input_page;
import testBase.TestBase;

public class NewTest extends BasePage{
	
	public NewTest(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}
	public WebDriver driver;
	/*
	 * @BeforeMethod 
	 * public void beforeMethod() throws Exception { openBrowser(); //
	 * prop = getprop(); //test = extent.startTest((this.getClass().getSimpleName()
	 * + " :: " + method.getName()),method.getName());
	 * //test.assignAuthor("Vijay Chetgiri");
	 * //test.assignCategory("SmokeReport--Prod"); }
	 */
	@Test
	public void verifyTPText() throws Exception {
		openBrowser();
		New_car_input_page car1 = new New_car_input_page();
		car1.selectRenewsec();
		Thread.sleep(5000);
		String verifyTPtext = car1.verifyTPText();
		System.out.println(verifyTPtext);
		Assert.assertEquals(verifyTPtext, "T.P. Only (1 Yr)");
		//test.log(LogStatus.INFO, "TP Text Verified successfully");
	}
	
	
	

}
