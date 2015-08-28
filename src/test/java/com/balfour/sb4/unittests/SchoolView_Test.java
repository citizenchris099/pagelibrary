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
import com.balfour.publishing.qa.SchoolListPOJO;
import com.balfour.publishing.qa.SchoolViewPOJO;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolListPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolViewPage;

@SuppressWarnings("unused")
public class SchoolView_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	String unameVal = "adminuser002";
	String pwordVal = "password";
	String sANum = "09660";
	String sName = "Winfield City Schools";
	String bCity = "Winfield";
	String bState = "Kansas";
	String bCountry = "United States";
	String sOffice = "Jay Elmore";
	String sStatus = "ACTIVE";
	String sRegion = "03 - South East";
	String grades = "K - 5";
	String cont00 = "Primary Tracy Noren tracy.noren@balfour.com 800-945-1699";
	String cont01 = "Secondary Jay Elmore jay.elmore@balfour-rep.com 205-444-5088";
	String addy = "BILLING ADDRESS 232 Pirate Cove Winfield, Kansas 35594, United States";
	String pr0 = null;
	String url = null;
	String url2 = null;
	Test_EnviornmentPOJO slugNAction = null;
	SchoolListPOJO sl0 = new SchoolListPOJO();
	SchoolViewPOJO sv0 = new SchoolViewPOJO();
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

		pr0 = slugNAction.getLogin();
		url = new Test_Enviornment().envUrl(pr0);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		sl0.setsNum(sANum);
		sl0.setsName(sName);
		sl0.setCity(bCity);
		sl0.setState(bState);
		sl0.setCountry(bCountry);
		sl0.setSalesO(sOffice);
		sv0.setbAdd1(addy);
		sv0.setCont0(cont00);
		sv0.setCont1(cont01);
		sv0.setGrade(grades);
		sv0.setNumber(sANum);
		sv0.setRegion(sRegion);
		sv0.setsName(sName);
		sv0.setsOffice(sOffice);
		sv0.setStatus(sStatus);

	}

	@Test
	public void SchoolViewTest003() throws InterruptedException {

		pr0 = slugNAction.getSchool_list();
		url2 = new Test_Enviornment().envUrl(pr0);
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
		driver.get(url2);
		sv1 = new Sb4SchoolListPage(driver).goToViewPage(sl0).checkSchoolView(
				false);

		System.out.println("expected hash = " + sv0.hashCode());
		System.out.println("actual hash = " + sv1.hashCode());

		if (sv1.hashCode() != sv0.hashCode()) {
			throw new RuntimeException("Hash values didn't match");
		}

	}
}
