package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.scienergy.development.qa.pages.spec.SpecLoginPage;

public class genericTest001 {

	WebDriver driver;
	private String username = "wr";
	private String password = "wr";

	@BeforeSuite
	public void setup() throws MalformedURLException {
		driver = new FirefoxDriver();
		// DesiredCapabilities cap = DesiredCapabilities.firefox();
		// cap.setCapability("platform", "Windows 7");
		// cap.setCapability("version", "40.0");
		// cap.setCapability("name", "OCO test");
		//
		// driver = new RemoteWebDriver(
		// new
		// URL("http://citizenchris:a8f0eeb8-bb02-4788-b6d1-3680f480930c@ondemand.saucelabs.com:80/wd/hub"),
		// cap);

		// ((FirefoxDriver) driver).setFileDetector(new LocalFileDetector());
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() {
		driver.get("http://tasking.scienergydev.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void ocoTest003() throws InterruptedException {
		new SpecLoginPage(driver).loginAs(username, password);
	}

}