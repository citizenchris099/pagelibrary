package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.balfour.publishing.qa.pages.Page;

/**
 * Studio Balfour Back End User page services that allow user to search and
 * select user.
 * 
 * @author cmanning
 * 
 */
public class Sb4AdminDeleteUserPage extends Page {

	/**
	 * locators
	 */
	private By delUserTitle = By.xpath("//*[.='Delete Users']");
	private By delAllCon = By.xpath("//input[@id='delete_option0']");
	private By submit = By.xpath("//input[@id='submit']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4AdminDeleteUserPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(delUserTitle, delAllCon);
	}

	/**
	 * user search field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4AdminDeleteUserPage clickDelAll() {
		_driver.findElement(delAllCon).click();
		return this;
	}

	private Sb4AdminDeleteUserPage clickSubmit() {

		_driver.findElement(submit).click();
		return this;
	}

	/**
	 * services
	 * 
	 * @throws InterruptedException
	 */

	public Sb4AdminUserPage finDeleteUser() throws InterruptedException {

		clickDelAll();
		clickSubmit();
		return new Sb4AdminUserPage(_driver);
	}

}