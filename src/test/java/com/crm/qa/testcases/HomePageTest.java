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

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
		public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		ContactsPage contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("HomePageTitle"),"Home page title not matched");
	}
	
	@Test(priority=2)
	public void homePageUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=3)
	public void homePageContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void exit(){
		driver.quit();
	}
	

}
