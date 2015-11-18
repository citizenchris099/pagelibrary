package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * the Studio Balfour landing page. as of this writing there are not page
 * specific elements or services all are accessed via shared objects.
 * 
 * @author cmanning
 * 
 */
public class Sb4SearchResultsPage extends Page {

	/**
	 * locators
	 */
	private By searchResultsTitle = By.xpath("//*[.='Search Results']");
	private By resultsFor = By.xpath("//span[.='Search Results for:']");
	private By notFound = By.xpath("//*[.='Not Found']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4SearchResultsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(searchResultsTitle, resultsFor);
		logger.info("Search Results Page loaded");
	}

	/**
	 * elements
	 */

	public Sb4SearchResultsPage searchResults(String value) {

		String txt = "//a[@href='" + value + "']";
		By button = By.xpath(txt);
		waitForElementVisable(button);
		_driver.findElement(button).click();
		return this;
	}

	public Sb4SearchResultsPage searchNotFound() {
		waitForElementVisable(notFound);
		return this;
	}
}