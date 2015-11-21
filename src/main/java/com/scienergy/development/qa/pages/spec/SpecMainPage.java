package com.scienergy.development.qa.pages.spec;

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
	private By taskSummaryChild = By.xpath(".//textarea[contains(@class,'taskquickaddform-summary')]");
	private By taskDescriptionChild = By.xpath(".//textarea[contains(@class,'taskquickaddform-description')]");
	private By taskLocationChild = By.xpath(".//div[contains(@class,'Select-placeholder')] [.='Location']");
	private By taskDueDateChild = By.xpath(".//input[contains(@class,'taskquickadd-date')]");
	private By addTaskLabelsChild = By.xpath(".//div[.='Labels']");
	private By addTaskAssignee = By.xpath(".//div[.='Assignee']");

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
	 * elements: add task form
	 */

	public SpecMainPage showAddTask() {
		findElement(showAddTaskParent).findElement(showAddTaskChild).click();
		return this;
	}

	public SpecMainPage enterSummary(String value) {
		findElement(addTaskParent).findElement(taskSummaryChild).sendKeys(value, Keys.ENTER);
		return this;
	}

	public SpecMainPage enterDescripton(String value) {
		findElement(addTaskParent).findElement(taskDescriptionChild).sendKeys(value, Keys.ENTER);
		return this;
	}

	public SpecMainPage enterLocation(String value) {
		dynamicSendKeys(addTaskParent, taskLocationChild, value);
		return this;
	}

	public SpecMainPage enterDate(String value) {
		findElement(addTaskParent).findElement(taskDueDateChild).sendKeys(value, Keys.ENTER);
		return this;
	}
	
	public SpecMainPage enterLabel(String[] value) {
//		dynamicSendKeys(addTaskParent, addTaskLabelsChild, value);
		dynamicLabels(addTaskParent, addTaskLabelsChild, value);
		return this;
	}
	
	public SpecMainPage enterAssignee(String value) {
		dynamicSendKeys(addTaskParent, addTaskAssignee, value);
		return this;
	}

	public SpecMainPage hideAddTask() {
		findElement(addTaskParent).findElement(hideAddTaskChild).click();
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
