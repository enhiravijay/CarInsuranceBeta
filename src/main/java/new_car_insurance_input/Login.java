package new_car_insurance_input;

//import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePage.BasePage;
import io.qameta.allure.Step;
import utility.ExcelUtils;

public class Login extends BasePage {
	
	
	@FindBy(xpath = "//img[@alt='user login']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement UserName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[@id='submitbtn']")
	WebElement Submit;
	
	@FindBy(xpath = "//*[@id='myNavbar']/ul/li[1]/a")
	WebElement CarEle;
	
	@FindBy(xpath = "//span[@class='ad_quote']")
	WebElement btnAddQuote;
	
	@FindBy(xpath = "//div/span[@class='txtwhite']")
	WebElement loginName;
	//head/title
	
	//input[@id='username']
	//input[@id='password']
	//button[@id='submitbtn']
	//public Properties prop;
	//public TestBase tb;
	//Config Config;
	//Properties prop;
	//public WebDriver driver;
	
	public Login() {
		super();
		//this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	protected boolean islogin() throws Exception {
		//boolean blogin=false;
		String getlogin = ExcelUtils.getMapData("Login");
		if(getlogin.contains("YES")) {
			return true;
		}else {
			return false;
		}
	}
	
	@Step("getting login name")
	public String verifyLoginSuccess() throws Exception {
		String lName = loginName.getText();
		return lName;
	}
	
	@Step("Login with user: {0} and Password {1} step...")
	public  void checkLogin(String Uname,String Pswd) throws Exception {
		System.out.println("sssttttaaarrrttt");
		prop=utility.Config.loadPropertyFile();
		//driver.get(Config.prop.getProperty("liveurl"));
		driver.get(prop.getProperty("qaurl"));
		boolean check = islogin();
		if(check==true) {
		boolean status = isElementDisplayed(LoginButton);
		if(status) {
			LoginButton.click();
			UserName.click();
			UserName.clear();
			UserName.sendKeys(Uname);
			Password.sendKeys(Pswd);
			Submit.click();
			isElementDisplayed(CarEle);
			CarEle.click();
			Thread.sleep(5000);
			isElementDisplayed(btnAddQuote);
			btnAddQuote.click();
			
		}else {
			System.out.println("Login button is disabled");
		}
			
		}else {
			System.out.println("No login required");
		}
		
	}

}
