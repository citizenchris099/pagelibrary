package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.scienergy.development.qa.pages.spec.SpecLoginPage;
import com.scienergy.development.qa.pages.spec.SpecMainPage;

public class genericTest001 {

	WebDriver driver;
	private String username = "wr";
	private String password = "wr";
	private String uNFerror = "User not found";
	private String IPerror = "Incorrect password";
	String[] labels = { "James", "Larry", "Tom", "Lacy" };

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform", "OS X 10.11");
		cap.setCapability("version", "46.0");
		cap.setCapability("name", "Spec Test");

		driver = new RemoteWebDriver(
				new URL("http://SCIenergyChris:72c2a9c3-9d7e-462c-bb46-9b5626fd903d@ondemand.saucelabs.com:80/wd/hub"),
				cap);

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
	public void loginTest001() throws InterruptedException {
		new SpecLoginPage(driver).loginAs(username, password).showAddTask().enterLocation("Test")
				.enterDate("2015-12-25").enterSummary("awesome sauce").enterDescripton("this sauce is awesome")
				.enterLabel(labels).enterAssignee("Wilford Reich").hideAddTask();
	}

	// @Test
	public void loginTest002() throws InterruptedException {
		new SpecLoginPage(driver).loginAs("rw", password, uNFerror);
	}

	// @Test
	public void loginTest003() throws InterruptedException {
		new SpecLoginPage(driver).loginAs(username, "rw", IPerror);
	}

}