package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	
	@Test(priority=2)
	public void verifyContactsHeaderTest() {
		Assert.assertTrue(contactsPage.verifyContactsHeader());
	}
	
	@Test(priority=1)
	public void verifyContactsNameSelectByNameTest() {
		contactsPage.selectContactsByName("new contract");
	}
	
	@AfterMethod
	public void exit(){
		driver.quit();
	}
	
}
