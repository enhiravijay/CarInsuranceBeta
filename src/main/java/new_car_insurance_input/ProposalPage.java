package new_car_insurance_input;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;

public class ProposalPage extends BasePage {
	
	@FindBy(xpath = "//div[@class='popupScreen']/div[@class='popupclose']")
	WebElement btnCloseUp;

	@FindBy(xpath = "//a[@id='TabPersonalInfo']")
	WebElement TabPersonalInfo;
	
	@FindBy(xpath = "//select[@id='Salutation']")
	WebElement Salutation;
	
	@FindBy(xpath = "//input[@id='ContactLastName']")
	WebElement inputLastName;
	
	@FindBy(xpath = "//input[@id='DOBofOwner']")
	WebElement btnDobCal;
	
	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	WebElement selectYear;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	WebElement selectMonth;

	@FindBy(xpath = "//select[@id='MaritalStatus']")
	WebElement selectMarStatus;
	
	@FindBy(xpath = "//select[@id='ContactOccupationId']")
	WebElement selectOccupation;
	
	@FindBy(xpath = "//input[@id='ContactMobile']")
	WebElement inputMobile;
	
	@FindBy(xpath = "//input[@id='ContactEmail']")
	WebElement inputEmail;
	
	
	public ProposalPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public  void enterContact() throws Exception {
		enterContactDetails();
				
	}
	
	private void enterContactDetails() throws Exception {
		handleWait(btnCloseUp, driver, 20);
		btnCloseUp.click();
		TabPersonalInfo.click();
		Thread.sleep(200);
		Salutation.click();
		handleDropDown(Salutation,"Mr");
		sendText(inputLastName, "Kumar");
		btnDobCal.click();
		handleDropDown(selectYear, "1982");
		handleDropDown(selectMonth, "Oct");
		selectDay("10");
		handleDropDown(selectMarStatus, "Married");
		handleDropDown(selectOccupation, "Others");
		inputMobile.sendKeys("9999999999");
		inputEmail.sendKeys("policybosstesting@gmail.com");
	}
	
	private  void selectDay(String dayValue) {
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

	
}
