package com.crm.qa.testdata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.Xls_Reader;

public class TestDataExcel {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Hp\\eclipse-workspace\\FreeCRMAutomation\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx");
		String firstName = reader.getCellData("Sheet1", "FirstName", 2);
		System.out.println(firstName);
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\amit\\Selenium\\chromedriver_win32\\chromedriver.exe"); WebDriver driver
		 * = new ChromeDriver(); driver.get("https://classic.crmpro.com/register/");
		 */
		

	}

}
