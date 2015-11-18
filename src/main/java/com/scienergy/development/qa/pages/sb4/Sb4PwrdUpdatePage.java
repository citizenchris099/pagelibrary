package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.balfour.publishing.qa.PwrdUpdatePOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Class contains Studio Balfour Password Update page
 * 
 * @author cmanning
 * 
 */
public class Sb4PwrdUpdatePage extends Page {

	/**
	 * locators
	 */
	private By resetTile = By.xpath("//*[.='Reset Password']");
	private By pwd1 = By.xpath("//input[@name='password_1']");
	private By pwd2 = By.xpath("//input[@name='password_2']");
	private By submit = By.xpath("//button[.='Submit']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4PwrdUpdatePage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(resetTile, pwd1);
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
	private Sb4PwrdUpdatePage clickSubmit() {
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
	private Sb4PwrdUpdatePage profileMsgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	/**
	 * used to set value into password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4PwrdUpdatePage setPWord1(String value) {
		_driver.findElement(pwd1).sendKeys(value);
		return this;
	}

	/**
	 * used to set value into confirm password field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4PwrdUpdatePage setPWord2(String value) {
		_driver.findElement(pwd2).sendKeys(value);
		return this;
	}

	/**
	 * Services
	 */

	/**
	 * used to set the password
	 * 
	 * @param obj
	 *            : of PwrdUpdatePOJO
	 * @return : Sb4LoginPage
	 * @throws InterruptedException
	 */
	public Sb4LoginPage updatePword(PwrdUpdatePOJO obj)
			throws InterruptedException {

		logger.info("Begin password Update");
		setPWord1(obj.getPword());
		setPWord2(obj.getPword());
		clickSubmit();
		profileMsgChk(obj.getMsg());
		logger.info("password Update complete");
		return new Sb4LoginPage(_driver);
	}

}