package com.example.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	@FindBy(linkText = "Pay")
	private WebElement payLink;
	@FindBy(linkText = "Account")
	private WebElement accountLink;
	@FindBy(linkText = "logout")
	private WebElement logoutLink;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

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
