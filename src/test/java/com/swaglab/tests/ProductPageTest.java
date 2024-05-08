package com.swaglab.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.swaglab.base.BaseTest;
import com.swaglab.constants.AppConstants;

public class ProductPageTest extends BaseTest {

	@Test(priority = 1)
	public void productPageTitleTest() {
		productPage =loginpage.navigateToProductPage(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		String productPageTitle = productPage.getProductPageTitle();
		Assert.assertEquals(productPageTitle, AppConstants.PRODUCT_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void addTocartTest() {
		//productPage = loginpage.navigateToProductPage("standard_user","secret_sauce");
		Assert.assertTrue(productPage.addItemsToCartAndNavigate());

	}

}
