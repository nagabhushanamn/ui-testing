package com.example.demo.bdd;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "src/test/resources/features", 
		glue = { "com.example.demo.bdd" },
		plugin = { "pretty","json:target/cucumber-reports/Cucumber.json",
				   "junit:target/cucumber-reports/Cucumber.xml" })
public class LoginUITest extends AbstractTestNGCucumberTests {	
}
