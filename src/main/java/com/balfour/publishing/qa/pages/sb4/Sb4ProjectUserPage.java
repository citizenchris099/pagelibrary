package com.balfour.publishing.qa.pages.sb4;

import java.sql.SQLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;

public class Sb4ProjectUserPage extends Page {

	/**
	 * locators
	 */
	private By aNewUser = By.xpath("//a[@href='#new_register_form']");
	private By regNewUser = By.xpath("//div[@id='register_form_alert']");
	private By fName = By
			.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-003']");
	private By lName = By
			.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-004']");
	private By email = By
			.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-005']");
	private By role = By
			.xpath("//div[@class='ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-006']");
	private By rKeyButton = By.xpath("//button[.='Resend Key']");
	private By search = By.xpath(".//input[@type='text']");
	private By searchRow = By.xpath("//div[@class='ui-grid-row ng-scope']");
	private By NUFName = By.xpath("//input[@name='first_name']");
	private By NULName = By.xpath("//input[@name='last_name']");
	private By NUEmail = By.xpath("//input[@name='email']");
	private By NURole = By.xpath("//select[@name='role']");
	private By enter = By.xpath("//button[@type='submit']");
	private By userRegMsg = By.xpath("//div[contains(text(), 'User Added')]");
	private By delReg = By.xpath("//button[.='Delete Registration']");
	private By editUserButton = By.xpath(".//button[.='Edit User']");

	private String slug = slugNAction.getnReg_dynamic();
	private String keyUrl = new Test_Enviornment().envUrl(slug);
	UserMenu um = new UserMenu(_driver);

	public Sb4ProjectUserPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(aNewUser, regNewUser);
		logger.info("Project User Page is loaded");
	}

	/**
	 * elements
	 */

	private Sb4ProjectUserPage fNameSearch(String value) {

		WebElement fNameTxt = _driver.findElement(fName);
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage lNameSearch(String value) {

		WebElement fNameTxt = _driver.findElement(lName);
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage emailSearch(String value) {

		WebElement fNameTxt = _driver.findElement(email);
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage roleSearch(String value) {

		WebElement fNameTxt = _driver.findElement(role);
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage rKey() {

		waitForElementPresence(rKeyButton, 10);
		return this;
	}

	private Sb4ProjectUserPage delReg() {

		waitForElementPresence(delReg, 10);
		return this;
	}

	private Sb4ProjectUserPage editUser() {

		_driver.findElement(editUserButton).click();
		return this;
	}

	private Sb4ProjectUserPage NUFname(String value) {

		_driver.findElement(NUFName).sendKeys(value);
		;
		return this;
	}

	private Sb4ProjectUserPage NULname(String value) {

		_driver.findElement(NULName).sendKeys(value);
		;
		return this;
	}

	private Sb4ProjectUserPage NUEmail(String value) {

		_driver.findElement(NUEmail).sendKeys(value);
		;
		return this;
	}

	private Sb4ProjectUserPage NURole(String value) {

		Select dropdown = new Select(_driver.findElement(NURole));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4ProjectUserPage clickEnter() {

		_driver.findElement(enter).click();
		return this;
	}

	private String GetKey(UserRegPOJO obj) throws InterruptedException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		String aVariable = new DbUtil().B4PubData(obj.getEmail(),
				obj.getStatement(), obj.getDb_url(), obj.getDb_username(),
				obj.getDb_pword(), obj.getDb_reg_key());
		String link = String.format(keyUrl, aVariable);
		logger.info(link);

		return link;
	}

	/**
	 * services
	 */

	/**
	 * used to fill out the user register section of user admin
	 * 
	 * @param obj
	 *            : of UserRegPOJO
	 * @return : the url to the users register profile page. this is a standard
	 *         url concatonated with the register key from b4pub.
	 * @throws InterruptedException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String regNewUser(UserRegPOJO obj) throws InterruptedException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {

		NUFname(obj.getfName());
		NULname(obj.getlName());
		NUEmail(obj.getEmail());
		NURole(obj.getRole());
		clickEnter();
		waitForElementPresence(userRegMsg, 10);
		String key = GetKey(obj);
		return key;
	}

	public Sb4ProjectUserPage userSearch(UserRegPOJO obj) {
		_driver.navigate().refresh();
		fNameSearch(obj.getfName());
		lNameSearch(obj.getlName());
		emailSearch(obj.getEmail());
		roleSearch(obj.getRole());
		return this;
	}

	public Sb4ProjectUserPage userRegButtons() {
		rKey();
		delReg();
		return this;
	}

	public int userRegSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		return _driver.findElements(rKeyButton).size();
	}

	/**
	 * used to search for registered users
	 * 
	 * @param obj
	 *            : of UserRegPOJO
	 * @return : int count
	 */
	public int userSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		return _driver.findElements(editUserButton).size();
	}

	public Sb4ProjNRolePage editUser(UserRegPOJO obj)
			throws InterruptedException {
		if (userSearchCount(obj) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		userSearch(obj);
		editUser();
		return new Sb4ProjNRolePage(_driver);
	}

	public Sb4ProjectUserPage deleteRegUser(UserRegPOJO obj)
			throws InterruptedException {
		userSearch(obj).userRegButtons();
		_driver.findElement(delReg).click();
		Alert alert = _driver.switchTo().alert();
		alert.accept();
		Thread.sleep(20000);
		Alert alert2 = _driver.switchTo().alert();
		alert2.accept();
		_driver.navigate().refresh();
		return this;
	}

	public Sb4LoginPage LogOut() throws InterruptedException {
		um.LogOut();
		return new Sb4LoginPage(_driver);
	}
}