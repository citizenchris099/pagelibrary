package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.Test_EnviornmentPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * these are the services available across all pages in the WP BE essentially
 * every link along the top or left side of the WP BE should go here
 * 
 * @author cmanning
 * 
 */
public class Sb4AdminSideBar extends Page {

	/**
	 * locators
	 */
	private By users = By.xpath("//*[.='Users']");
	private Test_EnviornmentPOJO slugNAction = new Test_Enviornment()
			.slugNAction();
	private String adminProfile = slugNAction.getWpAdminProfile();
	private By profile = dynamicLocator(adminProfile);
	private By logOut = By.xpath("//a[.='Log Out']");

	/**
	 * basic constructor
	 * 
	 * @param driver
	 */
	public Sb4AdminSideBar(WebDriver driver) {
		super(driver);
	}

	/**
	 * takes user to the WP BE user page
	 */
	public void UsersPage() {
		Actions builder = new Actions(_driver);
		WebElement um = _driver.findElement(users);
		builder.moveToElement(um).build().perform();
		um.click();
	}

	/**
	 * logs user out
	 */
	public void LogOut() {

		Actions builder = new Actions(_driver);
		WebElement um = _driver.findElement(profile);
		builder.moveToElement(um).build().perform();
		waitForElementVisable(logOut);
		_driver.findElement(logOut).click();
	}
}