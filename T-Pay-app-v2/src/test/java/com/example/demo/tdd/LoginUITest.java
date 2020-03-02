package com.example.demo.tdd;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.example.demo.data.ReadExcel;
import com.example.demo.page.HomePage;
import com.example.demo.page.LoginPage;

public class LoginUITest {

	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	@DataProvider(name = "users")
	public Object[][] getUsers() {
		// return new Object[][] { { "user1", "user1pass" }, { "user2", "user2pass" } };
		return ReadExcel.getExcelData("src/test/resources/users.xlsx", "Sheet1");

	}

	@Parameters(value = { "browser" })
	@BeforeTest
	public void launchChromeBrowser(String browser) {
		System.out.println(browser);
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/nag/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/nag/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		if (browser.equals("headless")) {
			
			// 1. phantomjs
			//System.setProperty("phantomjs.binary.path", "/Users/nag/Downloads/phantomjs-2.1.1-macosx/bin/phantomjs");
			//driver = new PhantomJSDriver();
			
			// 2. HTMLUnitDriver
			driver=new HtmlUnitDriver();
		}
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.get("http://localhost:8080");
	}

	@Test(dataProvider = "users")
	public void login(String userName, String password) {
		loginPage.setUserName(userName);
		loginPage.setPassword(password);
		loginPage.doLogin();
		String actual = homePage.getUserName();
		AssertJUnit.assertEquals(actual, userName);
		homePage.logout();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
