package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * Class file for Back End Dashboard page this is the first page you land when
 * logging into the Studio Balfour Back End
 * 
 * @author cmanning
 * 
 */
public class Sb4AdminDashboardPage extends Page {

	/**
	 * locators
	 */
	private By dbActivity = By.xpath("//div[@id='dashboard_activity']");
	private By dbAtAGlance = By.xpath("//div[@id='dashboard_right_now']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4AdminDashboardPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(dbActivity, dbAtAGlance);
	}

	/**
	 * services
	 */

	/**
	 * takes you to the WP BE User page uses shared side bar class
	 * 
	 * @return : Sb4AdminUserPage
	 * @throws InterruptedException
	 */
	public Sb4AdminUserPage GoToUserPage() throws InterruptedException {
		new Sb4AdminSideBar(_driver).UsersPage();
		return new Sb4AdminUserPage(_driver);
	}

	public Sb4LoginPage adminLogOut() throws InterruptedException {
		new Sb4AdminSideBar(_driver).LogOut();
		return new Sb4LoginPage(_driver);
	}

}