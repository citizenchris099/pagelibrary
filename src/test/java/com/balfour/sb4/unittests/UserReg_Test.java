package com.balfour.sb4.unittests;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.balfour.publishing.TestPOJO;
import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.Test_EnviornmentPOJO;
import com.balfour.publishing.qa.ProjConfigPOJO;
import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4NewUserReg;
import com.balfour.publishing.qa.pages.sb4.Sb4NewUserRegProf;
import com.balfour.publishing.qa.pages.sb4.Sb4ProjectConfigPage;
import com.balfour.publishing.qa.pages.sb4.Sb4ProjectUserPage;
import com.balfour.publishing.qa.pages.sb4.Sb4ProjectViewPage;
import com.balfour.publishing.qa.pages.sb4.Sb4RegisterPage;

public class UserReg_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	Sb4NewUserReg sb4NewUserReg;
	Sb4NewUserRegProf sb4NewUserRegProf;
	Page pg;
	UserRegPOJO ur0 = null;
	ProjConfigPOJO pc0 = null;
	TestPOJO tp0 = null;
	Test_EnviornmentPOJO slugNAction = new Test_Enviornment().slugNAction();
	String closed = "Project Registration Closed";
	String badPass = "Invalid Project Password";

	@BeforeSuite
	public void setup() throws MalformedURLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 8");
		caps.setCapability("version", "40.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("tags",
				new String[] { "Chrome", "40.0", "Windows 8" });
		caps.setCapability("name", "User Admin Test");

		driver = new RemoteWebDriver(
				new URL(
						"http://citizenchris:a8f0eeb8-bb02-4788-b6d1-3680f480930c@ondemand.saucelabs.com:80/wd/hub"),
				caps);

		// ((FirefoxDriver) driver).setFileDetector(new LocalFileDetector());
		pg = new Page(driver);
		pc0 = new ProjConfigPOJO();
		pc0.setEnrollment(new Page(driver).randomPhone());
		pc0.setYear("2016");
		pc0.setProjName("2016 IT MyYear Test Account");
		pc0.setStatus("Free");
		pc0.setdSeason("Fall");
		pc0.setAdviser("veggie tester007");
		pc0.setAe("veggie tester004");
		pc0.setRep("veggie tester006");
		pc0.setTeacher(true);
		pc0.setHomeroom(false);
		pc0.setrPWord("password");
		pc0.setProject("Y50061");

		ur0 = new UserRegPOJO();
		ur0.setfName(pg.randomFName());
		ur0.setlName(pg.randomLName());
		ur0.setEmail(pg.emailGen002());
		ur0.setProject("Y50061");
		ur0.setMsg("Your profile information has been created");
		ur0.setoMsg("Please check your email");
		ur0.setPhone(pg.randomPhone());
		ur0.setuName(ur0.getEmail());
		ur0.setPword(pg.randomPass());
		ur0.setStatement("SELECT user_register_key FROM b4pub.user_register where user_register_email = ?");
		ur0.setDb_url("jdbc:mysql://pub-constellation-qa-db-01.ckdfohchwkze.us-east-1.rds.amazonaws.com:3306/b4pub");
		ur0.setDb_username("vpc_dbuser");
		ur0.setDb_pword("prat0ri0n");
		ur0.setDb_reg_key("user_register_key");
		ur0.setRole("approved");

		tp0 = new TestPOJO();
		tp0.setSbLogOnUrl(new Test_Enviornment().envUrl(slugNAction.getLogin()));
		tp0.setSbRegUrl(new Test_Enviornment().envUrl(slugNAction.getRegister()));
		tp0.setSbPUUrl(new Test_Enviornment().envUrl(slugNAction
				.getProject_users()));
		tp0.setSbProjConf(new Test_Enviornment().envUrl(slugNAction
				.getProject_config()));
		tp0.setAdminUName("veggie_administrator");
		tp0.setAdminPword("cOOKE1964");
		tp0.setAdvUname("veggietester007");
		tp0.setAdvPword("Welles113*");
		tp0.setMiscUname001("veggietester003");
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() throws MalformedURLException {

		driver.get(tp0.getSbLogOnUrl());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void userAdminTest001() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		new Sb4LoginPage(driver).loginAs(tp0.getMiscUname001(),
				tp0.getAdvPword());

		driver.get(tp0.getSbProjConf());
		driver.get(setRegType("Invite Only", pc0, tp0));
		driver.get(openReg("Invite Only", ur0, pc0));
		new Sb4NewUserRegProf(driver).doReg(ur0, false);
		userLogin(ur0);
		userSearch(ur0, tp0);
		userCleanUp(ur0, tp0);

	}

	@Test
	public void userAdminTest002() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		new Sb4LoginPage(driver).loginAs(tp0.getMiscUname001(),
				tp0.getAdvPword());

		driver.get(tp0.getSbProjConf());
		driver.get(setRegType("Password Only", pc0, tp0));
		
		negativeReg("Password Only", badPass, ur0, pc0);

	}

	private String setRegType(String type, ProjConfigPOJO obj, TestPOJO obj1)
			throws InterruptedException {
		String reg = null;
		String regUrl = obj1.getSbRegUrl() + obj.getProject();
		obj.setrType(type);
		if (obj.getrType().equals("Password Only")) {
			reg = new Sb4ProjectConfigPage(driver).successfulUpDate(obj)
					.getRegType();
			System.out.println("Your RType is displaying as " + reg);
		} else if (type.equals("Invite Only")) {
			reg = new Sb4ProjectConfigPage(driver).successfulUpDate(obj)
					.getRegType();
			regUrl = new Sb4ProjectViewPage(driver).getInviteUrl();
		} else
			reg = new Sb4ProjectConfigPage(driver).successfulUpDate(obj)
					.getRegType();

		String[] array = obj.getrType().trim().split(" ");
		String typeSplit = array[0].trim();

		System.out.println("your split type = " + typeSplit);

		if (!reg.equals(typeSplit)) {
			throw new RuntimeException(
					"Registration Type is not dispalying correctly");
		}
		System.out.println("Your RType is displaying as " + reg);
		new Sb4ProjectViewPage(driver).LogOut();

		return regUrl;
	}

	private String openReg(String type, UserRegPOJO obj, ProjConfigPOJO obj2)
			throws InterruptedException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		obj2.setrType(type);
		return new Sb4RegisterPage(driver).registerUser(obj, obj2);
	}

	private void userLogin(UserRegPOJO obj) throws InterruptedException {
		driver.get(tp0.getSbLogOnUrl());
		new Sb4LoginPage(driver).loginAs(obj.getEmail(), obj.getPword())
				.LogOut();
	}

	private void userSearch(UserRegPOJO obj, TestPOJO obj1)
			throws InterruptedException {
		driver.get(obj1.getSbLogOnUrl());
		new Sb4LoginPage(driver)
				.loginAs(obj1.getAdvUname(), obj1.getAdvPword());
		driver.get(obj1.getSbPUUrl());
		if (new Sb4ProjectUserPage(driver).userSearchCount(obj) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		new Sb4ProjectUserPage(driver).LogOut();

	}

	private void userCleanUp(UserRegPOJO obj, TestPOJO obj1)
			throws InterruptedException {
		driver.get(obj1.getSbLogOnUrl());
		new Sb4LoginPage(driver)
				.loginAsAdmin(obj1.getAdminUName(), obj1.getAdminPword())
				.GoToUserPage()

				.deleteUser(obj.getEmail()).finDeleteUser();

	}

	private void negativeReg(String type, String msg, UserRegPOJO obj,
			ProjConfigPOJO obj1) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InterruptedException, SQLException {

		obj.setoMsg(msg);
		obj1.setrType(type);
		if (obj1.getrType().equals("Closed")) {
			new Sb4LoginPage(driver, obj.getoMsg());
		} else if (obj1.getrType().equals("Password Only")) {
			obj1.setrPWord("wrong");
			if (!openReg(obj1.getrType(), ur0, pc0).equals("Cannot Register")) {
				throw new RuntimeException(
						"Registration was not set to Password Only");
			}
		}
	}
}