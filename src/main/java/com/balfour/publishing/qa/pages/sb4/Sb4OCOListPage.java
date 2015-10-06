package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.OCOListPOJO;
import com.balfour.publishing.qa.OCOPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Class for On Campus Order list / landing page
 * 
 * @author cmanning
 * 
 */
public class Sb4OCOListPage extends Page {

	/**
	 * locators
	 */
	private By orderNum = By.xpath("//input[@name='orders_number']");
	private By orderName = By.xpath("//input[@name='orders_name']");
	private By balStatus = By.xpath("//select[@name='orders_balance']");
	private By filter = By.xpath("//button[@id='order_list_search_submitButton']");
	// private String ocoNew = slugNAction.getOcoNew();
	// private By newOrder = dynamicLocator(ocoNew);
	private By newOrder = By.xpath("//*[contains(@href,'/sales-orders/oncampus/?action=config&orderid=New')]");
	private By editOrder = By.xpath("//*[.='edit']");

	JavascriptExecutor jse = (JavascriptExecutor) _driver;

	/**
	 * constructor that uses shared is loaded service to check for two unique
	 * elements as well as check URL service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4OCOListPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(orderNum, newOrder);
		logger.info("On Campus List Page is loaded");
	}

	/**
	 * elements
	 */

	private By existingOCO(String value) {
		return By.xpath("//*[contains(@href, '" + value + "')]");
	}

	private Sb4OCOListPage clickFilter() {
		_driver.findElement(filter).click();
		return this;
	}

	private Sb4OCOListPage setOrderNum(String value) {
		_driver.findElement(orderNum).sendKeys(value);
		return this;
	}

	private Sb4OCOListPage setOrderName(String value) {
		_driver.findElement(orderName).sendKeys(value);
		return this;
	}

	private Sb4OCOListPage setBalStatus(String value) {
		Select dropdown = new Select(_driver.findElement(balStatus));
		dropdown.selectByVisibleText(value);
		return this;
	}

	private Sb4OCOListPage clickNewOrder() {

		WebElement no = _driver.findElement(newOrder);
		jse.executeScript("arguments[0].scrollIntoView(true);", no);
		jse.executeScript("arguments[0].click();", no);
		return this;
	}

	/**
	 * Searches for an existing order
	 * 
	 * @param obj
	 *            : OCOListPOJO
	 * @return : Sb4OCOPage
	 * @throws InterruptedException
	 */
	private Sb4OCOListPage fullOCOSearch(OCOPOJO obj) throws InterruptedException {
		logger.info("Begin OCO search");
		setOrderNum(obj.getOrderNumber());
		clickFilter();
		waitForElementVisable(existingOCO(obj.getOrderNumber()));
		logger.info("Order found with order number");
		setOrderName(obj.getName());
		clickFilter();
		waitForElementVisable(existingOCO(obj.getOrderNumber()));
		logger.info("Order found with name");
		setBalStatus(obj.getBalStatus());
		clickFilter();
		waitForElementVisable(existingOCO(obj.getOrderNumber()));
		logger.info("Order found with Bal status");
		clickFilter();
		waitForElementVisable(existingOCO(obj.getOrderNumber()));
		logger.info("OCO search complete and order found");
		return this;
	}

	/**
	 * services
	 * 
	 */

	/**
	 * clicks the create new order button
	 * 
	 * @return : Sb4OCOPage
	 * @throws InterruptedException
	 */
	public Sb4OCOPage createNewOrder() throws InterruptedException {

		clickNewOrder();
		return new Sb4OCOPage(_driver);
	}

	/**
	 * used to click the edit order button
	 * @param obj : OCOPOJO
	 * @return : Sb4OCOPage
	 * @throws InterruptedException
	 */
	public Sb4OCOPage editOCO(OCOPOJO obj) throws InterruptedException {
		fullOCOSearch(obj);
		_driver.findElement(editOrder).click();
		logger.info("clicking to edit OCO");
		return new Sb4OCOPage(_driver);
	}

	/** 
	 * used to click the view order button
	 * @param obj : OCOPOJO
	 * @return : Sb4OCOViewPage
	 * @throws InterruptedException
	 */
	public Sb4OCOViewPage viewOCO(OCOPOJO obj) throws InterruptedException {
		fullOCOSearch(obj);
		_driver.findElement(existingOCO(obj.getOrderNumber())).click();
		logger.info("clicking to view OCO");
		return new Sb4OCOViewPage(_driver);
	}

}