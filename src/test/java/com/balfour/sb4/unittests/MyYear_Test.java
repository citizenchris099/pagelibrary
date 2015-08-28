package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import ch.qos.logback.core.joran.action.Action;

import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;

@SuppressWarnings("unused")
public class MyYear_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	String unameVal = "e_adviser_test";
	String pwordVal = "testBalfour!5";
	private By myYear = By
			.xpath(".//a[@href='https://studiov3.balfour.com/myyear-login/']");
	private By myYearPages = By
			.xpath(".//section[@ng-class='determineSectionClasses(sheet)']");

	private By myYearTxtTool = By.xpath(".//div[@title='Text Box']");
	private By myYearCanvas = By.xpath(".//div[@id='svgcanvas']");
	private By myYearTxtBox = By.xpath(".//div[@id='editor']");

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability("platform", "Windows 8.1");
		cap.setCapability("version", "43.0");
		cap.setCapability("name", "My Year Test");

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
		driver.get("https://studiov3.balfour.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void MyYearTest001() throws InterruptedException {

		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
		driver.findElement(myYear).click();

		List<WebElement> element = driver.findElements(myYearPages);
		element.get(5).click();

		driver.switchTo().frame("svgedit");

		driver.findElement(myYearTxtTool).click();

		driver.findElement(myYearCanvas).click();
		driver.switchTo().defaultContent();
		WebElement text = driver.findElement(myYearTxtBox);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", text);
		text.clear();
		jse.executeScript("arguments[0].click();", text);
		text.sendKeys("Hello World");
		Thread.sleep(5000);
	}
}
