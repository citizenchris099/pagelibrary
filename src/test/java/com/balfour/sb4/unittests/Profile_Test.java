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

import com.balfour.publishing.qa.AdminProfilePOJO;
import com.balfour.publishing.qa.ProfilePOJO;
import com.balfour.publishing.qa.pages.sb4.RestUtil;
import com.balfour.publishing.qa.pages.sb4.Sb4AdminUserProfPage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4ProfilePage;

public class Profile_Test {

	WebDriver driver;
	Sb4AdminUserProfPage adminpro;
	RestUtil ru;
	String unameVal = "veggie_smurf";
	String pwordVal = "meatisevil";
	String email = "veggie_smurf@smurf.com";
	String admUname = "balfouradmin";
	String admPwrd = "Bal4Pass";
	String user = "veggie_smurf";
	String nEmailVal = "veggiesmurf@smurf.com";
	String bEmailVal = "citizenchris099@gmail.com";
	String nFNameVal = "Vegtastic";
	String nLNameVal = "Smurfins";
	String nPhoneVal = "7170023";
	String nDNameVal = "Veggie_Smurf";
	String nFBookVal = "VegtasticFBook";
	String nGoogleVal = "VeggieGoogle2";
	String nYahooVal = "VeggieYahoo2";
	String nTwitterVal = "VeggieTwitter2";
	String nLinkedinVal = "VeggieLinked2";
	String nPinVal = "VeggiePin2";
	String nInstaVal = "VeggieInsta2";
	String error = "is already taken. Please try again.";
	String successmsg = "Your profile information has been updated";
	String userUuid = "f0fd9d994dfe40dd871da403638f98a3";
	String enfoldUrl = "http://10.90.31.54:8000/users/";
	ProfilePOJO pr0 = null;
	ProfilePOJO pr1 = null;
	ProfilePOJO pr2 = null;
	ProfilePOJO pr3 = null;
	AdminProfilePOJO ap0 = null;
	AdminProfilePOJO ap1 = null;
	AdminProfilePOJO ap2 = null;
	AdminProfilePOJO ap3 = null;

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 8");
		caps.setCapability("version", "40.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("tags",
				new String[] { "Chrome", "40.0", "Windows 8" });
		caps.setCapability("name", "Profile Test");

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
	public void testSetUp() throws InterruptedException {
		driver.get("https://sb3-qa.balfour.com/dashboard/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void profileTest001() throws InterruptedException {

		ru = new RestUtil();
		pr0 = new Sb4LoginPage(driver).loginAs(unameVal, pwordVal)
				.GoToMyProfile().checkProfile();
		ap0 = new Sb4ProfilePage(driver).LogOut()
				.loginAsAdmin(admUname, admPwrd).GoToUserPage()
				.Go2UserProf(unameVal).checkAdminUProfile();

		pr1 = new ProfilePOJO();
		pr1.setuName(unameVal);
		pr1.setEmail(nEmailVal);
		pr1.setfName(nFNameVal);
		pr1.setlName(nLNameVal);
		pr1.setPhone(nPhoneVal);
		pr1.setdName(nDNameVal);
		pr1.setfBook(nFBookVal);
		pr1.setGoogle(nGoogleVal);
		pr1.setYahoo(nYahooVal);
		pr1.setTwitter(nTwitterVal);
		pr1.setLinkedin(nLinkedinVal);
		pr1.setPinterest(nPinVal);
		pr1.setInstagram(nInstaVal);

		ap1 = new AdminProfilePOJO();
		ap1.setuName(unameVal);
		ap1.setEmail(nEmailVal);
		ap1.setfName(nFNameVal);
		ap1.setlName(nLNameVal);
		ap1.setdName(nDNameVal);
		ap1.setfBook(nFBookVal);
		ap1.setGoogle(nGoogleVal);
		ap1.setYahoo(nYahooVal);
		ap1.setTwitter(nTwitterVal);
		ap1.setLinkedin(nLinkedinVal);
		ap1.setPinterest(nPinVal);
		ap1.setInstagram(nInstaVal);

		new Sb4AdminUserProfPage(driver).adminLogOut()
				.loginAs(unameVal, pwordVal).GoToMyProfile()
				.successfullUpdate(pr1).GoHome().GoToMyProfile();

		pr2 = new Sb4ProfilePage(driver).checkProfile();

		System.out.println(pr1.hashCode());
		System.out.println(pr2.hashCode());

		if (pr1.hashCode() != pr2.hashCode()) {
			throw new RuntimeException("FE Hash values didn't match");
		}

		ru.enfoldCheck(enfoldUrl, userUuid, "user.email", nEmailVal);

		ap2 = new Sb4ProfilePage(driver).LogOut()
				.loginAsAdmin(admUname, admPwrd).GoToUserPage()
				.Go2UserProf(unameVal).checkAdminUProfile();

		System.out.println(ap1.hashCode());
		System.out.println(ap2.hashCode());

		if (ap1.hashCode() != ap2.hashCode()) {
			throw new RuntimeException("BE Hash values didn't match");
		}

		new Sb4AdminUserProfPage(driver).adminLogOut()
				.loginAs(unameVal, pwordVal).GoToMyProfile()
				.successfullUpdate(pr0).GoHome().GoToMyProfile();

		pr3 = new Sb4ProfilePage(driver).checkProfile();

		System.out.println(pr0.hashCode());
		System.out.println(pr3.hashCode());

		if (pr0.hashCode() != pr3.hashCode()) {
			throw new RuntimeException("FE Hash values didn't match");
		}

		ru.enfoldCheck(enfoldUrl, userUuid, "user.email", email);

		ap3 = new Sb4ProfilePage(driver).LogOut()
				.loginAsAdmin(admUname, admPwrd).GoToUserPage()
				.Go2UserProf(unameVal).checkAdminUProfile();

		System.out.println(ap0.hashCode());
		System.out.println(ap3.hashCode());

		if (ap0.hashCode() != ap3.hashCode()) {
			throw new RuntimeException("BE Hash values didn't match");
		}

	}

}
