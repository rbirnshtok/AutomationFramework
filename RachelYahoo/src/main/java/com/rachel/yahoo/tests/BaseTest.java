package com.rachel.yahoo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.rachel.automationframework.DriverManager;
import com.rachel.automationframework.DriverManagerFactory;
import com.rachel.automationframework.DriverManagerFactory.DriverType;

public class BaseTest {
	DriverManager driverManager;
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeSuite
	public void suiteSetup(){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//yahooTestReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
/*        String currentDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", currentDir + "\\Drivers\\chromedriver.exe");
		wDriver = new ChromeDriver();
		wDriver.manage().window().maximize();*/
	}
	
    @BeforeTest
    public void beforeTest(ITestContext context) {
    	String sBrowserType = context.getCurrentXmlTest().getParameter("browser").toUpperCase();
    	DriverType driverTypeEnum = DriverType.valueOf(sBrowserType);
        driverManager = DriverManagerFactory.getManager(driverTypeEnum);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
    
	@AfterSuite
	public void suiteCleanUp(){
		extent.flush();
	}
	
	public void compareStrings(String sDescription, String sExpectedValue, String sActualValue){
		if(sExpectedValue.equals(sActualValue)){
			test.log(Status.PASS, "The " + sDescription + " was equal to '"+sExpectedValue+"' as expected");
		}
		else{
			test.log(Status.FAIL, "Value of " + sDescription + " was not as expected, expected: '"
					+ sExpectedValue + "' , actual was: '" + sActualValue + "'");
		}
	}
}
