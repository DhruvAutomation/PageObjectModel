package com.pom.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Dhruv Patel')]")
	@CacheLookup
	WebElement userNameLable;

	@FindBy (xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy (xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy (xpath = "//a[contains(text(),'New Deal')]")
	WebElement newDeal;

	@FindBy (xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	

	// Initializing the Page Objects:

	public HomePage() {
		PageFactory.initElements(driver, this);
	}


	//Actions

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		
		contactsLink.click();
		return new ContactsPage();
	}
	
		
	
	public  DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();

	}
	public  TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnNewContect() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
	public void clickOnNewDeal() {
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newDeal.click();
	}
}
