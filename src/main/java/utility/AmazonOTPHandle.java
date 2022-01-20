package utility;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import new_car_insurance_input.New_car_input_page;

public class AmazonOTPHandle {

	public static final String ACCOUNT_SID = "AC9304eadce6f5ad3a77008dd1d4bf1963";
	public static final String AUTH_TOKEN = "acfbdd0245018abf984e15c608612ddb";

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.policyboss.com/car-insurance");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.findElement(By.id("newSection")).click();
		New_car_input_page nc = new New_car_input_page();
		nc.enterVehicleDetail();
		nc.enterPolicyDetail();
		nc.enterPsnlDetail();
		/*Actions act = new Actions(driver);
		WebElement mousehover = driver.findElement(By.cssSelector("a#nav-link-accountList>span>span"));
		act.moveToElement(mousehover).build().perform();
		Thread.sleep(30000);
		driver.findElement(By.linkText("Start here.")).click();

		driver.findElement(By.id("ap_customer_name")).sendKeys("NaveenTestOTP");
		driver.findElement(By.id("auth-country-picker-container")).click();

		driver.findElement(By.xpath("//ul[@role='application']//li/a[contains(text(),'India +91')]")).click();
		driver.findElement(By.id("ap_phone_number")).sendKeys("9967192191");
		driver.findElement(By.id("ap_password")).sendKeys("TestAutomation@123");
		driver.findElement(By.id("continue")).click();*/

		// get the OTP using Twilio APIs:
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		//Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		String smsBody = getMessage();
		System.out.println(smsBody);
		String OTPNumber = smsBody.replaceAll("[^-?0-9]+", " ");
		System.out.println(OTPNumber);
		
		driver.findElement(By.id("auth-pv-enter-code")).sendKeys(OTPNumber);

	}

	public static String getMessage() {
		return (String) getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().contains("9967192191")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return (Stream<Message>) StreamSupport.stream(messages.spliterator(), false);
	}

}