package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.SchoolListPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * the Studio Balfour School List Page
 * 
 * @author cmanning
 * 
 */
public class Sb4SchoolListPage extends Page {

	/**
	 * locators
	 */
	private By schoolNumber = By
			.xpath("//input[@id='school_list_search_school_number']");
	private By schoolName = By
			.xpath("//input[@id='school_list_search_school_name']");
	private By schoolCity = By
			.xpath("//input[@id='school_list_search_school_city']");
	private By schoolState = By
			.xpath("//select[@id='school_list_search_school_state']");
	private By schoolCountry = By
			.xpath("//select[@id='school_list_search_school_country']");
	private By schoolSalesO = By
			.xpath("//select[@id='school_list_search_school_sales_office']");
	private By schoolSubmit = By
			.xpath("//button[@id='school_list_search_submitButton']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4SchoolListPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(schoolNumber, schoolState);
		logger.info("School Config Page loaded");
	}

	/**
	 * elements
	 */

	/**
	 * clicks submit / enter
	 * 
	 * @return
	 */
	private Sb4SchoolListPage clickSubmit() {
		_driver.findElement(schoolSubmit).click();
		return this;
	}

	/**
	 * enters text into school number search field
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4SchoolListPage setSchoolNum(String value) {
		_driver.findElement(schoolNumber).sendKeys(value);
		return this;
	}

	/**
	 * enters text into school name search field
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4SchoolListPage setSchoolName(String value) {
		_driver.findElement(schoolName).sendKeys(value);
		return this;
	}

	/**
	 * enters text into school city search field
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4SchoolListPage setSchoolCity(String value) {
		_driver.findElement(schoolCity).sendKeys(value);
		return this;
	}

	/**
	 * enters text into school state select menu
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4SchoolListPage setSchoolState(String value) {
		Select dropdown = new Select(_driver.findElement(schoolState));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * enters text into school country select menu
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4SchoolListPage setSchoolCountry(String value) {
		Select dropdown = new Select(_driver.findElement(schoolCountry));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * enters text into school Sales Office select menu
	 * 
	 * @param value
	 *            : to enter into field
	 * @return
	 */
	private Sb4SchoolListPage setSchoolSalesO(String value) {
		Select dropdown = new Select(_driver.findElement(schoolSalesO));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to assert the presence of a school config link
	 * 
	 * @param value
	 *            : of school number
	 * @param click
	 *            : boolean to denote whether link is clicked
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4SchoolListPage schoolConfigLink(String value, Boolean click)
			throws InterruptedException {

		String scd = slugNAction.getSchool_config_dynamic();
		By button = dynamicLocator(scd, value);
		waitForElementVisable(button);
		if (click == true) {
			_driver.findElement(button).click();
		}
		return this;
	}

	/**
	 * used to assert the presence of a school view link
	 * 
	 * @param value
	 *            : of school number
	 * @param click
	 *            : boolean to denote whether link is clicked
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4SchoolListPage schoolViewLink(String value, Boolean click)
			throws InterruptedException {

		String svd = slugNAction.getSchool_view_dynamic();
		By button = dynamicLocator(svd, value);
		waitForElementVisable(button);
		if (click == true) {
			_driver.findElement(button).click();
		}
		return this;
	}

	/**
	 * used to test the School List Page filters. This service continuously
	 * Checks for the presence of a school after each filter is used.
	 * 
	 * @param obj
	 *            : of SchoolListPOJO
	 * @param config
	 *            : used to denote whether to go to the config or view page for
	 *            the school. if true then go to config, false go to view;
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4SchoolListPage fullSearch(SchoolListPOJO obj, Boolean config)
			throws InterruptedException {

		setSchoolNum(obj.getsNum());
		clickSubmit();
		schoolViewLink(obj.getsNum(), false);
		schoolConfigLink(obj.getsNum(), false);
		setSchoolName(obj.getsName());
		clickSubmit();
		schoolViewLink(obj.getsNum(), false);
		schoolConfigLink(obj.getsNum(), false);
		setSchoolCity(obj.getCity());
		clickSubmit();
		schoolViewLink(obj.getsNum(), false);
		schoolConfigLink(obj.getsNum(), false);
		setSchoolState(obj.getState());
		clickSubmit();
		schoolViewLink(obj.getsNum(), false);
		schoolConfigLink(obj.getsNum(), false);
		setSchoolCountry(obj.getCountry());
		clickSubmit();
		schoolViewLink(obj.getsNum(), false);
		schoolConfigLink(obj.getsNum(), false);
		setSchoolSalesO(obj.getSalesO());
		clickSubmit();
		if (config == true) {
			schoolConfigLink(obj.getsNum(), true);
		} else {
			schoolViewLink(obj.getsNum(), true);
		}
		return this;
	}

	/**
	 * services
	 * 
	 */

	/**
	 * performs a full search then clicks to go to the desired schools view page
	 * 
	 * @param obj
	 *            : of SchoolListPOJO
	 * @return : Sb4SchoolViewPage
	 * @throws InterruptedException
	 */
	public Sb4SchoolViewPage goToViewPage(SchoolListPOJO obj)
			throws InterruptedException {
		logger.info("Begin full search of School List Page");
		fullSearch(obj, false);
		logger.info("Full search of School List Page successfull");
		return new Sb4SchoolViewPage(_driver);
	}

	/**
	 * performs a full search then clicks to go to the desired schools config
	 * page
	 * 
	 * @param obj
	 *            : of SchoolListPOJO
	 * @return : Sb4SchoolConfigPage
	 * @throws InterruptedException
	 */
	public Sb4SchoolConfigPage goToConfigPage(SchoolListPOJO obj)
			throws InterruptedException {
		logger.info("Begin full search of School List Page");
		fullSearch(obj, true);
		logger.info("Full search of School List Page successfull");
		return new Sb4SchoolConfigPage(_driver);
	}
}