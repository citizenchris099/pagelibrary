package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.scienergy.development.qa.ProjectListPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * the Studio Balfour Project List Page
 * 
 * @author cmanning
 * 
 */
public class Sb4ProjectListPage extends Page {

	/**
	 * locators
	 */
	private By projYear = By.xpath("//select[@name='project_year']");
	private By projStatus = By.xpath("//select[@name='project_status']");
	private By projNum = By
			.xpath("//input[@id='project_list_search_project_number']");
	private By projName = By.xpath("//input[@name='project_name']");
	private By projAe = By.xpath("//select[@name='project_ae']");
	private By projAdv = By.xpath("//select[@name='project_adviser']");
	private By projSR = By.xpath("//select[@name='project_sales_rep']");
	private By filter = By
			.xpath("//button[@id='project_list_search_submitButton']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ProjectListPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(projYear, projStatus);
		logger.info("Project List Page loaded");
	}

	/**
	 * elements
	 */

	/**
	 * clicks submit / enter
	 * 
	 * @return
	 */
	private Sb4ProjectListPage clickFilter() {
		_driver.findElement(filter).click();
		return this;
	}

	/**
	 * chooses option in the project year select menu
	 * 
	 * @param value
	 *            : of option to choose
	 * @return
	 */
	private Sb4ProjectListPage setProjYear(String value) {
		Select dropdown = new Select(_driver.findElement(projYear));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * chooses option in the project status select menu
	 * 
	 * @param value
	 *            : of option to choose
	 * @return
	 */
	private Sb4ProjectListPage setProjStatus(String value) {
		Select dropdown = new Select(_driver.findElement(projStatus));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * enters text into project number search field
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4ProjectListPage setProjNum(String value) {
		_driver.findElement(projNum).sendKeys(value);
		return this;
	}

	/**
	 * enters text into project name search field
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4ProjectListPage setProjName(String value) {
		_driver.findElement(projName).sendKeys(value);
		return this;
	}

	/**
	 * chooses option in the project account executive select menu
	 * 
	 * @param value
	 *            : of option to choose
	 * @return
	 */
	private Sb4ProjectListPage setProjAE(String value) {
		Select dropdown = new Select(_driver.findElement(projAe));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * chooses option in the project adviser select menu
	 * 
	 * @param value
	 *            : of option to choose
	 * @return
	 */
	private Sb4ProjectListPage setProjAdv(String value) {
		Select dropdown = new Select(_driver.findElement(projAdv));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * chooses option in the project adviser select menu
	 * 
	 * @param value
	 *            : of option to choose
	 * @return
	 */
	private Sb4ProjectListPage setProjSR(String value) {
		Select dropdown = new Select(_driver.findElement(projSR));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to assert presence and click the project config link.
	 * 
	 * @param value
	 *            : of expected project number
	 * @param click
	 *            : boolean to determine whether link is to be clicked. link
	 *            will be clicked if true is passed.
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4ProjectListPage projConfigLink(String value, Boolean click)
			throws InterruptedException {

		String pcd = slugNAction.getProject_config_dynamic();
		By button = dynamicLocator(pcd, value);
		waitForElementVisable(button);
		if (click == true) {
			_driver.findElement(button).click();
		}
		return this;
	}

	/**
	 * used to assert presence and potentially click the project view link
	 * 
	 * @param value
	 *            : of project number
	 * @param click
	 *            : boolean to determine whether link is to be clicked. link
	 *            will be clicked if true is passed.
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4ProjectListPage projViewLink(String value, Boolean click)
			throws InterruptedException {

		String pvd = slugNAction.getProject_view_dynamic();
		By button = dynamicLocator(pvd, value);
		waitForElementVisable(button);
		if (click == true) {
			_driver.findElement(button).click();
		}
		return this;
	}

	/**
	 * used to test the Project List Page filters. This service continuously
	 * Checks for the presence of a project after each filter is used.
	 * 
	 * @param obj
	 *            : ProjectListPOJO
	 * @return : Sb4ProjectConfigPage
	 * @throws InterruptedException
	 */
	private Sb4ProjectListPage fullSearch(ProjectListPOJO obj, Boolean config)
			throws InterruptedException {

		setProjYear(obj.getpYear());
		clickFilter();
		setProjStatus(obj.getpStatus());
		clickFilter();
		setProjNum(obj.getpNumber());
		clickFilter();
		projViewLink(obj.getpNumber(), false);
		logger.info("Year, Status & Number filter Search was successful");
		setProjName(obj.getpName());
		clickFilter();
		projViewLink(obj.getpNumber(), false);
		logger.info("Name filter Search was successful");
		setProjAE(obj.getpAe());
		clickFilter();
		projViewLink(obj.getpNumber(), false);
		logger.info("AE filter Search was successful");
		setProjSR(obj.getpSR());
		clickFilter();
		projViewLink(obj.getpNumber(), false);
		logger.info("Sales Rep filter Search was successful");
		setProjAdv(obj.getpAdv());
		clickFilter();
		if (config == true) {
			projConfigLink(obj.getpNumber(), true);
		} else {
			projViewLink(obj.getpNumber(), true);
		}
		return this;
	}

	/**
	 * services
	 */

	/**
	 * performs full search and clicks to go to the project config page.
	 * 
	 * @param obj
	 *            : ProjectListPOJO
	 * @return : Sb4ProjectConfigPage
	 * @throws InterruptedException
	 */
	public Sb4ProjectConfigPage goToConfigPage(ProjectListPOJO obj)
			throws InterruptedException {
		logger.info("Begin full search of Project List Page");
		fullSearch(obj, true);
		logger.info("Filter Search was successful");
		return new Sb4ProjectConfigPage(_driver);
	}

	/**
	 * performs full search and clicks to go to the project view page.
	 * 
	 * @param obj
	 *            : ProjectListPOJO
	 * @return : Sb4ProjectConfigPage
	 * @throws InterruptedException
	 */
	public Sb4ProjectViewPage goToViewPage(ProjectListPOJO obj)
			throws InterruptedException {
		logger.info("Begin full search of Project List Page");
		fullSearch(obj, false);
		logger.info("Filter Search was successful");
		return new Sb4ProjectViewPage(_driver);
	}

}