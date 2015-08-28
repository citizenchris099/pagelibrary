package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.ProfilePOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Class contains Studio Balfour Profile Page objects this is the page where a
 * user edits various aspects of their profile changes made here should be
 * reflected within enfold as well as the Studio Balfour Back End
 * 
 * @author cmanning
 * 
 */
public class Sb4ProfilePage extends Page {

	/**
	 * locators
	 */
	private By profileTile = By.xpath("//*[.='Profile']");
	private By userName = By.xpath("//*[@name='username']");
	private By eMail = By.xpath("//*[@name='email']");
	private By fName = By.xpath("//*[@name='firstname']");
	private By lName = By.xpath("//*[@name='lastname']");
	private By phone = By.xpath("//*[@name='phone']");
	private By disName = By.xpath("//select[@name='displayname']");
	private By google = By.xpath("//*[@name='googleplus']");
	private By yahoo = By.xpath("//*[@name='yahoo']");
	private By twitter = By.xpath("//*[@name='twitter']");
	private By linkedin = By.xpath("//*[@name='linkedin']");
	private By pintrest = By.xpath("//*[@name='pinterest']");
	private By instagram = By.xpath("//*[@name='instagram']");
	private By fbook = By.xpath("//*[@name='facebook']");
	private By pwd1 = By.xpath("//input[@name='pwd1']");
	private By pwd2 = By.xpath("//input[@name='pwd2']");
	private By submit = By.xpath("//button[.='Submit']");
	private By cancel = By.xpath("//button[.='Cancel']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ProfilePage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(profileTile, twitter);
		logger.info("Profile Page is loaded");
	}

	/**
	 * elements
	 */

	/**
	 * profile submit button
	 * 
	 * @return
	 */
	private Sb4ProfilePage clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * cancel button
	 * 
	 * @return
	 */
	private Sb4ProfilePage clickCancel() {
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
	private Sb4ProfilePage profileMsgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	private String getUName() {
		disabledCheck(userName);
		return _driver.findElement(userName).getAttribute("value");
	}

	private String getEmail() {
		return _driver.findElement(eMail).getAttribute("value");
	}

	/**
	 * used to set value into email field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setEMail(String value) {
		_driver.findElement(eMail).clear();
		_driver.findElement(eMail).sendKeys(value);
		return this;
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
	private Sb4ProfilePage setFName(String value) {
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
	private Sb4ProfilePage setLName(String value) {
		_driver.findElement(lName).clear();
		_driver.findElement(lName).sendKeys(value);
		return this;
	}

	private String getPhone() {
		return _driver.findElement(phone).getAttribute("value");
	}

	/**
	 * used to set value into phone field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setPhone(String value) {
		_driver.findElement(phone).clear();
		_driver.findElement(phone).sendKeys(value);
		return this;
	}

	private String getDName() {
		return new Select(_driver.findElement(disName))
				.getFirstSelectedOption().getText();
	}

	private Sb4ProfilePage setDName(String value) {
		new Select(_driver.findElement(disName)).selectByValue(value);
		return this;
	}

	private String getGoogle() {
		return _driver.findElement(google).getAttribute("value");
	}

	/**
	 * used to set value into google field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setGoogle(String value) {
		_driver.findElement(google).clear();
		_driver.findElement(google).sendKeys(value);
		return this;
	}

	private String getYahoo() {
		return _driver.findElement(yahoo).getAttribute("value");
	}

	/**
	 * used to set value into yahoo field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setYahoo(String value) {
		_driver.findElement(yahoo).clear();
		_driver.findElement(yahoo).sendKeys(value);
		return this;
	}

	private String getTwitter() {
		return _driver.findElement(twitter).getAttribute("value");
	}

	/**
	 * used to set value into twitter field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setTwitter(String value) {
		_driver.findElement(twitter).clear();
		_driver.findElement(twitter).sendKeys(value);
		return this;
	}

	private String getLinkedin() {
		return _driver.findElement(linkedin).getAttribute("value");
	}

	/**
	 * used to set value into linkedin field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setLinkedin(String value) {
		_driver.findElement(linkedin).clear();
		_driver.findElement(linkedin).sendKeys(value);
		return this;
	}

	private String getPintrest() {
		return _driver.findElement(pintrest).getAttribute("value");
	}

	/**
	 * used to set value into pinterest field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setPintrest(String value) {
		_driver.findElement(pintrest).clear();
		_driver.findElement(pintrest).sendKeys(value);
		return this;
	}

	private String getFBook() {
		return _driver.findElement(fbook).getAttribute("value");
	}

	/**
	 * used to set value into facebook field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setFBook(String value) {
		_driver.findElement(fbook).clear();
		_driver.findElement(fbook).sendKeys(value);
		return this;
	}

	private String getInstagram() {
		return _driver.findElement(instagram).getAttribute("value");
	}

	/**
	 * used to set value into instagram field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setInstagram(String value) {
		_driver.findElement(instagram).clear();
		_driver.findElement(instagram).sendKeys(value);
		return this;
	}

	/**
	 * used to set value into password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setPWord1(String value) {
		_driver.findElement(pwd1).sendKeys(value);
		return this;
	}

	/**
	 * used to set value into confirm password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ProfilePage setPWord2(String value) {
		_driver.findElement(pwd2).sendKeys(value);
		return this;
	}

	/**
	 * updates all values of the User Profile
	 * 
	 * @param obj
	 *            : of ProfilePOJO
	 * @return
	 */
	private Sb4ProfilePage updateProfile(ProfilePOJO obj) {

		logger.info("Begin profile Update");
		setEMail(obj.getEmail());
		setFName(obj.getfName());
		setLName(obj.getlName());
		setPhone(obj.getPhone());
		setDName(obj.getdName());
		setFBook(obj.getfBook());
		setGoogle(obj.getGoogle());
		setYahoo(obj.getYahoo());
		setTwitter(obj.getTwitter());
		setLinkedin(obj.getLinkedin());
		setPintrest(obj.getPinterest());
		setInstagram(obj.getInstagram());
		logger.info("profile Update complete");
		return this;
	}

	/**
	 * Services
	 */

	/**
	 * used to set Only the password values of the User Profile.
	 * 
	 * @param obj
	 *            : of ProfilePOJO
	 * @return
	 */
	public Sb4ProfilePage updatePword(ProfilePOJO obj) {

		logger.info("Begin password Update");
		setPWord1(obj.getPword());
		setPWord2(obj.getPword());
		clickSubmit();
		profileMsgChk(obj.getMsg());
		logger.info("password Update complete");
		return this;
	}

	public Sb4ProfilePage successfullUpdate(ProfilePOJO obj) {

		logger.info("Begin Profile Update");
		updateProfile(obj);
		clickSubmit();
		profileMsgChk(obj.getMsg());
		logger.info("Profile Update complete");
		return this;
	}

	public Sb4ProfilePage cancelUpdate(ProfilePOJO obj) {

		logger.info("Begin Profile Update");
		updateProfile(obj);
		clickCancel();

		return this;
	}

	/**
	 * used to check values in the form fields of User Profile
	 * 
	 * @return : object of ProfilePOJO
	 */
	public ProfilePOJO checkProfile() {
		ProfilePOJO obj = new ProfilePOJO();

		obj.setuName(getUName());
		obj.setEmail(getEmail());
		obj.setfName(getFname());
		obj.setlName(getLname());
		obj.setPhone(getPhone());
		obj.setfBook(getFBook());
		obj.setGoogle(getGoogle());
		obj.setYahoo(getYahoo());
		obj.setTwitter(getTwitter());
		obj.setLinkedin(getLinkedin());
		obj.setPinterest(getPintrest());
		obj.setInstagram(getInstagram());
		logger.info("Profile info retrieved");
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