package com.scienergy.spec.unittests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.scienergy.development.qa.TaskPOJO;
import com.scienergy.development.qa.pages.Page;
import com.scienergy.development.qa.pages.spec.RndStringUtil;
import com.scienergy.development.qa.pages.spec.SpecLoginPage;
import com.scienergy.development.qa.pages.spec.SpecMainPage;

public class genericTest001 {

	WebDriver driver;
	RndStringUtil randomString = new RndStringUtil();
	TaskPOJO tp0 = null;
	TaskPOJO tp1 = null;
	TaskPOJO tp2 = null;
	private String username = "testusername";
	private String password = "testpassword";
	private String uNFerror = "User not found";
	private String IPerror = "Incorrect password";
	String[] labels = { randomString.Random2Word(), randomString.Random2Word() };

	String summary = randomString.RandomUName();
	String description = randomString.RandomUName();
	String location = randomString.RandomUName();
	String assignee = "Test User";
	String date = randomString.date(1);

	String[] nLabels = { randomString.Random2Word(), randomString.Random2Word(), randomString.Random2Word(),
			randomString.Random2Word() };
	String nSummary = randomString.RandomUName();
	String nDescription = randomString.RandomUName();
	String nLocation = randomString.RandomUName();
	String nAssignee = "Test User2";
	String nDate = randomString.date(90);
	String comment = randomString.Random2Word();

	String taskingURL = "http://tasking.scienergydev.com/";
	String localURL = "http://localhost:3000/";

	String[] addTask = { "taskAssignee" };
	String[] editTask = { "editTaskCommentField" };
	String[] filterTask = { "allFilterAssignee" };

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

		tp0 = createTaskInfo(addTask);
		tp1 = taskInfoClone(tp0);
		taskInfoEdit(tp1, editTask, 1);

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

	// @Test
	public void specTest001() throws InterruptedException {
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

		if (tp1.hashCode() != tp2.hashCode()) {
			throw new RuntimeException("Task Info did not match");
		}
	}

	@Test
	public void commentTest001() throws InterruptedException {
		String[] commentText = new SpecLoginPage(driver).loginAs(username, password).addNewTask(tp0, addTask)
				.findTask(tp0.getSummary(), tp0).editTask(tp0, tp1, editTask).getCommentText();
		String dateTime = randomString.curDateTime().toLowerCase();
		System.out.println("comment author = " + commentText[0]);
		System.out.println("comment date = " + commentText[1]+" date time i generated = "+dateTime);
		System.out.println("comment text = " + commentText[2]);
	}

	private TaskPOJO createTaskInfo(String[] task) {
		TaskPOJO orig = new TaskPOJO();
		orig.setSummary(summary);
		for (String t : task) {
			if (t.equals("addDescription")) {
				orig.setDescription(description);
			} else if (t.equals("taskLocation")) {
				orig.setLocation(location);
				orig.setLocationPresent(1);
			} else if (t.equals("taskDueDate")) {
				orig.setDueDate(date);
			} else if (t.equals("edidTaskDueDate")) {
				orig.setDueDate(date);
			} else if (t.equals("taskLabels")) {
				orig.setLabels(labels);
				orig.setLabelsPresent(orig.getLabels().length);
			} else if (t.equals("taskAssignee")) {
				orig.setAssignee(assignee);
				orig.setAssigneePresent(1);
			}
		}
		return orig;
	}

	private TaskPOJO taskInfoClone(TaskPOJO orig) {
		TaskPOJO edit = new TaskPOJO();
		edit.setSummary(orig.getSummary());
		edit.setDescription(orig.getDescription());
		edit.setLocation(orig.getLocation());
		edit.setLocationPresent(orig.getAssigneePresent());
		edit.setDueDate(orig.getDueDate());
		if (orig.getLabels() != null) {
			edit.setLabels(orig.getLabels());
			edit.setLabelsPresent(orig.getLabels().length);
		}
		edit.setAssignee(orig.getAssignee());
		edit.setAssigneePresent(orig.getAssigneePresent());
		return edit;
	}

	private TaskPOJO taskInfoEdit(TaskPOJO edit, String[] task, int status) {
		for (String t : task) {
			if (t.equals("edidTaskSummary")) {
				edit.setSummary(nSummary);
			} else if (t.equals("edidTaskDescription")) {
				edit.setDescription(description);
			} else if (t.equals("taskLocation")) {
				edit.setLocation(location);
				edit.setLocationPresent(1);
			} else if (t.equals("taskDueDate")) {
				edit.setDueDate(date);
			} else if (t.equals("taskLabels")) {
				edit.setLabels(labels);
				edit.setLabelsPresent(edit.getLabels().length);
			} else if (t.equals("taskAssignee")) {
				edit.setAssignee(assignee);
				edit.setAssigneePresent(1);
			} else if (t.equals("existingLocation")) {
				edit.setLocation(nLocation);
			} else if (t.equals("existingAssignee")) {
				edit.setAssignee(nAssignee);
			} else if (t.equals("edidTaskDueDate")) {
				edit.setDueDate(nDate);
			} else if (t.equals("existingLabels")) {
				edit.setLabels(nLabels);
				edit.setLabelsPresent(edit.getLabels().length);
			} else if (t.equals("editTaskCommentField")) {
				edit.setComment001(comment);
			} else if (t.equals("blockTask")) {
				edit.setBlocked(1);
			} else if (t.equals("cancelTask")) {
				edit.setCanceled(1);
			} else if (t.equals("unBlockTask")) {
				edit.setBlocked(0);
			} else if (t.equals("reopenTask")) {
				edit.setCanceled(0);
			} else if (t.equals("editStatus")) {
				edit.setStatus(status);
			}
		}
		return edit;
	}
}