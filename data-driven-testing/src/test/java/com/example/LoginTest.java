package com.example;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class LoginTest {

	WebDriver driver;

	@BeforeSuite
	public void registerWebDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/nag/Downloads/chromedriver");
	}

	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://shop.demoqa.com/");

		driver.manage().window().maximize();

		driver.findElement(By.linkText("Dismiss")).click();

	}

	@DataProvider(name = "user_credentails")
	public Object[][] getData() {

		// data-source-1 : in-memory
//		return new Object[][] {
//			{"blt_user1","blt_user1","blt_user1@mail.com"},
//			{"blt_user2","blt_user2","blt_user2@mail.com"}
//		};

		// data-source-2 : .csv
//		return getCSVFile("user_credentials.csv");

		// data-source-3 : .xlsx
		// return getXLSXFile("user_credentials.xlsx");

		// data-source-34 : database ( e.g MySQL )
		return getUserFromDatabase();
	}

	@Test(dataProvider = "user_credentails")
	public void login(String username, String password, String email) {

		driver.findElement(By.linkText("My Account")).click();

		driver.findElement(By.id("username")).sendKeys(username);

		driver.findElement(By.id("password")).sendKeys(password);

		driver.findElement(By.name("login")).click();

		String actual = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]/strong[1]")).getText();

		assertEquals(actual, username);

	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("Log out")).click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	private static Object[][] getCSVFile(String fileName) {

		Object[][] data = null;

		File file = new File(fileName); //
		FileReader fr; // 16-bit / text / character
		BufferedReader br = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			List<String[]> lines = new ArrayList<String[]>();
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty())
					lines.add(line.split(","));
			}

			// convert our list to a String array.
			String[][] array = new String[lines.size()][0];

			data = lines.toArray(array);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return data;

	}

	private Object[][] getXLSXFile(String fileName) {
		Workbook workbook = null;
		Object[][] data = null;
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Sheet sheet1 = workbook.getSheet("Sheet1");
			int totalRows = (sheet1.getLastRowNum() - sheet1.getFirstRowNum()) + 1;
			List<String[]> lines = new ArrayList<String[]>();
			for (int i = 0; i < totalRows; i++) {
				Row row = sheet1.getRow(i);
				int totalCols = row.getLastCellNum() - row.getFirstCellNum();
				String[] line = new String[totalCols];
				for (int j = 0; j < totalCols; j++) {
					Cell cell = row.getCell(j);
					line[j] = cell.getStringCellValue();
				}
				lines.add(line);
			}
			String[][] sdata = new String[lines.size()][0];
			data = lines.toArray(sdata);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;

	}

	public Object[][] getUserFromDatabase() {

		Connection connection = null;
		Object[][] data = null;
		try {
//		step-1
			DriverManager.registerDriver(new Driver());

//		step-2
			String url = "jdbc:mysql://localhost:3306/shop_db";
			String user = "root";
			String password = "root1234";
			connection = DriverManager.getConnection(url, user, password);
//		step-3
			String sql = "select * from shop_db.SHOP_USERS";
			Statement sqlStatement = connection.createStatement();
			ResultSet rs = sqlStatement.executeQuery(sql);

			List<String[]> lines = new ArrayList<String[]>();

			while (rs.next()) {
				String[] line = new String[3];
				line[0] = rs.getString(1);
				line[1] = rs.getString(2);
				line[2] = rs.getString(3);
				lines.add(line);
			}

			String[][] sdata = new String[lines.size()][0];
			data = lines.toArray(sdata);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return data;

	}

}
