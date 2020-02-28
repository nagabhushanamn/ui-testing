package com.example.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

	@FindBy(xpath = "/html/body/div/pre/span[1]")
	private WebElement accNumberElement;
	@FindBy(xpath = "/html/body/div/pre/span[2]")
	private WebElement accBalanceElement;

	public String getAccNumber() {
		return accNumberElement.getText();
	}

	public String getAccBalance() {
		return accBalanceElement.getText();
	}

}
