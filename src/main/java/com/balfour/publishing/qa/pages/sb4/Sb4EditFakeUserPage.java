package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Class contains Studio Balfour Edit Fake User Page objects
 * 
 * @author cmanning
 * 
 */
public class Sb4EditFakeUserPage extends Page {

	/**
	 * locators
	 */
	private By editUserTile = By.xpath("//*[.='Project Info']");
	private By userName = By.xpath("//*[@name='username']");
	private By fName = By.xpath("//*[@name='firstname']");
	private By lName = By.xpath("//*[@name='lastname']");
	private By submit = By.xpath("//button[@id='admin_edit_user_submitButton']");
	private By cancel = By.xpath("//button[@id='admin_edit_user_resetButton']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4EditFakeUserPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(editUserTile, userName);
		logger.info("Sb4EditUserPage is loaded");
	}

	/**
	 * elements
	 */

	/**
	 * profile submit button
	 * 
	 * @return
	 */
	private Sb4EditFakeUserPage clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * cancel button
	 * 
	 * @return
	 */
	public Sb4EditFakeUserPage clickCancel() {
		_driver.findElement(cancel).click();
		return this;
	}

	/**
	 * used to assert correct message appears upon a successful and or
	 * Unsuccessful profile update
	 * 
	 * @param successmsg
	 * @return
	 */
	private Sb4EditFakeUserPage msgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	private String getUName() {
		disabledCheck(userName);
		return _driver.findElement(userName).getAttribute("value");
	}

	private String getFname() {
		return _driver.findElement(fName).getAttribute("value");
	}

	/**
	 * used to set value into first name field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4EditFakeUserPage setFName(String value) {
		_driver.findElement(fName).clear();
		_driver.findElement(fName).sendKeys(value);
		return this;
	}

	private String getLname() {
		return _driver.findElement(lName).getAttribute("value");
	}

	/**
	 * used to set value into last name field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4EditFakeUserPage setLName(String value) {
		_driver.findElement(lName).clear();
		_driver.findElement(lName).sendKeys(value);
		return this;
	}

	/**
	 * updates all values of the User Profile
	 * 
	 * @param obj
	 *            : of ProfilePOJO
	 * @return
	 */
	private Sb4EditFakeUserPage updateUser(UserRegPOJO obj) {

		logger.info("Begin Fake User Update");
		setFName(obj.getfName());
		setLName(obj.getlName());
		logger.info("Update Fake User complete");
		return this;
	}

	/**
	 * Services
	 */

	public Sb4EditFakeUserPage successfullUpdate(UserRegPOJO obj) {

		updateUser(obj);
		clickSubmit();
		msgChk(obj.getMsg());
		return this;
	}

	public UserRegPOJO checkEditFakeUser() {
		UserRegPOJO obj = new UserRegPOJO();
		obj.setuName(getUName());
		obj.setfName(getFname());
		obj.setlName(getLname());
		logger.info("Edit Fake User info retrieved");
		return obj;
	}

	/**
	 * shared service to take user to home page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4HomePage GoHome() throws InterruptedException {
		new MenuBar(_driver).goHome();
		return new Sb4HomePage(_driver);
	}

	/**
	 * shared service to log user out
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4LoginPage LogOut() throws InterruptedException {
		new UserMenu(_driver).LogOut();
		return new Sb4LoginPage(_driver);
	}
}