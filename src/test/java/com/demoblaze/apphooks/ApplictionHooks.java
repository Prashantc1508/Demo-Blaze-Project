package com.demoblaze.apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.demoblaze.factory.DriverFactory;
import com.demoblaze.utill.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplictionHooks {

	//1. prop initilise
	
	private ConfigReader configReader;
	Properties prop;
	private DriverFactory driverfactory;
	WebDriver driver;
	
	
	@Before(order=0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		//String value = prop.getProperty("browser");
	}
	
	//2. Launch bowser
	@Before(order=1)
	public void launchBrowser() {
		String browserValue = prop.getProperty("browser");
		 driverfactory = new DriverFactory();
		 
		 // to run as chrome
		// driver = driverfactoryChrome.init_driver_crome(browserValue);
		 driver = driverfactory.init_driver(browserValue);
	}
	
	@After(order=0)
	public void quitBrowser() {
		driver.quit();
	}
}
