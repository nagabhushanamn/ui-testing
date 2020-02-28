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

import com.example.pages.HomePage;
import com.example.pages.IndexPage;

public class LoginTest {

	private IndexPage indexPage;
	private HomePage homePage;

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

		indexPage = new IndexPage(driver); // page-object
		homePage = new HomePage(driver); // 

	}

	@Test(priority = 0)
	public void loginSuccess() {

		indexPage.setUserName("blt");
		indexPage.setPassword("password");
		indexPage.submitLoginForm();

		String actual = homePage.getLoggedUser();
		assertEquals(actual, "USER");

	}

	@Test(priority = 1)
	public void loginFailure() {
		indexPage.setUserName("blt");
		indexPage.setPassword("bla bla");
		indexPage.submitLoginForm();

		String actual = homePage.getTitle();
		assertEquals(actual, "index");

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
