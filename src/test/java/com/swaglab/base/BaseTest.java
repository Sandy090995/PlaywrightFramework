package com.swaglab.base;

import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.microsoft.playwright.Page;
import com.swaglab.factory.PlaywrightFactory;
import com.swaglab.pages.LoginPage;
import com.swaglab.pages.ProductPage;

public class BaseTest {

	PlaywrightFactory pf;
	protected Page page;
	protected Properties prop;
	
	protected LoginPage loginpage;
	protected ProductPage productPage;

	@BeforeTest
	public void setup() {
		pf = new PlaywrightFactory();
		prop = pf.init_prop(); // will call config file
		page = pf.initBrowser(prop);
		loginpage = new LoginPage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
