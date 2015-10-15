package com.balfour.publishing.qa.pages.sb4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
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
	private By purchaser = By.xpath("//fieldset[@id='purchaserFieldset']");
	private By purchaserChevron = By.xpath(".//span[@class='glyphicon glyphicon-white glyphicon-chevron-down']");
	private By pFirst = By.xpath("//input[@name='purchaserFirstName']");
	private By pMi = By.xpath("//input[@name='purchaserMiddleName']");
	private By pLast = By.xpath("//input[@name='purchaserLastName']");
	private By pEmail = By.xpath("//input[@name='purchaserEmail']");
	private By sEmail = By.xpath("//input[@name='studentEmail']");
	private By add1 = By.xpath("//input[@name='purchaser_address_1']");
	private By add2 = By.xpath("//input[@name='purchaser_address_2']");
	private By city = By.xpath("//input[@name='purchaser_city']");
	private By zip = By.xpath("//input[@name='purchaser_zip']");
	private By phone = By.xpath("//input[@name='purchaserPhone']");
	private By sFirst = By.xpath("//input[@name='studentFirstName']");
	private By sMi = By.xpath("//input[@name='studentMiddleName']");
	private By sLast = By.xpath("//input[@name='studentLastName']");
	private By sGrade = By.xpath("//select[@name='studentGrade']");

	private By packagePrice = By.xpath("//input[contains(@data-reactid,'BASICPACKAGE')] [@type='currency']");
	private By packageAdd = By.xpath("//span[contains(@data-reactid,'BASICPACKAGE')] [@class='glyphicon glyphicon-plus glyphicon-white']");
	private By balDue = By.cssSelector(".totalPrice div p span:nth-child(2)");

	private By payType = By.xpath("//select[@name='payType']");
	private By amtPaid = By.xpath("//input[@name='payAmount']");
	private By chkNum = By.xpath("//input[@name='payReference']");

	private By saveView = By.xpath("//*[@id='submitLink']");
	private By saveNew = By.xpath("//*[@id='submitAndNewLink']");
	private By nextOrder = By.xpath("//*[@id='nextOrder']");
	private By printReceipt = By.xpath("//*[@id='printReceipt']");
	private By viewOrder = By.xpath("//*[@id='viewOrder']");
	private By saveEdit = By.xpath("//*[contains(@id,'submitLink')] [.='Save']");

	private By prevPayments = By.xpath("//div[@class='previousPayments']");
	private By prevPaymentsRow = By.xpath(".//div[@class='row'][2]");
	private By newPaymentsRow = By.xpath(".//div[@class='row'][3]");

	private By ocoNumber = By.cssSelector(".confirmList div fieldset div p span:nth-child(2)");

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
		isLoaded(sFirst, packagePrice);
		logger.info("On Campus Orders Page is loaded");
	}

	/**
	 * elements
	 */

	/**
	 * prototype for a method that anticipates having to click through sevearl
	 * timeout errors and clicking to try to submit the order again
	 * 
	 * @return
	 */
	// private Object protoclickSaveView() {
	// int loop = 0;
	//
	// while (loop < 1) {
	// try {
	// _driver.findElement(saveView).click();
	// return this;
	// } catch (UnhandledAlertException u) {
	// logger.info("OCO error popped up");
	// Alert alert = _driver.switchTo().alert();
	// alert.accept();
	// loop++;
	// }
	// }
	//
	// // should only get here in the saveView.click() didn't work
	// throw new RuntimeException("OCO error was thrown");
	// }

	/**
	 * the decision was made to fail any test where an error popped up so this
	 * method should be used
	 * 
	 * @return
	 */
	private Sb4OCOPage clickSaveView() {
		try {
			_driver.findElement(saveView).click();
		} catch (UnhandledAlertException u) {
			logger.info("OCO error was thrown");
			throw new RuntimeException("OCO error was thrown");
		}
		return this;
	}

	private Sb4OCOPage clickSaveNew() {
		_driver.findElement(saveNew).click();
		waitForElementVisable(nextOrder);
		waitForElementVisable(printReceipt);
		waitForElementVisable(viewOrder);
		return this;
	}

	private Sb4OCOPage clickSaveEdit() {
		_driver.findElement(saveEdit).click();
		return this;
	}

	private Sb4OCOPage expandPurchaser() {
		WebElement expand = _driver.findElement(purchaser);
		if (expand.findElements(purchaserChevron).size() > 0) {
			expand.findElement(purchaserChevron).click();
		}
		waitForElementVisable(pFirst);
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

	private String getPFirst() {
		return _driver.findElement(pFirst).getAttribute("value");
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

	private String getPLast() {
		return _driver.findElement(pLast).getAttribute("value");
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

	private String getPEmail() {
		return _driver.findElement(pEmail).getAttribute("value");
	}

	/**
	 * first clears then enters text into Student email field
	 * 
	 * @param value
	 *            : of text to be entered
	 * @return
	 */
	private Sb4OCOPage setSEmail(String value) {
		Boolean textVal = _driver.findElement(sEmail).isEnabled();
		if (textVal == true) {
			_driver.findElement(sEmail).clear();
			_driver.findElement(sEmail).sendKeys(value);
		}
		return this;
	}

	private String getSEmail() {
		return _driver.findElement(sEmail).getAttribute("value");
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

	private String getAdd1() {
		return _driver.findElement(add1).getAttribute("value");
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

	private String getAdd2() {
		return _driver.findElement(add2).getAttribute("value");
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

	private String getCity() {
		return _driver.findElement(city).getAttribute("value");
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

	private String getZip() {
		return _driver.findElement(zip).getAttribute("value");
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

	private String getPhone() {
		return _driver.findElement(phone).getAttribute("value");
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

	private String getSFirst() {
		return _driver.findElement(sFirst).getAttribute("value");
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

	private String getSLast() {
		return _driver.findElement(sLast).getAttribute("value");
	}

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

	private String getGrade() {
		return new Select(_driver.findElement(sGrade)).getFirstSelectedOption().getText();
	}
	
	public String getPackPrice(){
		return _driver.findElement(packagePrice).getAttribute("value");
	}
	
	private String getBalDue(){
		return _driver.findElement(balDue).getText();
	}
	
	private Sb4OCOPage clickPackageAdd(){
		_driver.findElement(packageAdd).click();
		return this;
	}

	/**
	 * used to edit the price and quantity value for the first package on the
	 * OCO order form
	 * 
	 * @param price
	 *            : desired price of package
	 * @param quantity
	 *            : amount to enter into quantity field
	 * @return : Sb4OCOPage
	 */
	private Sb4OCOPage prodQuantity(String price, String quantity) {
		logger.info("setting On Campus Order product and quantity");
		waitForElementVisable(packagePrice);
		_driver.findElement(packagePrice).clear();
		_driver.findElement(packagePrice).sendKeys(price);
		_driver.findElement(packagePrice).sendKeys(Keys.TAB, quantity, Keys.TAB);
		return this;
	}

	private Sb4OCOPage prodQuantity(String price, String quantity, String pack) {
		logger.info("setting On Campus Order product and quantity");

		By pax = By.xpath("//input[contains(@data-reactid,'" + pack + "')] [@type='currency']");

		waitForElementVisable(pax);
		_driver.findElement(pax).clear();
		_driver.findElement(pax).sendKeys(price);
		_driver.findElement(pax).sendKeys(Keys.TAB, quantity, Keys.TAB);
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
	private Sb4OCOPage persIcon(String menuId, String iconId, String value) throws InterruptedException {

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
		if (!_driver.findElement(amtPaid).getAttribute("value").equals("0")){
			logger.info("The OCO Amount was not 0");
			throw new RuntimeException("The OCO Amount was not 0");
		}
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

		if (check == true) {
			waitForElementVisable(chkNum);
			_driver.findElement(chkNum).clear();
			_driver.findElement(chkNum).sendKeys(value);
		}
		return this;
	}

	private String getPrevPayment() {
		WebElement pp = _driver.findElement(prevPayments);
		return pp.findElement(prevPaymentsRow).getText().replaceAll("\n", " ").replaceAll("\r", " ").trim();
	}

	private String getNewPayment() {
		WebElement pp = _driver.findElement(prevPayments);
		return pp.findElement(newPaymentsRow).getText().replaceAll("\n", " ").replaceAll("\r", " ").trim();
	}

	private String getPrevPType() {
		String type = null;
		String tmp = getPrevPayment();
		String[] tokens = tmp.split(" ");
		String ty = tokens[0].trim();
		if (ty.equals("cash")) {
			type = "Cash";
		} else if (ty.equals("check")) {
			type = "Check";
		} else if (ty.equals("comp")) {
			type = "Comp";
		} else
			throw new RuntimeException("The OCO payment type was not a known value");
		return type;
	}

	private String getPrevPDate() {
		String tmp = getPrevPayment();
		String[] tokens = tmp.split(" ");
		return tokens[2] + " " + tokens[3].trim();
	}

	private String getPrevPAmt() {
		String tmp = getPrevPayment();
		String[] tokens = tmp.split(" ");
		return tokens[5].replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	private String getPrevCNum() {
		String tmp = getPrevPayment();
		String[] tokens = tmp.split(" ");
		return tokens[5].replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	private String getNewPType() {
		String type = null;
		String tmp = getNewPayment();
		String[] tokens = tmp.split(" ");
		String ty = tokens[0].trim();
		if (ty.equals("cash")) {
			type = "Cash";
		} else if (ty.equals("check")) {
			type = "Check";
		} else if (ty.equals("comp")) {
			type = "Comp";
		} else
			throw new RuntimeException("The OCO payment type was not a known value");
		return type;
	}

	private String getNewPDate() {
		String tmp = getNewPayment();
		String[] tokens = tmp.split(" ");
		return tokens[2] + " " + tokens[3].trim();
	}

	private String getNewPAmt() {
		String tmp = getNewPayment();
		String[] tokens = tmp.split(" ");
		return tokens[5].replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	private String getNewCNum() {
		String tmp = getNewPayment();
		String[] tokens = tmp.split(" ");
		return tokens[5].replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	/**
	 * fills out the form section of OCO. Purchaser & Student info
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return
	 */
	private Sb4OCOPage setOCOForm(OCOPOJO obj) {
		logger.info("filling out On Campus Order form");
		if (obj.getFilloutPurchaser() == true) {
			expandPurchaser().setPFirst(obj.getpFName()).setPLast(obj.getpLName()).setPEmail(obj.getEmail())
					.setAdd1(obj.getAdd1()).setAdd2(obj.getAdd2()).setCity(obj.getCity()).setZip(obj.getZip())
					.setPhone(obj.getPhone());
		}
		setSFirst(obj.getsFName()).setSLast(obj.getsLName()).setGrade(obj.getGrade());
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
		logger.info("setting On Campus Order payment info");

		if (!obj.getpType().equals("Comp") & obj.getPaymentMade() == false) {
			setPayType(obj.getpType()).setChkNum(obj.getCheck(), obj.getcNum());
			setAmtPaid(obj.getaPaid());
		} else if (!obj.getaPType().equals("Comp") & obj.getPaymentMade() == true) {
			setPayType(obj.getaPType()).setChkNum(obj.getCheck(), obj.getcNum());
			setAmtPaid(obj.getaAPaid());
		} else if (obj.getpType().equals("Comp") & obj.getPaymentMade() == false) {
			setPayType(obj.getpType());
		} else if (obj.getaPType().equals("Comp") & obj.getPaymentMade() == true) {
			setPayType(obj.getaPType());
		}
		return this;
	}

	/**
	 * used in conjunction with the saveNewOCO method. using this method click
	 * to view the current order
	 * 
	 * @return : Sb4OCOViewPage
	 * @throws InterruptedException
	 */
	private Sb4OCOPage clickViewOrder() throws InterruptedException {
		_driver.findElement(viewOrder).click();
		return this;
	}

	/**
	 * used in conjunction with the saveNewOCO method. using this method click
	 * to start the next order
	 * 
	 * @return : Sb4OCOPage
	 */
	private Sb4OCOPage clickNextOrder() {
		_driver.findElement(nextOrder).click();
		return this;
	}

	private String getOCONumber() {
		return _driver.findElement(ocoNumber).getText();
	}

	/**
	 * services
	 * 
	 */

	/**
	 * updates the OCOPOJO passed in with the form information found on the edit
	 * OCO page
	 * 
	 * @param obj
	 *            : OCOPOJO
	 */
	public void getEditOCOInfo(OCOPOJO obj) {
		if (obj.getFilloutPurchaser() == true) {
			expandPurchaser();
			logger.info("edit getPFirst value found = " + getPFirst());
			obj.setpFName(getPFirst());
			logger.info("edit getPLast value found = " + getPLast());
			obj.setpLName(getPLast());
			logger.info("edit getPEmail value found = " + getPEmail());
			obj.setEmail(getPEmail());
			logger.info("edit getAdd1 value found = " + getAdd1());
			obj.setAdd1(getAdd1());
			logger.info("edit getAdd2 value found = " + getAdd2());
			obj.setAdd2(getAdd2());
			logger.info("edit getCity value found = " + getCity());
			obj.setCity(getCity());
			logger.info("edit getZip value found = " + getZip());
			obj.setZip(getZip());
			logger.info("edit getPhone value found = " + getPhone());
			obj.setPhone(getPhone());
		}
		logger.info("edit getSFirst value found = " + getSFirst());
		obj.setsFName(getSFirst());
		logger.info("edit getSLast value found = " + getSLast());
		obj.setsLName(getSLast());
		logger.info("edit getGrade value found = " + getGrade());
		obj.setGrade(getGrade());
		logger.info("prev pay type = " + getPrevPType());
		obj.setDate(getPrevPDate());
		logger.info("prev pay date = " + getPrevPDate());
		obj.setpType(getPrevPType());
		logger.info("prev pay amt = " + getPrevPAmt());
		obj.setaPaid(getPrevPAmt());
		if (obj.getpType().equals("Check")) {
			obj.setcNum(getPrevCNum());
		}
		if (obj.getPaymentMade() == true) {
			logger.info("prev pay type = " + getNewPType());
			obj.setpDate(getNewPDate());
			logger.info("prev pay date = " + getNewPDate());
			obj.setaPType(getNewPType());
			logger.info("prev pay amt = " + getNewPAmt());
			obj.setaAPaid(getNewPAmt());
			if (obj.getpType().equals("Check")) {
				obj.setcNum(getNewCNum());
			}
		}
	}

	/**
	 * used to edit an existing OCO
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return : Sb4OCOViewPage
	 * @throws InterruptedException
	 */
	public Sb4OCOViewPage saveEditOCO(OCOPOJO obj) throws InterruptedException {
		logger.info("Begin editing existing OCO");
		setOCOForm(obj);
		if (obj.getPaymentMade() == true) {
			setOCOProdNPayment(obj);
		}
		clickSaveEdit();
		return new Sb4OCOViewPage(_driver);
	}

	/**
	 * used to fill out the OCO form and choose the save and view option
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return : Sb4OCOViewPage
	 * @throws InterruptedException
	 */
	public Sb4OCOViewPage saveViewOCO(OCOPOJO obj) throws InterruptedException {
		logger.info("Begin creating Save and View On Campus Order");
		setOCOForm(obj).prodQuantity(obj.getPrice(), obj.getQuan()).setOCOProdNPayment(obj).clickSaveView();
		return new Sb4OCOViewPage(_driver);
	}

	/**
	 * used to fill out the OCO form and choose the save and new option. then
	 * clicks to view the current order
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return : Sb4OCOViewPage
	 * @throws InterruptedException
	 */
//	public Sb4OCOViewPage saveNewViewOCO(OCOPOJO obj) throws InterruptedException {
//		logger.info("Begin creating Save and New then View On Campus Order");
//		setOCOForm(obj).prodQuantity(obj.getPrice(), obj.getQuan()).setOCOProdNPayment(obj).clickSaveNew()
//				.clickViewOrder();
//		for (String winHandle : _driver.getWindowHandles()) {
//			_driver.switchTo().window(winHandle);
//		}
//		return new Sb4OCOViewPage(_driver);
//	}
	
	public Sb4OCOViewPage saveNewViewOCO(OCOPOJO obj) throws InterruptedException {
		logger.info("Begin creating Save and New then View On Campus Order");
		setOCOForm(obj).clickPackageAdd().setOCOProdNPayment(obj).clickSaveNew()
				.clickViewOrder();
		obj.setPrice(getPackPrice());
		for (String winHandle : _driver.getWindowHandles()) {
			_driver.switchTo().window(winHandle);
		}
		return new Sb4OCOViewPage(_driver);
	}

	/**
	 * used to fill out the OCO form and choose the save and new option. then
	 * clicks to start the next order
	 * 
	 * @param obj
	 *            : OCOPOJO
	 * @return : Sb4OCOViewPage
	 * @throws InterruptedException
	 */
	public Sb4OCOPage saveNewStartOCO(OCOPOJO obj) throws InterruptedException {
		logger.info("Begin creating Save and New then New On Campus Order");
		obj.setOrderNumber(setOCOForm(obj).prodQuantity(obj.getPrice(), obj.getQuan()).setOCOProdNPayment(obj).clickSaveNew().getOCONumber());
				clickNextOrder();
		return this;
	}

}