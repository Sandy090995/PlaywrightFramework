package com.swaglab.pages;

import com.microsoft.playwright.Page;

public class ProductPage {

	private Page page;

	// 1. page constructor
	public ProductPage(Page page) {
		this.page = page;
	}

	// Object repo in the form of string div[class='app_logo']
	// 2. String Locator

	private String button_AddToCart = "button:has-text('ADD TO CART')"; // list
	private String inventory_ItemsName = "div[class='inventory_item_name']"; // list
	private String inventory_ItemPrice = "div[class='inventory_item_price']"; // list
	private String button_Cart_Icon = "a[class='shopping_cart_link fa-layers fa-fw']";
	private String button_RemoveItem = "button:has-text('REMOVE')"; // list

	// 3. page actions/methods
	public String getProductPageTitle() {
		return page.title();
	}

	public boolean addItemsToCartAndNavigate() {
		page.click(button_AddToCart); // add 1st item
		page.click(button_AddToCart); // add second item
		page.click(button_Cart_Icon);
		CartPage cp = new CartPage(page);
		if (page.isVisible(cp.getCartpageTitle())) {
			return true;
		} else {
			return false;
		}
	}

	public CartPage navigateToCartPage() {
		page.click(button_Cart_Icon);
		return new CartPage(page);
	}

}
