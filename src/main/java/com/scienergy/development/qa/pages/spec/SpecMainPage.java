package com.scienergy.development.qa.pages.spec;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.scienergy.development.qa.TaskPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * Spectrum Main Page
 * 
 * @author cmanning
 * 
 */
public class SpecMainPage extends Page {

	public HashMap<String, By> locators = new HashMap<String, By>();
	public HashMap<String, TaskPOJO> taskEntry = new HashMap<String, TaskPOJO>();
	public TaskPOJO tp0 = new TaskPOJO();

	JavascriptExecutor jse = (JavascriptExecutor) _driver;
	Actions builder = new Actions(_driver);

	/**
	 * constructor uses shared isloaded service to check for the presence of two
	 * unique elements.
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public SpecMainPage(WebDriver driver) throws InterruptedException {
		super(driver);

		/**
		 * locators : filters
		 */
		locators.put("search", By.xpath("//input[@placeholder='Search']"));
		locators.put("allTasksActive", By.xpath("//a[contains(@class,'is-active')] [.='All Tasks']"));
		locators.put("allTasksInActive", By.xpath("//a[contains(@class,'nav-link false')] [.='All Tasks']"));
		locators.put("myTasksActive", By.xpath("//a[contains(@class,'nav-link active')] [.='My Tasks']"));
		locators.put("myTasksInActive", By.xpath("//a[contains(@class,'nav-link false')] [.='My Tasks']"));
		locators.put("quickFilter", By.xpath("//a[@class='quickfilter-item-link']"));
		locators.put("quickFilterICreated",
				By.xpath("//a[contains(@class,'quickfilter-item-choiceset-link')] [.='Tasks I Created']"));
		locators.put("quickFilterStarred",
				By.xpath("//a[contains(@class,'quickfilter-item-choiceset-link')] [.='Tasks I Starred']"));
		locators.put("quickFilterBlocked",
				By.xpath("//a[contains(@class,'quickfilter-item-choiceset-link')] [.='Blocked Tasks']"));
		locators.put("allFilters", By.xpath("//span[.='All Filters']"));
		locators.put("allFilterLocation", By.xpath("//div[@id='locations']"));
		locators.put("allFilterDue", By.xpath("//div[@id='due']"));
		locators.put("allFilterLabels", By.xpath("//div[@id='labels']"));
		locators.put("allFilterAssignee", By.xpath("//div[@id='assignees']"));
		locators.put("allFilterStatus", By.xpath("//div[@id='statuses']"));
		locators.put("allFilterMoreO", By.xpath("//div[@id='moreOptions']"));
		locators.put("allFiltersDropDownParent",
				By.xpath("//div[contains(@class,'taskqueuefilters-filteritem-dropdown')]"));
		locators.put("allFiltersSearch", By.xpath(".//input[contains(@placeholder,'Search')]"));
		locators.put("clearAdFilters", By.xpath("//span[.='Clear All']"));

		/**
		 * locators: log out
		 */
		locators.put("loginName", By.xpath("//a[contains(@class,'login-link-text')] [@id='login-name-link']"));
		locators.put("signOut", By.xpath("//div[contains(@class,'login-button')] [@id='login-buttons-logout']"));

		/**
		 * locators: date picker
		 */
		locators.put("datePickerParent", By.xpath("//div[@class='datepicker']"));
		locators.put("datePickerPrevMoChild", By.xpath(".//a[contains(@class,'previous')]"));
		locators.put("datePickerNextMoChild", By.xpath(".//a[contains(@class,'next')]"));

		/**
		 * locators: add task form
		 */
		locators.put("showAddTaskParent", By.xpath("//div[contains(@class,'taskquickaddtoggle')]"));
		locators.put("addTaskParent", By.xpath("//div[contains(@class,'taskquickaddform')]"));
		locators.put("showAddTaskChild", By.xpath(".//i[contains(@class,'scicon-plus-circle-outline')]"));
		locators.put("hideAddTaskChild", By.xpath(".//i[@class='scicon-close']"));
		locators.put("taskDueDate", By.xpath(".//input[contains(@placeholder,'Due')]"));
		locators.put("addSummary", By.xpath(".//textarea[contains(@class,'taskquickaddform-summary')]"));

		locators.put("addDescription", By.xpath(".//textarea[contains(@class,'taskquickaddform-description')]"));
		locators.put("create", By.xpath("//button[.='Create']"));

		/**
		 * locators: edit task form
		 */
		locators.put("editTaskParent", By.xpath("//div[@class='taskdetails']"));
		locators.put("editTaskStatusChild",
				By.xpath(".//button[contains(@class,'mod-dropdownarrow')] [@aria-expanded='false']"));
		locators.put("editTaskStatusOptionChild", By.xpath(".//a[@name='status']"));
		locators.put("editTaskBlockCancel", By.xpath(".//span[@class='scicon-dots-horizontal']"));
		locators.put("blockTask", By.xpath(".//a[.='Block Task']"));
		locators.put("unBlockTask", By.xpath(".//span[.='Unblock']"));
		locators.put("blockedIndicator", By.xpath(".//span[.='Task Blocked']"));
		locators.put("canceledIndicator", By.xpath(".//span[.='Task Canceled']"));
		locators.put("reopenTask", By.xpath(".//button[.='Reopen']"));
		locators.put("blockMessage", By.xpath(".//p[contains(text(), 'Because I said so')]"));
		locators.put("cancelTask", By.xpath(".//a[.='Cancel Task']"));
		locators.put("edidTaskSummary", By.xpath(".//textarea[@name='summary']"));
		locators.put("edidTaskDescription", By.xpath(".//textarea[@name='description']"));
		locators.put("edidTaskDueDate", By.xpath(".//input[@placeholder='Due']"));
		locators.put("editTaskCommentField", By.xpath(".//textarea[contains(@placeholder,'Add a comment')]"));
		locators.put("editTaskCommentButton", By.xpath(".//button[contains(text(), 'Comment')]"));

		/**
		 * locators: add/edit task fields
		 */
		locators.put("taskLocation", By.xpath(".//div[contains(@class,'Select-placeholder')] [.='Location']"));
		locators.put("taskLabels", By.xpath(".//div[.='Labels']"));
		locators.put("taskAssignee", By.xpath(".//div[.='Assignee']"));

		/**
		 * locators: taskqueue
		 */
		locators.put("taskListParent", By.xpath("//div[@class='taskqueue-tasklist']"));

		isLoaded(locators.get("search"), locators.get("allTasksActive"));
		logger.info("Spec Main Page is loaded");
	}

	/**
	 * uses all filters. first clicks to reveal the filters menus. then clicks
	 * the specific menu based on tasks then a specific check box based on value
	 * 
	 * @param task:
	 *            String[] that denotes the locator key to pass. this should be
	 *            a locator key for one of the all filter sub menus.
	 * @param value:
	 *            String that denotes the specific check box to click
	 * @return
	 */
	public SpecMainPage useAllFilters(String[] task, String value) {
		findElement(locators.get("allFilters")).click();
		for (String t : task) {
			findElement(locators.get(t)).click();
			findElement(By.xpath("//div[contains(@data-reactid,'" + value + "')] [@class='checkbox']")).click();
		}
		return this;
	}

	/**
	 * uses the all filters search feature. first clicks to reveal the filters
	 * menu. then clicks the specific menu and uses the search field to find the
	 * desired opton.
	 * 
	 * @param task
	 *            : String[] that denotes the locator key to pass. this should
	 *            be a locator key for one of the all filter sub menus.
	 * @param placeholder
	 *            : the values of placeholder in the search field
	 * @param value
	 *            : that you want to pass to the search field
	 * @param userId
	 *            : of the user to click
	 * @return
	 */
	public SpecMainPage useAllFiltersSearch(String[] task, String placeholder, String value, String userId) {
		findElement(locators.get("allFilters")).click();
		for (String t : task) {
			findElement(locators.get(t)).click();
			findElement(By.xpath("//input[contains(@placeholder,'" + placeholder + "')]")).sendKeys(value);
			findElement(By.xpath("//div[contains(@data-reactid,'" + userId + "')] [@class='checkbox']")).click();
		}
		return this;
	}

	/**
	 * elements
	 */
	private SpecMainPage clickLoginName() {
		findElement(locators.get("loginName")).click();
		return this;
	}

	private SpecMainPage clickSignOut() {
		findElement(locators.get("signOut")).click();
		return this;
	}

	private SpecMainPage search(String value) {
		findElement(locators.get("search")).sendKeys(value);
		return this;
	}

	/**
	 * uses selenium actions to move to a text area, click it then enter text
	 * 
	 * @param parent
	 *            : parent element that denotes whether to use the add or edit
	 *            task area
	 * @param child
	 *            : specific element to edit
	 * @param values
	 *            : String[] that contains the value(s) to enter into the field
	 */
	private void dynamicSendKeys(By parent, By child, String[] values) {
		builder.moveToElement(findElement(parent).findElement(child)).click();
		for (String v : values) {
			builder.sendKeys(v, Keys.ENTER).build().perform();
		}
	}

	/**
	 * uses selenium actions to move to a text area, click it then enter text
	 * 
	 * @param parent
	 *            : parent element that denotes whether to use the add or edit
	 *            task area
	 * @param child
	 *            : specific element to edit
	 * @param values
	 *            : String that contains the value to enter into the field
	 */
	private void dynamicSendKeys(By parent, By child, String value) {
		builder.moveToElement(findElement(parent, child)).click().sendKeys(value, Keys.ENTER).build().perform();
	}

	private SpecMainPage useDatePicker(WebElement addOrEdit, String value) {
		addOrEdit.click();
		findElement(locators.get("datePickerParent"), locators.get("datePickerNextMoChild")).click();
		findElement(locators.get("datePickerParent"),
				By.xpath(".//div[contains(text(), '" + value + "')] [@class='datepicker__day']")).click();
		return this;
	}

	private SpecMainPage showAddTask() {
		findElement(locators.get("showAddTaskParent"), locators.get("showAddTaskChild")).click();
		return this;
	}

	private SpecMainPage hideAddTask() {
		findElement(locators.get("addTaskParent"), locators.get("hideAddTaskChild")).click();
		return this;
	}

	private SpecMainPage clickCreate() {
		findElement(locators.get("create")).click();
		return this;
	}

	private SpecMainPage clickComment() {
		findElement(locators.get("editTaskParent"), locators.get("editTaskCommentButton")).click();
		return this;
	}

	private By taskInQueue(String value) {
		return By.xpath(".//span[contains(text(), '" + value + "')] [@class='js-taskqueue-task-summary']");
	}

	/**
	 * clicks a task in queue based on the summary
	 * 
	 * @param value
	 *            : String of summary of task to select
	 * @return
	 */
	private SpecMainPage selectTaskInQueue(String value) {
		findElement(taskInQueue(value)).click();
		return this;
	}

	private void addTaskElement(String field, String value) {
		dynamicSendKeys(locators.get("addTaskParent"), locators.get(field), value);
	}

	private void addTaskElement(String field, String[] value) {
		dynamicSendKeys(locators.get("addTaskParent"), locators.get(field), value);
	}

	private void editTaskElement(String field, String value) {
		dynamicSendKeys(locators.get("editTaskParent"), locators.get(field), value);
	}

	private void editTaskElement(String field, String[] value) {
		dynamicSendKeys(locators.get("editTaskParent"), locators.get(field), value);
	}

	private SpecMainPage editTaskValue(String field, String value) {
		findElement(locators.get("editTaskParent"), locators.get(field)).clear();
		findElement(locators.get("editTaskParent"), locators.get(field)).sendKeys(value);
		return this;
	}

	private By editLocation(String value) {
		return By.xpath(".//div[contains(text(), '" + value + "')] [@class='Select-placeholder']");
	}

	/**
	 * used to edit either location or assignee fields when values are already
	 * present
	 * 
	 * @param task
	 *            : By locator for eitehr assignee or location field
	 * @param oValue
	 *            : original value present
	 * @param nValue
	 *            : new value to enter
	 * @return SpecMainPage
	 */
	private SpecMainPage editTaskLocationAssignee(By task, String oValue, String nValue) {
		builder.moveToElement(findElement(locators.get("editTaskParent"), editLocation(oValue))).click()
				.sendKeys(Keys.BACK_SPACE).build().perform();
		dynamicSendKeys(locators.get("editTaskParent"), task, nValue);
		return this;
	}

	/**
	 * used to edit the task calendar
	 * 
	 * @param value
	 *            : String two digit date value ex: 01, 19 etc...
	 * @return : SpecMainPage
	 */
	private SpecMainPage editTaskDate(String value) {
		useDatePicker(findElement(locators.get("editTaskParent"), locators.get("edidTaskDueDate")), value);
		return this;
	}

	/**
	 * used to remove edit task labels
	 * 
	 * @param choice
	 *            : String[] of label names that need to be removed
	 * @return: SpecMainPage
	 */
	public SpecMainPage removeEditTaskLabels(String[] choice) {
		for (String c : choice) {
			findElement(locators.get("editTaskParent"),
					By.xpath(".//span[contains(text(), '×')] [contains(@data-reactid,'" + c + "')]")).click();
		}
		return this;
	}

	private int editLabelCount(String[] labels) {
		int count = 0;
		while (count < labels.length) {
			if (findElements(locators.get("editTaskParent"),
					By.xpath(".//span[contains(text(), '×')] [contains(@data-reactid,'" + labels[count] + "')]"))
							.size() > 0) {
				count++;
			}
		}
		return count;
	}

	private SpecMainPage alert(String choice) {
		Alert alert = _driver.switchTo().alert();
		if (choice.equals("accept")) {
			alert.sendKeys("Because I said so");
			alert.accept();
		} else if (choice.equals("decline")) {
			alert.dismiss();
		}
		return this;
	}

	/**
	 * services
	 */

	/**
	 * shared log out service
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public SpecLoginPage LogOut() throws InterruptedException {
		clickLoginName().clickSignOut();
		return new SpecLoginPage(_driver);
	}

	/**
	 * fills out the add task form
	 * 
	 * @param obj
	 *            : TaskPOJO
	 * @param task:
	 *            accepts String[] values must include either an empty string or
	 *            one of the following. addDescription, taskLocation,
	 *            taskDueDate, taskLabels, taskAssignee
	 * @return: SpecMainPage
	 */
	public SpecMainPage addNewTask(TaskPOJO obj, String[] task) {
		showAddTask();
		addTaskElement("addSummary", obj.getSummary());
		for (String t : task) {
			if (t.equals("addDescription")) {
				addTaskElement(t, obj.getDescription());
			} else if (t.equals("taskLocation")) {
				addTaskElement(t, obj.getLocation());
			} else if (t.equals("taskDueDate")) {
				addTaskElement(t, obj.getDueDate());
			} else if (t.equals("taskLabels")) {
				addTaskElement(t, obj.getLabels());
			} else if (t.equals("taskAssignee")) {
				addTaskElement(t, obj.getAssignee());
			} else
				throw new RuntimeException("Task passed was not an accepted value");
		}
		clickCreate();
		hideAddTask();
		return this;
	}

	/**
	 * used to search for and then click on an existing task
	 * 
	 * @param value
	 *            : what will be entered into search field
	 * @param obj
	 *            : TaskPOJO this is used to get the summary of the task being
	 *            searched for
	 * @return: SpecMainPage
	 */
	public SpecMainPage findTask(String value, TaskPOJO obj) {
		search(value);
		selectTaskInQueue(obj.getSummary());
		return this;
	}

	public int checkTaskInQueuePresent(String value) {
		return findElements(locators.get("taskListParent"), taskInQueue(value)).size();
	}

	/**
	 * used to edit an existing task
	 * 
	 * @param orig:
	 *            TaskPOJO that represents the values of the original task
	 * @param edit:
	 *            TaskPOJO that represents the values of the edited task
	 * @param task
	 *            : String[] of what is to be edited. accepts the following
	 *            values. edidTaskSummary, edidTaskDescription, taskLocation,
	 *            taskDueDate, taskLabels, taskAssignee, existingLocation,
	 *            existingAssignee, existingDate, existingLabels and
	 *            editTaskCommentField
	 * @return SpecMainPage
	 */
	public SpecMainPage editTask(TaskPOJO orig, TaskPOJO edit, String[] task) {
		for (String t : task) {
			if (t.equals("edidTaskSummary")) {
				editTaskValue(t, edit.getSummary());
			} else if (t.equals("edidTaskDescription")) {
				editTaskValue(t, edit.getDescription());
			} else if (t.equals("taskLocation")) {
				editTaskElement(t, edit.getLocation());
			} else if (t.equals("taskDueDate")) {
				editTaskElement(t, edit.getDueDate());
			} else if (t.equals("taskLabels")) {
				editTaskElement(t, edit.getLabels());
			} else if (t.equals("taskAssignee")) {
				editTaskElement(t, edit.getAssignee());
			} else if (t.equals("existingLocation")) {
				editTaskLocationAssignee(locators.get("taskLocation"), orig.getLocation(), edit.getLocation());
			} else if (t.equals("existingAssignee")) {
				editTaskLocationAssignee(locators.get("taskAssignee"), orig.getAssignee(), edit.getAssignee());
			} else if (t.equals("existingDate")) {
				String[] date = edit.getDueDate().split("-");
				editTaskDate(date[2].trim());
			} else if (t.equals("existingLabels")) {
				removeEditTaskLabels(orig.getLabels());
				editTaskElement("taskLabels", edit.getLabels());
			} else if (t.equals("editTaskCommentField")) {
				editTaskElement(t, edit.getComment001());
				clickComment();
			} else if (t.equals("blockTask")) {
				findElement(locators.get("editTaskParent"), locators.get("editTaskBlockCancel")).click();
				findElement(locators.get("editTaskParent"), locators.get("blockTask")).click();
				alert("accept");
			} else if (t.equals("cancelTask")) {
				findElement(locators.get("editTaskParent"), locators.get("editTaskBlockCancel")).click();
				findElement(locators.get("editTaskParent"), locators.get("cancelTask")).click();
				alert("accept");
			} else if (t.equals("unBlockTask")) {
				findElement(locators.get("editTaskParent"), locators.get("unBlockTask")).click();
			} else if (t.equals("reopenTask")) {
				findElement(locators.get("editTaskParent"), locators.get("reopenTask")).click();
			} else if (t.equals("editStatus")) {
				findElement(locators.get("editTaskParent"), locators.get("editTaskStatusChild")).click();
				findElements(locators.get("editTaskParent"), locators.get("editTaskStatusOptionChild"))
						.get(edit.getStatus()).click();
			} else
				throw new RuntimeException("Task passed was not an accepted value");
		}
		return this;
	}

	public TaskPOJO checkTask(TaskPOJO edit, String[] task) {
		TaskPOJO obj = new TaskPOJO();
		obj.setSummary(findElement(locators.get("editTaskParent"), locators.get("edidTaskSummary")).getText());
		obj.setDescription(findElement(locators.get("editTaskParent"), locators.get("edidTaskDescription")).getText());
		obj.setDueDate(findElement(locators.get("editTaskParent"), locators.get("edidTaskDueDate"))
				.getAttribute("value").trim());
		obj.setAssigneePresent(findElements(locators.get("editTaskParent"), editLocation(edit.getAssignee())).size());
		obj.setLocationPresent(findElements(locators.get("editTaskParent"), editLocation(edit.getLocation())).size());
		obj.setBlocked(findElements(locators.get("editTaskParent"), locators.get("unBlockTask")).size());
		obj.setCanceled(findElements(locators.get("editTaskParent"), locators.get("reopenTask")).size());
		if (edit.getLabels() != null) {
			obj.setLabelsPresent(editLabelCount(edit.getLabels()));
		}
		return obj;
	}
}