package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.ContactsPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.utils.TestUtils;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage  homePage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}
	
	//test cases should be independent from each other that/s why we use open and quit browser all the time for every test 
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test (priority =1)
	
	public void verifyHomepageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO - CRM software for customer relationship management, sales, and support.", "Home page title is not match");  // "Home page title is not match" --> if test fail than this message is printed ow not
																// we can put any message for us.
	}
	@Test (priority =2)
		public void verifyUsernameTest() {
		testUtils.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test
	public void verifyContactsLink() {
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

}
