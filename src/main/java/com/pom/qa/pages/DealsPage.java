package com.pom.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class DealsPage extends TestBase {

	@FindBy (xpath = "//td[contains(text(),'Deals')]")
	WebElement dealslabel;
	
	@FindBy (id = "title")
	WebElement title;
	
	@FindBy (name = "client_lookup")
	WebElement company;
	
	@FindBy (id = "amount")
	WebElement amount;
	
	@FindBy (xpath = "//input[@type='submit' and @value = 'Save and Create Another']")
	WebElement saveBtn;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsLabel() {
		return dealslabel.isDisplayed();
	}
	
	public void createNewDeal(String prof, String comp, String amot) {
		title.sendKeys(prof);
		company.sendKeys(comp);
		amount.sendKeys(amot);
		saveBtn.click();
	}
	
	
	
	
	
	
}
