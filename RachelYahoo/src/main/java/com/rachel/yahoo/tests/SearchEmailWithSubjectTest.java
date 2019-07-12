package com.rachel.yahoo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SearchEmailWithSubjectTest extends BaseTest{
	@Test
	public void loginToYahooAndSearchEmails(){
		String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir + "\\Drivers\\chromedriver.exe");
		String sUSerName = "Rachel Birnshtok";
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.navigate().to("https://mail.yahoo.com");
		wd.get("https://mail.yahoo.com");
		compareStrings("Dummy value:", "Dummy1", "Dummy2");
		
	}
}
