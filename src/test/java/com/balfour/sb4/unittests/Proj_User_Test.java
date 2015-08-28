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
import com.balfour.publishing.qa.ProfilePOJO;
import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;
import com.balfour.publishing.qa.pages.sb4.Sb4HomePage;
import com.balfour.publishing.qa.pages.sb4.Sb4LoginPage;
import com.balfour.publishing.qa.pages.sb4.Sb4NewUserReg;
import com.balfour.publishing.qa.pages.sb4.Sb4NewUserRegProf;
import com.balfour.publishing.qa.pages.sb4.Sb4ProjectUserPage;
import com.balfour.publishing.qa.pages.sb4.Sb4UserAdminPage;

public class Proj_User_Test {

	WebDriver driver;
	Sb4HomePage sb4dashboard;
	Sb4LoginPage sb4login;
	Sb4NewUserReg sb4NewUserReg;
	Sb4NewUserRegProf sb4NewUserRegProf;
	String lUnameVal = "veggietester003";
	String lPwordVal = "Welles113*";
	String stmt = "SELECT user_register_key FROM b4pub.user_register where user_register_email = ?";
	String url = "jdbc:mysql://pub-constellation-qa-db-01.ckdfohchwkze.us-east-1.rds.amazonaws.com:3306/b4pub";
	String userName = "vpc_dbuser";
	String password = "prat0ri0n";
	String val2 = "user_register_key";
	String regPWord = "Costello";
	String enfoldUrl = "http://10.90.31.54:8000/users?email=";
	String enfoldRole = "3c267146ed0b475e8e9b7b3c1a89e701";
	String enfoldKey = "users[0].role_id";
	Page pg;
	UserRegPOJO ur0 = null;
	TestPOJO tp0 = null;
	Test_EnviornmentPOJO slugNAction = new Test_Enviornment().slugNAction();
	String key = null;
	ProfilePOJO pr1 = null;
	ProfilePOJO pr2 = null;
	UserRegPOJO ur1 = null;

	@BeforeSuite
	public void setup() throws MalformedURLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException,
			InterruptedException, SQLException {
		// driver = new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "44.0");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("tags", new String[] { "Chrome", "44.0",
				"Windows 10" });
		caps.setCapability("name", "Project User Test");

		driver = new RemoteWebDriver(
				new URL(
						"http://citizenchris:a8f0eeb8-bb02-4788-b6d1-3680f480930c@ondemand.saucelabs.com:80/wd/hub"),
				caps);

		// ((FirefoxDriver) driver).setFileDetector(new LocalFileDetector());
		pg = new Page(driver);
		tp0 = new TestPOJO();
		tp0.setSbLogOnUrl(new Test_Enviornment().envUrl(slugNAction.getLogin()));
		tp0.setSbRegUrl(new Test_Enviornment().envUrl(slugNAction.getRegister()));
		tp0.setSbPUUrl(new Test_Enviornment().envUrl(slugNAction
				.getProject_users()));
		tp0.setSbProjConf(new Test_Enviornment().envUrl(slugNAction
				.getProject_config()));
		tp0.setSbUAUrl(new Test_Enviornment().envUrl(slugNAction
				.getUser_admin()));
		tp0.setAdminUName("veggieadministrator");
		tp0.setAdminPword("cOOKE1964");
		tp0.setAdvUname("veggietester007");
		tp0.setAdvPword("Welles113*");
		tp0.setMiscUname001("veggietester003");

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

		pr1 = new ProfilePOJO();
		pr1.setfName(pg.randomFName());
		pr1.setlName(pg.randomLName());
		pr1.setPhone(pg.randomPhone());
		pr1.setfBook(pg.randomLName());
		pr1.setGoogle(pg.randomLName());
		pr1.setYahoo(pg.randomLName());
		pr1.setTwitter(pg.randomLName());
		pr1.setLinkedin(pg.randomLName());
		pr1.setPinterest(pg.randomLName());
		pr1.setInstagram(pg.randomLName());
		pr1.setBio(pg.randomLName());
		pr1.setMsg("The profile information has been updated");

		ur1 = new UserRegPOJO();
		ur1.setfName(pr1.getfName());
		ur1.setlName(pr1.getlName());
		ur1.setEmail(ur0.getEmail());
		ur1.setProject(ur0.getProject());
		ur1.setRole(ur0.getRole());
		createNewUser(ur0, tp0);
	}

	@AfterSuite
	public void teardown() throws InterruptedException {
		userCleanUp(ur0, tp0);
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

	@Test
	public void projectUserTest002() throws InterruptedException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		new Sb4LoginPage(driver).loginAs(tp0.getAdvUname(), tp0.getAdvPword());
		driver.get(tp0.getSbPUUrl());
		if (new Sb4ProjectUserPage(driver).userRegSearchCount(ur0) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		new Sb4ProjectUserPage(driver).editUser(ur0).addProjectList("Y50063")
				.projAction("#f796094653f249bca764c2b040aa7ceb").LogOut()
				.loginAs(ur0.getEmail(), ur0.getPword()).CheckProject("Y50063")
				.LogOut().loginAs(tp0.getAdvUname(), tp0.getAdvPword());
		driver.get(tp0.getSbPUUrl());
		new Sb4ProjectUserPage(driver).editUser(ur0).projAction("#Y50063")
				.LogOut().loginAs(ur0.getEmail(), ur0.getPword())
				.CheckProject("Y50061").LogOut();
	}

	private void createNewUser(UserRegPOJO obj, TestPOJO obj1)
			throws InterruptedException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {

		driver.get(obj1.getSbLogOnUrl());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		new Sb4LoginPage(driver).loginAs(obj1.getMiscUname001(),
				obj1.getAdvPword());
		driver.get(obj1.getSbUAUrl());
		key = new Sb4UserAdminPage(driver).regNewUser(obj);
		new Sb4UserAdminPage(driver).LogOut();
		driver.get(key);
		new Sb4NewUserRegProf(driver).doReg(obj, false, false);
		driver.get(obj1.getSbLogOnUrl());
		new Sb4LoginPage(driver).loginAs(obj.getEmail(), obj.getPword())
				.LogOut();
	}

	private void userCleanUp(UserRegPOJO obj, TestPOJO obj1)
			throws InterruptedException {
		driver.get(obj1.getSbLogOnUrl());
		new Sb4LoginPage(driver)
				.loginAsAdmin(obj1.getAdminUName(), obj1.getAdminPword())
				.GoToUserPage()

				.deleteUser(obj.getEmail()).finDeleteUser().adminLogOut();
	}
}