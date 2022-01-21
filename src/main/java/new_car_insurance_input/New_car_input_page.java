package new_car_insurance_input;

import static org.testng.Assert.assertTrue;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;
import utility.ExcelUtils;
import utility.Log;

public class New_car_input_page extends BasePage {

	

	@FindBy(xpath = "//div[@class='addquot_div']/div/span")
	WebElement AddQuote;
	
	@FindBy(xpath = "//a[@id='renewSection']")
	WebElement RenewSection;
	
	@FindBy(xpath = "//button[@id='lblTP']")
	WebElement btnTPOnly;
	
	@FindBy(xpath = "//button[@id='lblOD']")
	WebElement btnODOnly;
	
	@FindBy(xpath = "//button[@id='lblComp']")
	WebElement btnComprehensive;

	@FindBy(xpath = "//input[@id='MakeModel']")
	WebElement MakeMyModel;

	@FindBy(xpath = "//select[@id='FuelType']")
	WebElement SelectFuelType;

	@FindBy(xpath = "//select[@id='VariantID']")
	WebElement SelectVariant;

	@FindBy(xpath = "//div/input[@id='DOPCRenew']")
	WebElement SelectFirstRegistrationDate;

	@FindBy(xpath = "//div[@class='dtp']/div[1]/div/div/div[3]/div[2][@class='dtp-actual-year p80']")
	WebElement GetFirstRegYearText;

	@FindBy(xpath = "//div[@class='dtp-date']/div/div[3]/a[@class='dtp-select-year-after']")
	WebElement GetFirstRegNextYearBtn;

	@FindBy(xpath = "//div[@class='dtp-date']/div/div[1]/a[@class='dtp-select-year-before']")
	WebElement GetFirstRegPrevYearBtn;

	@FindBy(xpath = "//div[@class='dtp']/div[1]/div[1]/div[3]/div/table/tbody/tr/td/a")
	WebElement GetFirstRegDay;

	@FindBy(xpath = "//div[@class='dtp']//div[2]/button[@class='dtp-btn-ok btn btn-flat btn-sm'][1]")
	WebElement ClickfirstRegOK;

	@FindBy(xpath = "//input[@id='CityofRegitration']")
	WebElement PlaceOfRegistration;

	@FindBy(xpath = "//input[@id='ManufactureDate']")
	WebElement SelectMonthOfManf;
	
	@FindBy(xpath = "//button[@id='BtnYes']")
	WebElement IsVehFinancedYes;
	
	@FindBy(xpath = "//button[@id='BtnNo']")
	WebElement IsVehFinancedNo;
	
	@FindBy(xpath = "//input[@id='oslc_si']")
	WebElement FinanceAmt;

	@FindBy(xpath = "//div[@class='dtp']/div/div/div/div/div[@class='dtp-actual-month p80']")
	WebElement GetRegMonthText;
	
	@FindBy(xpath = "//div[@class='dtp']/div/div/div/div/div[@class='dtp-actual-month p80']")
	WebElement GetpolicyexpiryMonthText;
	
	@FindBy(xpath = "//div[@class='dtp']/div/div/div/div/div[3]/a[@class='dtp-select-month-after']")
	WebElement CLickNextMonth;
	
	@FindBy(xpath = "//div[@class='dtp']/div/div/div/div/div[1]/a[@class='dtp-select-month-before']")
	WebElement CLickPreMonth;
	
	@FindBy(xpath = "//div[@class='dtp-date']/div/div[2][@class='dtp-actual-year p80']")
	WebElement GetManfYearText;

	@FindBy(xpath = "//div[@class='dtp-date']/div/div[3]/a[@class='dtp-select-year-after']")
	WebElement CLickNextManfYear;

	@FindBy(xpath = "//a[@class='btn btn-primary btn-xl page-scroll next']")
	WebElement NextButton;

	@FindBy(xpath = "//*[@id='PolicyExpiryDate']")
	WebElement SelectPolicyExpiryField;

	@FindBy(xpath = "//*[@class='dtp']/div/div[1]/div[1]/div[1]/div[2]")
	WebElement GetExpMonthText;

	@FindBy(xpath = "//*[@class='dtp']/div/div[1]/div[3]/div[1]/table/tbody/tr/td")
	WebElement GetExpMonthCells;

	@FindBy(xpath = "//*[@class='dtp']/div/div[2]/button[4]")
	WebElement NCBOkbtn;

	@FindBy(xpath = "//div/select[@id='PreviousInsurer']")
	WebElement SelectPreviousInsurer;

	@FindBy(xpath = "//*[@id='lblHaveNCBCertificate-No']")
	WebElement SelectClaimOnLastYearPolicyNo;

	@FindBy(xpath = "//*[@id='lblHaveNCBCertificate-Yes']")
	WebElement SelectClaimOnLastYearPolicyYes;

	@FindBy(xpath = "//*[@class='btn btn-primary btn-xl page-scroll next1']")
	WebElement SelectNextButtonNCB;

	@FindBy(xpath = "//*[@id='ContactName']")
	WebElement EnterFullName;

	@FindBy(xpath = "//*[@id='ContactMobile']")
	WebElement EnterMobile;

	@FindBy(xpath = "//*[@id='btnCompareQuote']")
	WebElement CalculateQuoteBTN;
	
	@FindBy(xpath = "//*[@id='lblPolicyExist-Yes']")
	WebElement SelectYesComprehensive;
	
	@FindBy(xpath = "//*[@id='lblPolicyExist-No']")
	WebElement SelectNoComprehensive;
	
	@FindBy(xpath = "//*[@id='PolicyExpiryDate']")
	WebElement SelectPolicyExpDate;
	
	@FindBy(xpath = "//div[@class='bikeinsurance run-animation']/div/div[3]/a[2]")
	WebElement SelectPolicyNextButton;
	
	@FindBy(xpath = "//div/input[@id='txtotp']")
	WebElement EnterOTP;
	
	@FindBy(xpath = "//div/button[@class='verify']")
	WebElement SelectVerifyBtn;
	
	@FindBy(xpath = "//div[@class='LoadPopup']/div/div[@class='popupclose']")
	WebElement ClosePopup;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li")
	WebElement autoOptions;
	
	@FindBy(xpath = "//ul[@id='ui-id-1']/li")
	WebElement autoOptionsPlaceofReg;
	
	
	//Config Config;
	//Properties prop;
	//public WebDriver driver;
	Login login;
	
	public New_car_input_page() {
		super();
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		// TODO Auto-generated constructor stub
	}
	

	public void selectRenewsec() {
		try {
			waitHandle(driver, RenewSection, 20);
			//RenewSection.click();
		} catch (NoSuchElementException  e) {
			// TODO: handle exception
			System.out.println("Incorrect Element");
		}
		
	}

	// This method is replaced by enterMakeModel2 method below
	/*public void enterMakeModel(String Vehicle, String model)  {
		//WebDriver driver,String Vehicle, String model
		try {
			System.out.println("into enter MakeModel");
			MakeMyModel.click();
			MakeMyModel.sendKeys(Vehicle);
			Thread.sleep(10000);
			WebElement moveelem = driver.findElement(By.xpath("//div[contains(.,'"+ model +"')]"));
			System.out.println(moveelem.getText());
			Actions actions = new Actions(driver);
			actions.moveToElement(moveelem).click().build().perform();
			driver.findElement(By.xpath("//select[@id='FuelType']")).click();
		} catch (Exception e) {
			System.out.println("Make Model Not Entered");
			e.getStackTrace();
			e.getMessage();
		}
	}*/
	
	public void enterMakeModel2(String Vehicle,String Model) {
		try {
			final Logger logger = Log.getLogData(Log.class.getName());
			
			waitHandle(driver, MakeMyModel, 20);
			System.out.println("into enter MakeModel");
			MakeMyModel.click();
			MakeMyModel.sendKeys(Vehicle);
			handleAutoDropDown(autoOptions, Model);
			logger.info("Entered make Model");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Make Model Not Entered");
			e.getStackTrace();
			e.getMessage();
		}
		
		
	}
	
	public void handleAutoDropDown(WebElement autoOptions,String Model) {
		List<WebElement> opList = autoOptions.findElements(By.xpath("//li/div[contains(text(),'" + Model + "')]"));
		int opSize = opList.size();
		for(int i = 0;i<opSize;i++) {
			if(opSize > 1) {
				opList.get(i).click();
				break;
			}else {
				opList.get(i).click();
				}
		}
	}

	public void selectFuelType(String fueltype) throws Exception {
		waitHandle(driver, SelectFuelType, 20);
		handleDropDown(SelectFuelType, fueltype);
	}

	public void selectVariant(String variant) throws Exception {
		waitHandle(driver, SelectVariant, 20);
		handleDropDown(SelectVariant, variant);
	}

	public void selectRegDate() throws Exception {
		Thread.sleep(1000);
		SelectFirstRegistrationDate.click();
		System.out.println("clicked on reg date");
		selectMonth(GetRegMonthText, ExcelUtils.getMapData("SelectRegMonth"));
		selectYear(GetFirstRegYearText, ExcelUtils.getMapData("SelectRegYear"));
		selectDay(ExcelUtils.getMapData("SelectRegDay"));
		ClickfirstRegOK.click();

	}

	public void selectPlaceOfRegistration(String City, String Place) {
		//final Logger logger = Log.getLogData(Log.class.getName());
		final Logger logger = Log.getLogData(Log.class.getName());
		logger.info("entering place of registeration");
		PlaceOfRegistration.sendKeys(City);
		handleAutoDropDown(autoOptionsPlaceofReg, Place);
		//WebElement moveelem = driver.findElement(By.xpath("//div[contains(.,'" + Place + "')]"));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(moveelem).click().build().perform();
		//logger.info("entered place of registration");
	}

	public void selectManfcMonth(String monthValue, String yearValue) throws Exception {
		SelectMonthOfManf.click();
		selectMonth(GetRegMonthText, monthValue);
		selectYear(GetManfYearText, yearValue);
	}
	
	//IsVehFinanced
	
	public void IsVehFinance(String YesNo,String num) throws Exception {
		if (YesNo.equalsIgnoreCase("yes")) {
			IsVehFinancedYes.click();
			FinanceAmt.sendKeys(num);
		}
		if (YesNo.equalsIgnoreCase("no")) {
			handleWait(IsVehFinancedNo, driver, 40);
			//jsExecute(IsVehFinancedNo);
			//IsVehFinancedNo.click();
		}
	}

	public void clickNextDetail() {
		//NextButton.click();
		//jsExecute(NextButton);
	}

	public void selectClaimOnLastYearPolicy(String yesno) {
		if (yesno.equalsIgnoreCase("yes")) {
			SelectClaimOnLastYearPolicyYes.click();
		}
		if (yesno.equalsIgnoreCase("no")) {
			SelectClaimOnLastYearPolicyNo.click();
		}

	}
	
	public void selectComprehensivePolicy(String yesno) throws InterruptedException {
		Thread.sleep(5000);
		if (yesno.equalsIgnoreCase("Yes")) {
			SelectYesComprehensive.click();
		}
		if (yesno.equalsIgnoreCase("No")) {
			SelectNoComprehensive.click();
		}

	}

	public void selectPolicyExpiryDate() throws Exception {
		final Logger logger = Log.getLogData(Log.class.getName());
		logger.info("entering policy details");
		Thread.sleep(1000);
		SelectPolicyExpDate.click();
		selectMonth(GetRegMonthText, ExcelUtils.getMapData("SelectPolicyExpMonth"));
		selectYear(GetFirstRegYearText, ExcelUtils.getMapData("SelectPolicyExpYear"));
		selectDay(ExcelUtils.getMapData("SelectPolicyExpDay"));
		String pExpDate = ExcelUtils.getMapData("SelectPolicyExpDay")+"-"+ExcelUtils.getMapData("SelectPolicyExpMonth")+"-"+ExcelUtils.getMapData("SelectPolicyExpYear");
		System.out.println(pExpDate);
		ClickfirstRegOK.click();
		
		logger.info("entered policy details");
	}

	public void selectPreviousInsurer(String previousinsurer) throws Exception {
		
		handleDropDown(SelectPreviousInsurer, previousinsurer);
	}

	

	public void clickNCBNextBtn() {
		SelectNextButtonNCB.click();
	}
	
	public void clickPolicyNxtBtn() {
		SelectPolicyNextButton.click();
	}

	public void enterFullName(String fullname) {
		final Logger logger = Log.getLogData(Log.class.getName());
		logger.info("entering fullname");
		EnterFullName.sendKeys(fullname);
		logger.info("entered fullname");
	}

	public void enterMobile(String MobileNo) {
		final Logger logger = Log.getLogData(Log.class.getName());
		logger.info("entering Mobile no");
		EnterMobile.sendKeys(MobileNo);
		logger.info("entered Mobile no");
	}

	public void clickCalculateQuote() {
		CalculateQuoteBTN.click();
	}

	private void selectMonth(WebElement monthEle,String monthValue) throws Exception {
		//String mon;

		System.out.println("selecting month ");
		System.out.println("month to be selected"+ExcelUtils.getMapData("SelectRegMonth"));
		String actMonthArray [] = new String [] {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		String expMonthArray [] = new String [] {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		
		System.out.println("month showing is "+ monthEle.getText());
		String actMonthTxt;
		
		int strActMonindex = 0;
		for(int i = 0;i<actMonthArray.length;i++) {
			String strArrActMonth = actMonthArray[i];
			actMonthTxt = monthEle.getText();
			System.out.println(strArrActMonth);
			if(strArrActMonth.equalsIgnoreCase(actMonthTxt)) {
				System.out.println(actMonthArray[i].indexOf(strArrActMonth));
				break;
			}else {
				strActMonindex++;
			}
		}
		int strExpMonindex = 0;
		for(int i = 0;i<expMonthArray.length;i++) {
			String strArrExpMonth = expMonthArray[i];
			if(strArrExpMonth.equalsIgnoreCase(monthValue)) {
				break;
			}else {
				strExpMonindex++;
			}
		}
		
		for(int y = 0;y<13;y++) {
			String monthh = monthEle.getText();
			
			if(strActMonindex == strExpMonindex) {
				System.out.println(monthh + "this is p mon");
				break;
			}else if (strActMonindex < strExpMonindex) {
				waitHandle(driver, CLickNextMonth,20000);
				//CLickNextMonth.click();
				break;
			}else if (strActMonindex > strExpMonindex){
				waitHandle(driver, CLickPreMonth,20000);
				//CLickPreMonth.click();
				break;
			}
		}
		
		
		/*String monthh = monthEle.getText();
		System.out.println(monthh + "this is p mon");
		String mon;
		System.out.println("Hello ");
		System.out.println(ExcelUtils.getMapData("SelectRegMonth"));
		for (int i = 0; i <= 12; i++) {
			mon = monthEle.getText();
			System.out.println(mon);
			if (mon.equalsIgnoreCase(monthValue)) {
				System.out.println(mon + " mon value is equal to " + monthValue);
				break;
			} else {
				CLickNextMonth.click();
				i++;
			}

		}*/
	}

	private void selectYear(WebElement YearEle, String yearValue) throws Exception {
		//String yearr = YearEle.getText();
		int intcalyear = Integer.parseInt(GetFirstRegYearText.getText());
		
		System.out.println("this is p yearr" + intcalyear + " intcalyear");
		System.out.println(ExcelUtils.getMapData("SelectRegYear"));
		for (int i = 0; i <= 24; i++) {
			if (intcalyear == Integer.parseInt(yearValue) && intcalyear == Integer.parseInt(GetFirstRegYearText.getText())) {
				System.out.println(intcalyear + " mon value is equal to " + yearValue);
				break;
			} else if(intcalyear < Integer.parseInt(yearValue)){
				waitHandle(driver, GetFirstRegNextYearBtn,20000);
				intcalyear++;
				//GetFirstRegPrevYearBtn.click();
			}else if (intcalyear > Integer.parseInt(yearValue)) {
				waitHandle(driver, GetFirstRegPrevYearBtn,10000);
				//GetFirstRegNextYearBtn.click();
				intcalyear --;

			}else {
				System.out.println("Year is not there in system");
				assertTrue(intcalyear == Integer.parseInt(GetFirstRegYearText.getText()), "Year is not present");
				break;
			}
		}
	}

	private void selectDay(String dayValue) {
		WebElement dayelem=driver.findElement(By.xpath("//div[@class='dtp']/div[1]/div[1]/div[3]/div/table/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		//WebElement dayelem=driver.findElement(By.xpath("//table[@class='table dtp-picker-days']/tbody/tr/td/a[contains(.,'" + dayValue + "')]"));
		

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
	public void enterVehicleDetail() throws Exception {
		//System.out.println("Started Entering Vehicle Detail");
		final Logger logger = Log.getLogData(Log.class.getName());
		logger.info("entering vehicle details");
		selectRenewsec();
		//enterMakeModel(ExcelUtils.getMapData("Vehicle"),ExcelUtils.getMapData("Model"));
		enterMakeModel2(ExcelUtils.getMapData("Vehicle"),ExcelUtils.getMapData("Model"));
		selectFuelType(ExcelUtils.getMapData("FuelType"));
		selectVariant(ExcelUtils.getMapData("Variant"));
		selectRegDate();
		selectPlaceOfRegistration(ExcelUtils.getMapData("SelectCity"),ExcelUtils.getMapData("SelectPlace"));
		IsVehFinance(ExcelUtils.getMapData("SelectVehFinanced"),ExcelUtils.getMapData("SelectFinanceAmt"));
		clickNextDetail();
		logger.info("entered vehicle details");
		
		
	}
	
	public void enterPolicyDetail() throws Exception {
		
		selectComprehensivePolicy(ExcelUtils.getMapData("SelectComprehensivePolicy"));
		selectPolicyExpiryDate();
		selectPreviousInsurer(ExcelUtils.getMapData("SelectPreviousInsurer"));
		selectClaimOnLastYearPolicy(ExcelUtils.getMapData("SelectClaimOnLastYearPolicy"));
		clickNCBNextBtn();
		
	}
	
	public void enterPsnlDetail() throws Exception {
		enterFullName(ExcelUtils.getMapData("EnterFullName"));
		enterMobile(ExcelUtils.getMapData("EnterMobileNo"));
		CalculateQuoteBTN.click();
		login = new Login();
		boolean status = login.islogin();
		if(status) {
			Thread.sleep(10000);
			//ClosePopup.click();
			ClosePopup.click();
		}else {
			EnterOTP.sendKeys("1111");
			SelectVerifyBtn.click();
			Thread.sleep(10000);
			ClosePopup.click();
			//jsExecute(ClosePopup);
		}
		
	}
	
	public String verifyTPText() {
		waitHandle(driver, btnTPOnly, 5000);
		//btnTPOnly.click();
		String txtVerify = verifyElementTxt(btnTPOnly);
		return txtVerify;
		}
	
	public String verifyODText() {
		//waitHandle(driver, btnODOnly, 5000);
		//btnODOnly.click();
		String txtVerify = verifyElementTxt(btnODOnly);
		return txtVerify;
		}
	
	public String verifyCompText() {
		waitHandle(driver, btnComprehensive, 5000);
		//btnComprehensive.click();
		String txtVerify = verifyElementTxt(btnComprehensive);
		return txtVerify;
		}
	


}
