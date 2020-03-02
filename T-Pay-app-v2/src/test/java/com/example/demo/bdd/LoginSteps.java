package com.example.demo.bdd;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.example.demo.page.HomePage;
import com.example.demo.page.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	@Given("^I am on the login page$")
	public void user_is_on_Home_Page() {
		System.setProperty("webdriver.chrome.driver", "/Users/nag/Downloads/chromedriver");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http:localhost:8080");
	}
	
	@When("^I fill username ([^\"]*)$")
	public void fill_userName(String userName) {
		loginPage.setUserName(userName);
	}

	@And("^I fill password ([^\"]*)$")
	public void fill_password(String password) {
		loginPage.setPassword(password);
	}

	@And("^I p[a-z]* login$")
	public void doLogin() {
		loginPage.doLogin();
	}

	@Then("^I should be on the home page and see welcome ([^\"]*)$")
	public void verify_welcome_with_name(String userName) {
		String actual = homePage.getUserName();
		assertEquals(actual, userName);
		driver.close();
	}
	

}
