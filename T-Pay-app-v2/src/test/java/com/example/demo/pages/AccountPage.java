package com.example.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

	@FindBy(xpath = "/html/body/div/pre/span[1]")
	private WebElement accNumberElement;
	@FindBy(xpath = "/html/body/div/pre/span[2]")
	private WebElement accBalanceElement;

	public AccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getAccNumber() {
		return accNumberElement.getText();
	}

	public String getAccBalance() {
		return accBalanceElement.getText();
	}

}
