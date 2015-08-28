package com.balfour.publishing.qa.pages.sb4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.balfour.publishing.qa.pages.Page;

/**
 * Class for On Campus Order elements and services
 * 
 * @author cmanning
 * 
 */
public class Sb4OCOViewPage extends Page {

	/**
	 * locators
	 */
	private By payInfo = By.xpath("//div[@id='payment-info']");
	private By payInfoSub = By.xpath(".//div[@class='payment right']");
	private By orderTotal = By.xpath(".//div[@id='order-total']");
	private By purchaser = By.xpath(".//div[@id='purchaser']");
	private By student = By.xpath(".//div[@id='student']");
	private By orderNum = By.xpath(".//div[@id='order-number']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4OCOViewPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(payInfo, orderTotal);
		logger.info("On Campus Orders Page is loaded");
	}

	/**
	 * elements
	 */

	public String[] getPayInfo() {
		waitForElementPresence(payInfo, 15);
		String[] tmp = new String[4];
		WebElement info = _driver.findElement(payInfo);
		List<WebElement> allLi = info.findElements(payInfoSub);
		int count = 0;
		for (WebElement eachLi : allLi) {
			tmp[count] = eachLi.getText();
			count++;
		}
		return tmp;
	}

	public String oDate() {

		String[] array = new String[4];
		array = getPayInfo();
		String[] tokens = array[0].split(",");
		String line1 = tokens[0].trim();
		return line1.trim();
	}

	public String curDate() {

		Date today = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("MMM dd");
		String reportDate = df.format(today);
		return reportDate.trim();
	}

	public String pType() {

		String[] array = new String[4];
		array = getPayInfo();
		String pType = array[1].trim();
		return pType.trim();
	}

	public String aPaid() {

		String[] array = new String[4];
		array = getPayInfo();
		String[] tokens = array[2].split(":");
		String aPaid = tokens[1].trim();
		return aPaid.trim();
	}

	public String oTotal() {

		WebElement oTotal = _driver.findElement(orderTotal);
		String tmp = oTotal.getText().trim().replaceAll("\n", " ")
				.replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String total = tokens[1].trim();
		String[] tokens1 = total.split(" ");
		String aTotal = tokens1[0];
		return aTotal.trim();
	}

	public String tDue() {

		WebElement oTotal = _driver.findElement(orderTotal);
		String tmp = oTotal.getText().trim().replaceAll("\n", " ")
				.replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String due = tokens[2].trim();
		return due.trim();
	}
	
	public String getOnum() {

		WebElement oNum = _driver.findElement(orderNum);
		String tmp = oNum.getText().trim().replaceAll("\n", " ")
				.replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String due = tokens[1].trim();
		return due.trim();
	}

	public String getPurchaser() {

		return _driver.findElement(purchaser).getText().trim()
				.replaceAll("\n", " ").replaceAll("\r", " ");
	}
	
	public String getStudent() {

		return _driver.findElement(student).getText().trim()
				.replaceAll("\n", " ").replaceAll("\r", " ");
	}

	/**
	 * services
	 * 
	 */

	public void checODate() {

		if (!oDate().equals(curDate())) {
			throw new RuntimeException(
					"The Order date did not match the Current date");
		}
	}

}