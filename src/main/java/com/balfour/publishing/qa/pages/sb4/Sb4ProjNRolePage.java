package com.balfour.publishing.qa.pages.sb4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.balfour.publishing.qa.UserRegPOJO;
import com.balfour.publishing.qa.pages.Page;

/**
 * Studio Balfour Home Page
 * 
 * @author cmanning
 * 
 */
public class Sb4ProjNRolePage extends Page {

	/**
	 * locators
	 */
	private By title = By.xpath("//*[.='User Projects and Roles']");
	private By addProj = By.xpath("//*[.='Add a Project']");
	private By addProjInput = By.xpath("//*[@placeholder='add project']");
	private By addProjSubmit = By.xpath("//input[@value='Add']");
	private By projList = By.xpath("//div[@id='postbox-container-1']");
	private By usrProjList = By.xpath("//table[@id='project_list_container']");

	UserMenu um = new UserMenu(_driver);

	/**
	 * constructor that uses shared isloaded service to check for two unique
	 * elements as well as check url service to assert correct url
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public Sb4ProjNRolePage(WebDriver driver) throws InterruptedException {
		super(driver);
		isLoaded(title, addProj);
		logger.info("Sb4ProjNRolePage Page is loaded");
	}

	/**
	 * elements
	 */

	/**
	 * present when user logged in w/access to all projects. used to search for
	 * projects to add to user
	 * 
	 * @param value
	 *            : project to add.
	 * @return
	 */
	private Sb4ProjNRolePage projectSearch(String value) {
		waitForElementVisable(addProjInput, 15);
		_driver.findElement(addProjInput).sendKeys(value + Keys.ENTER);
		return this;
	}

	/**
	 * add button used in conjunction with the projectSearch element
	 * 
	 * @return
	 */
	private Sb4ProjNRolePage clickAdd() {
		_driver.findElement(addProjSubmit).click();
		return this;
	}

	/**
	 * used to check whether a project was in fact added to a user
	 * 
	 * @param value
	 *            : of project to look for
	 * @return
	 */
	private int projChk(String value) {
		_driver.navigate().refresh();
		waitForElementPresence(usrProjList, 10);
		By proj = By.xpath(".//*[contains(text(), '" + value + "')]");
		WebElement uPList = _driver.findElement(usrProjList);
		return uPList.findElements(proj).size();
	}

	/**
	 * services
	 */

	/**
	 * searches for then adds project to user. then a check is performed to
	 * assert project was successfully added
	 * 
	 * @param value
	 *            : of project to be added / searched for
	 * @return
	 */
	public Sb4ProjNRolePage addProject(String value) {

		projectSearch(value).clickAdd();
		if (projChk(value) < 1) {
			throw new RuntimeException("project Was Not Found");
		}
		return this;
	}

	/**
	 * to be used when a user w/o access to all projects is on the project and
	 * roles page. in cases such as these users have access to a specific list
	 * of projects.
	 * 
	 * @param value
	 *            : of project to add / search for
	 * @return
	 */
	public Sb4ProjNRolePage addProjectList(String value) {

		By proj = By.xpath(".//*[contains(text(), '" + value + "')]");
		WebElement pList = _driver.findElement(projList);
		pList.findElement(proj).click();
		if (projChk(value) < 1) {
			throw new RuntimeException("User Was Not Found");
		}
		return this;
	}

	/**
	 * used to either make a project default or delete project from user
	 * 
	 * @param value
	 *            : of href for the given action. each action has unique href
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjNRolePage projAction(String value) throws InterruptedException {
		_driver.navigate().refresh();
		By action = By.xpath("//*[@href='" + value + "']");
		waitForElementVisable(action);
		WebElement li = _driver.findElement(action);
		JavascriptExecutor jse = (JavascriptExecutor) _driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", li);
		waitForElementClickable(action, 10);
		jse.executeScript("arguments[0].click();", li);
		return this;
	}

	/**
	 * used to assign project role when accessing the project role page from
	 * User Admin
	 * 
	 * @param href
	 *            : of project select menu to check
	 * @param role
	 *            : desired role
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjNRolePage projRole(String href, String role) throws InterruptedException {
		_driver.navigate().refresh();
		By action = By.xpath("//select[@data-project-uuid='" + href + "']");
		waitForElementVisable(action);
		Select dropdown = new Select(_driver.findElement(action));
		dropdown.selectByVisibleText(role);
		return this;
	}

	/**
	 * used to assert a project role selected
	 * 
	 * @param href
	 *            : of project select menu to check
	 * @return
	 * @throws InterruptedException
	 */
	private String projRoleSelected(String href) throws InterruptedException {
		_driver.navigate().refresh();
		By action = By.xpath("//select[@data-project-uuid='" + href + "']");
		waitForElementVisable(action);
		return new Select(_driver.findElement(action)).getFirstSelectedOption().getText();
	}

	/**
	 * tests whether the expected role is selected
	 * 
	 * @param href
	 *            : of project select menu to check
	 * @param obj
	 *            : UserRegPOJO
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjNRolePage projRoleCheck(String href, UserRegPOJO obj) throws InterruptedException {
		String selectedRole = projRoleSelected(href);
		System.out.println("selected role = " + selectedRole);
		System.out.println("ur1 role = " + obj.getRole());
		if (!selectedRole.equals(obj.getRole())) {
			throw new RuntimeException("User Info did not match");
		}
		return this;
	}

	/**
	 * shared log out service
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4LoginPage LogOut() throws InterruptedException {
		_driver.navigate().refresh();
		um.LogOut();
		return new Sb4LoginPage(_driver);
	}

	/**
	 * shared service takes user to profile page
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProfilePage GoToMyProfile() throws InterruptedException {
		um.MyProfile();
		return new Sb4ProfilePage(_driver);
	}

	/**
	 * shared change project service for users w/ >8 projects
	 * 
	 * @param mainProj
	 *            : initial project present in the menu
	 * @param nextProj
	 *            : desired project to switch to
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjNRolePage ChangeProject(String mainProj, String nextProj) throws InterruptedException {
		um.projectMenu(mainProj, nextProj);
		return this;
	}

	/**
	 * shared change project service for users w/ <8 projects
	 * 
	 * @param mainProj
	 *            : initial project present in the menu
	 * @param nextProj
	 *            : desired project to switch to
	 * @return
	 * @throws InterruptedException
	 */
	public Sb4ProjNRolePage ChangeProject2(String mainProj, String nextProj) throws InterruptedException {
		um.projectMenuSearch(mainProj, nextProj);
		return this;
	}

	/**
	 * shared Check Project service
	 * 
	 * @param project
	 * @return
	 */
	public Sb4ProjNRolePage CheckProject(String project) {
		um.projectCheck(project);
		return this;
	}

	/**
	 * uses SB site search feature
	 * 
	 * @param value
	 *            : of site to search for
	 * @return : Sb4SearchResultsPage
	 * @throws InterruptedException
	 */
	public Sb4SearchResultsPage SiteSearch(String value) throws InterruptedException {
		um.SiteSearch(value);
		return new Sb4SearchResultsPage(_driver);
	}

	public void userFBack(String Value) {

		new MenuBar(_driver).userFBack(Value);
	}
}