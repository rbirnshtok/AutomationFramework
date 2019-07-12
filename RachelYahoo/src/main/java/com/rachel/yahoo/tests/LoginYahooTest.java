package com.rachel.yahoo.tests;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.rachel.yahoo.datamodel.Environment;
import com.rachel.yahoo.pages.YahooLoginPage;

public class LoginYahooTest extends BaseTest{
	
	@Test(dataProvider="EnvData")
	public void Login(String sUsername, String sPassword, String sUrl) throws JsonParseException, JsonMappingException, IOException{
		YahooLoginPage loginPage = new YahooLoginPage(this.driver);
		loginPage.login(sUsername, sPassword, sUrl);
	}
	
	@DataProvider(name="EnvData")
	public String[][] getLoginData(ITestContext context) throws JsonParseException, JsonMappingException, IOException{
		String arr[][] = null;
		String sFileName = context.getCurrentXmlTest().getParameter("EnvironmentDataFile");
		String sEnvironment = context.getCurrentXmlTest().getParameter("Environment");
		Environment env = Environment.get(System.getProperty("user.dir") + "\\test-input\\"+sFileName, sEnvironment);
		return new String[][]{{env.users.get("admin").username, env.users.get("admin").password, env.url},
							  {env.users.get("agent").username, env.users.get("agent").password, env.url}};
	}
}
