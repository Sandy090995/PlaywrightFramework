package com.swaglab.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.microsoft.playwright.Page;
import com.swaglab.factory.PlaywrightFactory;
import com.swaglab.pages.LoginPage;

public class LoginPageTest {

	PlaywrightFactory pf;
	Page page;
	LoginPage loginpage;

	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		page = pf.initBrowser("chromium");
		loginpage = new LoginPage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"}
		};
	}

	@Test
	public void loginPageTitleTest() {
		String loginpageTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(loginpageTitle, "Swag Labs");
	}

	
	@Test(dataProvider = "getLoginData")
	public void loginToApplication(String username,String password) {
     String actualTitle= loginpage.loginToApplication(username,password);
     Assert.assertEquals(actualTitle, "https://www.saucedemo.com/v1/inventory.html");
     page.goBack();
	}
}
