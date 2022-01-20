package new_car_insurance_input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;
import utility.ExcelUtils;

public class QuotePage extends BasePage{

	@FindBy(xpath = "//div[@class='CRN']")
	WebElement crnNo;

	@FindBy(xpath = "//div[@class='insurer_ctn odometer odometer-auto-theme']/div/span/span[2]/span/span/span[@class='odometer-value']")
	WebElement Insurers;

	@FindBy(xpath = "//div[@class='boxLeft img2 pad-lft']/img")
	WebElement InsurerName;

	@FindBy(xpath = "//li[@class='LiClass']/div[@class='boxLeft resultPrice pad-lft dynamic']/h5")
	WebElement Idv;

	@FindBy(xpath = "//div[@class='boxLeft pad-rht dynamic']/a/span")
	WebElement Premium;

	@FindBy(xpath = "//span[@id='Variant']")
	WebElement GetVariant;

	@FindBy(xpath = "//span[@id='RTOName']")
	WebElement GetRto;

	@FindBy(xpath = "//div[@id='LoaderImg']")
	WebElement GetLoader;
	
	@FindBy(xpath = "//div[@class='popupScreen']/div[@class='popupclose']")
	WebElement popupClose;
	// getInsurerName //div[@class='boxLeft img2 pad-lft']/img
	// getIdv //li[@class='LiClass']/div[@class='boxLeft resultPrice pad-lft dynamic']/h5/text()
	// getPremium //div[@class='boxLeft pad-rht dynamic']/a/span
	//get Variant //span[@id='Variant']
	public QuotePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public Integer getCrn() {
		int crn = Integer.parseInt(crnNo.getText());
		if (crn >0) {
			System.out.println("crn for this input is " + crn);
		}else {
			System.out.println("Crn no is 0");
		}
		return crn;
	}

	public String getVariantdetails() {
		String variantdetail = GetVariant.getText();
		//System.out.println("Variant of vehicle is " + variantdetail);
		return variantdetail;
	}

	public String getRtodetails() {
		String rtoDetail = GetRto.getText();
		//System.out.println("Variant of vehicle is " + rtoDetail);
		return rtoDetail;
	}



	public Integer getNoOfInsurers() {
		int insurers = Integer.parseInt(Insurers.getText());
		if (insurers > 0) {
			//System.out.println("crn for this input is " + insurers);
		}else {
			//System.out.println("Crn no is 0");
		}
		return insurers;
	}
	
	

	public  Map<Integer, Map<Integer, List<String>>> getQuoteDetails() {
		// Insurance name details

		waitForElementToBeGone(GetLoader, 1000);
		List<WebElement> insurer = Insurers.findElements(By.xpath("//div[@class='boxLeft img2 pad-lft']/img[@sname]"));
		int insurerSize = insurer.size();
		// Idv details
		List<WebElement> idvEle = Idv.findElements(By.xpath("//li[@class='LiClass']/div[@class='boxLeft resultPrice pad-lft dynamic']/h5"));
		int idvSize = idvEle.size();
		// Insurance premium details
		List<WebElement> premEle = Premium.findElements(By.xpath("//div[@class='boxLeft pad-rht dynamic']/a/span"));
		int premiumSize = premEle.size();

		Integer crnvalue = getCrn();
		String crnvalis = crnvalue.toString();
		Integer NoofInsureris = getNoOfInsurers();
		String InsurerCount = NoofInsureris.toString();
		String Variandetail = getVariantdetails();
		String Rtodetail = getRtodetails();

		List<String> insData = new ArrayList<String>();
		insData.add(crnvalis);
		insData.add(Variandetail);
		insData.add(Rtodetail);
		insData.add(InsurerCount);


		// get insurance name in map
		Map<Integer, Map<Integer, List<String>>> insuMap = new HashMap<Integer, Map<Integer, List<String>>>();
		Map<Integer, List<String>> insDataMap = new HashMap<Integer, List<String>>();

		//insDataMap.put(NoofInsureris, value)
		// get insurance data in map

		for(int i = 0;i<insurerSize;i++) {
			List<String> datalist = new ArrayList<String>();
			//Object[] insdata = insDataMap.putAll(insurer.get(i).getAttribute("alt"));
			//waitHandle(driver, Insurers, 20000);
			//waitForElementToBeGone(GetLoader, 1000);
			//loadingWait(driver, GetLoader);
			datalist.add(insurer.get(i).getAttribute("alt"));
			String premiumtxt = premEle.get(i).getText();
			String premiumValue = premiumtxt.replaceAll("[^a-zA-Z0-9]", "");
			datalist.add(premiumValue);
			datalist.add(idvEle.get(i).getText());
			insDataMap.put(i, datalist);
			insuMap.put(i, insDataMap);

			//System.out.println(insurer.get(i).getAttribute("alt"));
		}
		insDataMap.put(insurerSize,insData);
		insuMap.put(insurerSize,insDataMap);



		return insuMap;

	}

	public void getIdv() throws Exception {
		List<WebElement> idvEle = Idv.findElements(By.xpath("//li[@class='LiClass']/div[@class='boxLeft resultPrice pad-lft dynamic']/h5"));
		int idvSize = idvEle.size();
		for(int i = 0;i<idvSize;i++) {

			//System.out.println(idvEle.get(i).getText());
		}
	}

	public void getPremium() {
		List<WebElement> premEle = Premium.findElements(By.xpath("//div[@class='boxLeft pad-rht dynamic']/a/span"));
		int premiumSize = premEle.size();
		for(int i = 0;i<premiumSize;i++) {
			String premiumtxt = premEle.get(i).getText();
			//System.out.println("Premium is Rs "+ premiumtxt.replaceAll("[^a-zA-Z0-9]", ""));
		}


	}
	
	public boolean verifyCrn() {
		
		
		Integer vCrn = getCrn();
		if(vCrn > 0) {
			return true;
		}else {
			return false;	
		}
		
		

}

	public  Map<Integer, Map<Integer, List<String>>> getDataMap() {
		//QuotePage qpp = new QuotePage(driver);
		//Map<Integer, Map<Integer, List<String>>> qmap = qpp.getQuoteDetails();
		Map<Integer, Map<Integer, List<String>>> qmap = getQuoteDetails();
		/*for(Integer insdetails:qmap.keySet()) {
				Map<Integer, List<String>> qmapvalue = qmap.get(insdetails);
				System.out.println("Key = " + insdetails + ", Value = " + qmapvalue);
			}*/
		return qmap;


	}
	
	public boolean ifInsurerPresent() throws Exception {
		boolean insurerpresent = false;
		Map<Integer, Map<Integer, List<String>>> abc = getQuoteDetails();
		int abcsize = abc.size();
		for(Integer insdetails : abc.keySet()) {
			Map<Integer, List<String>> qmapvalue = abc.get(insdetails);
			List<String> qstringvalue = qmapvalue.get(insdetails);
			for(int i =0;i<4;i++) {
				if(qstringvalue.get(0).contains(ExcelUtils.getMapData("IsInsurerPresent"))) {
					System.out.println("buying insurer"+qstringvalue.get(0));
					insurerpresent=true;
					break;
				}
			}
		}
		return insurerpresent;
		
	}
	
	public void buyInsurer() throws Exception {
		boolean valueis = ifInsurerPresent();
		if(valueis) {
			//div[@class='boxLeft img2 pad-lft']/img[contains(@title, 'Tata')]
			List<WebElement> Liclass = driver.findElements(By.xpath("//li[@class='LiClass']"));
			int liCount = Liclass.size();
			
			List<WebElement> buyIns = driver.findElements(By.xpath("//div[@class='boxLeft pad-rht dynamic']/a"));
			for (int i = 0;i<liCount;i++) {
				List<WebElement> insurer = Insurers.findElements(By.xpath("//div[@class='boxLeft img2 pad-lft']/img[@sname]"));
				int insurerSize = insurer.size();
				String instext = insurer.get(i).getAttribute("alt");
				System.out.println("Insurer to be bought is "+ instext);
				if(instext.contains(ExcelUtils.getMapData("IsInsurerPresent"))) {
					buyIns.get(i).click();
					Thread.sleep(100);
					//isElementClickable(popupClose);
					//driver.findElement(By.xpath("//div[@class='popupScreen']/div[@class='popupclose']")).click();
					//popupClose.click();
					break;
				}
				
			}
			
		}else {
			System.out.println("given insurer is not present");
		}
	}
}
