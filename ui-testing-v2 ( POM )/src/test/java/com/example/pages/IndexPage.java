package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page-class
public class IndexPage {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement usernameElement;
	@FindBy(name = "password")
	WebElement passwordElement;
	@FindBy(xpath = "//input")
	WebElement btnElement;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String userName) {
		usernameElement.sendKeys(userName);
	}

	public void setPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void submitLoginForm() {
		btnElement.submit();
	}

}
