package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.balfour.publishing.qa.pages.Page;

/**
 * Studio Balfour Log In page class contains methods needed for log in as well
 * as password reset
 * 
 * @author cmanning
 * 
 */
public class Sb4TermsPage extends Page {

	/**
	 * locators
	 */
	private By agree = By.xpath("//button[@name='i_agree']");
	private By doNotAgree = By.xpath("//button[@name='i_dont_agree']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4TermsPage(WebDriver driver) throws InterruptedException {
		super(driver);
//		isLoaded(agree, doNotAgree);
//		logger.info("Terms&Policy Page is loaded");
	}

	/**
	 * elements
	 */

	private Sb4TermsPage clickAgree() {
		_driver.findElement(agree).click();
		return this;
	}

	private Sb4TermsPage clickDontAgree() {
		_driver.findElement(doNotAgree).click();
		return this;
	}

	/**
	 * services
	 */

	/**
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4HomePage agreeTerms() throws InterruptedException {

		clickAgree();
		return new Sb4HomePage(_driver);
	}
	
	public Sb4LoginPage doNotAgree() throws InterruptedException{
		
		clickDontAgree();
		return new Sb4LoginPage(_driver);
	}
	
	public int termsPageCheck(){
		return _driver.findElements(agree).size();
	}
}