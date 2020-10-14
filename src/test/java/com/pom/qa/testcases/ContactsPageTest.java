package com.pom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pom.qa.base.TestBase;
import com.pom.qa.pages.ContactsPage;
import com.pom.qa.pages.HomePage;
import com.pom.qa.pages.LoginPage;
import com.pom.qa.utils.TestUtils;

public class ContactsPageTest extends TestBase {
LoginPage loginPage;
HomePage homePage;
TestUtils testUtils;
ContactsPage contactsPage;
String sheetName ="contacts";
public ContactsPageTest() {
	super();
}

@BeforeMethod
public void setUp() {
	initialization();
	testUtils = new TestUtils();
	contactsPage = new ContactsPage();
	loginPage = new LoginPage();
	homePage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	testUtils.switchToFrame();
	contactsPage = homePage.clickOnContactsLink();
	
}

@Test (priority = 1)

public void verifyContactspageLabel() {
	Assert.assertTrue(contactsPage.verifyContactsLabel(),"contact Label is not present");
	}
@Test (priority =2)
public void selectContactsTest() {
	contactsPage.selectContacts("maya patil");
}

@Test (priority =3)
public void selectMultipleContactsTest() {
	contactsPage.selectContacts("maya patil");
	contactsPage.selectContacts("shweta patel");
}

@DataProvider
public Object[][] getCRMTestData() {
	Object data[][] = TestUtils.getTestdata(sheetName);
	return data;
}


@Test (priority =4 ,dataProvider= "getCRMTestData")
public void validateCreateNewContact(String title, String firstname, String lastname, String company) {
	homePage.clickOnNewContect();
	//contactsPage.createNewContact("Mr.", "Tom", "cena", "Google");
	
	contactsPage.createNewContact(title, firstname, lastname, company);
}

@Test (priority =5)
public void validateAddedName() {
	Assert.assertTrue(contactsPage.verifyAddedContact(),"Name is not Added");
}








@AfterMethod

public void tearDown() {
	driver.quit();
}





}







