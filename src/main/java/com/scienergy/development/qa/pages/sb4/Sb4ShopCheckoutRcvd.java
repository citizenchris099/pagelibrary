package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.balfour.publishing.qa.pages.Page;

/**
 * class used to verify arrival at the checkout received page
 * 
 * @author cmanning
 * 
 */
public class Sb4ShopCheckoutRcvd extends Page {

	/**
	 * locators
	 */
	By thankYou = By.xpath("//*[.='Thank you. Your order has been received.']");
	By oDetails = By.xpath("//*[.='Order Details']");

	/**
	 * Constructor used to verify arrival at the checkout received page
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ShopCheckoutRcvd(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(thankYou, oDetails);
		logger.info("Check Out Received Page is loaded");
	}
}