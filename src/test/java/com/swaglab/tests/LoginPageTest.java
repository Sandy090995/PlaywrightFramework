package com.swaglab.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.swaglab.base.BaseTest;
import com.swaglab.constants.AppConstants;

public class LoginPageTest extends BaseTest{

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String loginpageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(loginpageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actualURL=loginpage.getLoginPageURL();
		Assert.assertEquals(actualURL, prop.getProperty("url"));
	}

	@Test(dataProvider = "getLoginData",priority = 3)
	public void loginToApplication1(String username, String password) {
	    String actualTitle = loginpage.loginToApplication(username, password);
	    Assert.assertEquals(actualTitle, "https://www.saucedemo.com/v1/inventory.html");
	    // Check if the current data is the last data from the data provider
	    if (!username.equals("performance_glitch_user")) {
	    	page.goBack();
	       // return;
	    }
	    // Execute page.goBack() for all other data
	    //page.goBack();
	}
	
	//@Test(dataProvider = "getLoginData")
	public void loginToApplication(String username,String password) {
     String actualTitle= loginpage.loginToApplication(username,password);
     Assert.assertEquals(actualTitle, "https://www.saucedemo.com/v1/inventory.html");
     page.goBack();
	}
}
