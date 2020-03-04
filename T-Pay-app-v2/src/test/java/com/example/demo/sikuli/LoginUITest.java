package com.example.demo.sikuli;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class LoginUITest {

	public static void main(String[] args) throws FindFailed {
		WebDriver driver = null;
		try {
			Screen screen = new Screen();
//			Pattern userNameField = new Pattern(
//					"/Users/nag/git/ui-testing/T-Pay-app-v2/src/test/java/com/example/demo/sikuli/screen-images/username.png");
//			Pattern passwordField = new Pattern(
//					"/Users/nag/git/ui-testing/T-Pay-app-v2/src/test/java/com/example/demo/sikuli/screen-images/password.png");
			Pattern loginBtn = new Pattern(
					"/Users/nag/git/ui-testing/T-Pay-app-v2/src/test/java/com/example/demo/sikuli/screen-images/btn.png");

			System.setProperty("webdriver.chrome.driver", "/Users/nag/Downloads/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			driver.get("http://localhost:8080");

			loginBtn.similar(0.4);

			screen.find(loginBtn).click();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.close();
		}

	}

}
