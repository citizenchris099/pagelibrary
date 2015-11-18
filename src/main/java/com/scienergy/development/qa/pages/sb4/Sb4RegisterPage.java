package com.scienergy.development.qa.pages.sb4;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.scienergy.development.Test_Enviornment;
import com.scienergy.development.qa.ProjConfigPOJO;
import com.scienergy.development.qa.UserRegPOJO;
import com.scienergy.development.qa.pages.Page;

/**
 * class used to access the Studio Balfour Shop / Supply Desk features
 * 
 * @author cmanning
 * 
 */
public class Sb4RegisterPage extends Page {

	/**
	 * locators
	 */
	private By registerTitle = By.xpath("//*[.='Register']");
	private By email = By.xpath("//input[@name='requestEmail']");
	private By fName = By.xpath("//input[@name='requestFirstName']");
	private By lName = By.xpath("//input[@name='requestLastName']");
	private By pNum = By.xpath("//input[@name='project_number']");
	private By pPword = By.xpath("//input[@name='project_password']");
	private By submit = By.xpath("//button[@id='_submitButton']");
	private String keyUrl = new Test_Enviornment().envUrl(slugNAction
			.getnReg_dynamic());

	/**
	 * standard constructor used to verify correct page is loaded
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4RegisterPage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(registerTitle, email);
	}

	/**
	 * elements
	 */

	private Sb4RegisterPage setEmail(String value) {

		_driver.findElement(email).sendKeys(value);
		return this;
	}

	private Sb4RegisterPage setFName(String value) {

		_driver.findElement(fName).sendKeys(value);
		return this;
	}

	private Sb4RegisterPage setLName(String value) {

		_driver.findElement(lName).sendKeys(value);
		return this;
	}

	private Sb4RegisterPage setPNum(String value) {

		_driver.findElement(pNum).sendKeys(value);
		return this;
	}

	private Sb4RegisterPage setPPword(String value) {

		_driver.findElement(pPword).sendKeys(value);
		return this;
	}

	private Sb4RegisterPage clickSubmit() {

		_driver.findElement(submit).click();
		return this;
	}

	private Sb4RegisterPage MsgChk(String successmsg) {

		By msg = By.xpath("//*[contains(text(), '" + successmsg + "')]");
		waitForElementVisable(msg, 10);
		return this;
	}

	private String GetKey(UserRegPOJO obj) throws InterruptedException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		String aVariable = new DbUtil().B4PubData(obj.getEmail(),
				obj.getStatement(), obj.getDb_url(), obj.getDb_username(),
				obj.getDb_pword(), obj.getDb_reg_key());
		String link = String.format(keyUrl, aVariable);
		logger.info(link);

		return link;
	}

	/**
	 * services
	 */

	/**
	 * used to fill out the form on the register page
	 * 
	 * @param obj
	 *            : of UserRegPOJO
	 * @param obj2
	 *            : of ProjConfigPOJO
	 * @throws SQLException
	 * @throws InterruptedException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public String registerUser(UserRegPOJO obj, ProjConfigPOJO obj2)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, InterruptedException, SQLException {

		setEmail(obj.getEmail());
		setFName(obj.getfName());
		setLName(obj.getlName());
		MsgChk(obj2.getProjName());
		if (obj2.getrType().equals("Password Only")) {
			setPPword(obj2.getrPWord());
		}
		clickSubmit();
		MsgChk(obj.getoMsg());
		if (obj.getoMsg().equals("Invalid Project Password")) {
			return "Cannot Register";
		} else
			return GetKey(obj);
	}

}
