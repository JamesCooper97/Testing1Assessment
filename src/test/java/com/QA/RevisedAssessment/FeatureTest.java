package com.QA.RevisedAssessment;

import java.util.List;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.QA.RevisedAssessment.AdminLoginPage;
import com.QA.RevisedAssessment.Constants;
import com.QA.RevisedAssessment.CreateUserPage;
import com.QA.RevisedAssessment.ProfilePage;
import com.QA.RevisedAssessment.ReportUtils;
import com.QA.RevisedAssessment.UsersPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FeatureTest {
	WebDriver driver = null;
	Actions action = null;
	
	CreateUserPage createUserPage = null;
	AdminLoginPage adminLoginPage = null;
	UsersPage usersPage = null;
	ProfilePage profilePage = null;
	ProfileConfigurePage profileConfigurePage = null;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		ReportUtils.createReport();
		
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {

		ReportUtils.createTest("Create Users");
		
		driver.get(Constants.ADMINLOGIN);
		
		ReportUtils.logTest("Navigated to admin login page");
//		ReportUtils.logScreenShot(driver);
		
		adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.inputUser("Admin");
		adminLoginPage.inputPassword("3588d401d51f4a01bd633e0d4e5f70b1");
		adminLoginPage.tickBox();
		adminLoginPage.submitForm();
		
//		ReportUtils.logTest("Admin Logged In");
		
		driver.get(Constants.ADDUSER);
		createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
//		ReportUtils.logTest("Directed to Users Page");
//		ReportUtils.logScreenShot(driver);
		
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {

		createUserPage.addUsername("WakaWaka");
	    createUserPage.addPassword("TIFFANY29");
	    createUserPage.addConfirmPassword("TIFFANY29");
	    createUserPage.addFullName("Tiffany Jenkins");
		
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {

		createUserPage.clickCreateUser();
	    
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		driver.get(Constants.USERS);
		boolean a = false;
		
		if (driver.findElement(By.linkText("WakaWaka")) != null) {
			a = true;
		}
		assertTrue("No user found", a);
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		createUserPage.addUsername(arg1);
	    createUserPage.addPassword(arg2);
	    createUserPage.addConfirmPassword(arg3);
	    createUserPage.addFullName(arg4);
	    createUserPage.clickCreateUser();
	    
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		driver.get(Constants.USERS);
		boolean a = false;
		if (driver.findElement(By.linkText(arg1)) != null) {
			a = true;
		}
		assertTrue("No user found", a);
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		driver.get(Constants.ADMINLOGIN);
		adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.inputUser("Admin");
		adminLoginPage.inputPassword("3588d401d51f4a01bd633e0d4e5f70b1");
		adminLoginPage.tickBox();
		adminLoginPage.submitForm();
		
		driver.get(Constants.USERS);
		usersPage = PageFactory.initElements(driver, UsersPage.class);
		
		boolean a = false;
		if (driver.findElement(By.linkText(arg1)) != null) {
			a = true;
		}
		
		assertTrue(a);
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		WebElement user = driver.findElement(By.linkText(arg1));
		usersPage.clickUser(user);
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		
		profilePage = PageFactory.initElements(driver, ProfilePage.class);
		String user = profilePage.getId(driver);
		
		assertEquals("Wrong User selected or no user exists",arg1,user);
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		driver.get(Constants.ADMINLOGIN);
		adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginPage.inputUser("Admin");
		adminLoginPage.inputPassword("3588d401d51f4a01bd633e0d4e5f70b1");
		adminLoginPage.tickBox();
		adminLoginPage.submitForm();
		
		driver.get(Constants.USERS);
		usersPage = PageFactory.initElements(driver, UsersPage.class);
		
		WebElement user = driver.findElement(By.linkText(arg1));
		usersPage.clickUser(user);
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {

	    profilePage = PageFactory.initElements(driver, ProfilePage.class);
	    profilePage.clickConfigure();

	}

	@When("^I change the old username on the Configure Page to a new username \"([^\"]*)\"$")
	public void i_change_the_old_username_on_the_Configure_Page_to_a_new_username(String arg1) throws Throwable {
		profileConfigurePage = PageFactory.initElements(driver, ProfileConfigurePage.class);
		profileConfigurePage.changeName(arg1);
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		profileConfigurePage.submitForm();
	}

	@Then("^the Configure Page should show the new username \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_username(String arg1) throws Throwable {
	    profilePage = PageFactory.initElements(driver, ProfilePage.class);
	    String name = profilePage.getName(driver);
	    System.out.println(name);
	    assertEquals(name,arg1);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
		ReportUtils.flushReport();
		
	}
}
