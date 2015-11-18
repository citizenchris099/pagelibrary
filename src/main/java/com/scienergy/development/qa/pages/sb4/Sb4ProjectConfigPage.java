package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.scienergy.development.qa.ProjConfigPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * Class for Project Config elements and services
 * 
 * @author cmanning
 * 
 */
public class Sb4ProjectConfigPage extends Page {

	/**
	 * locators
	 */
	private By year = By.xpath("//select[@name='year']");
	private By projNum = By.xpath("//input[@name='project_num']");
	private By projName = By.xpath("//input[@name='project_name']");
	private By projStatus = By.xpath("//select[@name='project_status']");
	private By enrollment = By.xpath("//input[@name='enrollment']");
	private By dSeason = By.xpath("//select[@name='season']");
	private By teacher = By.xpath("//input[@name='show_teacher']");
	private By homeroom = By.xpath("//input[@name='show_homeroom']");
	private By adviser = By.xpath("//select[@name='adviser']");
	private By rep = By.xpath("//select[@name='sales_rep']");
	private By ae = By.xpath("//select[@name='ae']");
	private By submit = By.xpath("//button[.='Enter']");
	private By regType = By.xpath("//select[@name='registration_type']");
	private By regPWord = By.xpath("//input[@name='registration_password']");

	/**
	 * constructor that uses shared is loaded service to check for two unique
	 * elements as well as check URL service
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ProjectConfigPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(projNum, projStatus);
		logger.info("Project Config Page is loaded");
	}

	/**
	 * elements
	 */

	/**
	 * clicks submit / enter
	 * 
	 * @return
	 */
	private Sb4ProjectConfigPage clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * used to set the Year
	 * 
	 * @param value
	 *            : desired year
	 * @return
	 */
	private Sb4ProjectConfigPage setYear(String value) {
		Select dropdown = new Select(_driver.findElement(year));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to set the value of Project Name
	 * 
	 * @param value
	 *            : intended
	 * @return
	 */
	private Sb4ProjectConfigPage setPName(String value) {
		_driver.findElement(projName).clear();
		_driver.findElement(projName).sendKeys(value);
		return this;
	}

	/**
	 * used to set the Status
	 * 
	 * @param value
	 *            : desired Status
	 * @return
	 */
	private Sb4ProjectConfigPage setStatus(String value) {
		Select dropdown = new Select(_driver.findElement(projStatus));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4ProjectConfigPage setEnrollment(String value) {
		_driver.findElement(enrollment).clear();
		_driver.findElement(enrollment).sendKeys(value);
		return this;
	}

	/**
	 * used to set the dSeason
	 * 
	 * @param value
	 *            : desired dSeason
	 * @return
	 */
	private Sb4ProjectConfigPage setDSeason(String value) {
		Select dropdown = new Select(_driver.findElement(dSeason));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to set the Registration Type
	 * 
	 * @param value
	 *            : desired Status
	 * @return
	 */
	private Sb4ProjectConfigPage setRType(String value) {
		Select dropdown = new Select(_driver.findElement(regType));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to set the value of Registration Password
	 * 
	 * @param value
	 *            : intended
	 * @return
	 */
	private Sb4ProjectConfigPage setRPword(String value) {
		_driver.findElement(regPWord).clear();
		_driver.findElement(regPWord).sendKeys(value);
		return this;
	}
	
	private Sb4ProjectConfigPage clearRPword() {
		_driver.findElement(regPWord).clear();
		return this;
	}

	/**
	 * sets the status of the teacher check box
	 * 
	 * @return
	 */
	private Sb4ProjectConfigPage setTeacher(boolean te) {

		if (te != _driver.findElement(teacher).isSelected()) {
			_driver.findElement(teacher).click();
		}

		return this;
	}

	/**
	 * sets the status of the homeroom check box
	 * 
	 * @return
	 */
	private Sb4ProjectConfigPage setHomeRoom(boolean hr) {

		if (hr != _driver.findElement(homeroom).isSelected()) {
			_driver.findElement(homeroom).click();
		}

		return this;
	}

	/**
	 * used to set the adviser
	 * 
	 * @param value
	 *            : desired adviser
	 * @return
	 */
	private Sb4ProjectConfigPage setAdviser(String value) {
		Select dropdown = new Select(_driver.findElement(adviser));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to set the rep
	 * 
	 * @param value
	 *            : desired rep
	 * @return
	 */
	private Sb4ProjectConfigPage setRep(String value) {
		Select dropdown = new Select(_driver.findElement(rep));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to set the ae
	 * 
	 * @param value
	 *            : desired ae
	 * @return
	 */
	private Sb4ProjectConfigPage setAE(String value) {
		Select dropdown = new Select(_driver.findElement(ae));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4ProjectConfigPage profileMsgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	/**
	 * sets the project config form fields to values that are retrieved from the
	 * FormPOJO
	 * 
	 * @param obj
	 *            : object of the FormPOJO required to get the values needed for
	 *            the form
	 * @return
	 */
	private Sb4ProjectConfigPage setProjConfig(ProjConfigPOJO obj) {

		setYear(obj.getYear());
		setPName(obj.getProjName());
		setStatus(obj.getStatus());
		setEnrollment(obj.getEnrollment());
		setDSeason(obj.getdSeason());
		setAdviser(obj.getAdviser());
		setRep(obj.getRep());
		setAE(obj.getAe());
		setTeacher(obj.getTeacher());
		setHomeRoom(obj.getHomeroom());
		return this;
	}

	public void setRegType(ProjConfigPOJO obj) throws InterruptedException {

		logger.info("Begin Update of Registration Type");
		setRType(obj.getrType());
		clearRPword();
		if (obj.getrType().equals("Password Only")) {
			setRPword(obj.getrPWord());
		}
		logger.info("Update Project Config Complete");
	}

	/**
	 * services
	 */

	public Sb4ProjectViewPage successfulUpDate(ProjConfigPOJO obj)
			throws InterruptedException {
		logger.info("Begin Update Project Config");
		setProjConfig(obj);
		setRegType(obj);
		clickSubmit();
		profileMsgChk("has been updated");
		logger.info("Update Project Config Complete");
		return new Sb4ProjectViewPage(_driver);
	}
}