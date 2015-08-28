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
public class Sb4EditUserPage extends Page {

	/**
	 * locators
	 */
	private By editUserTile = By.xpath("//*[.='Edit User']");
	private By userName = By.xpath("//*[@name='username']");
	private By eMail = By.xpath("//*[@name='email']");
	private By fName = By.xpath("//*[@name='firstname']");
	private By lName = By.xpath("//*[@name='lastname']");
	private By phone = By.xpath("//*[@name='phone']");
	private By google = By.xpath("//*[@name='googleplus']");
	private By yahoo = By.xpath("//*[@name='yahoo']");
	private By twitter = By.xpath("//*[@name='twitter']");
	private By linkedin = By.xpath("//*[@name='linkedin']");
	private By pintrest = By.xpath("//*[@name='pinterest']");
	private By instagram = By.xpath("//*[@name='instagram']");
	private By fbook = By.xpath("//*[@name='facebook']");
	private By pNR = By.xpath("//button[@id='projects_roles_submitButton']");
	private By submit = By
			.xpath("//button[@id='admin_edit_user_submitButton']");
	private By cancel = By.xpath("//button[@id='admin_edit_user_resetButton']");
	private By bio = By.xpath("//textarea[@id='admin_edit_user_bio']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4EditUserPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(editUserTile, bio);
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
	private Sb4EditUserPage clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * cancel button
	 * 
	 * @return
	 */
	public Sb4EditUserPage clickCancel() {
		_driver.findElement(cancel).click();
		return this;
	}
	
	/**
	 * profile project and roles button
	 * 
	 * @return
	 */
	private Sb4EditUserPage clickProjNRoles() {
		_driver.findElement(pNR).click();
		return this;
	}

	/**
	 * used to assert correct message appears upon a successful and or
	 * Unsuccessful profile update
	 * 
	 * @param successmsg
	 * @return
	 */
	private Sb4EditUserPage msgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	private String getUName() {
		disabledCheck(userName);
		return _driver.findElement(userName).getAttribute("value");
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
	private Sb4EditUserPage setFName(String value) {
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
	private Sb4EditUserPage setLName(String value) {
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
	private Sb4EditUserPage setPhone(String value) {
		_driver.findElement(phone).clear();
		_driver.findElement(phone).sendKeys(value);
		return this;
	}

	private String getBio() {
		return _driver.findElement(bio).getText().trim();
	}

	/**
	 * used to set value into phone field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4EditUserPage setBio(String value) {
		_driver.findElement(phone).clear();
		_driver.findElement(phone).sendKeys(value);
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
	private Sb4EditUserPage setGoogle(String value) {
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
	private Sb4EditUserPage setYahoo(String value) {
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
	private Sb4EditUserPage setTwitter(String value) {
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
	private Sb4EditUserPage setLinkedin(String value) {
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
	private Sb4EditUserPage setPintrest(String value) {
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
	private Sb4EditUserPage setFBook(String value) {
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
	private Sb4EditUserPage setInstagram(String value) {
		_driver.findElement(instagram).clear();
		_driver.findElement(instagram).sendKeys(value);
		return this;
	}

	/**
	 * updates all values of the User Profile
	 * 
	 * @param obj
	 *            : of ProfilePOJO
	 * @return
	 */
	private Sb4EditUserPage updateUser(ProfilePOJO obj) {

		logger.info("Begin User Update");
		setFName(obj.getfName());
		setLName(obj.getlName());
		setBio(obj.getBio());
		setPhone(obj.getPhone());
		setFBook(obj.getfBook());
		setGoogle(obj.getGoogle());
		setYahoo(obj.getYahoo());
		setTwitter(obj.getTwitter());
		setLinkedin(obj.getLinkedin());
		setPintrest(obj.getPinterest());
		setInstagram(obj.getInstagram());
		logger.info("Update User complete");
		return this;
	}

	/**
	 * Services
	 */

	public Sb4EditUserPage successfullUpdate(ProfilePOJO obj) {

		updateUser(obj);
		clickSubmit();
		msgChk(obj.getMsg());
		return this;
	}

	public Sb4EditUserPage cancelUpdate(ProfilePOJO obj) {

		logger.info("Begin Profile Update");
		updateUser(obj);
		clickCancel();

		return this;
	}

	/**
	 * used to check values in the form fields of User Profile
	 * 
	 * @return : object of ProfilePOJO
	 */
	public ProfilePOJO checkEditUser() {
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
		obj.setBio(getBio());
		logger.info("Profile info retrieved");
		return obj;
	}
	
	public Sb4ProjNRolePage goToProjNRole() throws InterruptedException{
		
		clickProjNRoles();
		return new Sb4ProjNRolePage(_driver);
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