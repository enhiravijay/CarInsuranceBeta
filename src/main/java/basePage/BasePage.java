package basePage;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utility.Config;
import utility.Constant;
import utility.WebEventListener;

public class BasePage {

	public static WebDriver driver;
	public boolean bResult;
	public static Properties prop;
	// public Login login;
	public static Config con;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public BasePage() {
		// BasePage.driver = driver;
		bResult = true;
		Config con = new Config();
		BasePage.con = con;

	}

	public void printt() {
		System.out.println("base page driver is" + driver);
	}

	public static void handleDropDown(WebElement ele, String Value) throws Exception {
		Thread.sleep(5000);
		Select selectByVisibleText = new Select(ele);
		selectByVisibleText.selectByVisibleText(Value);
	}

	public static void selectDate() {

	}

	public static void waitHandle(WebDriver driver, WebElement ele, int timeout) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public boolean isElementDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isElementClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element.isEnabled();
		} catch (Exception e) {
			return false;
		}
	}

	public void waitForElementToBeGone(WebElement element, int timeout) {
		if (isElementDisplayed(element)) {
			new WebDriverWait(driver, timeout).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
		}
	}

	/*
	 * public void jsExecute(WebElement element) { waitHandle(driver, element, 20);
	 * // WebElement element=driver.findElement(By.xpath""); JavascriptExecutor ex =
	 * (JavascriptExecutor) driver; ex.executeScript("arguments[0].click()",
	 * element); }
	 */

	public String capture(String screenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = Constant.Path_ScreenShot;
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);

		return dest;
	}

	public static void handleWait(WebElement ele, WebDriver driver, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void sendText(WebElement ele, String value) {
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}

	public static String verifyElementTxt(WebElement ele) {
		String eleText = ele.getText();
		return eleText;
	}

	public WebDriver openBrowser() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		return driver;
	}

	public static Properties getprop() throws Exception {
		// con = new Config();
		prop = Config.loadPropertyFile();
		return prop;

	}
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}


	public void softverification(String Actual, String Expected, int iTestCaseRow) throws Exception {
		boolean bResult;
		if (Expected.equalsIgnoreCase(Actual)) {
			bResult = true;
			System.out.println("value are matching");
			System.out.println("act and expe match" + bResult);
			// ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);

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
				// ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
			}

			softassert.assertAll();

		}

	}
}
