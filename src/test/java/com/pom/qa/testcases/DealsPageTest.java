package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.DealsPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.utils.TestUtils;

public class DealsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	DealsPage dealsPage;
//	String sheetname = "deals";
	public DealsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		dealsPage = new DealsPage();
		loginPage = new LoginPage();
		homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtils.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@Test (priority =1)
	
	public void verifyDealsPageLabel() {
		Assert.assertTrue(dealsPage.verifyDealsLabel(), "Deals is not present");
	}
	/*@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtils.getTestdata(sheetname);
		return data;
	}
	
	@Test (dataProvider = "getCRMTestData", priority = 2)
	public void validateCreateNewDeal(String title, String company, String amount) {
		homePage.clickOnNewDeal();
		dealsPage.createNewDeal(title, company, amount);
		
	}*/
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
