package com.example;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("SimpleTest :: @BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("SimpleTest :: @BeforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("SimpleTest :: @BeforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("SimpleTest :: @BeforeMethod");
	}

	// ----------------------------------------------------
	@Test
	public void beTrue() {
		System.out.println("SimpleTest :: @Test - beTrue");
		assertTrue(true);
	}

	@Test
	public void beFalse() {
		System.out.println("SimpleTest :: @Test - beFalse");
		assertFalse(false);
	}
	// ----------------------------------------------------

	@AfterMethod
	public void afterMethod() {
		System.out.println("SimpleTest :: @AfterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("SimpleTest :: @AfterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("SimpleTest :: @AfterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("SimpleTest :: @AfterSuite");
	}

}
