package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.OCOPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Class for On Campus Order elements and services
 * 
 * @author cmanning
 * 
 */
public class Sb4OCOPage extends Page {

	/**
	 * locators
	 */
	private By date = By.xpath("//input[@name='orderdate']");
	private By pFirst = By.xpath("//input[@name='purchaserFirstName']");
	private By pMi = By.xpath("//input[@name='purchaserMiddleName']");
	private By pLast = By.xpath("//input[@name='purchaserLastName']");
	private By pEmail = By.xpath("//input[@name='purchaserEmail']");
	private By add1 = By.xpath("//input[@name='purchaser_address_1']");
	private By add2 = By.xpath("//input[@name='purchaser_address_2']");
	private By city = By.xpath("//input[@name='purchaser_city']");
	private By state = By.xpath("//select[@name='purchaser_state']");
	private By zip = By.xpath("//input[@name='purchaser_zip']");
	private By country = By.xpath("//select[@name='purchaser_country']");
	private By phone = By.xpath("//input[@name='purchaserPhone']");
	private By sFirst = By.xpath("//input[@name='studentFirstName']");
	private By sMi = By.xpath("//input[@name='studentMiddleName']");
	private By sLast = By.xpath("//input[@name='studentLastName']");
	private By sGrade = By.xpath("//select[@name='studentGrade']");

	private By orderTotal = By.xpath("//span[@data-reactid='.0.1.0.0.0.1']");
	private By balanceDue = By.xpath("//span[@data-reactid='.0.1.1.0.0.1']");

	private By payType = By.xpath("//select[@name='payType']");
	private By amtPaid = By.xpath("//input[@name='payAmount']");
	private By chkNum = By.xpath("//input[@name='payReference']");

	private By submit = By.xpath("//button[.='Enter']");

	JavascriptExecutor jse = (JavascriptExecutor) _driver;

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4OCOPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(pFirst, date);
		logger.info("On Campus Orders Page is loaded");
	}

	/**
	 * elements
	 */

	/**
	 * used to click the submit button
	 * 
	 * @return
	 */
	private Sb4OCOPage clickSubmit() {
		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * first clears then enters text into Purchaser First Name field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setPFirst(String value) {
		_driver.findElement(pFirst).clear();
		_driver.findElement(pFirst).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser Middle Name field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setPMi(String value) {
		_driver.findElement(pMi).clear();
		_driver.findElement(pMi).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser Last Name field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setPLast(String value) {
		_driver.findElement(pLast).clear();
		_driver.findElement(pLast).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser email field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setPEmail(String value) {
		_driver.findElement(pEmail).clear();
		_driver.findElement(pEmail).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser address 1 field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setAdd1(String value) {
		_driver.findElement(add1).clear();
		_driver.findElement(add1).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser address 2 field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setAdd2(String value) {
		_driver.findElement(add2).clear();
		_driver.findElement(add2).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser city field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setCity(String value) {
		_driver.findElement(city).clear();
		_driver.findElement(city).sendKeys(value);
		return this;
	}

	/**
	 * used to choose option in Purchaser state select menu
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setState(String value) {
		Select dropdown = new Select(_driver.findElement(state));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser zip field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setZip(String value) {
		_driver.findElement(zip).clear();
		_driver.findElement(zip).sendKeys(value);
		return this;
	}

	/**
	 * used to choose option in Purchaser country select menu
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setCountry(String value) {
		Select dropdown = new Select(_driver.findElement(country));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * first clears then enters text into Purchaser phone field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setPhone(String value) {
		_driver.findElement(phone).clear();
		_driver.findElement(phone).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Student First Name field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setSFirst(String value) {
		_driver.findElement(sFirst).clear();
		_driver.findElement(sFirst).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Student Middle Name field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setSMi(String value) {
		_driver.findElement(sMi).clear();
		_driver.findElement(sMi).sendKeys(value);
		return this;
	}

	/**
	 * first clears then enters text into Student Last Name field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setSLast(String value) {
		_driver.findElement(sLast).clear();
		_driver.findElement(sLast).sendKeys(value);
		return this;
	}

	/**
	 * used to assert the options available in the Student grade select menu
	 * 
	 * @param array
	 *            : of expected values available in the grade menu
	 * @return
	 */
	// private Sb4OCOPage gradesAvailable(String[] array) {
	//
	// optionsAvailable(array, sGrade);
	// return this;
	// }

	/**
	 * used to choose option in Purchaser grade select menu
	 * 
	 * @param value
	 *            : of option to be entered
	 * @return
	 */
	private Sb4OCOPage setGrade(String value) {
		Select dropdown = new Select(_driver.findElement(sGrade));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to edit the quantity value for products on page
	 * 
	 * @param value
	 *            : of data-reactid
	 * @param value2
	 *            : amount to enter into quantity field
	 * @return
	 */
	private Sb4OCOPage prodQuantity(String value, String value2) {
		String txt = "//input[@data-reactid='" + value + "']";
		By button = By.xpath(txt);
		waitForElementVisable(button);
		_driver.findElement(button).clear();
		_driver.findElement(button).sendKeys(value2);
		_driver.findElement(button).sendKeys(Keys.TAB);
		return this;
	}

	/**
	 * used to edit lines of personalization.
	 * 
	 * @param value
	 *            : of data-reactid for specific line of pers
	 * @param value2
	 *            : of text to enter in line
	 * @return
	 */
	private Sb4OCOPage persLine(String value, String value2) {

		By line = By.xpath("//input[@data-reactid='" + value + "']");
		WebElement um = _driver.findElement(line);
		jse.executeScript("arguments[0].scrollIntoView(true);", um);
		um.sendKeys(value2);
		return this;
	}

	/**
	 * sets the personalization icon value
	 * 
	 * @param menuId
	 *            : react id of the desired pers icon menu
	 * @param iconId
	 *            : react id of the icon as it appears on screen after the icon
	 *            is chosen
	 * @param value
	 *            : of desired icon
	 * @return
	 * @throws InterruptedException
	 */
	private Sb4OCOPage persIcon(String menuId, String iconId, String value)
			throws InterruptedException {

		By menu = By.xpath("//select[@data-reactid='" + menuId + "']");
		By icon = By.xpath("//img[@data-reactid='" + iconId + "']");

		WebElement um = _driver.findElement(menu);
		jse.executeScript("arguments[0].scrollIntoView(true);", um);
		Select dropdown = new Select(um);
		dropdown.selectByValue(value);
		waitForElementVisable(icon);
		return this;
	}

	/**
	 * used to retrieve the order total
	 * 
	 * @return : string of order total
	 */
	private String getOrderTotal() {
		return _driver.findElement(orderTotal).getText().trim();
	}

	/**
	 * used to retrieve the balance
	 * 
	 * @return : string of balance
	 */
	private String getBalanceDue() {
		return _driver.findElement(balanceDue).getText().trim();
	}

	/**
	 * used to check both the order total and ballance
	 * 
	 * @param obj
	 *            : of OCOPOJO
	 * @return : boolean
	 */
	public boolean checkTotalNBal(OCOPOJO obj) {
		System.out.println("Total = "+getOrderTotal());
		Boolean orderTotalsMatch = getOrderTotal().equals(obj.getOrderTotal());
		System.out.println(orderTotalsMatch);
		System.out.println("Balance = "+getBalanceDue());
		Boolean balDueMatch = getBalanceDue().equals(obj.getBalance());
		System.out.println(balDueMatch);

		return orderTotalsMatch && balDueMatch;
	}

	/**
	 * used to choose opton in the payment type select menu
	 * 
	 * @param value
	 *            : of option to choose
	 * @return
	 */
	private Sb4OCOPage setPayType(String value) {
		WebElement pt = _driver.findElement(payType);
		jse.executeScript("arguments[0].scrollIntoView(true);", pt);

		Select dropdown = new Select(_driver.findElement(payType));
		dropdown.selectByVisibleText(value);
		return this;
	}

	/**
	 * used to set the Amount Paid value
	 * 
	 * @param value
	 *            : of amount paid
	 * @return
	 */
	private Sb4OCOPage setAmtPaid(String value) {
		_driver.findElement(amtPaid).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		_driver.findElement(amtPaid).sendKeys(Keys.BACK_SPACE + value);
		_driver.findElement(amtPaid).sendKeys(Keys.TAB);
		return this;
	}

	/**
	 * used to set the value of the check number field
	 * 
	 * @param check
	 *            : boolean value used to determine whether or not to set value.
	 * @param value
	 *            : to be entered into check number field.
	 * @return
	 */
	private Sb4OCOPage setChkNum(Boolean check, String value) {

		if (check = true) {
			waitForElementVisable(chkNum);
			_driver.findElement(chkNum).clear();
			_driver.findElement(chkNum).sendKeys(value);
		}
		return this;
	}

	/**
	 * fills out the form section of OCO. Purchaser & Student info
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return
	 */
	private Sb4OCOPage setOCOForm(OCOPOJO obj) {

		setPFirst(obj.getpFName());
		setPMi(obj.getpMi());
		setPLast(obj.getpLName());
		setPEmail(obj.getEmail());
		setAdd1(obj.getAdd1());
		setAdd2(obj.getAdd2());
		setCity(obj.getCity());
		setState(obj.getState());
		setZip(obj.getZip());
		setCountry(obj.getCountry());
		setPhone(obj.getPhone());
		setSFirst(obj.getsFName());
		setSMi(obj.getsMi());
		setSLast(obj.getsLName());
		setGrade(obj.getGrade());
		return this;
	}

	/**
	 * fills out the products and payment section of OCO
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return
	 */
	private Sb4OCOPage setOCOProdNPayment(OCOPOJO obj) {

		setAmtPaid(obj.getaPaid());
		setPayType(obj.getpType());
		setChkNum(obj.getCheck(), obj.getcNum());
		return this;
	}

	/**
	 * services
	 * 
	 */

	public Sb4OCOViewPage minimumOrder(OCOPOJO obj) throws InterruptedException {

		setOCOForm(obj);
		prodQuantity(obj.getpQuanId(), obj.getpQuanVal());
		if (!checkTotalNBal(obj) == true) {
			throw new RuntimeException(
					"Total & Balance Values were not as expected & didn't match");
		}
		setOCOProdNPayment(obj);
		clickSubmit();
		return new Sb4OCOViewPage(_driver);
	}

	public Sb4OCOPage fullOrder(OCOPOJO obj) throws InterruptedException {

		setOCOForm(obj);
		prodQuantity(obj.getpQuanId(), obj.getpQuanVal());
		persLine(obj.getLineId(), obj.getLineVal());
		persIcon(obj.getIconMenuId(), obj.getIconId(), obj.getIconMenuValue());
		if (!checkTotalNBal(obj) == true) {
			throw new RuntimeException(
					"Total & Balance Values were not as expected & didn't match");
		}
		setOCOProdNPayment(obj);
		return this;
	}
}