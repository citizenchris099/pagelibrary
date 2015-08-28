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
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4OCOListPage;
import com.balfour.publishing.qa.pages.sb4.Sb4OCOPage;
import com.balfour.publishing.qa.pages.sb4.Sb4OCOViewPage;

@SuppressWarnings("unused")
public class OnCampusOrders_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	String unameVal = "veggietester004";
	String pwordVal = "Welles113*";
	String school = "2015 Henderson High School";
	String state = "Arkansas";
	String country = "United States";
	String gd1 = "4";
	String gd2 = "5";
	String gd3 = "6";
	String gd4 = "7";
	String product = "l33t Yearbook";
	String prod1 = ".0.0.$YB56803.2.0.1";
	String prod2 = ".0.0.$687523.2.0.1";
	String prod3 = ".0.0.$PERSPACKAGE2845.2.0.1";
	String icon3 = "YB56803-3";
	String icon1Text = "American";
	String price = "101.51";
	String seniorPrice = "116.47";
	String paid = "19";
	String balance = "300.49";

	String pFName = "David";
	String pMi = "R";
	String pLName = "Jones";
	String email = "dbowie@ziggy.com";
	String add1 = "4658 Rock Star Ln";
	String add2 = "";
	String city = "London";
	String zip = "90210";
	String phone = "8675309";
	String sFName = "Ziggy";
	String sMi = "";
	String sLName = "Stardust";
	String grade = "7";
	String orderTotal = "1036.31";
	String pType = "Check";
	String aPaid = "100";
	String cNum = "00120564";
	String pId = ".0.0.1:$PERSPACKAGE=111106.2.0.1";
	String pQ = "2";
	String total = "120.00";
	String bal = "120.00";
	Boolean check = true;

	OCOPOJO oco0 = null;

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 8.1");
		caps.setCapability("version", "43.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("tags", new String[] { "Chrome", "43.0",
				"Windows 8.1" });
		caps.setCapability("name", "On Campus Orders Test");

		driver = new RemoteWebDriver(
				new URL(
						"http://citizenchris:a8f0eeb8-bb02-4788-b6d1-3680f480930c@ondemand.saucelabs.com:80/wd/hub"),
				caps);

		// ((FirefoxDriver) driver).setFileDetector(new LocalFileDetector());
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() {
		driver.get("https://sb3-qa.balfour.com/dashboard/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void onCampusTest003() throws InterruptedException {

		oco0 = new OCOPOJO();
		oco0.setpFName(pFName);
		oco0.setpMi(pMi);
		oco0.setpLName(pLName);
		oco0.setEmail(email);
		oco0.setAdd1(add1);
		oco0.setAdd2(add2);
		oco0.setCity(city);
		oco0.setState(state);
		oco0.setZip(zip);
		oco0.setCountry(country);
		oco0.setPhone(phone);
		oco0.setsFName(sFName);
		oco0.setsMi(sMi);
		oco0.setsLName(sLName);
		oco0.setGrade(grade);
		oco0.setOrderTotal(orderTotal);
		oco0.setBalance(balance);
		oco0.setpType(pType);
		oco0.setaPaid(aPaid);
		oco0.setcNum(cNum);
		oco0.setCheck(check);
		oco0.setpQuanId(pId);
		oco0.setpQuanVal(pQ);
		oco0.setBalance(bal);
		oco0.setOrderTotal(total);

		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
		driver.get("https://sb3-qa.balfour.com/oncampus/");
		System.out.println("Order Date = "+new Sb4OCOListPage(driver).createNewOrder().minimumOrder(oco0).oDate());
		System.out.println("Current Date = "+new Sb4OCOViewPage(driver).curDate());
		new Sb4OCOViewPage(driver).checODate();
		System.out.println("Payment Type = "+new Sb4OCOViewPage(driver).pType());
		System.out.println("Amount Paid = "+new Sb4OCOViewPage(driver).aPaid());
		System.out.println("Order Total = "+new Sb4OCOViewPage(driver).oTotal());
		System.out.println("Total Due = "+new Sb4OCOViewPage(driver).tDue());
		System.out.println("purchaser = "+new Sb4OCOViewPage(driver).getPurchaser());
		System.out.println("student = "+new Sb4OCOViewPage(driver).getStudent());
		System.out.println("order number = "+new Sb4OCOViewPage(driver).getOnum());
	}
}