package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.pom.qa.base.TestBase;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;		//import LoginPage
	HomePage homePage;

	 public LoginPageTest() {  //make constructor of LoginPageTest
		super();			// to initialize parent method so we don't get null point exception error.
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test (priority =1)
	
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test (priority =2)
	
	public void crmLogoTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test (priority =3)
	
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	
}
