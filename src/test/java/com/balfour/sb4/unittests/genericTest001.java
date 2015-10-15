package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.balfour.publishing.qa.OCOPOJO;
import com.balfour.publishing.qa.pages.Page;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4OCOListPage;
import com.balfour.publishing.qa.pages.sb4.Sb4OCOPage;
import com.balfour.publishing.qa.pages.sb4.Sb4OCOViewPage;

@SuppressWarnings("unused")
public class genericTest001 {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	private String unameVal = "veggietester003";
	private String pwordVal = "cOOKE1964";
	private Page pg = new Page(driver);
	private String[] add2 = { "apt 101", "apt 202", "apt 303", "apt 404" };
	private String[] city = { "Pirate Cove", "Ninja Way", "Mutant Road", "Alien Drive" };
	private String[] zip = { "90210", "79936", "75287", "60629" };
	private String[] grade = { "Pre-K", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "Undergraduate",
			"Post-Graduate", "Doctorate", "Alumni", "Faculty", "Yearbook Staff" };
	private String[] projects = { "627649", "611336", "621369", "615782", "623573", "627017", "604978", "605717",
			"620192" };

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("platform", "Windows 7");
		cap.setCapability("version", "40.0");
		cap.setCapability("name", "OCO test");

		driver = new RemoteWebDriver(
				new URL("http://citizenchris:a8f0eeb8-bb02-4788-b6d1-3680f480930c@ondemand.saucelabs.com:80/wd/hub"),
				cap);

		// ((FirefoxDriver) driver).setFileDetector(new LocalFileDetector());
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() {
		driver.get("https://sb3-qa.balfour.com/login/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void ocoTest003() throws InterruptedException {
		OCOPOJO ocoA = createOCOInfo("Comp", "2800", true);
		OCOPOJO ocoB = createOCOInfo("Cash", "2800", true);
		OCOPOJO ocoC = createOCOInfo("Check", "2800", true);
		OCOPOJO ocoD = createOCOInfo("Comp", "2800", false);
		OCOPOJO ocoE = createOCOInfo("Cash", "2800", false);
		OCOPOJO ocoF = createOCOInfo("Check", "2800", false);
		OCOPOJO ocoG = createOCOInfo("Comp", "5000", true);
		OCOPOJO ocoH = createOCOInfo("Cash", "5000", true);
		OCOPOJO ocoI = createOCOInfo("Check", "5000", true);
		OCOPOJO ocoJ = createOCOInfo("Comp", "5000", false);
		OCOPOJO ocoK = createOCOInfo("Cash", "5000", false);
		OCOPOJO ocoL = createOCOInfo("Check", "5000", false);
		OCOPOJO[] orders = { ocoA, ocoB, ocoC, ocoD, ocoE, ocoF, ocoG, ocoH, ocoI, ocoJ, ocoK, ocoL };
//		OCOPOJO[] orders = { ocoA };
		int test = 0;
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal).ChangeProject2("550074");

		for (OCOPOJO oco : orders) {
			System.out.println("BEGINING TEST "+test);
			driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
			OCOPOJO oco1 = oCOInfoClone(oco);
			new Sb4OCOListPage(driver).createNewOrder().saveNewViewOCO(oco).getOCOInfo(oco1);
			System.out.println("oco pfn = " + oco.getpFName() + " oco1 pfn = " + oco1.getpFName());
			System.out.println("oco pln = " + oco.getpLName() + " oco1 pln = " + oco1.getpLName());
			System.out.println("oco a1 = " + oco.getAdd1() + " oco1 a1 = " + oco1.getAdd1());
			System.out.println("oco a2 = " + oco.getAdd2() + " oco1 a2 = " + oco1.getAdd2());
			System.out.println("oco ct = " + oco.getCity() + " oco1 ct = " + oco1.getCity());
			System.out.println("oco st = " + oco.getState() + " oco1 st = " + oco1.getState());
			System.out.println("oco zp = " + oco.getZip() + " oco1 zp = " + oco1.getZip());
			System.out.println("oco ph = " + oco.getPhone() + " oco1 ph = " + oco1.getPhone());

			System.out.println("oco sfn = " + oco.getsFName() + " oco1 sfn = " + oco1.getsFName());
			System.out.println("oco sln = " + oco.getsLName() + " oco1 sln = " + oco1.getsLName());
			System.out.println("oco ot = " + oco.getOrderTotal() + " oco1 ot = " + oco1.getOrderTotal());
			System.out.println("oco bal = " + oco.getBalance() + " oco1 bal = " + oco1.getBalance());
			System.out.println("oco nbal = " + oco.getnBalance() + " oco1 nbal = " + oco1.getnBalance());

			System.out.println("oco pt = " + oco.getpType() + " oco1 pt = " + oco1.getpType());
			System.out.println("oco ap = " + oco.getaPaid() + " oco1 ap = " + oco1.getaPaid());
			System.out.println("oco dt = " + oco.getDate() + " oco1 dt = " + oco1.getDate());
			System.out.println("oco pm = " + oco.getPaymentMade() + " oco1 pm = " + oco1.getPaymentMade());

			System.out.println("oco pdt = " + oco.getpDate() + " oco1 pt = " + oco1.getpDate());
			System.out.println("oco apt = " + oco.getaPType() + " oco1 apt = " + oco1.getaPType());
			System.out.println("oco apm = " + oco.getaAPaid() + " oco1 apm = " + oco1.getaAPaid());
			if (oco.hashCode() != oco1.hashCode()) {
				throw new RuntimeException("OCO Info did not match");
			}
			OCOPOJO oco2 = oCOInfoClone(oco1);
			driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
			new Sb4OCOListPage(driver).editOCO(oco1).getEditOCOInfo(oco2);
			if (oco1.hashCode() != oco2.hashCode()) {
				throw new RuntimeException("OCO Info did not match");
			}
			OCOPOJO oco3 = oCOInfoClone(oco2);
			createOCOEditInfo(oco3, false, "student", "Comp", "000");
			OCOPOJO oco4 = oCOInfoClone(oco3);
			new Sb4OCOPage(driver).saveEditOCO(oco3).getOCOInfo(oco4);

			System.out.println("oco3 pfn = " + oco3.getpFName() + " oco4 pfn = " + oco4.getpFName());
			System.out.println("oco3 pln = " + oco3.getpLName() + " oco4 pln = " + oco4.getpLName());
			System.out.println("oco3 a1 = " + oco3.getAdd1() + " oco4 a1 = " + oco4.getAdd1());
			System.out.println("oco3 a2 = " + oco3.getAdd2() + " oco4 a2 = " + oco4.getAdd2());
			System.out.println("oco3 ct = " + oco3.getCity() + " oco4 ct = " + oco4.getCity());
			System.out.println("oco3 st = " + oco3.getState() + " oco4 st = " + oco4.getState());
			System.out.println("oco3 zp = " + oco3.getZip() + " oco4 zp = " + oco4.getZip());
			System.out.println("oco3 ph = " + oco3.getPhone() + " oco4 ph = " + oco4.getPhone());

			System.out.println("oco3 sfn = " + oco3.getsFName() + " oco4 sfn = " + oco4.getsFName());
			System.out.println("oco3 sln = " + oco3.getsLName() + " oco4 sln = " + oco4.getsLName());
			System.out.println("oco3 ot = " + oco3.getOrderTotal() + " oco4 ot = " + oco4.getOrderTotal());
			System.out.println("oco3 bal = " + oco3.getBalance() + " oco4 bal = " + oco4.getBalance());
			System.out.println("oco3 nbal = " + oco3.getnBalance() + " oco4 nbal = " + oco4.getnBalance());

			System.out.println("oco3 pt = " + oco3.getpType() + " oco4 pt = " + oco4.getpType());
			System.out.println("oco3 ap = " + oco3.getaPaid() + " oco4 ap = " + oco4.getaPaid());
			System.out.println("oco3 dt = " + oco3.getDate() + " oco4 dt = " + oco4.getDate());
			System.out.println("oco3 pm = " + oco3.getPaymentMade() + " oco4 pm = " + oco4.getPaymentMade());

			System.out.println("oco3 pdt = " + oco3.getpDate() + " oco4 pt = " + oco4.getpDate());
			System.out.println("oco3 apt = " + oco3.getaPType() + " oco4 apt = " + oco4.getaPType());
			System.out.println("oco3 apm = " + oco3.getaAPaid() + " oco4 apm = " + oco4.getaAPaid());

			if (oco3.hashCode() != oco4.hashCode()) {
				throw new RuntimeException("OCO Info did not match");
			}
			OCOPOJO oco5 = oCOInfoClone(oco4);
			new Sb4OCOViewPage(driver).editOCO().getEditOCOInfo(oco5);

			System.out.println("oco5 pfn = " + oco5.getpFName() + " oco4 pfn = " + oco4.getpFName());
			System.out.println("oco5 pln = " + oco5.getpLName() + " oco4 pln = " + oco4.getpLName());
			System.out.println("oco5 a1 = " + oco5.getAdd1() + " oco4 a1 = " + oco4.getAdd1());
			System.out.println("oco5 a2 = " + oco5.getAdd2() + " oco4 a2 = " + oco4.getAdd2());
			System.out.println("oco5 ct = " + oco5.getCity() + " oco4 ct = " + oco4.getCity());
			System.out.println("oco5 st = " + oco5.getState() + " oco4 st = " + oco4.getState());
			System.out.println("oco5 zp = " + oco5.getZip() + " oco4 zp = " + oco4.getZip());
			System.out.println("oco5 ph = " + oco5.getPhone() + " oco4 ph = " + oco4.getPhone());

			System.out.println("oco5 sfn = " + oco5.getsFName() + " oco4 sfn = " + oco4.getsFName());
			System.out.println("oco5 sln = " + oco5.getsLName() + " oco4 sln = " + oco4.getsLName());
			System.out.println("oco5 ot = " + oco5.getOrderTotal() + " oco4 ot = " + oco4.getOrderTotal());
			System.out.println("oco5 bal = " + oco5.getBalance() + " oco4 bal = " + oco4.getBalance());
			System.out.println("oco5 nbal = " + oco5.getnBalance() + " oco4 nbal = " + oco4.getnBalance());

			System.out.println("oco5 pt = " + oco5.getpType() + " oco4 pt = " + oco4.getpType());
			System.out.println("oco5 ap = " + oco5.getaPaid() + " oco4 ap = " + oco4.getaPaid());
			System.out.println("oco5 dt = " + oco5.getDate() + " oco4 dt = " + oco4.getDate());
			System.out.println("oco5 pm = " + oco5.getPaymentMade() + " oco4 pm = " + oco4.getPaymentMade());

			System.out.println("oco5 pdt = " + oco5.getpDate() + " oco4 pt = " + oco4.getpDate());
			System.out.println("oco5 apt = " + oco5.getaPType() + " oco4 apt = " + oco4.getaPType());
			System.out.println("oco5 apm = " + oco5.getaAPaid() + " oco4 apm = " + oco4.getaAPaid());

			if (oco4.hashCode() != oco5.hashCode()) {
				throw new RuntimeException("OCO Info did not match");
			}
			System.out.println("TEST "+test+" COMPLETE");
			test++;
			driver.get("https://sb3-qa.balfour.com/");
			
		}
	}

	// @Test
	public void ocoTest004() throws InterruptedException {
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
		OCOPOJO oco = createOCOInfo("Cash", "5000", "5000", false);
		OCOPOJO oco1 = createOCOInfo("Check", "5000", "5000", false);
		OCOPOJO oco2 = createOCOInfo("Comp", "5000", "5000", false);
		OCOPOJO oco4 = oCOInfoClone(oco);
		OCOPOJO oco5 = oCOInfoClone(oco1);
		OCOPOJO oco6 = oCOInfoClone(oco2);
		new Sb4HomePage(driver).ChangeProject2("550074");
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		new Sb4OCOListPage(driver).createNewOrder().saveNewStartOCO(oco).saveNewStartOCO(oco1).saveNewStartOCO(oco2);
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		new Sb4OCOListPage(driver).viewOCO(oco).getOCOInfo(oco4);
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		new Sb4OCOListPage(driver).viewOCO(oco1).getOCOInfo(oco5);
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		new Sb4OCOListPage(driver).viewOCO(oco2).getOCOInfo(oco6);

		System.out.println("oco2 pfn = " + oco2.getpFName() + " oco4 pfn = " + oco6.getpFName());
		System.out.println("oco2 pln = " + oco2.getpLName() + " oco4 pln = " + oco6.getpLName());
		System.out.println("oco2 a1 = " + oco2.getAdd1() + " oco4 a1 = " + oco6.getAdd1());
		System.out.println("oco2 a2 = " + oco2.getAdd2() + " oco4 a2 = " + oco6.getAdd2());
		System.out.println("oco2 ct = " + oco2.getCity() + " oco4 ct = " + oco6.getCity());
		System.out.println("oco2 st = " + oco2.getState() + " oco4 st = " + oco6.getState());
		System.out.println("oco2 zp = " + oco2.getZip() + " oco4 zp = " + oco6.getZip());
		System.out.println("oco2 ph = " + oco2.getPhone() + " oco4 ph = " + oco6.getPhone());

		System.out.println("oco2 sfn = " + oco2.getsFName() + " oco4 sfn = " + oco6.getsFName());
		System.out.println("oco2 sln = " + oco2.getsLName() + " oco4 sln = " + oco6.getsLName());
		System.out.println("oco2 ot = " + oco2.getOrderTotal() + " oco4 ot = " + oco6.getOrderTotal());
		System.out.println("oco2 bal = " + oco2.getBalance() + " oco4 bal = " + oco6.getBalance());
		System.out.println("oco2 nbal = " + oco2.getnBalance() + " oco4 nbal = " + oco6.getnBalance());

		System.out.println("oco2 pt = " + oco2.getpType() + " oco4 pt = " + oco6.getpType());
		System.out.println("oco2 ap = " + oco2.getaPaid() + " oco4 ap = " + oco6.getaPaid());
		System.out.println("oco2 dt = " + oco2.getDate() + " oco4 dt = " + oco6.getDate());
		System.out.println("oco2 pm = " + oco2.getPaymentMade() + " oco4 pm = " + oco6.getPaymentMade());

		System.out.println("oco2 pdt = " + oco2.getpDate() + " oco4 pt = " + oco6.getpDate());
		System.out.println("oco2 apt = " + oco2.getaPType() + " oco4 apt = " + oco6.getaPType());
		System.out.println("oco2 apm = " + oco2.getaAPaid() + " oco4 apm = " + oco6.getaAPaid());

		if (oco.hashCode() != oco4.hashCode()) {
			throw new RuntimeException("oco & oco4 Info did not match");
		}
		if (oco1.hashCode() != oco5.hashCode()) {
			throw new RuntimeException("oco1 & oco5 Info did not match");
		}
		if (oco2.hashCode() != oco6.hashCode()) {
			throw new RuntimeException("oco2 & oco6 Info did not match");
		}
		driver.get("https://sb3-qa.balfour.com/");
	}

	// @Test
	public void ocoTest005() throws InterruptedException {
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
		OCOPOJO oco = createOCOInfo("Cash", "5000", "5000", true);
		new Sb4HomePage(driver).ChangeProject2("627649");
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		new Sb4OCOListPage(driver).createNewOrder().saveNewStartOCO(oco);
		System.out.println("Your order number = " + oco.getOrderNumber());
	}

	/**
	 * used to create initial OCO info
	 * 
	 * @param payType
	 *            : accepted values are "Comp","Cash" and "Check"
	 * @param price
	 *            : of the item to be ordered
	 * @param paid
	 * @param fulOrder
	 *            : Boolean that denotes whether to complete the full form. True
	 *            = fill out purchaser and False = fill out only student
	 * @return : OCOPOJO
	 */
	private OCOPOJO createOCOInfo(String payType, String price, String paid, Boolean fulOrder) {

		OCOPOJO oco = new OCOPOJO();
		oco.setDate(pg.curDate());
		oco.setFilloutPurchaser(fulOrder);
		if (fulOrder == true) {
			setPurchaser(oco);
		}
		setStudent(oco);
		oco.setPrice(price);
		oco.setOrderTotal(oco.getPrice());
		oco.setQuan("1");
		oco.setName(oco.getsFName());
		oco.setPaymentMade(false);
		oco.setCheck(false);
		setPayment(payType, paid, oco);
		int ocoprice = Integer.parseInt(oco.getPrice());
		int ocopaid = Integer.parseInt(oco.getaPaid());
		if (ocopaid < ocoprice & !payType.equals("Comp")) {
			oco.setBalStatus("Existing Balance");
			int bal = ocoprice - ocopaid;
			oco.setBalance(String.valueOf(bal));
		} else if (ocopaid == ocoprice & !payType.equals("Comp")) {
			oco.setBalStatus("Paid in Full");
			oco.setBalance("000");
		} else if (payType.equals("Comp")) {
			oco.setBalStatus("Complimentary");
			oco.setBalance("Complimentary");
		}
		return oco;
	}

	/**
	 * used to create initial OCO info. this version does not need price as
	 * price is retrieved from the OCO form
	 * 
	 * @param payType
	 *            : accepted values are "Comp","Cash" and "Check"
	 * @param paid
	 *            : of the item to be ordered
	 * @param fulOrder
	 *            : Boolean that denotes whether to complete the full form. True
	 *            = fill out purchaser and False = fill out only student
	 * @return OCOPOJO
	 */
	private OCOPOJO createOCOInfo(String payType, String paid, Boolean fulOrder) {

		OCOPOJO oco = new OCOPOJO();
		oco.setDate(pg.curDate());
		oco.setFilloutPurchaser(fulOrder);
		if (fulOrder == true) {
			setPurchaser(oco);
		}
		setStudent(oco);
		oco.setOrderTotal(oco.getPrice());
		oco.setQuan("1");
		oco.setPrice("5000");
		oco.setOrderTotal(oco.getPrice());
		oco.setName(oco.getsFName());
		oco.setPaymentMade(false);
		oco.setCheck(false);
		setPayment(payType, paid, oco);
		int ocoprice = Integer.parseInt(oco.getPrice());
		int ocopaid = Integer.parseInt(oco.getaPaid());
		if (ocopaid < ocoprice & !payType.equals("Comp")) {
			oco.setBalStatus("Existing Balance");
			int bal = ocoprice - ocopaid;
			oco.setBalance(String.valueOf(bal));
		} else if (ocopaid == ocoprice & !payType.equals("Comp")) {
			oco.setBalStatus("Paid in Full");
			oco.setBalance("000");
		} else if (payType.equals("Comp")) {
			oco.setBalStatus("Complimentary");
			oco.setBalance("Complimentary");
		}
		return oco;
	}

	/**
	 * used to clone the OCOPOJO passed in.
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return : OCOPOJO
	 */
	private OCOPOJO oCOInfoClone(OCOPOJO obj) {
		Page pg = new Page(driver);
		OCOPOJO oco = new OCOPOJO();
		oco.setFilloutPurchaser(obj.getFilloutPurchaser());
		if (oco.getFilloutPurchaser() == true) {
			oco.setpFName(obj.getpFName());
			oco.setpLName(obj.getpLName());
			oco.setEmail(obj.getEmail());
			oco.setAdd1(obj.getAdd1());
			oco.setAdd2(obj.getAdd2());
			oco.setCity(obj.getCity());
			oco.setZip(obj.getZip());
			oco.setState(obj.getState());
			oco.setPhone(obj.getPhone());
		}
		oco.setsFName(obj.getsFName());
		oco.setsLName(obj.getsLName());
		oco.setGrade(obj.getGrade());
		oco.setStudentEmail(obj.getStudentEmail());
		oco.setPrice(obj.getPrice());
		oco.setOrderTotal(obj.getPrice());
		oco.setQuan(obj.getQuan());
		oco.setName(obj.getName());
		oco.setPaymentMade(obj.getPaymentMade());
		oco.setCheck(obj.getCheck());
		oco.setpType(obj.getpType());
		oco.setcNum(obj.getcNum());
		oco.setaPaid(obj.getaPaid());
		oco.setBalStatus(obj.getBalStatus());
		oco.setBalance(obj.getBalance());
		oco.setDate(obj.getDate());
		oco.setpDate(obj.getpDate());
		oco.setaPType(obj.getaPType());
		oco.setaAPaid(obj.getaAPaid());
		oco.setnBalance(obj.getnBalance());
		return oco;
	}

	/**
	 * modifies the OCOPOJO passed in to contain unique information used in
	 * testing OCO edits.
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @param payment
	 *            : Boolean to determine if a additional payment is made. true =
	 *            make a payment, false = do not
	 * @param edit
	 *            : accepted values are "student", "purchaser" and "both".
	 *            denotes the scope of what will be edited in form section of
	 *            the order.
	 * @param pType
	 *            : type of additional payment made
	 * @param amt
	 *            : amount of additional payment
	 */
	private void createOCOEditInfo(OCOPOJO obj, Boolean payment, String edit, String pType, String amt) {
		System.out.println("createOCOEditInfo  payment 1 = " + obj.getPaymentMade());
		if (payment == true) {
			obj.setPaymentMade(true);
			setPayment(pType, amt, obj);
		}
		if (edit.equals("student")) {
			setStudent(obj);
		} else if (edit.equals("purchaser")) {
			obj.setFilloutPurchaser(true);
			setPurchaser(obj);
		} else if (edit.equals("both")) {
			obj.setFilloutPurchaser(true);
			setStudent(obj);
			setPurchaser(obj);
		}
	}

	/**
	 * used to set the information about a purchaser to be used in various OCO
	 * tests
	 * 
	 * @param oco
	 *            : OCOPOJO
	 */
	private void setPurchaser(OCOPOJO obj) {

		obj.setpFName(pg.randomFName());
		obj.setpLName(pg.randomLName());
		obj.setEmail(pg.emailGen002());
		obj.setAdd1("1234 " + pg.randomNames(5));
		obj.setAdd2(add2[randomIndex(add2)]);
		obj.setCity(city[randomIndex(city)]);
		obj.setZip(zip[randomIndex(zip)]);
		obj.setState("TX");
		obj.setPhone(pg.randomPhone());
	}

	/**
	 * used to set the student info
	 * 
	 * @param oco
	 */
	private void setStudent(OCOPOJO obj) {
		obj.setsFName(pg.randomFName());
		obj.setsLName(pg.randomLName());
		obj.setGrade(grade[randomIndex(grade)]);
		obj.setStudentEmail(pg.emailGen002());
	}

	/**
	 * used to set the payment information of an OCO
	 * 
	 * @param payType
	 *            : accepts "Check", "Cash" and "Comp"
	 * @param paid
	 *            : Amount of payment
	 * @param oco
	 *            : OCOPOJO
	 */
	private void setPayment(String payType, String paid, OCOPOJO obj) {
		if (obj.getPaymentMade() == false) {
			if (payType.equals("Check")) {
				obj.setpType("Check");
				obj.setCheck(true);
				obj.setcNum(pg.randomPhone());
			} else if (!payType.equals("Check")) {
				obj.setpType(payType);
			}
			obj.setaPType(obj.getpType());
			if (!payType.equals("Comp")) {
				obj.setaPaid(paid);
			} else if (payType.equals("Comp")) {
				obj.setaPaid("000");
			}
			int ocoprice = Integer.parseInt(obj.getPrice());
			int ocopaid = Integer.parseInt(obj.getaPaid());
			int bal = ocoprice - ocopaid;
			obj.setBalance(String.valueOf(bal));
		} else if (obj.getPaymentMade() == true) {
			if (payType.equals("Check")) {
				obj.setaPType("Check");
				obj.setCheck(true);
				obj.setcNum(pg.randomPhone());
			} else if (!payType.equals("Check")) {
				obj.setaPType(payType);
			}
			obj.setpDate(pg.curDate());
			if (!payType.equals("Comp")) {
				obj.setaAPaid(paid);
			} else if (payType.equals("Comp")) {
				obj.setaAPaid("000");
			}
			int ocoprice = Integer.parseInt(obj.getPrice());
			int ocopaid = Integer.parseInt(obj.getaPaid());
			int ocoNpaid = Integer.parseInt(obj.getaAPaid());
			int bal = ocoprice - ocopaid - ocoNpaid;
			obj.setnBalance(String.valueOf(bal));
		}
	}

	private int randomIndex(String[] array) {
		Random random = new Random();
		return random.nextInt(array.length);
	}
}