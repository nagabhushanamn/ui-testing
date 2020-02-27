package com.example;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

	WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void registerWebDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/nag/Downloads/chromedriver");
	}

	@BeforeTest(alwaysRun = true)
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/web/");
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@BeforeMethod(alwaysRun = true)
	public void clearInputFields() {
		driver.findElement(By.id("number1")).clear();
		driver.findElement(By.id("number2")).clear();
	}

//	@Test(priority = 0,groups = {"nag","kishore"})
//	public void add1And2() {
//		
//		System.out.println(Thread.currentThread().getName() +" -> add1And2");
//
//		WebElement number1Element = driver.findElement(By.id("number1"));
//		WebElement number2Element = driver.findElement(By.id("number2"));
//		WebElement goElement = driver.findElement(By.id("go"));
//		WebElement outputElement = driver.findElement(By.id("output"));
//
//		number1Element.sendKeys("1");
//		number2Element.sendKeys("2");
//		goElement.click();
//		String actual = outputElement.getText();
//		String expected = "3";
//
//		assertEquals(actual, expected);
//
//	}
//
//	@Test(priority = 1,groups = {"nag"})
//	public void add10And20() {
//		
//		System.out.println(Thread.currentThread().getName() +" -> add10And20");
//
//		WebElement number1Element = driver.findElement(By.id("number1"));
//		WebElement number2Element = driver.findElement(By.id("number2"));
//		WebElement goElement = driver.findElement(By.id("go"));
//		WebElement outputElement = driver.findElement(By.id("output"));
//
//		number1Element.sendKeys("10");
//		number2Element.sendKeys("20");
//		goElement.click();
//
//		String actual = outputElement.getText();
//		String expected = "30";
//
//		assertEquals(actual, expected);
//
//	}
//	
//	@Test(groups = {"kishore"})
//	public void add100And200() {
//
//		System.out.println(Thread.currentThread().getName() +" -> add100And200");
//		
//		WebElement number1Element = driver.findElement(By.id("number1"));
//		WebElement number2Element = driver.findElement(By.id("number2"));
//		WebElement goElement = driver.findElement(By.id("go"));
//		WebElement outputElement = driver.findElement(By.id("output"));
//
//		number1Element.sendKeys("100");
//		number2Element.sendKeys("200");
//		goElement.click();
//
//		String actual = outputElement.getText();
//		String expected = "300";
//
//		assertEquals(actual, expected);
//
//	}
//	
	
	@DataProvider(name = "number_factory")
	public Object[][] getNumbers() {
		return new Object[][] {
			{1,2,3},
			{10,20,30},
			{100,200,300},
		};
	}
	

	@Test(dataProvider = "number_factory")
	public void add(int n1, int n2, int expected) {

		System.out.println(Thread.currentThread().getName() + " -> add100And200");

		WebElement number1Element = driver.findElement(By.id("number1"));
		WebElement number2Element = driver.findElement(By.id("number2"));
		WebElement goElement = driver.findElement(By.id("go"));
		WebElement outputElement = driver.findElement(By.id("output"));

		number1Element.sendKeys(String.valueOf(n1));
		number2Element.sendKeys(String.valueOf(n2));
		goElement.click();

		String actual = outputElement.getText();

		assertEquals(actual, String.valueOf(expected));

	}

	@AfterTest(alwaysRun = true)
	public void terminateBrowser() {
		driver.close();
	}

}
