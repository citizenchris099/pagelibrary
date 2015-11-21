package com.scienergy.development.qa.pages.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * 'todopoc' or 'Spectrum' login page
 * 
 * @author cmanning
 * 
 */
public class SpecLoginPage extends Page {

	/**
	 * locators
	 */
	private By sciLogo = By.xpath("//img[@src='/images/SCIenergy_logo.png']");
	private By userName = By.xpath("//input[@placeholder='Username']");
	private By passWord = By.xpath("//input[@placeholder='Password']");
	private By login = By.xpath("//input[@type='submit']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public SpecLoginPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(sciLogo, login);
		logger.info("Spec Log In Page is loaded");
	}

	/**
	 * alt constructor method for failed logins
	 * 
	 * @param driver
	 * @param errormsg
	 *            : error message that should appear upon failed log in
	 * @throws InterruptedException
	 */
	public SpecLoginPage(WebDriver driver, String errormsg) throws InterruptedException {
		super(driver);
		isLoaded(sciLogo, login);
		waitForElementVisable(dynamicMsg(errormsg));
	}

	/**
	 * elements
	 */

	/**
	 * log in page username field
	 * 
	 * @param value
	 *            : of username to enter
	 * @return : SpecLoginPage
	 */
	private SpecLoginPage setUname(String value) {
		findElement(userName).sendKeys(value);
		return this;
	}

	/**
	 * log in page password field
	 * 
	 * @param value
	 *            : of password to enter
	 * @return : SpecLoginPage
	 */
	private SpecLoginPage setPword(String value) {
		findElement(passWord).sendKeys(value);
		return this;
	}

	/**
	 * sign in button on main log in screen
	 * 
	 * @return : SpecLoginPage
	 */
	private SpecLoginPage clickSignin() {
		findElement(login).click();
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
	 * @return: SpecMainPage
	 * @throws InterruptedException
	 */
	public SpecMainPage loginAs(String unameVal, String pwordVal) throws InterruptedException {
		logger.info("Begin LogIn");
		setUname(unameVal).setPword(pwordVal).clickSignin();
		return new SpecMainPage(_driver);
	}

	/**
	 * used to test bad log in
	 * 
	 * @param unameVal
	 * @param pwordVal
	 * @return: bad log in constructor should be called as the error message is
	 *          being passed
	 * @throws InterruptedException
	 */
	public SpecLoginPage loginAs(String unameVal, String pwordVal, String expectedError) throws InterruptedException {
		setUname(unameVal).setPword(pwordVal).clickSignin();
		return new SpecLoginPage(_driver, expectedError);
	}

}