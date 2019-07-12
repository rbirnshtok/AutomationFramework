package com.rachel.yahoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YahooLoginPage extends BasePage{
	
	WebDriver driver;
	
	String sUsername;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Profile image']")
	WebElement imgProfile;
	
	@FindBy(how=How.XPATH,using="//span[text()='Sign out']")
	WebElement btnSignOut;
	
	@FindBy(how=How.XPATH,using="//a[@class='sign-out']")
	WebElement lnkSignOut;
	
	@FindBy(how=How.XPATH,using="//a[@class='sign-out']")
	WebElement lnkSignOutAllAccounts;
	
	By byLnkUsername = By.xpath("//a[@class='username']/strong[text()='"+sUsername+"']/..");

	@FindBy(how=How.ID,using="login-username")
	WebElement txtUsername;
	
	@FindBy(how=How.ID,using="login-signin")
	WebElement btnNext;
	
	@FindBy(how=How.ID,using="login-passwd")
	WebElement txtPassword;
	
	@FindBy(how=How.ID,using="login-signin")
	WebElement btnSubmit;
	
	public YahooLoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public void login(String sUsername, String sPassword, String sUrl){
		driver.navigate().to(sUrl);
		/*test = extent.createTest("Test Case 1", "PASSED test case");
        Assert.assertTrue(true);
		WebElement lnkUsername = this.wDriver.findElement(byLnkUsername);
		
		if(btnSignOut.isEnabled()){
			btnSignOut.click();
		}
		
		if(lnkSignOut.isEnabled()){
			lnkSignOut.click();
		}
		
		if(lnkSignOutAllAccounts.isEnabled()){
			lnkSignOutAllAccounts.click();
		}
		
		if(lnkUsername.isEnabled()){
			lnkUsername.click();
		}*/
		
		txtUsername.sendKeys(sUsername);
		btnNext.click();
		txtPassword.sendKeys(sPassword);
		btnSubmit.click();
	}
	
	public void logout(){
		
	}
}
