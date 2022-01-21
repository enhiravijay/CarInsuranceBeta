package testBase;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import basePage.BasePage;
import new_car_insurance_input.Login;
import utility.Config;

public class TestBase {
	public WebDriver driver;
	Properties prop;
	BasePage basepage;
	Login login;
	
	

	public WebDriver openBrowser(String String, String UserName, String Password) throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		prop=utility.Config.loadPropertyFile();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		login=new Login();
		
		login.checkLogin(prop.getProperty("UserName1"),prop.getProperty("Password1"));
		return driver;
	}
	
	

	public Properties getprop() throws Exception {
		//Config con = new Config();
		prop = Config.loadPropertyFile();
		return prop;

	}

	public void softverification(String Actual, String Expected, int iTestCaseRow) throws Exception {
		boolean bResult;
		if (Expected.equalsIgnoreCase(Actual)) {
			bResult = true;
			System.out.println("value are matching");
			System.out.println("act and expe match" + bResult);
			//ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);

		} else {
			SoftAssert softassert = new SoftAssert();
			softassert.assertTrue(Expected.equals(Actual));
			System.out.println("this is actual" + " " + Actual);
			System.out.println("this is Expected" + Expected);
			System.out.println("first test");
			bResult = false;
			System.out.println(bResult);
			if (bResult == false) {
				System.out.println(bResult);
				//ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			}

			softassert.assertAll();

		}

	}

	/*public static String checkRunMode(int itestCaseRow) {
		return //ExcelUtils.getCellData(itestCaseRow, Constant.Col_RunMode);

	}*/
}
