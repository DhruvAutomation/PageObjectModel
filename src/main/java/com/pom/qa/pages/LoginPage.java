package com.pom.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR (Object Reposatory)
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy (name = "password")
	WebElement password;
	
	@FindBy (xpath = "//input[@class='btn btn-small']")
	WebElement loginbtn;
	
	@FindBy (xpath = "//a[@class='navbar-brand']")
	WebElement crmLogo;
	
	//Initializing the page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.sendKeys(Keys.ENTER);;
		//loginbtn.click();
		return new HomePage();   //make object for homepage as this the landing page of login page.
	}
}
