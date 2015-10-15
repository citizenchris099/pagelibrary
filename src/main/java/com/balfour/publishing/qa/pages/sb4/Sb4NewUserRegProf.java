package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.UserRegProfilePOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Used in Studio Balfour User Registration process. This is the second page in
 * the process. Here the user sets their initial profile values
 * 
 * @author cmanning
 * 
 */
public class Sb4NewUserRegProf extends Page {

	/**
	 * locators
	 */
	private By newRegTitle = By.xpath("//*[.='Register']");
	private By userName = By.xpath("//input[@name='username']");
	private By eMail = By.xpath("//input[@name='email_visible']");
	private By fName = By.xpath("//input[@name='firstname']");
	private By lName = By.xpath("//input[@name='lastname']");
	private By phone = By.xpath("//input[@name='phone']");
	private By disName = By.xpath("//input[@name='displayname']");
	private By google = By.xpath("//input[@name='googleplus']");
	private By yahoo = By.xpath("//input[@name='yahoo']");
	private By twitter = By.xpath("//input[@name='twitter']");
	private By linkedin = By.xpath("//input[@name='linkedin']");
	private By pintrest = By.xpath("//input[@name='pinterest']");
	private By instagram = By.xpath("//input[@name='instagram']");
	private By fbook = By.xpath("//input[@name='facebook']");
	private By pwd1 = By.xpath("//input[@name='pwd1']");
	private By pwd2 = By.xpath("//input[@name='pwd2']");
	private By submit = By.xpath("//button[.='Submit']");

	/**
	 * constructor that uses shared is loaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @param url
	 *            : unique url uses the user_register_key from b4_pub is passed
	 * @throws InterruptedException
	 */
	public Sb4NewUserRegProf(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(newRegTitle, yahoo);
		logger.info("Sb4NewUserRegProf loaded");
	}

	/**
	 * elements
	 */

	/**
	 * profile submit button
	 * 
	 * @return
	 */
	private Sb4NewUserRegProf clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * used to assert correct message appears upon a successful and or
	 * Unsuccessful profile update
	 * 
	 * @param successmsg
	 * @return
	 */
	private Sb4NewUserRegProf userRegMsgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	private String getUName() {
		return _driver.findElement(userName).getAttribute("value");
	}

	/**
	 * used to set the username value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setUName(String value) {
		_driver.findElement(userName).sendKeys(value);
		return this;
	}

	private String getEmail() {
		disabledCheck(eMail);
		return _driver.findElement(eMail).getAttribute("value");
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
	private Sb4NewUserRegProf setFName(String value) {
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
	private Sb4NewUserRegProf setLName(String value) {
		_driver.findElement(lName).sendKeys(value);
		return this;
	}

	/**
	 * used to set the phone value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setPhone(String value) {
		_driver.findElement(phone).sendKeys(value);
		return this;
	}

	private String getDName() {
		WebElement no = _driver.findElement(disName);
		JavascriptExecutor jse = (JavascriptExecutor) _driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", no);
		return _driver.findElement(disName).getAttribute("value");
	}

	/**
	 * used to set the display name value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setDName(String value) {
		_driver.findElement(disName).sendKeys(value);
		return this;
	}

	/**
	 * used to set the google value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setGoogle(String value) {
		_driver.findElement(google).sendKeys(value);
		return this;
	}

	/**
	 * used to set the Yahoo value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setYahoo(String value) {
		_driver.findElement(yahoo).sendKeys(value);
		return this;
	}

	/**
	 * used to set the twitter value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setTwitter(String value) {
		_driver.findElement(twitter).sendKeys(value);
		return this;
	}

	/**
	 * used to set the linkedin value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setLinkedin(String value) {
		_driver.findElement(linkedin).sendKeys(value);
		return this;
	}

	/**
	 * used to set the pinterest value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setPintrest(String value) {
		_driver.findElement(pintrest).sendKeys(value);
		return this;
	}

	/**
	 * used to set the facebook value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setFBook(String value) {
		_driver.findElement(fbook).sendKeys(value);
		return this;
	}

	/**
	 * used to set the instagram value
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setInstagram(String value) {
		_driver.findElement(instagram).sendKeys(value);
		return this;
	}

	/**
	 * used to set value into password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setPWord1(String value) {
		_driver.findElement(pwd1).sendKeys(value);
		return this;
	}

	/**
	 * used to set value into confirm password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4NewUserRegProf setPWord2(String value) {
		_driver.findElement(pwd2).sendKeys(value);
		return this;
	}

	/**
	 * services
	 */

	/**
	 * used to fill out the initial user registration profile form
	 * 
	 * @param obj
	 *            : UserRegPOJO
	 * @param uname
	 *            : boolean value denotes whether a unique username is entered.
	 *            if true is passed then the users first name will be entered as
	 *            the unique username.
	 * @param social
	 *            : denotes whether social fields are filled out.
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4NewUserRegProf doReg(UserRegPOJO obj, Boolean social) throws InterruptedException {

		logger.info("Begin completion of registration process");
		setUName(obj.getEmail());
		setFName(obj.getfName());
		setLName(obj.getlName());
		setPhone(obj.getPhone());

		if (social == true) {
			setFBook(obj.getfBook());
			setGoogle(obj.getGoogle());
			setYahoo(obj.getYahoo());
			setTwitter(obj.getTwitter());
			setLinkedin(obj.getLinkedin());
			setPintrest(obj.getPinterest());
			setInstagram(obj.getInstagram());
		}
		setPWord1(obj.getPword());
		setPWord2(obj.getPword());
		clickSubmit();
		userRegMsgChk(obj.getMsg());
		logger.info("registration process complete");
		return this;
	}

	public UserRegPOJO chkValues() {

		logger.info("Begin initial values check");
		UserRegPOJO obj = new UserRegPOJO();

		obj.setuName(getUName());
		obj.setEmail(getEmail());
		obj.setfName(getFname());
		obj.setlName(getLname());
		return obj;
	}
}