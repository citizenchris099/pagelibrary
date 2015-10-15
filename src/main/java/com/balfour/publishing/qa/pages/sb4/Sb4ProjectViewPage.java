package com.balfour.publishing.qa.pages.sb4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.balfour.publishing.qa.ProjectViewPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * the Studio Balfour Project View Page
 * 
 * @author cmanning
 * 
 */
public class Sb4ProjectViewPage extends Page {

	/**
	 * locators
	 */
	private By projectName = By.xpath("//div[@class='title-tile']");
	private By projYear = By.xpath("//div[@id='year']");
	private By projStatus = By.xpath("//div[@id='status']");
	private By projDSeason = By.xpath("//div[@id='season']");
	private By genActInfo = By.xpath("//div[@id='general-account-info']");
	private By regType = By.xpath(".//div[contains(text(),'Registration Type')]");
	private By projEnroll = By.xpath("//div[@id='enrollment']");
	private By projAdv = By.xpath("//div[contains(text(),'Adviser:')]");
	private By projRep = By.xpath("//div[contains(text(),'Sales Rep:')]");
	private By projAE = By.xpath("//div[contains(text(),'Account Exec:')]");
	private By sub2 = By.xpath(".//span[@class='font-xlarge strong']");
	private By sub3 = By.xpath(".//span[@class='font-small']");
	private By projUsers = By.xpath("//*[.='Project Users']");

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ProjectViewPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(projAdv, projEnroll);
		logger.info("Search Results Page loaded");
	}

	/**
	 * elements
	 */
	
	private Sb4ProjectViewPage clickProjUser(){
		_driver.findElement(projUsers).click();
		return this;
	}

	private String getProjName() {
		return _driver.findElement(projectName).getText().trim();
	}

	private String getProjYear() {
		WebElement year = _driver.findElement(projYear);
		return year.findElement(sub2).getText().trim();
	}

	private String getProjStatus() {
		WebElement status = _driver.findElement(projStatus);
		return status.findElement(sub2).getText().trim();
	}

	private String getProjSeason() {
		WebElement season = _driver.findElement(projDSeason);
		return season.findElement(sub2).getText().trim();
	}

	private String getProjEnroll() {
		WebElement enroll = _driver.findElement(projEnroll);
		return enroll.findElement(sub2).getText().trim();
	}

	private String getProjAdv() {
		WebElement adv = _driver.findElement(projAdv);
		return adv.findElement(sub3).getText().trim();
	}

	private String getProjRep() {
		WebElement adv = _driver.findElement(projRep);
		return adv.findElement(sub3).getText().trim();
	}

	private String getProjAE() {
		WebElement adv = _driver.findElement(projAE);
		return adv.findElement(sub3).getText().trim();
	}

	public String getRegType() {

		WebElement status = _driver.findElement(genActInfo);
		String[] array = status.findElement(regType).getText().trim().replaceAll("\n", " ").replaceAll("\r", " ")
				.split(":");
		String[] tokens = array[1].trim().split(" ");
		String line1 = tokens[0].trim();
		return line1;
	}

	public String getInviteUrl() {

		WebElement status = _driver.findElement(genActInfo);
		String[] array = status.findElement(regType).getText().trim().replaceAll("\n", " ").replaceAll("\r", " ")
				.split("=");
		String key = array[1].trim();
		String url = "https://sb3-qa.balfour.com/register?key=";
		return url + key;
	}

	/**
	 * services
	 */

	/**
	 * used to interrogate the text present on the project view page.
	 * 
	 * @return : obj of ProjectViewPOJO
	 */
	public ProjectViewPOJO checkProjView(boolean url) {

		ProjectViewPOJO obj = new ProjectViewPOJO();
		obj.setAdviser(getProjAdv());
		obj.setAe(getProjAE());
		obj.setdSeason(getProjSeason());
		obj.setEnrollment(getProjEnroll());
		obj.setProjName(getProjName());
		obj.setRep(getProjRep());
		obj.setStatus(getProjStatus());
		obj.setYear(getProjYear());
		obj.setrType(getRegType());
		if (url == true) {
			obj.setiLink(getInviteUrl());
		}
		return obj;
	}
	
	public Sb4ProjectUserPage goToProjUsers() throws InterruptedException{
		clickProjUser();
		return new Sb4ProjectUserPage(_driver);
	}

	public Sb4LoginPage LogOut() throws InterruptedException {
		new UserMenu(_driver).LogOut();
		return new Sb4LoginPage(_driver);
	}
}