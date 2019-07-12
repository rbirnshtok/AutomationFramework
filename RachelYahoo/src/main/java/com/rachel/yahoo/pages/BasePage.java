package com.rachel.yahoo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	//public static WebDriver wDriver = null;
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
