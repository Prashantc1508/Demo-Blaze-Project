package com.demoblaze.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	//1. initialise webdriver
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	//2 creating a method
	
	public static WebDriver init_driver(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else {
			System.out.println("Browser is not initialised" +browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

	return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
	return	tlDriver.get();
	}
}
