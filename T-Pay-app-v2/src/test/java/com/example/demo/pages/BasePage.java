package com.example.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

	@FindBy(linkText = "Pay")
	private WebElement payLink;
	@FindBy(linkText = "Account")
	private WebElement accountLink;
	@FindBy(linkText = "logout")
	private WebElement logoutLink;

	public void goToPayPage() {
		payLink.click();
	}

	public void goToAccountPage() {
		accountLink.click();
	}

	public void logout() {
		logoutLink.click();
	}

}
