package com.balfour.publishing.qa.pages.sb4;

import java.sql.SQLException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;

public class Sb4ProjectUserPage extends Page {

	Actions action = new Actions(_driver);

	/**
	 * locators
	 */
	private By aNewUser = By.xpath("//a[@href='#new_register_form']");
	private By regNewUser = By.xpath("//div[@id='register_form_alert']");
	private By rKeyButton = By.xpath("//button[.='Resend Key']");
	private By search = By.xpath(".//input[@type='text']");
	private By NUFName = By.xpath("//input[@name='first_name']");
	private By NULName = By.xpath("//input[@name='last_name']");
	private By NUEmail = By.xpath("//input[@name='email']");
	private By NURole = By.xpath("//select[contains(@id,'_role')]");
	private By FURole = By.xpath("//select[@class='form-control field-required addedRows']");
	private By enter = By.xpath("//button[@type='submit']");
	private By userRegMsg = By.xpath("//div[contains(text(), 'User Added')]");
	private By delReg = By.xpath("//button[.='Delete Registration']");
	private By editUserButton = By.xpath(".//button[.='Edit User']");
	private By noEmail = By.xpath(".//input[@name='fakeEmail']");
	private By noEmailUName = By.xpath(".//input[@name='user_name']");
	private By noEmailPword1 = By.xpath(".//input[@name='pwd1']");
	private By noEmailPword2 = By.xpath(".//input[@name='pwd2']");
	private By gridElement = By.xpath(".//div[@class='ui-grid-cell-contents ng-binding ng-scope']");
	private By fnSearch = By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0004')]");
	private By fnField = By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0004')]");
	private By lnSearch = By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0005')]");
	private By lnField = By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0005')]");
	private By emSearch = By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0006')]");
	private By emField = By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0006')]");
	private By roSearch = By.xpath(
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0007')]");
	private By roField = By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0007')]");

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
		WebElement fNameTxt = _driver.findElement(fnSearch);
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage lNameSearch(String value) {
		WebElement lNameTxt = _driver.findElement(lnSearch);
		lNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage emailSearch(String value) {
		WebElement email = _driver.findElement(emSearch);
		email.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage roleSearch(String value) {
		WebElement role = _driver.findElement(roSearch);
		role.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage userSearch(UserRegPOJO obj) {
		// _driver.navigate().refresh();
		fNameSearch(obj.getfName());
		lNameSearch(obj.getlName());
		if (obj.getEmailSearch() == true) {
			emailSearch(obj.getEmail());
		}
		roleSearch(obj.getRole());
		return this;
	}

	private int userRegSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		return _driver.findElements(rKeyButton).size();
	}

	private int userSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		return _driver.findElements(editUserButton).size();
	}

	private Sb4ProjectUserPage editUser() {
		_driver.findElement(editUserButton).click();
		return this;
	}

	private Sb4ProjectUserPage fakeUser() {
		_driver.findElement(noEmail).click();
		return this;
	}

	private Sb4ProjectUserPage NUFname(String value) {
		_driver.findElement(NUFName).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage NULname(String value) {
		_driver.findElement(NULName).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage NUEmail(String value) {
		_driver.findElement(NUEmail).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage NURole(String value) {
		Select dropdown = new Select(_driver.findElement(NURole));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4ProjectUserPage FURole(String value) {
		Select dropdown = new Select(_driver.findElement(FURole));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4ProjectUserPage rolesAvailable(String[] array) throws InterruptedException {
		try {
			logger.info("checking the fake user roles");
			optionsAvailable(array, FURole);
		} catch (RuntimeException e) {
			logger.info("expected fake user roles didn't match");
			LogOut();
			throw (e);
		}
		return this;
	}

	private Sb4ProjectUserPage FakeUName(String value) {
		_driver.findElement(noEmailUName).clear();
		_driver.findElement(noEmailUName).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage FakePword1(String value) {

		_driver.findElement(noEmailPword1).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage FakePword2(String value) {

		_driver.findElement(noEmailPword2).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage clickEnter() {

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
		logger.info("begin registering new user");
		NUFname(obj.getfName());
		NULname(obj.getlName());
		NUEmail(obj.getEmail());
		NURole(obj.getRole());
		clickEnter();
		waitForElementPresence(userRegMsg, 10);
		String key = GetKey(obj);
		return key;
	}

	public Sb4ProjectUserPage createFakeUser(UserRegPOJO obj, String[] roles) throws InterruptedException,
			InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		logger.info("begin creating fake user");
		fakeUser();
		NUFname(obj.getfName());
		NULname(obj.getlName());
		rolesAvailable(roles);
		FURole(obj.getRole());
		FakeUName(obj.getuName());
		FakePword1(obj.getPword());
		FakePword2(obj.getPword());
		try{
		clickEnter();
		waitForElementPresence(userRegMsg, 10);
		}catch(UnhandledAlertException e){
			logger.info("unexpected alert present");
			throw(e);
		}
		logger.info("fake user created");
		return this;
	}

	public Sb4ProjectUserPage checkFakeUserRoles(String[] roles) throws InterruptedException {
		fakeUser();
		rolesAvailable(roles);
		logger.info("correct roles available for fake user");
		return this;
	}

	public Sb4ProjectUserPage userFound(UserRegPOJO obj) {
		if (userSearchCount(obj) < 1) {
			logger.info("user was not found");
			throw new RuntimeException("User Was Not Found");
		}
		return this;
	}

	public Sb4ProjectUserPage userRegFound(UserRegPOJO obj) {
		if (userRegSearchCount(obj) < 1) {
			logger.info("user register was not found");
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
	public Sb4ProjectUserPage fNameEdit(UserRegPOJO obj) {
		logger.info("editing first name");
		waitForElementPresence(fnField, 10);
		WebElement fNameField = _driver.findElement(fnField);
		action.doubleClick(fNameField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(obj.getfName() + Keys.ENTER);
		return this;
	}

	/**
	 * edit the last name of a user found on the User Admin grid
	 * 
	 * @param value
	 * @return
	 */
	public Sb4ProjectUserPage lNameEdit(UserRegPOJO obj) {
		logger.info("editing last name");
		waitForElementPresence(lnField, 10);
		WebElement lNameField = _driver.findElement(lnField);
		action.doubleClick(lNameField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(obj.getlName() + Keys.ENTER);
		return this;
	}

	/**
	 * edit the email of a user found on the User Admin grid
	 * 
	 * @param value
	 * @return
	 */
	public Sb4ProjectUserPage emailEdit(UserRegPOJO obj) {
		logger.info("editing email");
		waitForElementPresence(emField, 10);
		WebElement emailField = _driver.findElement(emField);
		action.doubleClick(emailField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(obj.getEmail() + Keys.ENTER);
		return this;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public Sb4ProjectUserPage roleEdit(UserRegPOJO obj) {
		logger.info("editing role");
		waitForElementPresence(roField, 10);
		WebElement roleField = _driver.findElement(roField);
		action.doubleClick(roleField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().sendKeys(obj.getRole() + Keys.ENTER);
		return this;
	}

	/**
	 * searches for then clicks to edit the user
	 * 
	 * @param obj
	 *            : of UserRegPOJO
	 * @return : Sb4EditUserPage
	 * @throws InterruptedException
	 */
	public Sb4EditUserPage editUser(UserRegPOJO obj) throws InterruptedException {
		userFound(obj);
		editUser();
		return new Sb4EditUserPage(_driver);
	}
	
	public Sb4EditFakeUserPage editFakeUser(UserRegPOJO obj) throws InterruptedException {
		userFound(obj);
		editUser();
		return new Sb4EditFakeUserPage(_driver);
	}

	public Sb4ProjectUserPage deleteRegUser(UserRegPOJO obj) throws InterruptedException {
		logger.info("attempting to delete user register");
		userRegFound(obj);
		_driver.findElement(delReg).click();
		Alert alert = _driver.switchTo().alert();
		alert.accept();
		Thread.sleep(20000);
		Alert alert2 = _driver.switchTo().alert();
		alert2.accept();
		_driver.navigate().refresh();
		logger.info("user register deleted");
		return this;
	}

	public Sb4LoginPage LogOut() throws InterruptedException {
		um.LogOut();
		return new Sb4LoginPage(_driver);
	}

	/**
	 * shared change project service for users w/ <8 projects
	 * 
	 * @param mainProj
	 *            : initial project present in the menu
	 * @param nextProj
	 *            : desired project to switch to
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjectUserPage ChangeProject(String nextProj) throws InterruptedException {
		um.projectMenu(nextProj);
		return this;
	}

	/**
	 * shared change project service for users w/ >8 projects
	 * 
	 * @param mainProj
	 *            : initial project present in the menu
	 * @param nextProj
	 *            : desired project to switch to
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjectUserPage ChangeProject2(String nextProj) throws InterruptedException {
		um.projectMenuSearch(nextProj);
		return this;
	}
}