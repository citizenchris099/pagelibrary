package com.scienergy.development.qa.pages.spec;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.scienergy.development.qa.pages.Page;

/**
 * Spectrum Main Page
 * 
 * @author cmanning
 * 
 */
public class SpecMainPage extends Page {

	/**
	 * locators: main filters
	 */
	private By search = By.xpath("//input[@placeholder='Search']");
	private By allTasksActive = By.xpath("//a[contains(@class,'is-active')] [.='All Tasks']");
	private By allTasksInActive = By.xpath("//a[contains(@class,'nav-link false')] [.='All Tasks']");
	private By myTasksActive = By.xpath("//a[contains(@class,'nav-link active')] [.='My Tasks']");
	private By myTasksInActive = By.xpath("//a[contains(@class,'nav-link false')] [.='My Tasks']");
	private By moreParent = By.xpath("//li[@class='nav-item dropdown ']");
	private By moreChild = By.xpath(".//a[contains(@class,'nav-link dropdown-toggle')] [@href='#']");
	private By moreStarred = By.xpath("//label[contains(text(), 'Starred')]");
	private By moreBlocked = By.xpath("//label[contains(text(), 'Blocked')]");
	private By moreMe = By.xpath("//label[contains(text(), 'Created by me')]");
	private By advancedFilters = By.xpath("//span[contains(@class,'toggle-label')] [.='Advanced Filters']");
	private By adFilterCategories = By.xpath("//div[@class='filter-label']");
	private By clearAdFilters = By.xpath("//span[.='Clear All']");

	/**
	 * locators: log out
	 */
	private By loginName = By.xpath("//a[contains(@class,'login-link-text')] [@id='login-name-link']");
	private By signOut = By.xpath("//div[contains(@class,'login-button')] [@id='login-buttons-logout']");

	/**
	 * locators: add task form
	 */
	private By showAddTaskParent = By.xpath("//div[contains(@class,'taskquickaddtoggle')]");
	private By addTaskParent = By.xpath("//div[contains(@class,'taskquickaddform')]");
	private By showAddTaskChild = By.xpath(".//i[contains(@class,'scicon-plus-circle-outline')]");
	private By hideAddTaskChild = By.xpath(".//i[@class='scicon-close']");
	private By taskDueDateChild = By.xpath(".//input[contains(@class,'taskquickadd-date')]");
	private By taskSummaryChild = By.xpath(".//textarea[contains(@class,'taskquickaddform-summary')]");
	private By taskDescriptionChild = By.xpath(".//textarea[contains(@class,'taskquickaddform-description')]");
	private By create = By.xpath("//button[.='Create']");

	/**
	 * locators: edit task form
	 */
	private By editTaskParent = By.xpath("//div[@class='taskdetails']");
	private By editTaskStatusChild = By
			.xpath(".//button[contains(@class,'mod-dropdownarrow')] [@aria-expanded='false']");
	private By editTaskStatusOptionChild = By.xpath(".//a[@name='status']");
	private By editTaskBlockCancelChild = By.xpath(".//span[@class='scicon-dots-horizontal']");
	private By blockTaskChild = By.xpath(".//a[.='Block Task']");
	private By unBlockTaskChild = By.xpath(".//span[.='Unblock']");
	private By blockedIndicator = By.xpath(".//span[.='Task Blocked']");
	private By blockMessage = By.xpath(".//p[contains(text(), 'Because I said so')]");
	private By cancelTaskChild = By.xpath(".//a[.='Cancel Task']");

	/**
	 * locators: add/edit task fields
	 */
	private By taskLocationChild = By.xpath(".//div[contains(@class,'Select-placeholder')] [.='Location']");
	private By taskLabelsChild = By.xpath(".//div[.='Labels']");
	private By taskAssignee = By.xpath(".//div[.='Assignee']");

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
		isLoaded(search, allTasksActive);
		logger.info("Spec Main Page is loaded");
	}

	/**
	 * elements: log out
	 */
	private SpecMainPage clickLoginName() {
		findElement(loginName).click();
		return this;
	}

	private SpecMainPage clickSignOut() {
		findElement(signOut).click();
		return this;
	}

	/**
	 * elements: filters
	 */

	public SpecMainPage search(String value) {
		findElement(search).sendKeys(value);
		return this;
	}

	/**
	 * elements: add/edit task helper functions
	 */

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
	public void dynamicSendKeys(By parent, By child, String[] values) {
		builder.moveToElement(findElement(parent).findElement(child)).click();
		for (String v : values) {
			builder.sendKeys(v, Keys.ENTER).build().perform();
		}
	}

	/**
	 * elements: add task form
	 */

	public SpecMainPage showAddTask() {
		findElement(showAddTaskParent).findElement(showAddTaskChild).click();
		return this;
	}

	public SpecMainPage enterSummary(String[] value) {
		dynamicSendKeys(addTaskParent, taskSummaryChild, value);
		return this;
	}

	public SpecMainPage enterDescripton(String[] value) {
		dynamicSendKeys(addTaskParent, taskDescriptionChild, value);
		return this;
	}

	public SpecMainPage enterLocation(String[] value) {
		dynamicSendKeys(addTaskParent, taskLocationChild, value);
		return this;
	}

	public SpecMainPage enterDate(String[] value) {
		dynamicSendKeys(addTaskParent, taskDueDateChild, value);
		return this;
	}

	public SpecMainPage enterLabel(String[] value) {
		dynamicSendKeys(addTaskParent, taskLabelsChild, value);
		return this;
	}

	public SpecMainPage enterAssignee(String[] value) {
		dynamicSendKeys(addTaskParent, taskAssignee, value);
		return this;
	}

	public SpecMainPage hideAddTask() {
		findElement(addTaskParent).findElement(hideAddTaskChild).click();
		return this;
	}

	public SpecMainPage clickCreate() {
		findElement(create).click();
		return this;
	}

	/**
	 * elements: task queue
	 */

	public By taskInQueue(String value) {
		return By.xpath(".//span[contains(text(), '" + value + "')] [@class='js-taskqueue-task-summary']");
	}

	public SpecMainPage selectTaskInQueue(String value) {
		findElement(taskInQueue(value)).click();
		return this;
	}

	/**
	 * elements: edit task form
	 */

	private SpecMainPage clickEditTaskStatusMenu() {
		findElement(editTaskParent).findElement(editTaskStatusChild).click();
		return this;
	}

	/**
	 * used to select an Edit Task Status. retrieves all the elements within the
	 * pull down
	 * 
	 * @param selection
	 *            : int that denotes a selection of one of the retrieved
	 *            elements found within the menu
	 * @return : SpecMainPage
	 */
	public SpecMainPage chooseEditTaskStatus(int selection) {
		clickEditTaskStatusMenu();
		List<WebElement> li = findElement(editTaskParent).findElements(editTaskStatusOptionChild);
		li.get(selection).click();
		return this;
	}

	/**
	 * 
	 * @param choice
	 * @return
	 */
	public SpecMainPage blockOrCancelTask(String choice) {
		findElement(editTaskParent).findElement(editTaskBlockCancelChild).click();
		if (choice.equals("block")) {
			findElement(editTaskParent).findElement(blockTaskChild).click();
		} else if (choice.equals("cancel")) {
			findElement(editTaskParent).findElement(cancelTaskChild).click();
		}
		return this;
	}

	public SpecMainPage checkTaskBlocked() {
		if (!findElement(editTaskParent).findElement(blockMessage).isDisplayed()
				& findElement(editTaskParent).findElement(blockedIndicator).isDisplayed()
				& findElement(editTaskParent).findElement(unBlockTaskChild).isDisplayed() == true) {
			logger.info("unblock elements not present");
			throw new RuntimeException("unblock elements not present");
		} else
			logger.info("unblock elements present");
		return this;
	}

	public SpecMainPage clickUnBlockTask() {
		findElement(editTaskParent).findElement(unBlockTaskChild).click();
		return this;
	}

	public SpecMainPage alert(String choice) {
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

}
