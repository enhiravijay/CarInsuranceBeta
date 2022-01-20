package new_car_insurance_input;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testrough {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String Url = "http://qa.policyboss.com/car-insurance/buynow/2/ARN-SPUJN6L6-D6UW-CSXK-YUAJ-BVH2KFP634LS_1754948_97941/NonPOSP/640";
			driver.get(Url);
			Thread.sleep(200);
			 WebElement closepopup = driver.findElement(By.xpath("//div[@class='popupScreen']/div[@class='popupclose']"));
			 WebDriverWait waitc = new WebDriverWait(driver, 20);
			 waitc.until(ExpectedConditions.elementToBeClickable(closepopup));
			 closepopup.click();
			driver.findElement(By.xpath("//a[@id='TabPersonalInfo']")).click();
			Thread.sleep(200);
			WebElement ele = driver.findElement(By.xpath("//select[@id='Salutation']"));
			ele.click();
			Select sel = new Select(ele);
			sel.selectByVisibleText("Mr");
			WebElement ContactLastName = driver.findElement(By.xpath("//input[@id='ContactLastName']"));
			sendText(ContactLastName, "Kumar");
			driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			WebElement selYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			selYear.click();
			Select selYear1 = new Select(selYear);
			selYear1.selectByVisibleText("1982");
			WebElement selMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			selMonth.click();
			Select selMonth1 = new Select(selMonth);
			selMonth1.selectByVisibleText("Oct");
			//driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			Testrough.selectDay("10");
			 WebElement marStatus = driver.findElement(By.xpath("//select[@id='MaritalStatus']"));
			 marStatus.click();
			 Select marStatus1 = new Select(marStatus);
			 Thread.sleep(100);
			 marStatus1.selectByVisibleText("Married");
			dropDownHandle(marStatus,"Married");
			WebElement selOccupation = driver.findElement(By.xpath("//select[@id='ContactOccupationId']"));
			dropDownHandle(selOccupation,"Others");
			WebElement ContactMobile = driver.findElement(By.xpath("//input[@id='ContactMobile']"));
			sendText(ContactMobile, "9999988888");
			WebElement ContactEmail = driver.findElement(By.xpath("//input[@id='ContactEmail']"));
			sendText(ContactEmail, "policybosstesting@gmail.com");
			/*WebElement TabAddInfo = driver.findElement(By.xpath("//div/a[@id='TabAddInfo']"));
			TabAddInfo.click();
			WebElement CheckforToggle = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			WebElement RegisteredAddress = driver.findElement(By.xpath("//input[@id='RegisteredAddress']"));
			sendText(RegisteredAddress, "208 b,Bhartideep CHS");
			WebElement RegisteredAddress2 = driver.findElement(By.xpath("//input[@id='RegisteredAddress2']"));
			sendText(RegisteredAddress2, "Saibaba navghar road,bhayandar east");
			WebElement RegisteredAddress3 = driver.findElement(By.xpath("//input[@id='RegisteredAddress3']"));
			sendText(RegisteredAddress3, "Thana 401105");
			WebElement RegisteredPinCode = driver.findElement(By.xpath("//input[@id='RegisteredPinCode']"));
			sendText(RegisteredPinCode, "401105");
			Thread.sleep(60);
			WebElement RegisteredCityName = driver.findElement(By.xpath("//input[@id='RegisteredCityName']"));
			RegisteredCityName.click();
			WebElement ddlRegisteredCity = driver.findElement(By.xpath("//select[@id='ddlRegisteredCityId']"));
			ddlRegisteredCity.click();
			Select ddlRegisteredCity1 = new Select(ddlRegisteredCity);
			ddlRegisteredCity1.selectByIndex(1);*/
			WebElement TabVehicleAddInfo = driver.findElement(By.xpath("//div/a[@id='TabVehicleAddInfo']"));
			TabVehicleAddInfo.click();
			Thread.sleep(50);
			WebElement CheckforToggle1 = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle1.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			WebElement RegistrationNumberPart2 = driver.findElement(By.xpath("//input[@id='RegistrationNumberPart2']"));
			sendText(RegistrationNumberPart2, "EQ");
			WebElement RegistrationNumberPart3 = driver.findElement(By.xpath("//input[@id='RegistrationNumberPart3']"));
			sendText(RegistrationNumberPart3, "5648");
			WebElement EngineNumber = driver.findElement(By.xpath("//input[@id='EngineNumber']"));
			sendText(EngineNumber, "EN9967192191");
			WebElement ChasisNumber = driver.findElement(By.xpath("//input[@id='ChasisNumber']"));
			sendText(ChasisNumber, "CH99671234567");
			WebElement PolicyNumber = driver.findElement(By.xpath("//input[@id='PolicyNumber']"));
			sendText(PolicyNumber, "PL677991234567");
			WebElement VehicleColor = driver.findElement(By.xpath("//select[@id='VehicleColor']"));
			dropDownHandle(VehicleColor, "Black");
			String labelvalue = driver.findElement(By.xpath("//label[@id='IsFinancedYes']")).getAttribute("class");
			System.out.println("Value of a label is "+labelvalue);
			if(labelvalue.contains("btn-primary")) {
				WebElement FinancerAgreementType = driver.findElement(By.xpath("//select[@id='FinancerAgreementType']"));
				dropDownHandle(FinancerAgreementType, "Hypothecation");
				WebElement InstitutionName = driver.findElement(By.xpath("//input[@id='InstitutionName']"));
				waitHandle(driver, InstitutionName, 20);
				System.out.println("Entering Institution Name");
				InstitutionName.click();
				InstitutionName.clear();
				TypeInField(InstitutionName, "BAJAJ AUTO");
				Thread.sleep(300);
				handleAutoDropDown("BAJAJ AUTO");
			}
			//InstitutionName.sendKeys(Keys.BACK_SPACE);
			//Thread.sleep(10);
			//sendText(InstitutionName, "BAJAJ AUTO FINANC");
			//Thread.sleep(1000);
			//InstitutionName.sendKeys(Keys.TAB);
			//WebElement institutionoption = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li"));
			//InstitutionName.clear();
			//JavascriptExecutor executor = (JavascriptExecutor)driver;
			//executor.executeScript("document.getElementById('s').value='BAJAJ AUTO FINANC'");
			//((JavascriptExecutor)driver).executeAsyncScript("arguments[0].value='BAJAJ AUTO FINANC'",InstitutionName);
			//InstitutionName.sendKeys(Keys.BACK_SPACE);
			//InstitutionName.sendKeys(Keys.ENTER);
			//executor.executeScript("document.getElementById("textbox_id").value='new value';);
			//InstitutionName.sendKeys("BAJAJ AUTO FINANC");
			//InstitutionName.sendKeys(Keys.BACK_SPACE);
			
			//selectOptionWithText("BAJAJ AUTO FINANC");
			//WebElement autoCompleteOption = driver.findElement(By.xpath("//li[@class='ui-menu-item'][contains(text(),'BAJAJ AUTO FINANC')]"));
			//WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) autoCompleteOption));
			//autoCompleteOption.click();
			//handleAutoDropDown();
			Thread.sleep(3000);
			WebElement TabNomineeInfo = driver.findElement(By.xpath("//a[@id='TabNomineeInfo']"));
			TabNomineeInfo.click();
			WebElement CheckforToggle2 = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle2.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			WebElement NomineeRelationID = driver.findElement(By.xpath("//select[@id='NomineeRelationID']"));
			//NomineeRelationID.click();
			Select sel21 = new Select(NomineeRelationID);
			sel21.selectByVisibleText("Father");
			WebElement NomineeName = driver.findElement(By.xpath("//input[@id='NomineeName']"));
			sendText(NomineeName, "Test Nominee fname");
			driver.findElement(By.xpath("//input[@id='NomineeDOB']")).click();
			WebElement selYearn = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			selYearn.click();
			Select selYearnn = new Select(selYearn);
			selYearnn.selectByVisibleText("1971");
			WebElement selMonthn = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			selMonthn.click();
			Select selMonthnn = new Select(selMonthn);
			selMonthnn.selectByVisibleText("Oct");
			//driver.findElement(By.xpath("//input[@id='DOBofOwner']")).click();
			Testrough.selectDay("10");
			WebElement TabTermsConditions = driver.findElement(By.xpath("//div/a[@id='TabTermsConditions']"));
			TabTermsConditions.click();
			Thread.sleep(50);
			WebElement CheckforToggle4 = driver.findElement(By.xpath("//a[@aria-expanded='true']"));
			if(CheckforToggle4.getAttribute("aria-expanded").contains("false")) {
				WebElement ManField = driver.findElement(By.xpath("//div[@class='valerr']"));
				boolean manDis = ManField.isDisplayed();
				if(manDis==true) {
					System.out.println("Mandatory field's are not entered.");
				}
			}
			WebElement messageTextBox = driver.findElement(By.id("lbliagree"));
			Actions actions = new Actions(driver);
			actions.click(messageTextBox).build().perform();
			WebElement PaymentLink = driver.findElement(By.id("PaymentLink"));
			PaymentLink.click();
			
	}
	
	private static void selectDay(String dayValue) {
		WebElement dayelem=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		//WebElement dayelem=driver.findElement(By.xpath("//table[@class='table dtp-picker-days']/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		
		WebElement GetFirstRegDay = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
		int intcalday = Integer.parseInt(GetFirstRegDay.getText());
		System.out.println(intcalday);
		for (int i = 0; i <= 31; i++) {
			if (intcalday == Integer.parseInt(dayValue)) {
				System.out.println(intcalday + " mon value is equal to " + dayValue);
				dayelem.click();
				break;
			} else if(intcalday <= Integer.parseInt(dayValue)){
				intcalday++;
				//GetFirstRegPrevYearBtn.click();
			}
			System.out.println(intcalday);

		}
	}
	
	private static void dropDownHandle(WebElement ele,String value) {
		ele.click();
		Select sel = new Select(ele);
		sel.selectByVisibleText(value);
		}
	
	private static void sendText(WebElement ele,String value) {
		ele.click();
		ele.clear();
		ele.sendKeys(value);
	}
	
	public static void handleAutoDropDown(String Model) throws InterruptedException {
		//WebDriverWait wait =  new WebDriverWait(driver, 30);
		List<WebElement> autoOptions = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']"));
		//wait.until(ExpectedConditions.visibilityOf(autoOptions));
		//List<WebElement> opList = autoOptions.findElements(By.xpath("//li[@class='ui-menu-item']"));
		WebElement ele = driver.findElement(By.xpath("//li[@class='ui-menu-item'][contains(text(),'BAJAJ AUTO FINANCE LTD')]"));
		//WebDriverWait wait =  new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(ele));
		int opSize = autoOptions.size();
		 //Actions actions = new Actions(driver);
		System.out.println(opSize);
		for(int i = 0;i<opSize;i++) {
			if(opSize > 1) {
				System.out.println(autoOptions.get(i).isDisplayed());
				if(!autoOptions.get(i).isDisplayed()){
					System.out.println("autooption is not displayed first time");
					WebElement InstitutionName = driver.findElement(By.xpath("//input[@id='InstitutionName']"));
					InstitutionName.sendKeys(Keys.BACK_SPACE);
					}
				selectOptionWithText("BAJAJ AUTO FINANCE LTD");
				//JavascriptExecutor executor = (JavascriptExecutor)driver;
				//actions.sendKeys(Keys.ARROW_DOWN).build().perform();
				//actions.click();
				//executor.executeScript("arguments[0].click();", autoOptions.get(i));
				//System.out.println(autoOptions.get(i).getText());
				//System.out.println(autoOptions.get(i));
				//autoOptions.get(i).click();
				break;
			}else {
				System.out.println("autooption displayed hense came in else part one");
				System.out.println(autoOptions.get(i).isDisplayed());
				/*if(!autoOptions.get(i).isDisplayed()){
					WebElement InstitutionName = driver.findElement(By.xpath("//input[@id='InstitutionName']"));
					InstitutionName.sendKeys(Keys.BACK_SPACE);
					autoOptions.get(i).click();
				}*/
				selectOptionWithText("BAJAJ AUTO FINANCE LTD");
				Thread.sleep(2000);
				}
		}
	}
	
	public static void selectOptionWithText(String Model) {
		try {
/*			WebElement autoOptions = driver.findElement(By.xpath("//ul[@id='ui-id-1']"));
			WebDriverWait wait =  new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> optionsToSelect = autoOptions.findElements(By.xpath("//li[@class='ui-menu-item'][contains(text(),'" + textToSelect + "')]"));
			//List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }*/
			WebDriverWait wait =  new WebDriverWait(driver, 100);
			WebElement autoOptions = driver.findElement(By.xpath("//ul[@id='ui-id-1']/li"));
			System.out.println(autoOptions.getAttribute("id"));
			wait.until(ExpectedConditions.visibilityOf(autoOptions));
			List<WebElement> opList = autoOptions.findElements(By.xpath("//li[contains(text(),'" + Model + "')]"));
			
			int opSize = opList.size();
			for(int i = 0;i<opSize;i++) {
				if(opSize > 1) {
					System.out.println("auto option size is greater than one");
					if(opList.get(i).isDisplayed()){
						opList.get(i).click();
						break;
					}
					
				}else {
					System.out.println("auto option size is less than one");
					if(opList.get(i).isDisplayed()){
						System.out.println("trying to check oplist in selectOptionWithText if displayed");
						WebElement elex = opList.get(i);
						System.out.println(elex.getText());
						elex.click();
						break;
					}else {
						System.out.println("not displayed in selectOptionWithText if displayed");
						WebElement elex = opList.get(i);
						System.out.println(elex.getText());
						elex.click();
					}
					//WebElement InstitutionName = driver.findElement(By.xpath("//input[@id='InstitutionName']"));
					//InstitutionName.sendKeys(Keys.BACK_SPACE);
					//opList.get(i).click();
					}
			}
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public static void waitHandle(WebDriver driver,WebElement ele,int timeout) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		}
	
	public static void TypeInField(WebElement ele, String value) throws InterruptedException{
	    String val = value; 
	    ele.clear();

	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        ele.sendKeys(s);
	        Thread.sleep(300);
	    }       
	}

}
