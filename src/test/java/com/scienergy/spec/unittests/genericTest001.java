package com.scienergy.spec.unittests;

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

import com.scienergy.development.qa.pages.spec.RndStringUtil;
import com.scienergy.development.qa.pages.spec.SpecLoginPage;
import com.scienergy.development.qa.pages.spec.SpecMainPage;

public class genericTest001 {

	WebDriver driver;
	RndStringUtil randomString = new RndStringUtil();
	private String username = "wr";
	private String password = "wr";
	private String uNFerror = "User not found";
	private String IPerror = "Incorrect password";
	String[] labels = { randomString.Random2Word(), randomString.Random2Word(), randomString.Random2Word(),
			randomString.Random2Word() };
	String[] summary = { randomString.RandomUName() };
	String[] description = { randomString.RandomUName() };
	String[] location = { randomString.RandomUName() };
	String[] assignee = { "Wilford Reich" };
	String[] date = { "2015-12-25" };

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
		new SpecLoginPage(driver).loginAs(username, password).showAddTask().enterLocation(location).enterDate(date)
				.enterSummary(summary).enterDescripton(description).enterLabel(labels).enterAssignee(assignee)
				.clickCreate().hideAddTask().search(summary[0]).selectTaskInQueue(summary[0]).chooseEditTaskStatus(1)
				.blockOrCancelTask("block").alert("accept").checkTaskBlocked();
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