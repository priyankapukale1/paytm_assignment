package com.genericlib;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Driver {
	private static WebDriver dr = null;

	public static WebDriver getDriver() {
		return dr;
	}

	public static void LunchBrowser(String BrowserName,String url) {
		if (BrowserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserFiles/chromedriver.exe");
			dr = new ChromeDriver();
			System.out.println("Default Chrome Browser is Lunched");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserFiles/chromedriver.exe");
			System.out.print("Default Chrome Browser is Lunched");
			System.out.println("sucessfully");
		}
		getDriver().manage().window().maximize();
		getDriver().get(url);
		getDriver().manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	}
}
