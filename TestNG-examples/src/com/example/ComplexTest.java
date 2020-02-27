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

public class ComplexTest {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("ComplexTest :: @BeforeSuite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("ComplexTest :: @BeforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("ComplexTest :: @BeforeClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("ComplexTest :: @BeforeMethod");
	}

	// ----------------------------------------------------
	@Test
	public void beTrue() {
		System.out.println("ComplexTest :: @Test - beTrue");
		assertTrue(true);
	}

	@Test
	public void beFalse() {
		System.out.println("ComplexTest :: @Test - beFalse");
		assertFalse(false);
	}
	// ----------------------------------------------------

	@AfterMethod
	public void afterMethod() {
		System.out.println("ComplexTest :: @AfterMethod");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("ComplexTest :: @AfterClass");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("ComplexTest :: @AfterTest");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("ComplexTest :: @AfterSuite");
	}

}
