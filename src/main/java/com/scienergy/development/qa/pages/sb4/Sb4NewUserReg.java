package com.balfour.publishing.qa.pages.sb4;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Used in Studio Balfour User Registration process. This is the initial page in
 * the process.
 * 
 * @author cmanning
 * 
 */
public class Sb4NewUserReg extends Page {

	/**
	 * locators
	 */
	private By newRegTitle = By.xpath("//*[.='New Registration']");
	private By reqProjId = By.xpath("//*[@name='requestProjectID']");
	private By reqEmail = By.xpath("//input[@name='requestEmail']");
	private By reqFName = By.xpath("//input[@name='requestFirstName']");
	private By reqLName = By.xpath("//input[@name='requestLastName']");
	private By reqPWord = By.xpath("//input[@name='requestProjectPassword']");
	private By enter = By.xpath("//button[.='Enter']");

	private String slug = slugNAction.getnReg_dynamic();
	private String keyUrl = new Test_Enviornment().envUrl(slug);

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4NewUserReg(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(newRegTitle, reqProjId);
		logger.info("Sb4NewUserReg loaded");
	}

	/**
	 * elements
	 */

	/**
	 * used to assert presence of message on screen after a given action
	 * 
	 * @param msg
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4NewUserReg msgWait(String msg) throws InterruptedException {
		By err = By.xpath("//*[contains(text(), '" + msg + "')]");
		waitForElementVisable(err);
		return this;
	}

	/**
	 * iterates through all enter buttons until it finds one visible then clicks
	 * 
	 * @return
	 */
	private Sb4NewUserReg clickEnter() {
		java.util.List<WebElement> allElements = _driver.findElements(enter);
		for (WebElement t : allElements) {
			if (t.isDisplayed()) {
				t.click();
			}
		}
		return this;
	}

	/**
	 * used to choose specific project from pull down menu
	 * 
	 * @param value
	 *            : HTML value of the project to be used
	 * @return
	 */
	private Sb4NewUserReg selectProject(String value) {
		Select dropdown = new Select(_driver.findElement(reqProjId));
		dropdown.selectByValue(value);
		return this;
	}

	/**
	 * used to enter email
	 * 
	 * @param value
	 *            : of email to be set
	 * @return
	 */
	private Sb4NewUserReg setEmail(String value) {
		_driver.findElement(reqEmail).sendKeys(value);
		return this;
	}

	/**
	 * used to enter first name
	 * 
	 * @param value
	 *            : of first name to be set
	 * @return
	 */
	private Sb4NewUserReg setFName(String value) {
		_driver.findElement(reqFName).sendKeys(value);
		return this;
	}

	/**
	 * used to enter last name
	 * 
	 * @param value
	 *            : of last name to be set
	 * @return
	 */
	private Sb4NewUserReg setLName(String value) {
		_driver.findElement(reqLName).sendKeys(value);
		return this;
	}

	/**
	 * used to enter password for projects that require it
	 * 
	 * @param value
	 *            : of password to enter
	 * @return
	 */
	private Sb4NewUserReg setPWord(String value) {
		_driver.findElement(reqPWord).sendKeys(value);
		return this;
	}

	/**
	 * services
	 */

	public Sb4NewUserRegProf GetKey(UserRegPOJO obj)
			throws InterruptedException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		String aVariable = new DbUtil().B4PubData(obj.getEmail(),
				obj.getStatement(), obj.getDb_url(), obj.getDb_username(),
				obj.getDb_pword(), obj.getDb_reg_key());
		String link = String.format(keyUrl, aVariable);
		logger.info(link);
		_driver.get(link);

		return new Sb4NewUserRegProf(_driver);
	}

	/**
	 * Chooses project and waits for the presence of the email field.
	 * 
	 * @param proj
	 * @return
	 */
	public Sb4NewUserReg chooseProj(String proj) {
		logger.info("Choose Project");
		selectProject(proj);
		clickEnter();
		waitForElementVisable(reqEmail);
		return this;
	}

	/**
	 * used to initiate the registration process
	 * 
	 * @param obj
	 *            : of UserRegPOJO
	 * @param pword
	 *            : Boolean value to denote whether a password is required
	 *            during registration process. true = password needed.
	 * @return
	 * @throws InterruptedException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Sb4NewUserReg doNewRegistration(UserRegPOJO obj, Boolean pword)
			throws InterruptedException, InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {

		logger.info("Begin initial registration process");
		setEmail(obj.getEmail());
		setFName(obj.getfName());
		setLName(obj.getlName());

		if (pword == true) {
			setPWord(obj.getReg_pword());
		}
		return this;
	}

	public Sb4NewUserReg regMsg(UserRegPOJO obj) throws InterruptedException {

		clickEnter();
		msgWait(obj.getMsg());
		logger.info("initial registration process complete");
		return this;
	}

}