package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.Test_EnviornmentPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * used in testing the Studio Balfour cart page. this class file is used in
 * conjunction with the Sb4ShopPage class.
 * 
 * @author cmanning
 * 
 */
public class Sb4ShopCartPage extends Page {

	/**
	 * locators
	 */
	private By cartTitle = By.xpath("//*[.='Cart']");
	private By back2Store = By.xpath("//*[.='Back to Store']");
	private By contShop = By.xpath("//a[.='Continue Shopping']");
	private By plus = By.xpath(".//input[@class='plus']");
	private By minus = By.xpath(".//input[@class='minus']");
	private By upCart = By.xpath("//input[@name='update_cart']");
	private By cartUpMsg = By.xpath("//div[.='Cart updated.']");
	private By chkOut = By.xpath("//input[@name='proceed']");
	private Test_EnviornmentPOJO slugNAction = new Test_Enviornment()
			.slugNAction();
	private String shop = slugNAction.getShop();
	private By rtr2Shop = dynamicLocator(shop);


	/**
	 * constructor used to verify correct page is loaded. this constructor is
	 * used when going directly to cart w/o first adding an item or when the
	 * presence of an item is not needing to be verified.
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ShopCartPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(cartTitle, back2Store);
		logger.info("Shopping Cart Page is loaded");
	}

	/**
	 * constructor used to verify correct page is loaded. this version of the
	 * constructor is used when arrival at the cart is preceded by adding an
	 * item.
	 * 
	 * @param driver
	 * @param value2
	 * @throws InterruptedException
	 */
	public Sb4ShopCartPage(WebDriver driver, String value2)
			throws InterruptedException {
		super(driver);
		isLoaded(cartTitle, back2Store);
		String txt = "//a[@href='" + value2 + "']";
		By button = By.xpath(txt);
		waitForElementVisable(button, 10);
		logger.info("Shopping Cart Page is loaded");
	}

	/**
	 * elements
	 */

	private Sb4ShopCartPage clickBack2Store() {
		_driver.findElement(back2Store).click();
		return this;
	}

	/**
	 * continue shopping button
	 * 
	 * @return
	 */
	private Sb4ShopCartPage clickContShop() {
		_driver.findElement(contShop).click();
		return this;
	}

	/**
	 * clicks return to shop button which is only visible when cart is emptied.
	 * 
	 * @return
	 */
	private Sb4ShopCartPage clickRtrn2Shop() {
		_driver.findElement(rtr2Shop).click();
		return this;
	}

	/**
	 * checkout button
	 * 
	 * @return
	 */
	private Sb4ShopCartPage clickCheckout() {
		_driver.findElement(chkOut).click();
		return this;
	}

	/**
	 * used to identify a specific product present in shopping cart
	 * 
	 * @param value
	 *            : of specific product to identify
	 * @return : webelement of product
	 */
	private WebElement product(String value) {
		String txt = "//a[contains(text(), '" + value + "')]/../..";
		WebElement X = _driver.findElement(By.xpath(txt));
		return X;
	}

	/**
	 * uses the "product" element to identify product specific "plus" button
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ShopCartPage clickPlus(String value) {
		product(value).findElement(plus).click();
		return this;
	}

	/**
	 * uses the "product" element to identify product specific "minus" button
	 * 
	 * @param value
	 * @return
	 */
	private Sb4ShopCartPage clickMinus(String value) {
		product(value).findElement(minus).click();
		return this;
	}

	/**
	 * update cart button
	 * 
	 * @return
	 */
	private Sb4ShopCartPage clickUpdateCart() {
		_driver.findElement(upCart).click();
		return this;
	}

	/**
	 * services
	 */

	/**
	 * when only one item is present in cart this function can be used to remove
	 * it.
	 * 
	 * @param Value
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ShopPage rmwOnlyItem(String Value) throws InterruptedException {
		clickMinus(Value);
		clickUpdateCart();
		waitForElementPresence(cartUpMsg, 10);
		clickRtrn2Shop();
		return new Sb4ShopPage(_driver);
	}

	/**
	 * service to continue shopping using the Cont Shop button
	 * 
	 * @return : Shop Page
	 * @throws InterruptedException
	 */
	public Sb4ShopPage ContShop() throws InterruptedException {
		clickContShop();
		return new Sb4ShopPage(_driver);
	}

	/**
	 * takes you to the check out page
	 * 
	 * @return : check out page
	 * @throws InterruptedException
	 */
	public Sb4ShopCheckout Go2ChkOut() throws InterruptedException {
		clickCheckout();

		return new Sb4ShopCheckout(_driver);
	}

	/**
	 * takes user to supply desk main page "store"
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ShopPage GoToStore() throws InterruptedException {
		clickBack2Store();
		return new Sb4ShopPage(_driver);
	}

}