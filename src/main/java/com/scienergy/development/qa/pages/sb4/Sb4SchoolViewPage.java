package com.scienergy.development.qa.pages.sb4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.scienergy.development.qa.SchoolViewPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * the Studio Balfour School View Page
 * 
 * @author cmanning
 * 
 */
public class Sb4SchoolViewPage extends Page {

	/**
	 * locators
	 */
	private By adress = By.xpath("//div[@id='billing-address']");
	private By schoolName = By.xpath("//div[@class='title-tile']");
	private By salesO = By.xpath("//div[@id='sales-office']");
	private By status = By.xpath("//div[@id='status']");
	private By salesR = By.xpath("//div[contains(text(),'Sales Region')]");
	private By number = By.xpath("//div[@id='number']");
	private By contacts = By.xpath("//div[@id='contacts']");
	private By grades = By.xpath("//div[contains(text(),'Grades')]");
	private By sub01 = By.xpath(".//span[@class='font-xlarge strong']");
	private By sub02 = By.xpath(".//span[@class='font-medium']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4SchoolViewPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(adress, contacts);
		logger.info("School View Page loaded");
	}

	/**
	 * elements
	 */

	private String getSchoolName() {
		return _driver.findElement(schoolName).getText().trim();
	}

	public String getStatus() {

		WebElement salesRegion = _driver.findElement(status);
		return salesRegion.findElement(sub01).getText().trim();
	}

	/**
	 * used to retrieve the text of the sales region are of the page
	 * 
	 * @return
	 */
	private String getSalesRegion() {

		WebElement salesRegion = _driver.findElement(salesR);
		return salesRegion.findElement(sub02).getText().trim();
	}

	private String getSalesOffice() {

		WebElement salesOffice = _driver.findElement(salesO);
		return salesOffice
				.findElement(By.xpath(".//span[@class='font-large']"))
				.getText().trim();
	}

	private String getNumber() {

		WebElement num = _driver.findElement(number);
		return num.findElement(By.xpath(".//span[@class='font-large']"))
				.getText().trim();
	}

	private String getGrades() {

		WebElement gr = _driver.findElement(grades);
		return gr.findElement(By.xpath(".//span[@class='font-large']"))
				.getText().trim();
	}

	private String[] contacts() {
		String[] tmp = new String[4];
		WebElement billing = _driver.findElement(contacts);
		List<WebElement> allLi = billing.findElements(By.tagName("tr"));
		int count = 0;
		for (WebElement eachLi : allLi) {
			tmp[count] = eachLi.getText();
			count++;
		}
		return tmp;
	}

	private String contLine0() {

		String[] array = new String[4];
		array = contacts();
		String[] tokens = array[1].split(",");
		String line1 = tokens[0].trim();

		return line1;
	}

	private String contLine1() {

		String[] array = new String[4];
		array = contacts();
		String[] tokens = array[2].split(",");
		String line1 = tokens[0].trim();

		return line1;
	}

	/**
	 * used to interrogate the address text displayed on school view
	 * 
	 * @param value
	 *            : id value used to denote billing or shipping address
	 * @return
	 */
	private String adress(String value) {
		By adress = By.xpath("//div[@id='" + value + "']");
		WebElement billing = _driver.findElement(adress);

		String tmp = billing.getText().trim().replaceAll("\n", " ")
				.replaceAll("\r", " ");

		return tmp;
	}

	/**
	 * services
	 */

	/**
	 * used to interrogate all school view text
	 * 
	 * @param ship
	 *            : Boolean to denote whether to check for the shipping address.
	 *            if true then it is checked
	 * @return : obj of SchoolViewPOJO
	 * @throws InterruptedException
	 */
	public SchoolViewPOJO checkSchoolView(Boolean ship)
			throws InterruptedException {
		logger.info("retrieving School View info ");
		SchoolViewPOJO obj = new SchoolViewPOJO();
		obj.setbAdd1(adress("billing-address"));

		if (ship == true) {
			obj.setsAdd1(adress("shipping-address"));
		}

		obj.setsName(getSchoolName());
		obj.setRegion(getSalesRegion());
		obj.setsOffice(getSalesOffice());
		obj.setNumber(getNumber());
		obj.setCont0(contLine0());
		obj.setCont1(contLine1());
		obj.setStatus(getStatus());
		obj.setGrade(getGrades());
		logger.info("School View info retrieved");

		return obj;
	}
}