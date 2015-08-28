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

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.Test_EnviornmentPOJO;
import com.balfour.publishing.qa.SchoolConfigPOJO;
import com.balfour.publishing.qa.SchoolListPOJO;
import com.balfour.publishing.qa.SchoolViewPOJO;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolConfigPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolListPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolViewPage;

@SuppressWarnings("unused")
public class SchoolView_Test002 {

	WebDriver driver;
	String unameVal = "adminuser001";
	String pwordVal = "password";
	String mSchoolN = "Pirate City Schools";
	String mBAdd1 = "323 Pirate Cove";
	String mCity = "Pirate City";
	String mState = "23";
	String mZip = "90210";
	String mRegion = "04 - Texas/Louisiana";
	String mSalesO = "Abby Jane Herberg";
	String mGrade1 = "5";
	String mGrade2 = "6";
	String mGrade3 = "7";
	String mGrade4 = "8";
	String mGrade5 = "9";
	String Country = "United States";
	String oCont00 = "Mike Cobb";
	String oCont01 = "Janey Garrison";
	String oSchoolN = "Sample High School";
	String oBAdd1 = "232 Pirate Cove";
	String oCity = "Nowhereville";
	String oState = "17";
	String oZip = "35594";
	String oRegion = "03 - South East";
	String oSalesO = "Jay Elmore";
	String oGrade1 = "Kindergarten";
	String oGrade2 = "1";
	String oGrade3 = "2";
	String oGrade4 = "3";
	String oGrade5 = "4";
	String url = null;
	String url2 = null;
	Test_EnviornmentPOJO slugNAction = null;
	SchoolViewPOJO sv0 = null;
	SchoolViewPOJO sv1 = null;

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform", "Windows 8.1");
		cap.setCapability("version", "40.0");
		cap.setCapability("name", "school view Test");

		driver = new RemoteWebDriver(
				new URL(
						"http://citizenchris:a8f0eeb8-bb02-4788-b6d1-3680f480930c@ondemand.saucelabs.com:80/wd/hub"),
				cap);

		// ((FirefoxDriver) driver).setFileDetector(new LocalFileDetector());
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() {
		slugNAction = new Test_Enviornment().slugNAction();

		String login = slugNAction.getLogin();
		url = new Test_Enviornment().envUrl(login);
		String config = slugNAction.getSchool_config();
		url2 = new Test_Enviornment().envUrl(config);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void SchoolViewTest003() throws InterruptedException {

		new Sb4LoginPage(driver).loginAsAdmin(unameVal, pwordVal);
		driver.get(url2);

		SchoolConfigPOJO sc0 = new SchoolConfigPOJO();
		SchoolConfigPOJO sc1 = new SchoolConfigPOJO();
		sc0.setbAdd1(mBAdd1);
		sc0.setbAdd2("");
		sc0.setbCity(mCity);
		sc0.setbCountry(Country);
		sc0.setbState(mState);
		sc0.setbZip(mZip);
		sc0.setCont0(oCont01);
		sc0.setCont1(oCont00);
		sc0.setGrade01(mGrade1);
		sc0.setGrade02(mGrade2);
		sc0.setGrade03(mGrade3);
		sc0.setGrade04(mGrade4);
		sc0.setGrade05(mGrade5);
		sc0.setGrade06(oGrade1);
		sc0.setGrade07(oGrade2);
		sc0.setGrade08(oGrade3);
		sc0.setGrade09(oGrade4);
		sc0.setGrade10(oGrade5);
		sc0.setRegion(mRegion);
		sc0.setsOffice(mSalesO);
		sc0.setsName(mSchoolN);
		sc0.setsAB(true);

		sc1.setbAdd1(oBAdd1);
		sc1.setbAdd2("");
		sc1.setbCity(oCity);
		sc1.setbCountry(Country);
		sc1.setbState(oState);
		sc1.setbZip(oZip);
		sc1.setCont0(oCont00);
		sc1.setCont1(oCont01);
		sc1.setGrade01(oGrade1);
		sc1.setGrade02(oGrade2);
		sc1.setGrade03(oGrade3);
		sc1.setGrade04(oGrade4);
		sc1.setGrade05(oGrade5);
		sc1.setGrade06(mGrade1);
		sc1.setGrade07(mGrade2);
		sc1.setGrade08(mGrade3);
		sc1.setGrade09(mGrade4);
		sc1.setGrade10(mGrade5);
		sc1.setRegion(oRegion);
		sc1.setsOffice(oSalesO);
		sc1.setsName(oSchoolN);
		sc1.setsAB(true);

		sv0 = new Sb4SchoolConfigPage(driver).successfulUpDate(sc0, false)
				.checkSchoolView(true);

		System.out.println("mod hash = "+sv0.hashCode());

		driver.get(url2);

		sv1 = new Sb4SchoolConfigPage(driver).successfulUpDate(sc1, false)
				.checkSchoolView(true);

		System.out.println("original hash = "+sv1.hashCode());

	}
}
