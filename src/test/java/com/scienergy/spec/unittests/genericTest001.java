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

import com.scienergy.development.qa.TaskPOJO;
import com.scienergy.development.qa.pages.spec.RndStringUtil;
import com.scienergy.development.qa.pages.spec.SpecLoginPage;
import com.scienergy.development.qa.pages.spec.SpecMainPage;

public class genericTest001 {

	WebDriver driver;
	RndStringUtil randomString = new RndStringUtil();
	TaskPOJO tp0 = new TaskPOJO();
	TaskPOJO tp1 = new TaskPOJO();
	TaskPOJO tp2 = new TaskPOJO();
	private String username = "wr";
	private String password = "wr";
	private String uNFerror = "User not found";
	private String IPerror = "Incorrect password";
	String[] labels = { randomString.Random2Word(), randomString.Random2Word(), randomString.Random2Word(),
			randomString.Random2Word() };

	String[] labels2Delete = { labels[1], labels[2] };
	String summary = randomString.RandomUName();
	String description = randomString.RandomUName();
	String location = randomString.RandomUName();
	String assignee = "Wilford Reich";
	String date = "2015-12-25";

	String[] nLabels = { randomString.Random2Word(), randomString.Random2Word(), randomString.Random2Word(),
			randomString.Random2Word() };
	String nSummary = randomString.RandomUName();
	String nDescription = randomString.RandomUName();
	String nLocation = randomString.RandomUName();
	String nAssignee = "Alice Williams";
	String nDate = "2016-01-19";
	String comment = randomString.Random2Word();

	String taskingURL = "http://tasking.scienergydev.com/";
	String localURL = "http://localhost:3000/";

	String[] addTask = { "taskAssignee", "taskDueDate" };
	String[] editTask = { "edidTaskDescription", "existingAssignee", "taskLocation", "editTaskCommentField",
			"taskLabels" };

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

		tp0.setLabels(labels);
		tp0.setAssignee(assignee);
		tp0.setSummary(summary);
		tp0.setDescription(description);
		tp0.setLocation(location);
		tp0.setDueDate(date);

		tp1.setLabels(nLabels);
		tp1.setAssignee(nAssignee);
		tp1.setAssigneePresent(1);
		tp1.setSummary(nSummary);
		tp1.setDescription(nDescription);
		tp1.setLocation(nLocation);
		tp1.setLocationPresent(1);
		tp1.setDueDate(nDate);
		tp1.setComment(comment);
		tp1.setLabelsPresent(tp1.getLabels().length);
		tp1.setCanceled(0);
		tp1.setBlocked(0);

	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	@BeforeMethod
	public void testSetUp() {
		driver.get(localURL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void loginTest001() throws InterruptedException {
		new SpecLoginPage(driver).loginAs(username, password).addNewTask(tp0, addTask).findTask(tp0.getSummary(), tp0)
				.LogOut().loginAs(username, password).findTask(tp0.getSummary(), tp0).editTask(tp0, tp1, editTask)
				.LogOut();
		tp2 = new SpecLoginPage(driver).loginAs(username, password).findTask(tp0.getSummary(), tp0).checkTask(tp1);

		System.out.println("tp1 labels = " + tp1.getLabelsPresent() + " tp2 labels = " + tp2.getLabelsPresent());
		System.out.println("tp1 canceled = " + tp1.getCanceled() + " tp2 canceled = " + tp2.getCanceled());
		System.out.println("tp1 blocked = " + tp1.getBlocked() + " tp2 blocked = " + tp2.getBlocked());
		System.out
				.println("tp1 location = " + tp1.getLocationPresent() + " tp2 location = " + tp2.getLocationPresent());
		System.out
				.println("tp1 assignee = " + tp1.getAssigneePresent() + " tp2 assignee = " + tp2.getAssigneePresent());
		System.out.println("tp1 date = " + tp1.getDueDate() + " tp2 date = " + tp2.getDueDate());
		System.out.println("tp1 description = " + tp1.getDescription() + " tp2 description = " + tp2.getDescription());
		System.out.println("tp1 summary = " + tp1.getSummary() + " tp2 summary = " + tp2.getSummary());
	}

	private TaskPOJO taskInfoClone(TaskPOJO orig) {
		TaskPOJO edit = new TaskPOJO();
		edit.setSummary(orig.getSummary());
		edit.setDescription(orig.getDescription());
		edit.setDueDate(orig.getDueDate());
		edit.setAssigneePresent(orig.getAssigneePresent());
		edit.setLocationPresent(orig.getAssigneePresent());
		edit.setBlocked(orig.getBlocked());
		edit.setCanceled(orig.getCanceled());
		edit.setLabelsPresent(orig.getLabels().length);
		return edit;
	}

	private TaskPOJO taskInfoEdit(TaskPOJO edit, String[] task) {
		RndStringUtil randomString = new RndStringUtil();
		for (String t : task) {
			if (t.equals("edidTaskSummary")) {
				edit.setSummary(randomString.RandomUName());
			} else if (t.equals("edidTaskDescription")) {
				edit.setDescription(randomString.Random2Word());
			} else if (t.equals("taskLocation")) {
				edit.setLocation(randomString.RandomUName());
				edit.setLocationPresent(1);
			} else if (t.equals("taskDueDate")) {
//				edit
			} else if (t.equals("taskLabels")) {
			} else if (t.equals("taskAssignee")) {
			} else if (t.equals("existingLocation")) {
			} else if (t.equals("existingAssignee")) {
			} else if (t.equals("existingDate")) {
			} else if (t.equals("existingLabels")) {
			} else if (t.equals("editTaskCommentField")) {
			} else if (t.equals("blockTask")) {
			} else if (t.equals("cancelTaskChild")) {
			} else if (t.equals("unBlockTask")) {
			} else if (t.equals("reopenTask")) {
			} else if (t.equals("editStatus")) {
			}
		}
		return edit;
	}

}