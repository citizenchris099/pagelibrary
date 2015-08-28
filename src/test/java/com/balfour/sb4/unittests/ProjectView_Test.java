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
import com.balfour.publishing.qa.ProjectViewPOJO;
import com.balfour.publishing.qa.SchoolConfigPOJO;
import com.balfour.publishing.qa.SchoolListPOJO;
import com.balfour.publishing.qa.ProjConfigPOJO;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4ProjectConfigPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolConfigPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolListPage;
import com.balfour.publishing.qa.pages.sb4.Sb4SchoolViewPage;

@SuppressWarnings("unused")
public class ProjectView_Test {

	WebDriver driver;
	String oPName = "2015 Winfield City Schools";
	String oStatus = "Active";
	String oEnrollment = "8000";
	String oDSeason = "Summer";
	String oAdv = "Dawn Guin";
	String oRep = "Jay Elmore";
	String oAe = "Tracy Noren";
	String mYear = "2015";
	String mPName = "2015 Pirate City School";
	String mStatus = "Free";
	String mEnrollment = "9000";
	String mDSeason = "Fall";
	String mAdv = "Ana Rookstool";
	String mRep = "Amanda Reynolds";
	String mAe = "Alissa Konecny";
	String unameVal = "adminuser001";
	String pwordVal = "password";
	Boolean homeroom = true;
	Boolean teacher = false;
	String url = null;
	String url2 = null;
	Test_EnviornmentPOJO slugNAction = null;
	ProjectViewPOJO pv0 = null;
	ProjectViewPOJO pv1 = null;

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

		String login = slugNAction.getLogin();
		url = new Test_Enviornment().envUrl(login);
		String config = slugNAction.getProject_config();
		url2 = new Test_Enviornment().envUrl(config);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void SchoolViewTest003() throws InterruptedException {

		new Sb4LoginPage(driver).loginAsAdmin(unameVal, pwordVal);
		driver.get(url2);

		ProjConfigPOJO pc0 = new ProjConfigPOJO();
		ProjConfigPOJO pc1 = new ProjConfigPOJO();
		pc0.setYear(mYear);
		pc0.setProjName(mPName);
		pc0.setStatus(mStatus);
		pc0.setEnrollment(mEnrollment);
		pc0.setdSeason(mDSeason);
		pc0.setAdviser(mAdv);
		pc0.setAe(mAe);
		pc0.setRep(mRep);
		pc0.setTeacher(teacher);
		pc0.setHomeroom(homeroom);
		pc1.setYear(mYear);
		pc1.setProjName(oPName);
		pc1.setStatus(oStatus);
		pc1.setEnrollment(oEnrollment);
		pc1.setdSeason(oDSeason);
		pc1.setAdviser(oAdv);
		pc1.setAe(oAe);
		pc1.setRep(oRep);
		pc1.setTeacher(teacher);
		pc1.setHomeroom(homeroom);

		pv0 = new Sb4ProjectConfigPage(driver).successfulUpDate(pc0).checkProjView(false);

		System.out.println("mod hash = "+pv0.hashCode());

		driver.get(url2);

		pv1 = new Sb4ProjectConfigPage(driver).successfulUpDate(pc1).checkProjView(false);

		System.out.println("original hash = "+pv1.hashCode());

	}
}
