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

import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;

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
		cap.setCapability("platform", "Windows 10");
		cap.setCapability("version", "44.0");
		cap.setCapability("name", "generic test");

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
		driver.get("https://sb3-qa.balfour.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void logInTest001() throws InterruptedException {

		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal).projInfoChk();
	}
}