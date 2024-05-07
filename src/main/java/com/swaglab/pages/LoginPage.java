package com.swaglab.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// Object repo in the form of string div[class='app_logo']
	// 1. String Locator
	private String username_Field = "#user-name";
	private String password_Field = "#password";
	private String signIn_Button = "#login-button";

	// 2. page constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods
	public String getLoginPageTitle() {
		String title= page.title();
		System.out.println("Login page title is :- "+title);
		return title;
	}

	public String getLoginPageURL() {
		String loginURL = page.url();
		System.out.println("Login url is :- "+loginURL);
		return loginURL;
	}

	public String loginToApplication(String username,String password) {
		page.fill(username_Field, username);
		page.fill(password_Field, password);
		page.click(signIn_Button);
		System.out.println("New url is "+ page.url());
		return page.url();
	}
}
