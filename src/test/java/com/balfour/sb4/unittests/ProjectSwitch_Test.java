package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4NewUserReg;
import com.balfour.publishing.qa.pages.sb4.Sb4NewUserRegProf;

public class ProjectSwitch_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	Sb4NewUserReg sb4NewUserReg;
	Sb4NewUserRegProf sb4NewUserRegProf;
	String unameVal = "q4user001";
	String unameVal2 = "q4user002";
	String pwordVal = "q4user";
	String mainProj = "2014 Baker Elementary School";
	String nextProj = "2015 Elbert Palmer Elementary";
	String mainProj2 = "2013 Washington Middle School";
	String nextProj2 = "2016 The Yellow School";
	

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 8");
		caps.setCapability("version", "40.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("tags",
				new String[] { "Chrome", "40.0", "Windows 8" });
		caps.setCapability("name", "Project Switch Test");

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
	public void testSetUp() throws MalformedURLException {

		driver.get("https://sb3-qa.balfour.com/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
//	public void projSwitch001() throws InterruptedException {
//
//		new Sb4LoginPage(driver)
//		.loginAs(unameVal, pwordVal)
//		.ChangeProject(mainProj, nextProj)
//		.LogOut()
//		.loginAs(unameVal, pwordVal)
//		.ChangeProject(nextProj, mainProj)
//		.LogOut();
//	}
	
	@Test
	public void projSwitch002() throws InterruptedException {

		new Sb4LoginPage(driver)
		.loginAs(unameVal2, pwordVal)
		.ChangeProject2(mainProj2, nextProj2)
		.LogOut()
		.loginAs(unameVal2, pwordVal)
		.ChangeProject2(nextProj2, mainProj2)
		.LogOut();
	}

}
