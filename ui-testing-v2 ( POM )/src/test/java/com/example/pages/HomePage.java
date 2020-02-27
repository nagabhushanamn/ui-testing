package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(className = "badge")
	WebElement badgeElement;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoggedUser() {
		return badgeElement.getText();
	}

	public String getTitle() {
		return driver.getTitle();
	}

}
