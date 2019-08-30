package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory: Object Repository
	@FindBy(xpath="//td[contains(text(),'User: Amit Chaudhary')]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	//Initializing the Page Factory: Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	
}
