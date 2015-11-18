package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.scienergy.development.qa.SchoolConfigPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * the Studio Balfour School Config Page
 * 
 * @author cmanning
 * 
 */
public class Sb4SchoolConfigPage extends Page {

	/**
	 * locators
	 */
	private By schoolANum = By.xpath("//input[@name='account']");
	private By schoolName = By.xpath("//input[@name='school_name']");
	private By contact000 = By
			.xpath("//select[@id='_school_config_contact_0']");
	private By contact001 = By
			.xpath("//select[@id='_school_config_contact_1']");
	private By billAdd1 = By.xpath("//input[@name='billing_address_1']");
	private By billAdd2 = By.xpath("//input[@name='billing_address_2']");
	private By billCity = By.xpath("//input[@name='billing_city']");
	private By billState = By.xpath("//select[@name='billing_state']");
	private By billZip = By.xpath("//input[@name='billing_zip']");
	private By billCountry = By.xpath("//select[@name='billing_country']");
	private By sameAsBill = By
			.xpath("//input[@name='shipping_same_as_billing']");
	private By shipAdd1 = By.xpath("//input[@name='shipping_address_1']");
	private By shipAdd2 = By.xpath("//input[@name='shipping_address_2']");
	private By shipCity = By.xpath("//input[@name='shipping_city']");
	private By shipState = By.xpath("//select[@name='shipping_state']");
	private By shipZip = By.xpath("//input[@name='shipping_zip']");
	private By shipCountry = By.xpath("//select[@name='shipping_country']");
	private By grade = By.xpath("//select[@id='school_config_grade[]']");
	private By submit = By.xpath("//button[.='Enter']");
	private By region = By.xpath("//select[@name='region']");
	private By salesO = By.xpath("//select[@name='sales_office']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4SchoolConfigPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(schoolName, schoolANum);
		logger.info("School Config Page loaded");
	}

	/**
	 * elements
	 */

	/**
	 * clicks submit / enter
	 * 
	 * @return
	 */
	private Sb4SchoolConfigPage clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * used to check profile update messages
	 * 
	 * @param successmsg
	 *            : expected message
	 * @return
	 */
	private Sb4SchoolConfigPage MsgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);

		return this;
	}

	private Sb4SchoolConfigPage setSName(String value) {
		_driver.findElement(schoolName).clear();
		_driver.findElement(schoolName).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setContact00(String value) {
		Select dropdown = new Select(_driver.findElement(contact000));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4SchoolConfigPage setContact01(String value) {
		Select dropdown = new Select(_driver.findElement(contact001));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4SchoolConfigPage setBAdd1(String value) {
		_driver.findElement(billAdd1).clear();
		_driver.findElement(billAdd1).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setBAdd2(String value) {
		_driver.findElement(billAdd2).clear();
		_driver.findElement(billAdd2).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setBCity(String value) {
		_driver.findElement(billCity).clear();
		_driver.findElement(billCity).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setBZip(String value) {
		_driver.findElement(billZip).clear();
		_driver.findElement(billZip).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setBState(String value) {
		Select dropdown = new Select(_driver.findElement(billState));
		dropdown.selectByValue(value);
		return this;
	}

	private Sb4SchoolConfigPage setBCountry(String value) {
		Select dropdown = new Select(_driver.findElement(billCountry));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4SchoolConfigPage setSaB(boolean sab) {

		if (sab != _driver.findElement(sameAsBill).isSelected()) {
			_driver.findElement(sameAsBill).click();
		}

		return this;
	}

	private Sb4SchoolConfigPage setSAdd1(String value) {
		_driver.findElement(shipAdd1).clear();
		_driver.findElement(shipAdd1).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setSAdd2(String value) {
		_driver.findElement(shipAdd2).clear();
		_driver.findElement(shipAdd2).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setSCity(String value) {
		_driver.findElement(shipCity).clear();
		_driver.findElement(shipCity).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setSZip(String value) {
		_driver.findElement(shipZip).clear();
		_driver.findElement(shipZip).sendKeys(value);
		return this;
	}

	private Sb4SchoolConfigPage setSState(String value) {
		Select dropdown = new Select(_driver.findElement(shipState));
		dropdown.selectByValue(value);
		return this;
	}

	private Sb4SchoolConfigPage setSCountry(String value) {
		Select dropdown = new Select(_driver.findElement(shipCountry));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4SchoolConfigPage setRegion(String value) {
		Select dropdown = new Select(_driver.findElement(region));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4SchoolConfigPage setSalesO(String value) {
		Select dropdown = new Select(_driver.findElement(salesO));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to select grades
	 * 
	 * @param value
	 *            : of grade
	 * @return
	 */
	private Sb4SchoolConfigPage selectGrades(String value) {
		Select dropdown = new Select(_driver.findElement(grade));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to deselect grades
	 * 
	 * @param value
	 *            : of grade to be deselected
	 * @return
	 */
	private Sb4SchoolConfigPage deSelectGrades(String value) {
		Select dropdown = new Select(_driver.findElement(grade));
		dropdown.deselectByVisibleText(value);
		return this;
	}

	/**
	 * selects / deselects 5 grades
	 * 
	 * @param obj
	 *            : of SchoolConfigPOJO
	 * @return
	 */
	private Sb4SchoolConfigPage setGrades(SchoolConfigPOJO obj) {

		selectGrades(obj.getGrade01());
		selectGrades(obj.getGrade02());
		selectGrades(obj.getGrade03());
		selectGrades(obj.getGrade04());
		selectGrades(obj.getGrade05());
		deSelectGrades(obj.getGrade06());
		deSelectGrades(obj.getGrade07());
		deSelectGrades(obj.getGrade08());
		deSelectGrades(obj.getGrade09());
		deSelectGrades(obj.getGrade10());
		return this;
	}

	private Sb4SchoolConfigPage setOtherInfo(SchoolConfigPOJO obj) {

		setSName(obj.getsName());
		setSaB(obj.getsAB());
		setRegion(obj.getRegion());
		setSalesO(obj.getsOffice());
		setContact00(obj.getCont0());
		setContact01(obj.getCont1());

		return this;
	}

	/**
	 * used to set the entire School Config form including both billing and
	 * shipping address
	 * 
	 * @param obj
	 *            : of SalesConfigPOJO
	 * @return
	 */
	private Sb4SchoolConfigPage setBillingAdd(SchoolConfigPOJO obj) {

		setBAdd1(obj.getbAdd1());
		setBAdd2(obj.getbAdd2());
		setBCity(obj.getbCity());
		setBState(obj.getbState());
		setBZip(obj.getbZip());
		setBCountry(obj.getbCountry());

		return this;
	}

	/**
	 * used to set School Config when Shipping is Same as Billing is chosen
	 * 
	 * @param obj
	 *            : of SalesConfigPOJO
	 * @return
	 */
	private Sb4SchoolConfigPage setShippingAdd(SchoolConfigPOJO obj) {

		setSAdd1(obj.getsAdd1());
		setSAdd2(obj.getsAdd2());
		setSCity(obj.getsCity());
		setSState(obj.getsState());
		setSZip(obj.getsZip());
		setSCountry(obj.getsCountry());
		return this;
	}

	/**
	 * services
	 */

	/**
	 * used to update the school config page
	 * 
	 * @param obj
	 *            : SchoolConfigPOJO
	 * @param ship
	 *            : Boolean value used to denote whether to set the shipping
	 *            address values
	 * @return : Sb4SchoolViewPage
	 * @throws InterruptedException
	 */
	public Sb4SchoolViewPage successfulUpDate(SchoolConfigPOJO obj, Boolean ship)
			throws InterruptedException {
		logger.info("Begin Update of School Config");
		setOtherInfo(obj);
		setBillingAdd(obj);
		if (ship == true) {
			setShippingAdd(obj);
		}
		setGrades(obj);
		clickSubmit();
		MsgChk("has been updated");
		logger.info("Update of School Config Complete");
		return new Sb4SchoolViewPage(_driver);
	}
}