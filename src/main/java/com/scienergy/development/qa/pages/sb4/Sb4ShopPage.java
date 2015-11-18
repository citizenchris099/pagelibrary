package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.qa.pages.Page;

/**
 * class used to access the Studio Balfour Shop / Supply Desk features
 * 
 * @author cmanning
 * 
 */
public class Sb4ShopPage extends Page {


	/**
	 * locators
	 */
	private By shopTile = By.xpath("//*[.='Shop']");
	private By myCart = By.xpath("//*[.='My Cart']");
	private By orderBy = By.xpath("//select[@name='orderby']");

	/**
	 * standard constructor used to verify correct page is loaded
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ShopPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(shopTile, orderBy);
	}

	/**
	 * elements
	 */
	private Sb4ShopPage clickMyCart() {
		_driver.findElement(myCart).click();
		return this;
	}

	/**
	 * used to add item to the cart
	 * 
	 * @param value
	 *            : href of item to be added
	 * @return
	 */
	private Sb4ShopPage add2cart(String value) {
		String txt = "//a[@href='" + value + "']";
		By button = By.xpath(txt);
		_driver.findElement(button).click();
		return this;
	}

	/**
	 * services
	 */

	/**
	 * used to add item to cart
	 * 
	 * @param value
	 *            : href of item to be added
	 * @param value2
	 *            : href of the item on the cart page. this is used by the
	 *            constructor of the cart page to assert the correct item made
	 *            it to the cart
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ShopCartPage ClickAdd2Cart(String value, String value2)
			throws InterruptedException {
		add2cart(value);
		return new Sb4ShopCartPage(_driver, value2);
	}

	public Sb4ShopCartPage GoToCart() throws InterruptedException {
		clickMyCart();
		return new Sb4ShopCartPage(_driver);
	}
}
