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

import com.balfour.publishing.qa.ProjConfigPOJO;
import com.balfour.publishing.qa.SchoolConfigPOJO;
import com.balfour.publishing.qa.SchoolListPOJO;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolConfigPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolListPage;

@SuppressWarnings("unused")
public class SchoolList_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	String unameVal = "q4user002";
	String pwordVal = "q4user";
	String sANum = "09660";
	String sName = "Winfield City Schools";
	String bCity = "Winfield";
	String bState = "Kansas";
	String bCountry = "United States";
	String sOffice = "Test Office";
	int oHash = -709071760;

	Boolean sAB = false;

	ProjConfigPOJO fp1 = new ProjConfigPOJO();

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 8");
		caps.setCapability("version", "40.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("tags",
				new String[] { "Chrome", "40.0", "Windows 8" });
		caps.setCapability("name", "School List Test");

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
	public void testSetUp() throws InterruptedException {
		driver.get("https://sb3-qa.balfour.com/dashboard/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
		driver.get("https://sb3-qa.balfour.com/school_list/");
	}

//	@Test
//	public void schoolList_Test001() throws Exception {
//
//		new Sb4SchoolListPage(driver).searchByNumber(sANum);
//		SchoolConfigPOJO sc4 = new Sb4SchoolConfigPage(driver).checkSConfig002();
//
//		System.out.println(sc4.hashCode());
//		System.out.println(oHash);
//		if (sc4.hashCode() != oHash) {
//			throw new RuntimeException("Hash values didn't match");
//		}
//
//		new Sb4SchoolConfigPage(driver).LogOut();
//
//	}
//
////	@Test
//	public void schoolList_Test002() throws Exception {
//
//		new Sb4SchoolListPage(driver).noSearch("21795");
//
//	}
//	
////	@Test
//	public void schoolList_Test003() throws Exception {
//
//		new Sb4SchoolListPage(driver).searchByName(sName, sANum);
//		SchoolConfigPOJO sc4 = new Sb4SchoolConfigPage(driver).checkSConfig002();
//
//		System.out.println(sc4.hashCode());
//		System.out.println(oHash);
//		if (sc4.hashCode() != oHash) {
//			throw new RuntimeException("Hash values didn't match");
//		}
//
//		new Sb4SchoolConfigPage(driver).LogOut();
//
//	}
//	
//	@Test
//	public void schoolList_Test004() throws Exception {
//		
//		SchoolListPOJO sl0 = new SchoolListPOJO();
//		sl0.setsNum(sANum);
//		sl0.setsName(sName);
//		sl0.setCity(bCity);
//		sl0.setState(bState);
//		sl0.setCountry(bCountry);
//		sl0.setSalesO(sOffice);
//
//		new Sb4SchoolListPage(driver).fullSearch(sl0);
//		SchoolConfigPOJO sc4 = new Sb4SchoolConfigPage(driver).checkSConfig002();
//
//		System.out.println(sc4.hashCode());
//		System.out.println(oHash);
//		if (sc4.hashCode() != oHash) {
//			throw new RuntimeException("Hash values didn't match");
//		}
//
//		new Sb4SchoolConfigPage(driver).LogOut();
//
//	}
}
