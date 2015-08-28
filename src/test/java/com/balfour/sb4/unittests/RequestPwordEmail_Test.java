package com.balfour.sb4.unittests;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.SshUtil;

public class RequestPwordEmail_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	SshUtil sshUtil;
	String emailVal = "brainysmurf099@gmail.com";
	String badEmailVal = "madeup@mail.com";
	String unameVal = "VeggieAdviser";
	String pwordVal = "tofuisgreat";
	String ip = "10.90.31.223";
	String authusr = "ec2-user";
	String cmd = "rm /var/www/html/wp-content/plugins/b4helper/logs/email.log";
	String cmd1 = "ls /var/www/html/wp-content/plugins/b4helper/logs/email.log";
	String msg1 = "Password Reset Sent";
	String msg2 = "Email Not Found";

	@BeforeSuite
	public void setup() {
		driver = new FirefoxDriver();
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() {
		driver.get("https://sb3-qa.balfour.com/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void requestPwordEmail_Test() throws IOException,
			URISyntaxException, InterruptedException {

		new Sb4LoginPage(driver).delEmailLogFile(ip, authusr, cmd)
				.go2ResetPword().setEmail(emailVal).requestPwordEmail(msg1)
				.chkEmailLogFile(ip, authusr, cmd1);

	}
	
	@Test
	public void requestPwordBadEmail_Test() throws IOException,
			URISyntaxException, InterruptedException {

		new Sb4LoginPage(driver).delEmailLogFile(ip, authusr, cmd)
				.go2ResetPword().setEmail(badEmailVal).requestPwordEmail(msg2)
				.delEmailLogFile(ip, authusr, cmd1);

	}

}
