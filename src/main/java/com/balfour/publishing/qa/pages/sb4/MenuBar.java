package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.balfour.publishing.qa.pages.Page;

/**
 * this class represents all elements present in the horizontal 'bread crumbs'
 * bar near the top of Studio Balfour. these services are such that they can be
 * used within any other page class file
 * 
 * @author cmanning
 * 
 */
public class MenuBar extends Page {

	/**
	 * locators
	 */
	String home = slugNAction.getHome();
	private By homeButton = dynamicLocator(home);
	private By userFBackClosed = By
			.xpath("//div[@class='user-feedback-form closed']");
	private By userFBackOpened = By
			.xpath("//div[@class='user-feedback-form opened']");
	private By userFBackOpener = By.xpath(".//div[@class='opener']");
	private By userFBackTBox = By
			.xpath(".//textarea[@class='form-control field-required']");
	private By userFBackSubmit = By
			.xpath(".//button[@class='btn btn-primary']");

	/**
	 * basic constructor
	 * 
	 * @param driver
	 */
	public MenuBar(WebDriver driver) {
		super(driver);
	}

	/**
	 * elements
	 */

	private void openUsrFback() {

		WebElement fbak = _driver.findElement(userFBackClosed);
		fbak.findElement(userFBackOpener).click();
	}

	private void usrFbackTBox(String value) {

		WebElement tBox = _driver.findElement(userFBackOpened);
		tBox.findElement(userFBackTBox).sendKeys(value);
	}

	private void usrFbackSubmit() {

		WebElement tBox = _driver.findElement(userFBackOpened);
		tBox.findElement(userFBackSubmit).click();
	}

	/**
	 * services
	 */

	/**
	 * returns user to home page.
	 * 
	 * @return : Sb4HomePage
	 * @throws InterruptedException
	 */
	public Sb4HomePage goHome() throws InterruptedException {
		Actions builder = new Actions(_driver);
		WebElement hb = _driver.findElement(homeButton);
		builder.moveToElement(hb).build().perform();
		hb.click();
		return new Sb4HomePage(_driver);
	}

	public void userFBack(String value) {

		openUsrFback();
		usrFbackTBox(value);
		usrFbackSubmit();
	}

}