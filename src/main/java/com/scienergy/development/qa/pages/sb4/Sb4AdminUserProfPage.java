package com.scienergy.development.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.scienergy.development.qa.AdminProfilePOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * Studio Balfour Back End User Profile pages typically used in testing that
 * user values are as expected in the word press database
 * 
 * @author cmanning
 * 
 */
public class Sb4AdminUserProfPage extends Page {

	/**
	 * locators
	 */
	private By persOpt = By.xpath("//*[.='Personal Options']");
	private By uName = By.xpath("//input[@id='user_login']");
	private By fName = By.xpath("//input[@id='first_name']");
	private By lName = By.xpath("//input[@id='last_name']");
	private By dName = By.xpath("//select[@id='display_name']");
	private By eMail = By.xpath("//input[@id='email']");
	private By fbook = By.xpath("//input[@name='facebook']");
	private By google = By.xpath("//input[@name='googleplus']");
	private By yahoo = By.xpath("//input[@name='yahoo']");
	private By twitter = By.xpath("//input[@name='twitter']");
	private By linkedin = By.xpath("//input[@name='linkedin']");
	private By pintrest = By.xpath("//input[@name='pinterest']");
	private By instagram = By.xpath("//input[@name='instagram']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4AdminUserProfPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(persOpt, fName);
	}

	/**
	 * elements
	 */

	private String getUName() {
		disabledCheck(uName);
		return _driver.findElement(uName).getAttribute("value");
	}

	private String getFName() {
		return _driver.findElement(fName).getAttribute("value");
	}

	private String getLName() {
		return _driver.findElement(lName).getAttribute("value");
	}

	private String getDName() {
		return new Select(_driver.findElement(dName)).getFirstSelectedOption()
				.getText();
	}

	private String getEmail() {
		return _driver.findElement(eMail).getAttribute("value");
	}

	private String getFBook() {
		return _driver.findElement(fbook).getAttribute("value");
	}

	private String getTwitter() {
		return _driver.findElement(twitter).getAttribute("value");
	}

	private String getGoogle() {
		return _driver.findElement(google).getAttribute("value");
	}

	private String getYahoo() {
		return _driver.findElement(yahoo).getAttribute("value");
	}

	private String getLinkedin() {
		return _driver.findElement(linkedin).getAttribute("value");
	}

	private String getPinterest() {
		return _driver.findElement(pintrest).getAttribute("value");
	}

	private String getInstagram() {
		return _driver.findElement(instagram).getAttribute("value");
	}

	/**
	 * services
	 */

	/**
	 * used to check the Admin User Profile form contains the correct
	 * Information.
	 * 
	 * @return : object of AdminProfilePOJO
	 */
	public AdminProfilePOJO checkAdminUProfile() {
		AdminProfilePOJO obj = new AdminProfilePOJO();

		obj.setuName(getUName());
		obj.setfName(getFName());
		obj.setlName(getLName());
		obj.setdName(getDName());
		obj.setEmail(getEmail());
		obj.setfBook(getFBook());
		obj.setTwitter(getTwitter());
		obj.setGoogle(getGoogle());
		obj.setYahoo(getYahoo());
		obj.setLinkedin(getLinkedin());
		obj.setPinterest(getPinterest());
		obj.setInstagram(getInstagram());

		return obj;
	}

	/**
	 * uses shared logout service to log out
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4LoginPage adminLogOut() throws InterruptedException {
		new Sb4AdminSideBar(_driver).LogOut();
		return new Sb4LoginPage(_driver);
	}
}