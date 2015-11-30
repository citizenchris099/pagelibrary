package com.scienergy.development.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scienergy.development.Test_Environment;
import com.scienergy.development.Test_EnvironmentPOJO;
import com.scienergy.development.qa.pages.spec.RestUtil;
import com.scienergy.development.qa.pages.spec.RndStringUtil;
import com.scienergy.development.qa.pages.spec.SpecMainPage;

/**
 * base page class that contains various utilities that are shared across all
 * page class files
 * 
 * @author cmanning
 * 
 */
public class Page {
	protected static WebDriver _driver;
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected Test_EnvironmentPOJO slugNAction = new Test_Environment().slugNAction();

	Actions builder = null;

	public Page(WebDriver driver) {
		Page._driver = driver;
		builder = new Actions(_driver);
	}

	/**
	 * used to verify visibility of element on page
	 * 
	 * @param locator
	 *            : the locater to wait for
	 * @param timeout
	 *            : amount of time to wait
	 * @return
	 */
	public WebElement waitForElementVisable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(_driver, timeout);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * used to verify the clickability of an element
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(_driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * waits for the visibility of a locator
	 * 
	 * @param locator
	 *            : to wait for
	 * @return
	 */
	public WebElement waitForElementVisable(By locator) {
		return waitForElementVisable(locator, 10);
	}

	/**
	 * used to assert presence of element
	 * 
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(_driver, timeout);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * used for verifying HTTP response code
	 * 
	 * @param url
	 *            : to check reasons of
	 * @return
	 */
	public static boolean checkResponse(String url) {
		try {
			int resp_code = Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();

			if (resp_code == 200)
				return true;
			else
				return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	

	/**
	 * methods to verify page is loaded
	 */

	/**
	 * checks for the presence of two elements on a page to verify said page is
	 * loaded.
	 * 
	 * @param one
	 *            : first element to check
	 * @param two
	 *            : second element to check
	 * @throws InterruptedException
	 */
	public void isLoaded(By one, By two) throws InterruptedException {
		waitForElementPresence(one, 5);
		waitForElementPresence(two, 5);
	}

	/**
	 * uses the guerrilla mail api to get a random test email addy
	 * 
	 * @return
	 */
	public String emailGen() {
		String email = new RestUtil().guerrillamail();
		logger.info("User Email is " + email);
		return email;
	}

	/**
	 * used to assert the options available in a pulldown menu
	 * 
	 * @param array
	 *            : of expected options
	 * @param select
	 *            : locator of the pulldown to check
	 */
	public void optionsAvailable(String[] array, By select) {
		/**
		 * gets the size and all of the options within the pull down
		 */
		Select dropdown = new Select(_driver.findElement(select));
		List<WebElement> allOptions = dropdown.getOptions();

		int count = 0;
		for (WebElement we : allOptions) {
			logger.info(we.getText());
			System.out.println(we.getText());
			for (int i = 0; i < array.length; i++) {
				if (we.getText().equals(array[i])) {
					count++;
				}
			}
		}
		if (count != array.length) {
			throw new RuntimeException("Actual values didn't match");
		}
	}

	/**
	 * used to verify a field is disabled
	 * 
	 * @param locator
	 */
	public void disabledCheck(By locator) {
		Boolean textVal = _driver.findElement(locator).isEnabled();
		if (!textVal.equals(false)) {
			throw new RuntimeException("element was not disabled");
		}
	}

	/**
	 * used to click dynamic elements
	 * 
	 * @param locator
	 */
	public void dynamicClick(By locator) {
		java.util.List<WebElement> allElements = _driver.findElements(locator);
		for (WebElement t : allElements) {
			if (t.isDisplayed()) {
				t.click();
			}
		}
	}

	/**
	 * used to generate a locator based on an anticipated message that should
	 * appear
	 * 
	 * @param msg
	 *            : string that contains part of / all of message that should
	 *            appear
	 * @return : By locator for message
	 */
	public By dynamicMsg(String msg) {
		return By.xpath("//*[contains(text(), '" + msg + "')]");
	}

	/**
	 * tries to find an element and catches both NoSuchElementException &
	 * TimeoutException. logs potential errors (with the name of the locator so
	 * you know what failed) and then throws a RuntimeException (also with the
	 * name of the locator so you know what failed from the console)
	 * 
	 * @param e
	 *            : By locator of element to find
	 * @return : WebElement
	 */
	public WebElement findElement(By e) {
		try {
			return _driver.findElement(e);
		} catch (NoSuchElementException n) {
			logger.info("Locator named " + e + " was not found on page");
			throw new RuntimeException("Locator named " + e + " was not found on page");
		} catch (TimeoutException t) {
			logger.info("Locator named " + e + " was not found in time");
			throw new RuntimeException("Locator named " + e + " was not found in time");
		} catch (ElementNotVisibleException t) {
			logger.info("Locator named " + e + " was not visible");
			throw new RuntimeException("Locator named " + e + " was not visible");
		}
	}

	/**
	 * tries to find the parent element first element and catches both
	 * NoSuchElementException & TimeoutException. logs potential errors (with
	 * the name of the locator so you know what failed) and then throws a
	 * RuntimeException (also with the name of the locator so you know what
	 * failed from the console) the same is done for the child element.
	 * 
	 * @param e1
	 *            : By locator of the parent
	 * @param e2
	 *            : By locator of the child
	 * @return : WebElement of the child
	 */
	public WebElement findElement(By e1, By e2) {
		WebElement parent;
		try {
			parent = _driver.findElement(e1);
		} catch (NoSuchElementException n) {
			logger.info("Locator named " + e1 + " was not found on page");
			throw new RuntimeException("Locator named " + e1 + " was not found on page");
		} catch (TimeoutException t) {
			logger.info("Locator named " + e1 + " was not found in time");
			throw new RuntimeException("Locator named " + e1 + " was not found in time");
		} catch (ElementNotVisibleException t) {
			logger.info("Locator named " + e1 + " was not visible");
			throw new RuntimeException("Locator named " + e1 + " was not visible");
		}
		try {
			return parent.findElement(e2);
		} catch (NoSuchElementException n) {
			logger.info("Locator named " + e2 + " was not found on page");
			throw new RuntimeException("Locator named " + e2 + " was not found on page");
		} catch (TimeoutException t) {
			logger.info("Locator named " + e2 + " was not found in time");
			throw new RuntimeException("Locator named " + e2 + " was not found in time");
		} catch (ElementNotVisibleException t) {
			logger.info("Locator named " + e2 + " was not visible");
			throw new RuntimeException("Locator named " + e2 + " was not visible");
		}

	}

	public List<WebElement> findElements(By e1, By e2) {
		WebElement parent;
		try {
			parent = _driver.findElement(e1);
		} catch (NoSuchElementException n) {
			logger.info("Locator named " + e1 + " was not found on page");
			throw new RuntimeException("Locator named " + e1 + " was not found on page");
		} catch (TimeoutException t) {
			logger.info("Locator named " + e1 + " was not found in time");
			throw new RuntimeException("Locator named " + e1 + " was not found in time");
		}
		try {
			return parent.findElements(e2);
		} catch (NoSuchElementException n) {
			logger.info("Locator named " + e2 + " was not found on page");
			throw new RuntimeException("Locator named " + e2 + " was not found on page");
		} catch (TimeoutException t) {
			logger.info("Locator named " + e2 + " was not found in time");
			throw new RuntimeException("Locator named " + e2 + " was not found in time");
		}

	}

}
