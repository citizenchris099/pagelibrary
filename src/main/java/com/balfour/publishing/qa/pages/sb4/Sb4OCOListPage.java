package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.OCOListPOJO;
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
	private By filter = By.xpath("//button[@id='_list_search_submitButton']");
	private String ocoNew = slugNAction.getOcoNew();
	private By newOrder = dynamicLocator(ocoNew);

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
		JavascriptExecutor jse = (JavascriptExecutor) _driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", no);
		jse.executeScript("arguments[0].click();", no);
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
	 * Searches for an existing order
	 * 
	 * @param obj
	 *            : OCOListPOJO
	 * @return : Sb4OCOPage
	 * @throws InterruptedException
	 */
	public Sb4OCOPage fullOCOSearch(OCOListPOJO obj)
			throws InterruptedException {

		setOrderNum(obj.getOrderNumber());
		setOrderName(obj.getName());
		setBalStatus(obj.getBalStatus());
		clickFilter();
		return new Sb4OCOPage(_driver);
	}

}