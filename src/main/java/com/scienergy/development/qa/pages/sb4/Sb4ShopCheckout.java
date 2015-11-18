package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * used for all things Studio Balfour checkout related
 * 
 * @author cmanning
 * 
 */
public class Sb4ShopCheckout extends Page {

	/**
	 * locators
	 */
	private By chkOutTitle = By.xpath("//*[.='Checkout']");
	private By back2Store = By.xpath("//*[.='Back to Store']");
	private By myCart = By.xpath("//*[.='My Cart']");
	private By plOrder = By.xpath("//*[@id='place_order']");
	private By termsNCon = By.xpath("//a[.='terms & conditions']");
	private By termsChkBx = By.xpath("//input[@id='terms']");
	private By termsError = By
			.cssSelector("div.woocommerce > form.checkout.ng-pristine.ng-valid > ul.woocommerce-error");

	public Sb4ShopCheckout(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(chkOutTitle, termsNCon);
		logger.info("Shop Checkout Page is loaded");
	}

	/**
	 * elements
	 */

	private Sb4ShopCheckout clickMyCart() {
		_driver.findElement(myCart).click();
		return this;
	}

	private Sb4ShopCheckout clickBack2Store() {
		_driver.findElement(back2Store).click();
		return this;
	}

	/**
	 * terms check box
	 * 
	 * @return
	 */
	private Sb4ShopCheckout clickTerms() {
		_driver.findElement(termsChkBx).click();
		return this;
	}

	/**
	 * place order button
	 * 
	 * @return
	 */
	private Sb4ShopCheckout clickPlcOrder() {
		_driver.findElement(plOrder).click();
		return this;
	}

	/**
	 * services
	 */

	/**
	 * clicks terms box and place order button
	 * 
	 * @return : checkout received page
	 * @throws InterruptedException
	 */
	public Sb4ShopCheckoutRcvd placeOrder() throws InterruptedException {
		clickTerms();
		clickPlcOrder();
		return new Sb4ShopCheckoutRcvd(_driver);
	}

	/**
	 * used to attempt to place order w/o clicking terms box
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ShopCheckout badPlaceOrder() throws InterruptedException {
		clickPlcOrder();
		waitForElementVisable(termsError, 10);
		return this;
	}

	public Sb4ShopCartPage GoToCart() throws InterruptedException {
		clickMyCart();
		return new Sb4ShopCartPage(_driver);
	}

	public Sb4ShopPage GoToStore() throws InterruptedException {
		clickBack2Store();
		return new Sb4ShopPage(_driver);
	}

}