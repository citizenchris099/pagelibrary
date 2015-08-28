package com.balfour.sb4.unittests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.Test_EnviornmentPOJO;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4ShopPage;

public class Supplies_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	String unameVal = "veggie_smurf";
	String pwordVal = "meatisevil";
	String value = "/shop/?add-to-cart=433";
	Test_EnviornmentPOJO slugNAction = new Test_Enviornment().slugNAction();
	String prod001 = slugNAction.getProd001();
	String value2 = new Test_Enviornment().envUrl(prod001);
	String value3 = "Flying Ninja";

	@BeforeSuite
	public void setup() {
		driver = new FirefoxDriver();
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() throws InterruptedException {
		driver.get("https://sb3-qa.balfour.com/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		new Sb4LoginPage(driver).loginAs(unameVal, pwordVal);
	}

	@Test
	public void supplies_test001() throws InterruptedException {

		driver.get("https://sb3-qa.balfour.com/shop/");
		new Sb4ShopPage(driver).ClickAdd2Cart(value, value2)
				.rmwOnlyItem(value3);
	}
}
