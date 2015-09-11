package com.balfour.publishing.qa.pages;

import java.util.List;

import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.balfour.publishing.Test_Enviornment;
import com.balfour.publishing.Test_EnviornmentPOJO;
import com.balfour.publishing.qa.pages.sb4.RestUtil;
import com.balfour.publishing.qa.pages.sb4.RndStringUtil;

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
	protected Test_EnviornmentPOJO slugNAction = new Test_Enviornment()
			.slugNAction();

	public Page(WebDriver driver) {
		Page._driver = driver;
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
		return wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
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
			int resp_code = Request.Get(url).execute().returnResponse()
					.getStatusLine().getStatusCode();

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
		waitForElementPresence(one, 10);
		waitForElementPresence(two, 10);
	}

	/**
	 * used to generate a random email.
	 * 
	 * @return
	 */
	public String emailGen001() {
		String enfold = String.format(slugNAction.getEnfold(), "/users?email=");
		int expected = 404;

		@SuppressWarnings("unused")
		Boolean flag = true;
		String email = null;
		while (flag = true) {

			email = new RndStringUtil().randomPass();
			int results = new RestUtil().enfoldCheckCode(enfold, email);

			System.out.println(results);

			if (expected == results) {
				break;
			}
			flag = true;
		}
		logger.info("Email is " + email);
		return email;
	}
	
	public String emailGen002(){
		
		String email = new RestUtil().guerrillamail();
		logger.info("User Email is " + email);
		return email;
	}

	/**
	 * used to generate a random string.
	 * 
	 * @return
	 */
	public String randomString(int num) {
		String string = new RndStringUtil().RandomString(num);

		return string;
	}

	/**
	 * used to generate a random "name"
	 * 
	 * @param num
	 * @return
	 */
	public String randomNames(int num) {
		String string = new RndStringUtil().RandomName(num);

		return string;
	}

	/**
	 * used to generate random phone phone number
	 * 
	 * @return : 10 digit phone number string
	 */
	public String randomPhone() {
		String string = new RndStringUtil().RandomPhone();

		logger.info("User Phone is " + string);
		return string;
	}

	/**
	 * generates a random 20 character username.
	 * 
	 * @return
	 */
	public String randomUName() {
		String string = randomNames(20);

		logger.info("User Name is " + string);
		return string;
	}

	/**
	 * generates a random 8 character password.
	 * 
	 * @return
	 */
	public String randomPassword() {
		String string = new RndStringUtil().randomPass();

		logger.info("Password is " + string);
		return string;
	}

	/**
	 * generates a random 5 character first name
	 * 
	 * @return
	 */
	public String randomFName() {
		String string = randomNames(5);

		logger.info("First Name is " + string);
		return string;
	}

	/**
	 * generates a random 8 character last name.
	 * 
	 * @return
	 */
	public String randomLName() {
		String string = randomNames(8);

		logger.info("Last Name is " + string);
		return string;
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
	 * used to assert items selected in a multi-select pulldown
	 * 
	 * @param array
	 * @param select
	 */
	public void optionsSelected(String[] array, By select) {
		/**
		 * gets the size and all of the options within the pull down
		 */
		Select dropdown = new Select(_driver.findElement(select));
		List<WebElement> allOptions = dropdown.getAllSelectedOptions();

		int count = 0;
		for (WebElement we : allOptions) {
			logger.info(we.getText());
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
	 * used to generate a dynamic locator based on an href that is unique to the
	 * environment.
	 * 
	 * @param slugAction
	 *            : the unique slug and action of the href
	 * @param value
	 *            : that is concatenated with the slugAction. this is typically
	 *            a unique project or school id
	 * @return : xpath locator
	 */
	public By dynamicLocator(String slugAction, String value) {
		String link = String.format(slugAction, value);

		String url = new Test_Enviornment().envUrl(link);

		String txt = "//a[@href='" + url + "']";
		By button = By.xpath(txt);
		return button;
	}

	/**
	 * used to generate a dynamic locator based on an href that is unique to the
	 * environment.
	 * 
	 * @param slugAction
	 *            : the unique slug and action of the href
	 * @return
	 */
	public By dynamicLocator(String slugAction) {

		String url = new Test_Enviornment().envUrl(slugAction);
		By locator = By.xpath("//a[@href='" + url + "']");

		return locator;
	}

}
