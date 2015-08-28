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
public class Sb4AdminUserPage extends Page {

	/**
	 * locators
	 */
	private By searchUser = By.xpath("//*[@id='user-search-input']");
	private By searchSubmit = By.xpath("//*[@id='search-submit']");
	private By deleteUser = By.xpath("//a[.='Delete']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4AdminUserPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(searchUser, searchSubmit);
	}

	/**
	 * user search field
	 * 
	 * @param value
	 * @return
	 */
	private Sb4AdminUserPage searchValue(String value) {
		_driver.findElement(searchUser).sendKeys(value);
		return this;
	}

	/**
	 * search button
	 * 
	 * @return
	 */
	private Sb4AdminUserPage clickSearch() {
		_driver.findElement(searchSubmit).click();
		return this;
	}

	/**
	 * dynamic locator used when selecting specific user
	 * 
	 * @param value
	 *            : name of user to be selected
	 * @return
	 */
	private By User(String value) {
		String txt = "//a[contains(text(), '" + value + "')]";
		By user = By.xpath(txt);
		return user;
	}

	/**
	 * services
	 */

	/**
	 * perform search for specific user then click to go to that user profile
	 * 
	 * @param value
	 *            : name of desired user
	 * @return: Sb4AdminUserProfPage
	 */
	public Sb4AdminUserProfPage Go2UserProf(String user)
			throws InterruptedException {
		searchValue(user);
		clickSearch();
		_driver.findElement(User(user)).click();
		return new Sb4AdminUserProfPage(_driver);
	}

	public Sb4AdminDeleteUserPage deleteUser(String user)
			throws InterruptedException {

		searchValue(user);
		clickSearch();
		Actions builder = new Actions(_driver);
		WebElement usr = _driver.findElement(User(user));
		builder.moveToElement(usr).build().perform();
		waitForElementPresence(deleteUser, 10);
		_driver.findElement(deleteUser).click();
		return new Sb4AdminDeleteUserPage(_driver);
	}

	public Sb4LoginPage adminLogOut() throws InterruptedException {
		new Sb4AdminSideBar(_driver).LogOut();
		return new Sb4LoginPage(_driver);
	}
}