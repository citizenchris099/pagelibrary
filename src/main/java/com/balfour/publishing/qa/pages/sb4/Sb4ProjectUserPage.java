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
			"//div[contains(@class,'ui-grid-header-cell ui-grid-clearfix ng-scope ng-isolate-scope ui-grid-coluiGrid-0007')]"));

	private WebElement fNameField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0004')]"));
	private WebElement lNameField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0005')]"));
	private WebElement emailField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0006')]"));
	private WebElement roleField = _driver
			.findElement(By.xpath("//div[contains(@class,'ui-grid-cell ng-scope ui-grid-coluiGrid-0007')]"));

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
		fNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage lNameSearch(String value) {
		lNameTxt.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage emailSearch(String value) {
		email.findElement(search).sendKeys(value);
		return this;
	}

	private Sb4ProjectUserPage roleSearch(String value) {
		role.findElement(search).sendKeys(value);
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
		editUser();
		return _driver.findElements(rKeyButton).size();
	}

	private int userSearchCount(UserRegPOJO obj) {
		userSearch(obj);
		rKey();
		delReg();
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

	private Sb4ProjectUserPage rolesAvailable(String[] array) {

		optionsAvailable(array, FURole);
		return this;
	}

	private Sb4ProjectUserPage FakeUName(String value) {

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

		fakeUser();
		NUFname(obj.getfName());
		NULname(obj.getlName());
		rolesAvailable(roles);
		FURole(obj.getRole());
		FakeUName(obj.getuName());
		FakePword1(obj.getPword());
		FakePword2(obj.getPword());
		clickEnter();
		waitForElementPresence(userRegMsg, 10);
		return this;
	}

	

	public Sb4ProjectUserPage userFound(UserRegPOJO obj) {
		if (userSearchCount(obj) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		return this;
	}

	public Sb4ProjectUserPage userRegFound(UserRegPOJO obj) {
		if (userRegSearchCount(obj) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		return this;
	}

	public Sb4ProjectUserPage fNameEdit(String value) {
		action.doubleClick(fNameField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	public Sb4ProjectUserPage lNameEdit(String value) {
		action.doubleClick(lNameField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	public Sb4ProjectUserPage emailEdit(String value) {
		action.doubleClick(emailField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().clear();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	public Sb4ProjectUserPage roleEdit(String value) {
		action.doubleClick(roleField.findElement(gridElement)).perform();
		_driver.switchTo().activeElement().sendKeys(value + Keys.ENTER);
		return this;
	}

	public Sb4ProjNRolePage editUser(UserRegPOJO obj) throws InterruptedException {
		userFound(obj);
		editUser();
		return new Sb4ProjNRolePage(_driver);
	}

	public Sb4ProjectUserPage deleteRegUser(UserRegPOJO obj) throws InterruptedException {
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