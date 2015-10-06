package com.balfour.publishing.qa.pages.sb4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.balfour.publishing.qa.OCOPOJO;
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
		logger.info("On Campus Orders View Page is loaded");
	}

	/**
	 * elements
	 */

	private String[] getPayInfo() {
		waitForElementPresence(payInfo, 15);
		String[] tmp = new String[6];
		WebElement info = _driver.findElement(payInfo);
		List<WebElement> allLi = info.findElements(payInfoSub);
		int count = 0;
		for (WebElement eachLi : allLi) {
			tmp[count] = eachLi.getText();
			count++;
		}
		return tmp;
	}

	private String oDate() {
		String[] array = new String[4];
		array = getPayInfo();
		String[] tokens = array[0].split(",");
		String line1 = tokens[0].trim();
		logger.info("OCO date = " + line1.trim());
		return line1.trim();
	}

	/**
	 * used to get the date of additional payments
	 * 
	 * @return
	 */
	private String pDate() {
		String[] array = new String[4];
		array = getPayInfo();
		String[] tokens = array[3].split(",");
		String line1 = tokens[0].trim();
		logger.info("OCO date = " + line1.trim());
		return line1.trim();
	}

	private String curDate() {
		Date today = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("MMM dd");
		String reportDate = df.format(today);
		logger.info("Tadys date = " + reportDate.trim());
		return reportDate.trim();
	}

	/**
	 * used to check that a newly entered OCO date is todays date
	 */
	private void checODate() {
		logger.info("checking OCO date");
		if (!oDate().equals(curDate())) {
			logger.info("OCO date is not todays date");
			throw new RuntimeException("The Order date did not match the Current date");
		}
		logger.info("OCO date is todays date");
	}

	/**
	 * used to check that a newly entered OCO Payment date is todays date
	 */
	public void checPDate() {
		logger.info("checking OCO date");
		if (!pDate().equals(curDate())) {
			logger.info("OCO date is not todays date");
			throw new RuntimeException("The Payment date did not match the Current date");
		}
		logger.info("OCO date is todays date");
	}

	/**
	 * original payment type
	 * 
	 * @return
	 */
	private String pType() {
		String[] array = new String[4];
		array = getPayInfo();
		String pType = array[1].trim();
		return pType.trim();
	}

	/**
	 * additional payment type
	 * 
	 * @return
	 */
	private String aPType() {
		String[] array = new String[4];
		array = getPayInfo();
		String pType = array[4].trim();
		return pType.trim();
	}

	/**
	 * original amount paid
	 * 
	 * @return
	 */
	private String aPaid() {
		String[] array = new String[4];
		array = getPayInfo();
		String[] tokens = array[2].split(":");
		String aPaid = tokens[1].trim();
		return aPaid.trim().replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	/**
	 * additional amount paid
	 * 
	 * @return
	 */
	private String aAPaid() {
		String[] array = new String[4];
		array = getPayInfo();
		String[] tokens = array[5].split(":");
		String aPaid = tokens[1].trim();
		return aPaid.trim().replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	private String oTotal() {
		WebElement oTotal = _driver.findElement(orderTotal);
		String tmp = oTotal.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String total = tokens[1].trim();
		String[] tokens1 = total.split(" ");
		String aTotal = tokens1[1];
		return aTotal.trim().replaceAll("[^a-zA-Z0-9]", "").trim();
	}

	private String tDue() {
		WebElement oTotal = _driver.findElement(orderTotal);
		String tmp = oTotal.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String due = tokens[2].trim();
		return due.trim().replaceAll("[^a-zA-Z0-9]", "").trim();
	}
	
	private String tDueComp() {
		WebElement oTotal = _driver.findElement(orderTotal);
		String tmp = oTotal.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String due = tokens[1].trim();
		return due.trim().replaceAll("[^a-zA-Z]", "").trim();
	}

	private String getOnum() {
		WebElement oNum = _driver.findElement(orderNum);
		String tmp = oNum.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String due = tokens[1].trim();
		logger.info("OCO number = " + due.trim());
		return due.trim();
	}

	private String getPurchaserStudent(By locator, int token) {
		WebElement fname = _driver.findElement(locator);
		String tmp = fname.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(" ");
		String due = tokens[token].trim();
		return due.trim();
	}

	private String getPurchaserFName() {
		return getPurchaserStudent(purchaser, 1).trim();
	}

	private String getPurchaserLName() {
		return getPurchaserStudent(purchaser, 2).trim();
	}

	private String getStudentFName() {
		return getPurchaserStudent(student, 1).trim();
	}

	private String getStudentLName() {
		return getPurchaserStudent(student, 2).trim();
	}

	private String getAdd1() {
		return "1234 " + getPurchaserStudent(purchaser, 4).trim();
	}

	private String getAdd2() {
		return getPurchaserStudent(purchaser, 5) + " " + getPurchaserStudent(purchaser, 6).trim();
	}

	private String getCity() {
		return getPurchaserStudent(purchaser, 7) + " " + getPurchaserStudent(purchaser, 8).replaceAll(",", "").trim();
	}

	private String getState() {
		WebElement fname = _driver.findElement(purchaser);
		String tmp = fname.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(",");
		String due[] = tokens[1].trim().split(" ");
		return due[0].trim();
	}

	private String getZip() {
		WebElement fname = _driver.findElement(purchaser);
		String tmp = fname.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(",");
		String due[] = tokens[1].trim().split(" ");
		return due[1].trim();
	}

	private String getPhone() {
		WebElement fname = _driver.findElement(purchaser);
		String tmp = fname.getText().trim().replaceAll("\n", " ").replaceAll("\r", " ");
		String[] tokens = tmp.split(":");
		String due = tokens[1].trim();
		return due.trim();
	}

	/**
	 * services
	 * 
	 */

	/**
	 * used to interrogate the info of the OCO view page
	 * 
	 * @return OCOPOJO
	 */
	public OCOPOJO getOCOInfo(OCOPOJO obj) {
		logger.info("Checking On Campus Orders View Page info");
		checODate();
		OCOPOJO oco = new OCOPOJO();
		if (obj.getFilloutPurchaser() == true) {
			oco.setPhone(getPhone());
			oco.setZip(getZip());
			oco.setState(getState());
			oco.setCity(getCity());
			oco.setAdd1(getAdd1());
			oco.setAdd2(getAdd2());
			oco.setpFName(getPurchaserFName());
			oco.setpLName(getPurchaserLName());
		}
		oco.setsFName(getStudentFName());
		oco.setsLName(getStudentLName());
		oco.setOrderNumber(getOnum());
		if (!obj.getpType().equals("Comp")) {
			oco.setBalance(tDue());
		} else {
			oco.setBalance(tDueComp());
		}
		oco.setOrderTotal(oTotal());
		oco.setaPaid(aPaid());
		oco.setpType(pType());
		if (obj.getPaymentMade() == true) {
			checPDate();
			oco.setaPType(aPType());
			oco.setaAPaid(aAPaid());
		}

		logger.info("On Campus Orders View Page info retrieved");
		return oco;
	}

	/**
	 * shared service to log user out
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4LoginPage LogOut() throws InterruptedException {
		new UserMenu(_driver).LogOut();
		return new Sb4LoginPage(_driver);
	}
}