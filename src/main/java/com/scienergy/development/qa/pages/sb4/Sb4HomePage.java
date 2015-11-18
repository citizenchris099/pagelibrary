package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * Studio Balfour Home Page
 * 
 * @author cmanning
 * 
 */
public class Sb4HomePage extends Page {

	/**
	 * locators
	 */
	private By brand = By.xpath("//a[@class='navbar-brand']");
	private By status = By.xpath("//a[.='Book Status']");
	private By cancelTour = By.xpath("//span[@id='canceltour']");
	// private By build = By.xpath("//a[.='Build A Book']");
	// private By sales = By.xpath("//a[.='Sales & Orders']");
	// private By edu = By.xpath("//a[.='Education']");

	UserMenu um = new UserMenu(_driver);
	Sb4TermsPage tp = new Sb4TermsPage(_driver);

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4HomePage(WebDriver driver) throws InterruptedException {
		super(driver);
		if (tp.termsPageCheck() > 0) {
			logger.info("Terms Page is loaded");
			tp.agreeTerms();
		} else if (tourCheck() > 0) {
			logger.info("Tour is loaded");
			closeTour();
		} else
			isLoaded(brand, status);
		logger.info("Home Page is loaded");
	}

	/**
	 * elements
	 */

	private int tourCheck() {
		return _driver.findElements(cancelTour).size();
	}

	private void closeTour() {
		_driver.findElement(cancelTour).click();
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
	public Sb4LoginPage LogOut() throws InterruptedException {
		um.LogOut();
		return new Sb4LoginPage(_driver);
	}

	/**
	 * shared service takes user to profile page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProfilePage GoToMyProfile() throws InterruptedException {
		um.MyProfile();
		return new Sb4ProfilePage(_driver);
	}

	/**
	 * shared change project service for users w/ <8 projects
	 * 
	 * @param mainProj
	 *            : initial project present in the menu
	 * @param nextProj
	 *            : desired project to switch to
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4HomePage ChangeProject(String nextProj) throws InterruptedException {
		um.projectMenu(nextProj);
		return this;
	}

	/**
	 * shared change project service for users w/ >8 projects
	 * 
	 * @param mainProj
	 *            : initial project present in the menu
	 * @param nextProj
	 *            : desired project to switch to
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4HomePage ChangeProject2(String nextProj) throws InterruptedException {
		um.projectMenuSearch(nextProj);
		return this;
	}

	/**
	 * used to check the initial project that is loaded
	 * 
	 * @param project
	 * @return
	 */
	public Sb4HomePage CheckProject(String project) {
		um.projectLoaded(project);
		return this;
	}

	/**
	 * used to check for project in project menu
	 * 
	 * @param project
	 * @param project2
	 * @return
	 */
	public int CheckProject(String project, String project2) {
		return um.projectCheck(project2);
	}

	/**
	 * uses SB site search feature
	 * 
	 * @param value
	 *            : of site to search for
	 * @return : Sb4SearchResultsPage
	 * @throws InterruptedException
	 */
	public Sb4SearchResultsPage SiteSearch(String value) throws InterruptedException {
		um.SiteSearch(value);
		return new Sb4SearchResultsPage(_driver);
	}

	public void userFBack(String Value) {
		new MenuBar(_driver).userFBack(Value);
	}

	/**
	 * navigates to the project view / info page
	 * 
	 * @return : Sb4ProjectViewPage
	 * @throws InterruptedException
	 */
	public Sb4ProjectViewPage goToProjInfo() throws InterruptedException {
		um.projectInfo();
		return new Sb4ProjectViewPage(_driver);
	}

	/**
	 * checks for the presence of the project info menu. if present a runtime
	 * exception is thrown and the user is logged out.
	 * 
	 * @return Sb4HomePage
	 * @throws InterruptedException
	 */
	public Sb4HomePage projInfoChk() throws InterruptedException {
		if (um.projInfoCount() > 0) {
			LogOut();
			logger.info("project info menu was found");
			throw new RuntimeException("project info menu was found");
		} else
			logger.info("project info menu was not found");
		return this;
	}
}