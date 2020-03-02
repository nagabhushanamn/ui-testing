package com.example.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayPage extends BasePage {

	@FindBy(xpath = "/html/body/text()")
	private WebElement currentBalance;
	@FindBy(name = "fromAccNum")
	private WebElement fromAccNumberField;
	@FindBy(name = "toAccNum")
	private WebElement toAccNumberField;
	@FindBy(name = "amount")
	private WebElement amountField;
	@FindBy(tagName = "button")
	private WebElement txrBtn;

	public PayPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void fileTxrForm(double amount, String fromAccNum, String toAccNum) {
		amountField.sendKeys(String.valueOf(amount));
		fromAccNumberField.sendKeys(fromAccNum);
		toAccNumberField.sendKeys(toAccNum);
	}

	public void doTxr() {
		txrBtn.submit();
	}

}
