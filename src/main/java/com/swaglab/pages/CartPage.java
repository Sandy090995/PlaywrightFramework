package com.swaglab.pages;

import com.microsoft.playwright.Page;

public class CartPage {

	private Page page;

	// 1. page constructor
	public CartPage(Page page) {
		this.page = page;
	}

	// Object repo in the form of string div[class='app_logo']
	// 2. String Locator

	private String title_CartPage = "div:text('Your Cart')";
	private String inventory_ItemsName = "div[class='inventory_item_name']"; // list
	private String inventory_ItemPrice = "div[class='inventory_item_price']"; // list
	private String button_Cart_Icon = "a[class='shopping_cart_link fa-layers fa-fw']";
	private String button_RemoveItem = "button:has-text('REMOVE')"; // list

	public String getCartpageTitle() {
		return title_CartPage;
	}
}
