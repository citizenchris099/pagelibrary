package com.scienergy.development.qa.pages.sb4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.scienergy.development.Test_Enviornment;
import com.scienergy.development.qa.LogInPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * Studio Balfour Log In page class contains methods needed for log in as well
 * as password reset
 * 
 * @author cmanning
 * 
 */
public class Sb4LoginPage extends Page {

	/**
	 * locators
	 */
	private By userName = By.cssSelector("*[name^='usern']");
	private By passWord = By.cssSelector("*[name^='passw']");
	private By signIn = By.xpath("//button[.='Submit']");
	private By forgotPword = By.xpath("//*[.='Forgot Password?']");

	/**
	 * hidden request password locators
	 */
	private By b2Login = By.xpath("//*[.='Back to Login']");
	private By email = By.cssSelector("*[name^='email']");
	private By submit = By.xpath("//button[.='Submit']");

	private SshUtil sshUtil;
	private String keyUrl = new Test_Enviornment().envUrl(slugNAction.getPwrdNonce_dynamic());

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4LoginPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(userName, signIn);
		sshUtil = new SshUtil(_driver);
		logger.info("Log In Page is loaded");
	}

	/**
	 * alt constructor method for failed logins
	 * 
	 * @param driver
	 * @param errormsg
	 *            : error messae that should appear upon failed log in
	 */
	public Sb4LoginPage(WebDriver driver, String errormsg) {
		super(driver);
		waitForElementVisable(userName);
		waitForElementVisable(passWord);
		waitForElementVisable(signIn);
		By err = By.xpath("//*[contains(text(), '" + errormsg + "')]");
		waitForElementVisable(err);
	}

	/**
	 * elements
	 */

	/**
	 * log in page user name field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4LoginPage setUname(String value) {
		_driver.findElement(userName).sendKeys(value);
		return this;
	}

	/**
	 * log in page password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4LoginPage setPword(String value) {
		_driver.findElement(passWord).sendKeys(value);
		return this;
	}

	/**
	 * log in page forgot password button
	 * 
	 * @return
	 */
	private Sb4LoginPage clickForgotPword() {
		_driver.findElement(forgotPword).click();
		return this;
	}

	/**
	 * sign in button on main log in screen
	 * 
	 * @return
	 */
	private Sb4LoginPage clickSignin() {
		_driver.findElement(signIn).click();
		return this;
	}

	/**
	 * hidden submit button on reset password page iterates through all submit
	 * buttons until it finds a visible one then clicks visible button
	 * 
	 * @return
	 */
	private Sb4LoginPage clickSubmit() {
		java.util.List<WebElement> allElements = _driver.findElements(submit);
		for (WebElement t : allElements) {
			if (t.isDisplayed()) {
				t.click();
			}
		}
		return this;
	}

	/**
	 * hidden request password elements
	 */

	/**
	 * hidden forgot password email field only visible after having clicked
	 * forgot password button
	 * 
	 * @param value
	 * @return
	 */
	public Sb4LoginPage setEmail(String value) {
		_driver.findElement(email).sendKeys(value);
		return this;
	}

	/**
	 * takes you back to main log in page original fields will now be visible
	 * 
	 * @return
	 */
	private Sb4LoginPage clickb2Login() {
		_driver.findElement(b2Login).click();
		return this;
	}

	/**
	 * goes back to main log in page. asserts visibility of original user name
	 * field.
	 * 
	 * @return
	 */
	public Sb4LoginPage GoB2Login() {
		clickb2Login();
		waitForElementVisable(userName);
		return this;
	}

	/**
	 * reveals hidden forgot password elements
	 * 
	 * @return
	 */
	public Sb4LoginPage go2ResetPword() {
		clickForgotPword();
		return this;
	}

	/**
	 * services
	 */
	/**
	 * normal front end user log in
	 * 
	 * @param unameVal
	 * @param pwordVal
	 * @return: Dashboard Page constructor should be called
	 * @throws InterruptedException
	 */
	public Sb4HomePage loginAs(String unameVal, String pwordVal) throws InterruptedException {
		logger.info("Begin LogIn");
		setUname(unameVal);
		setPword(pwordVal);
		clickSignin();
		return new Sb4HomePage(_driver);
	}

	/**
	 * back end admin user log in
	 * 
	 * @param unameVal
	 * @param pwordVal
	 * @return: Dashboard Page constructor should be called
	 * @throws InterruptedException
	 */
	public Sb4AdminDashboardPage loginAsAdmin(String unameVal, String pwordVal) throws InterruptedException {
		setUname(unameVal);
		setPword(pwordVal);
		clickSignin();
		return new Sb4AdminDashboardPage(_driver);
	}

	/**
	 * used to test bad log in
	 * 
	 * @param unameVal
	 * @param pwordVal
	 * @return: bad log in constructor should be called as the error message is
	 *          being passed
	 */
	public Sb4LoginPage badloginAs(String unameVal, String pwordVal) {
		setUname(unameVal);
		setPword(pwordVal);
		clickSignin();
		return new Sb4LoginPage(_driver, "Invalid Username/Password");
	}

	/**
	 * used to test disabled user login
	 * 
	 * @param unameVal
	 * @param pwordVal
	 * @return
	 */
	public Sb4LoginPage disabledloginAs(String unameVal, String pwordVal) {
		setUname(unameVal);
		setPword(pwordVal);
		clickSignin();
		return new Sb4LoginPage(_driver, "Please contact your Balfour representative");
	}

	/**
	 * request password services
	 */

	/**
	 * clicks the submit button asserts presence of message indicating email
	 * sent.
	 * 
	 * @param msg
	 * @return
	 */
	public Sb4LoginPage requestPwordEmail(String msg) {
		clickSubmit();
		By err = By.xpath("//*[contains(text(), '" + msg + "')]");
		waitForElementVisable(err);
		GoB2Login();
		return this;
	}

	/**
	 * ssh methods (used to delete and then check for email log files)
	 */

	/**
	 * used to delete the reset password log file..
	 * 
	 * @param ip
	 *            : of aws instance
	 * @param authusr
	 *            : user name
	 * @param cmd
	 *            : command
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public Sb4LoginPage delEmailLogFile(String ip, String authusr, String cmd) throws IOException, URISyntaxException {
		sshUtil.rmFile(ip, authusr, cmd);

		return this;
	}

	/**
	 * used to assert presence of the reset password log file..
	 * 
	 * @param ip
	 *            : of aws instance
	 * @param authusr
	 *            : user name
	 * @param cmd
	 *            : command
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public Sb4LoginPage chkEmailLogFile(String ip, String authusr, String cmd)
			throws IOException, URISyntaxException, InterruptedException {
		sshUtil.lsFile(ip, authusr, cmd);

		return this;
	}

	/**
	 * used in reset password tests. concatenates a known url with a db nonce
	 * 
	 * @param obj
	 *            : LogInPOJO
	 * @return
	 * @throws InterruptedException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Sb4PwrdUpdatePage GetPwrdKey(LogInPOJO obj) throws InterruptedException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		String aVariable = new DbUtil().B4PubData(obj.getUserId(), obj.getStatement(), obj.getDb_url(),
				obj.getDb_username(), obj.getDb_pword(), obj.getDb_reg_key());
		String link = String.format(keyUrl, aVariable);
		logger.info(link);
		_driver.get(link);

		return new Sb4PwrdUpdatePage(_driver);
	}
}