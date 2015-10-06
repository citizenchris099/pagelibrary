package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.net.URL;
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
import com.balfour.publishing.qa.pages.sb4.Sb4OCOViewPage;

@SuppressWarnings("unused")
public class genericTest001 {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	String unameVal = "veggietester003";
	String pwordVal = "cOOKE1964";

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform", "OS X 10.11");
		cap.setCapability("version", "45.0");
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
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void ocoTest001() throws InterruptedException {
		OCOPOJO oco = createOCOInfo("Comp", "5999", "5999", true);
		OCOPOJO oco1 = new OCOPOJO();
		OCOPOJO oco2 = new OCOPOJO();
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal).ChangeProject2("Y50061");
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		oco1 = new Sb4OCOListPage(driver).createNewOrder().saveViewOCO(oco).getOCOInfo(oco);
		oco1.setName(oco.getsFName());
		oco1.setBalStatus(oco.getBalStatus());

		System.out.println("oco ototal = " + oco.getOrderTotal() + " oco1 ototal = " + oco1.getOrderTotal());
		System.out.println("oco bal = " + oco.getBalance() + " oco1 bal = " + oco1.getBalance());
		System.out.println("oco pt = " + oco.getpType() + " oco1 pt = " + oco1.getpType());
		System.out.println("oco ap = " + oco.getaPaid() + " oco1 ap = " + oco1.getaPaid());
		System.out.println("oco pf = " + oco.getpFName() + " oco1 pf = " + oco1.getpFName());
		System.out.println("oco pl = " + oco.getpLName() + " oco1 pl = " + oco1.getpLName());
		System.out.println("oco a1 = " + oco.getAdd1() + " oco1 a1 = " + oco1.getAdd1());
		System.out.println("oco a2 = " + oco.getAdd2() + " oco1 a2 = " + oco1.getAdd2());
		System.out.println("oco c = " + oco.getCity() + " oco1 c = " + oco1.getCity());
		System.out.println("oco s = " + oco.getState() + " oco1 s = " + oco1.getState());
		System.out.println("oco z = " + oco.getZip() + " oco1 z = " + oco1.getZip());
		System.out.println("oco p = " + oco.getPhone() + " oco1 p = " + oco1.getPhone());
		System.out.println("oco sf = " + oco.getsFName() + " oco1 sf = " + oco1.getsFName());
		System.out.println("oco sl = " + oco.getsLName() + " oco1 sl = " + oco1.getsLName());

		if (oco.hashCode() != oco1.hashCode()) {
			throw new RuntimeException("OCO Info did not match");
		}
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		oco2 = new Sb4OCOListPage(driver).viewOCO(oco1).getOCOInfo(oco);
		new Sb4OCOViewPage(driver).LogOut();
		if (oco1.hashCode() != oco2.hashCode()) {
			throw new RuntimeException("OCO Info did not match");
		}
	}

	// @Test
	public void ocoTest002() throws InterruptedException {
		OCOPOJO oco = createOCOInfo("Comp", "5999", "5099", true);
		OCOPOJO oco1 = new OCOPOJO();
		OCOPOJO oco2 = new OCOPOJO();
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal).ChangeProject2("Y50061");
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		oco1 = new Sb4OCOListPage(driver).createNewOrder().saveNewViewOCO(oco).getOCOInfo(oco);
		oco1.setName(oco.getsFName());
		oco1.setBalStatus(oco.getBalStatus());

		System.out.println("oco ototal = " + oco.getOrderTotal() + " oco1 ototal = " + oco1.getOrderTotal());
		System.out.println("oco bal = " + oco.getBalance() + " oco1 bal = " + oco1.getBalance());
		System.out.println("oco pt = " + oco.getpType() + " oco1 pt = " + oco1.getpType());
		System.out.println("oco ap = " + oco.getaPaid() + " oco1 ap = " + oco1.getaPaid());
		System.out.println("oco pf = " + oco.getpFName() + " oco1 pf = " + oco1.getpFName());
		System.out.println("oco pl = " + oco.getpLName() + " oco1 pl = " + oco1.getpLName());
		System.out.println("oco a1 = " + oco.getAdd1() + " oco1 a1 = " + oco1.getAdd1());
		System.out.println("oco a2 = " + oco.getAdd2() + " oco1 a2 = " + oco1.getAdd2());
		System.out.println("oco c = " + oco.getCity() + " oco1 c = " + oco1.getCity());
		System.out.println("oco s = " + oco.getState() + " oco1 s = " + oco1.getState());
		System.out.println("oco z = " + oco.getZip() + " oco1 z = " + oco1.getZip());
		System.out.println("oco p = " + oco.getPhone() + " oco1 p = " + oco1.getPhone());
		System.out.println("oco sf = " + oco.getsFName() + " oco1 sf = " + oco1.getsFName());
		System.out.println("oco sl = " + oco.getsLName() + " oco1 sl = " + oco1.getsLName());

		if (oco.hashCode() != oco1.hashCode()) {
			throw new RuntimeException("OCO Info did not match");
		}
		driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
		oco2 = new Sb4OCOListPage(driver).viewOCO(oco1).getOCOInfo(oco);
		if (oco1.hashCode() != oco2.hashCode()) {
			throw new RuntimeException("OCO Info did not match");
		}
	}

	// @Test
	// public void ocoTest003() throws InterruptedException {
	// OCOPOJO oco = new OCOPOJO();
	// oco.setOrderNumber("10010308");
	// oco.setBalStatus("Complimentary");
	// oco.setName("Fox");
	// new Sb4LoginPage(driver).loginAs(unameVal,
	// pwordVal).ChangeProject2("Y50061");
	// driver.get("https://sb3-qa.balfour.com/sales-orders/oncampus/");
	// System.out.println("Comp displays as "+new
	// Sb4OCOListPage(driver).viewOCO(oco).tDueComp());
	// }

	/**
	 * generates an OCOPOJO
	 * 
	 * @param payType
	 *            : String. accepted values are "Cash", "Comp", "Check"
	 * @param price
	 *            : of the item to order
	 * @param paid
	 *            : if ammount entered is less than pr
	 * @return
	 */
	private OCOPOJO createOCOInfo(String payType, String price, String paid, Boolean fulOrder) {
		Page pg = new Page(driver);
		OCOPOJO oco = new OCOPOJO();
		oco.setFilloutPurchaser(fulOrder);
		if (fulOrder == true) {
			oco.setpFName(pg.randomFName());
			oco.setpMi("L");
			oco.setpLName(pg.randomLName());
			oco.setEmail(pg.emailGen002());
			oco.setAdd1("1234 " + pg.randomNames(5));
			oco.setAdd2("apt 101");
			oco.setCity("Pirate Cove");
			oco.setZip("90210");
			oco.setState("TX");
			oco.setPhone(pg.randomPhone());

		}
		oco.setsFName(pg.randomFName());
		oco.setsMi("H");
		oco.setsLName(pg.randomLName());
		oco.setGrade("Yearbook Staff");
		oco.setStudentEmail(pg.emailGen002());

		oco.setPrice(price);
		oco.setOrderTotal(oco.getPrice());

		oco.setQuan("1");
		oco.setName(oco.getsFName());
		oco.setPaymentMade(false);
		oco.setCheck(false);
		if (payType.equals("Check")) {
			oco.setpType("Check");
			oco.setCheck(true);
			oco.setcNum("987456");
			oco.setaPaid(paid);
		} else if (payType.equals("Cash")) {
			oco.setpType("Cash");
			oco.setaPaid(paid);
		} else if (payType.equals("Comp")) {
			oco.setpType("Comp");
			oco.setaPaid("000");
		}

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

	private OCOPOJO createOCOEditInfo(OCOPOJO obj, Boolean payment, String edit) {
		Page pg = new Page(driver);
		if (payment == true) {
			obj.setPaymentMade(true);
			obj.setaPType("Cash");
			obj.setaAPaid("5000");
			int ocoprice = Integer.parseInt(obj.getPrice());
			int ocopaid = Integer.parseInt(obj.getaPaid());
			int ocoNpaid = Integer.parseInt(obj.getaAPaid());
			int bal = ocoprice - ocopaid - ocoNpaid;
			obj.setBalance(String.valueOf(bal));
		}
		if (edit.equals("student")) {
			obj.setsFName(pg.randomFName());
			obj.setsMi("P");
			obj.setsLName(pg.randomLName());

		} else if (edit.equals("purchaser")) {
			obj.setpFName(pg.randomFName());
			obj.setpMi("K");
			obj.setpLName(pg.randomLName());
		}

		return obj;
	}
}