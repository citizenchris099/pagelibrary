package com.balfour.publishing.qa.pages.sb4;

import java.sql.SQLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;

public class Sb4UserAdminPage extends Page {

	Actions action = new Actions(_driver);

	/**
	 * locators
	 */
	private By editUserButton = By.xpath(".//button[.='Edit User']");
	private By rKeyButton = By.xpath("//button[.='Resend Key']");
	private By delReg = By.xpath("//button[.='Delete Registration']");
	private By search = By.xpath(".//input[@type='text']");
	private By NUFName = By.xpath("//input[@name='first_name']");
	private By NULName = By.xpath("//input[@name='last_name']");
	private By NUEmail = By.xpath("//input[@name='email']");
	private By NURole = By.xpath("//select[@name='role']");
	private By NUProj = By.xpath("//div[contains(@id,'_project_chosen')]");
	private By NUProjTxt = By.xpath(".//input[@type='text']");
	private By enter = By.xpath("//button[@type='submit']");
	private By userRegMsg = By.xpath("//div[contains(text(), 'User Added')]");
	private By gridElement = By.xpath(".//div[@class='ui-grid-cell-contents ng-binding ng-scope']");

	/**
	 * webelements
	 */
	private WebElement fNameTxt = _driver.findElement(By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0004')]"));
	private WebElement lNameTxt = _driver.findElement(By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0005')]"));
	private WebElement email = _driver.findElement(By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0006')]"));
	private WebElement role = _driver.findElement(By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0009')]"));
	private WebElement project = _driver.findElement(By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0008')]"));

	private WebElement fNameField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0004')]"));
	private WebElement lNameField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0005')]"));
	private WebElement emailField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0006')]"));
	private WebElement roleField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0009')]"));

	private String keyUrl = new Test_Enviornment().envUrl(slugNAction.getnReg_dynamic());
	UserMenu um = new UserMenu(_driver);

	public Sb4UserAdminPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(NULName, NUFName);
		logger.info("User Admin Page is loaded");
	}

	/**
	 * elements
	 */

	private Sb4UserAdminPage fNameSearch(String value) {
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4UserAdminPage lNameSearch(String value) {
		lNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4UserAdminPage emailSearch(String value) {
		email.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4UserAdminPage projSearch(String value) {
		project.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4UserAdminPage roleSearch(String value) {
		role.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4UserAdminPage editUser() {

		_driver.findElement(editUserButton).click();
		return this;
	}

	private Sb4UserAdminPage rKey() {

		waitForElementPresence(rKeyButton, 10);
		return this;
	}

	private Sb4UserAdminPage delReg() {

		waitForElementPresence(delReg, 10);
		return this;
	}

	private Sb4UserAdminPage userSearch(UserRegPOJO obj) {
		// _driver.navigate().refresh();
		fNameSearch(obj.getfName());
		lNameSearch(obj.getlName());
		if (obj.getEmailSearch() == true) {
			emailSearch(obj.getEmail());
		}
		projSearch(obj.getProject());
		roleSearch(obj.getRole());
		return this;
	}

	private int userRegSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		rKey();
		delReg();
		return _driver.findElements(rKeyButton).size();
	}

	/**
	 * used to search for registered users
	 * 
	 * @param obj
	 *            : of UserRegPOJO
	 * @return : int count
	 */
	private int userSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		editUser();
		return _driver.findElements(editUserButton).size();
	}

	private Sb4UserAdminPage NUFname(String value) {

		_driver.findElement(NUFName).sendKeys(value);
		;
		return this;
	}

	private Sb4UserAdminPage NULname(String value) {

		_driver.findElement(NULName).sendKeys(value);
		;
		return this;
	}

	private Sb4UserAdminPage NUEmail(String value) {

		_driver.findElement(NUEmail).sendKeys(value);
		;
		return this;
	}

	private Sb4UserAdminPage NURole(String value) {

		Select dropdown = new Select(_driver.findElement(NURole));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4UserAdminPage NUProject(String value) {

		WebElement proj = _driver.findElement(NUProj);
		proj.click();
		proj.findElement(NUProjTxt).sendKeys(value + Keys.RETURN);
		return this;
	}

	private Sb4UserAdminPage clickEnter() {

		_driver.findElement(enter).click();
		return this;
	}

	private String GetKey(UserRegPOJO obj) throws InterruptedException, InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		String aVariable = new DbUtil().B4PubData(obj.getEmail(), obj.getStatement(), obj.getDb_url(),
				obj.getDb_username(), obj.getDb_pword(), obj.getDb_reg_key());
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
	public String regNewUser(UserRegPOJO obj) throws InterruptedException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {

		NUFname(obj.getfName());
		NULname(obj.getlName());
		NUEmail(obj.getEmail());
		NURole(obj.getRole());
		NUProject(obj.getProject());
		clickEnter();
		waitForElementPresence(userRegMsg, 10);
		return GetKey(obj);
	}

	/**
	 * assures that a user is found on the User Admin grid
	 * 
	 * @param obj
	 * @return
	 */
	public Sb4UserAdminPage userFound(UserRegPOJO obj) {
		if (userSearchCount(obj) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		return this;
	}

	public Sb4UserAdminPage userRegFound(UserRegPOJO obj) {
		if (userRegSearchCount(obj) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		return this;
	}

	/**
	 * used to edit the first name of a user on the User Admin Grid
	 * 
	 * @param value
	 * @return
	 */
	public Sb4UserAdminPage fNameEdit(String value) {
		action.doubleClick(fNameField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	/**
	 * edit the last name of a user found on the User Admin grid
	 * 
	 * @param value
	 * @return
	 */
	public Sb4UserAdminPage lNameEdit(String value) {
		action.doubleClick(lNameField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	/**
	 * edit the email of a user found on the User Admin grid
	 * 
	 * @param value
	 * @return
	 */
	public Sb4UserAdminPage emailEdit(String value) {
		action.doubleClick(emailField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public Sb4UserAdminPage roleEdit(String value) {
		action.doubleClick(roleField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	public Sb4EditUserPage editUser(UserRegPOJO obj) throws InterruptedException {
		userFound(obj);
		editUser();
		return new Sb4EditUserPage(_driver);
	}

	public Sb4UserAdminPage deleteRegUser(UserRegPOJO obj) throws InterruptedException {
		userRegFound(obj);
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