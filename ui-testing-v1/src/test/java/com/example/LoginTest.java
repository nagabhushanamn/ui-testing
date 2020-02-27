package com.example;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;

	@BeforeSuite
	public void registerWebDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/nag/Downloads/chromedriver");
	}

	@BeforeMethod
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/");
		driver.manage().window().maximize();
	}

	
	@Test(priority = 0)
	public void loginSuccess() {

		// step-1 : locate WebElements
		WebElement usernameElement = driver.findElement(By.name("username"));
		WebElement passwordElement = driver.findElement(By.name("password"));
		WebElement btnElement = driver.findElement(By.tagName("button"));
		// step-2 : feed input values
		usernameElement.sendKeys("blt");
		passwordElement.sendKeys("password");
		// step-3 : trigger events
		btnElement.submit();
		// step-4 : verify
		WebElement badgeElement = driver.findElement(By.className("badge"));
		String actual = badgeElement.getText();
		String expected = "USER";
		assertEquals(actual, expected);

	}

	@Test(priority = 1)
	public void loginFailure() {

		// step-1 : locate WebElements
		WebElement usernameElement = driver.findElement(By.name("username"));
		WebElement passwordElement = driver.findElement(By.name("password"));
		WebElement btnElement = driver.findElement(By.tagName("button"));
		// step-2 : feed input values
		usernameElement.sendKeys("blt");
		passwordElement.sendKeys("blabla");
		// step-3 : trigger events
		btnElement.submit();
		// step-4 : verify
		String actual = driver.getTitle();
		String expected = "index";
		assertEquals(actual, expected);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
