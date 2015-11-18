package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.balfour.publishing.qa.pages.Page;

/**
 * class that services used to access the front end user menu and project menu
 * presented at the top right of Studio Balfour
 * 
 * @author cmanning
 * 
 */
public class UserMenu extends Page {

	/**
	 * locators
	 */
	private By userMenuMain = By.cssSelector("div.btn-group.profile > button");
	private By siteSearch = By.cssSelector("div.btn-group.site-search > button");
	private By siteSearchField = By.xpath("//input[@placeholder='Search']");
	private By siteSearchButton = By.xpath("//input[@id='searchsubmit']");
	private By myProfile = By.xpath("//*[.='My Profile']");
	private By logout = By.xpath("//*[.='Logout']");
	private By menuColumn = By.xpath("//div[@class='col-sm-3 subnav']");
	private By bookStatus = By.xpath("//*[@href='/book-status']");
	private By projInfo = By.xpath(".//*[contains(@href,'balfour.com/book-status/project/')]");
	private By main = By.xpath("//button[contains(@class,'project-switcher-btn')]");

	Actions builder = new Actions(_driver);

	/**
	 * constructor
	 * 
	 * @param driver
	 */
	public UserMenu(WebDriver driver) {
		super(driver);
	}

	/**
	 * elements
	 */

	/**
	 * @return
	 */
	private WebElement moveToBookStatus() {
		_driver.findElement(bookStatus).click();
		waitForElementVisable(menuColumn);
		WebElement mc = _driver.findElement(menuColumn);
		builder.moveToElement(mc).build().perform();
		return mc;
	}

	/**
	 * services
	 */

	/**
	 * navigates to the project info / view page
	 */
	public void projectInfo() {
		WebElement mc = moveToBookStatus();
		builder.moveToElement(mc.findElement(projInfo)).build().perform();
		mc.findElement(projInfo).click();
	}

	public int projInfoCount() {
		WebElement mc = moveToBookStatus();
		return mc.findElements(projInfo).size();
	}

	public void SiteSearch(String value) {
		waitForElementVisable(siteSearch);
		_driver.findElement(siteSearch).click();
		waitForElementVisable(siteSearchField);
		waitForElementVisable(siteSearchButton);
		_driver.findElement(siteSearchField).sendKeys(value);
		_driver.findElement(siteSearchButton).click();
	}

	/**
	 * used to log out of Studio Balfour
	 */
	public void LogOut() {

		WebElement um = _driver.findElement(userMenuMain);
		builder.moveToElement(um).build().perform();
		um.click();
		waitForElementVisable(logout);
		_driver.findElement(logout).click();
	}

	/**
	 * used to access the user profile
	 */
	public void MyProfile() {
		WebElement um = _driver.findElement(userMenuMain);
		builder.moveToElement(um).build().perform();
		um.click();
		waitForElementVisable(myProfile);
		_driver.findElement(myProfile).click();
	}

	/**
	 * project switch for use with users that have <8 projects
	 * 
	 * @param val1
	 *            : is the current project that should be present upon
	 *            initiating the project switch
	 * @param val2
	 *            : the intended project to switch to
	 * @throws InterruptedException
	 */
	public void projectMenu(String val2) throws InterruptedException {
		By next = By.xpath("//a[contains(text(), '" + val2 + "')]");
		_driver.findElement(main).click();
		waitForElementVisable(next);
		_driver.findElement(next).click();
	}

	/**
	 * project switch for use with users that have >8 projects
	 * 
	 * @param mainProj
	 *            : is the current project that should be present upon
	 *            initiating the project switch
	 * @param nextProj
	 *            : the intended project to switch to
	 * @throws InterruptedException
	 */
	public void projectMenuSearch(String nextProj) throws InterruptedException {
		By search = By.xpath("//input[contains(@class,'search-projects')]");
		By next = By.cssSelector("ul.typeahead.dropdown-menu > li.active");
		_driver.findElement(main).click();
		waitForElementVisable(search, 30);
		WebElement um = _driver.findElement(search);
		builder.moveToElement(um).build().perform();
		builder.sendKeys(um, nextProj).build().perform();
		waitForElementVisable(next, 30);
		_driver.findElement(next).click();
	}

	/**
	 * used to check the current project loaded in the project switcher
	 * 
	 * @param proj
	 */
	public void projectLoaded(String proj) {
		By load = By.xpath("//button[contains(text(), '" + proj + "')]");
		waitForElementVisable(load, 15);
	}

	/**
	 * used to check if a project is available for users w/<8 projects
	 * 
	 * @param val2
	 * @return
	 */
	public int projectCheck(String val2) {
		By main = By.xpath("//button[contains(@class,'project-switcher-btn')]");
		By next = By.xpath("//a[contains(text(), '" + val2 + "')]");
		_driver.findElement(main).click();
		return _driver.findElements(next).size();
	}

}