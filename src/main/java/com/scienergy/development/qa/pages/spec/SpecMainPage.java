package com.scienergy.development.qa.pages.spec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * Studio Balfour Home Page
 * 
 * @author cmanning
 * 
 */
public class SpecMainPage extends Page {

	/**
	 * locators
	 */
	private By search = By.xpath("//input[@placeholder='Search']");
	private By allTasksActive = By.xpath("//a[contains(@class,'nav-link active')] [@name='all']");
	private By myTasksInActive = By.xpath("//a[contains(@class,'nav-link false')] [@name='my']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public SpecMainPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(search, allTasksActive);
		logger.info("Home Page is loaded");
	}

	/**
	 * elements
	 */

	private int tourCheck() {
		return _driver.findElements(myTasksInActive).size();
	}

	private void closeTour() {
		_driver.findElement(myTasksInActive).click();
	}

	/**
	 * services
	 */

	/**
	 * shared log out service
	 * 
	 * @return
	 * @throws InterruptedException
	 */
//	public Sb4LoginPage LogOut() throws InterruptedException {
//		um.LogOut();
//		return new Sb4LoginPage(_driver);
//	}

}
// }