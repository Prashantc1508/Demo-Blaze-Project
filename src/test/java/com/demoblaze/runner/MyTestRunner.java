package com.demoblaze.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\prashant\\eclipse-workspace\\CucumberEclipse\\DemoBlaze\\src\\test\\resources\\com\\Features",
		glue = {"com.demoblaze.stepdeffination","com.demoblaze.apphooks"},
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@AddToCart",
		monochrome = true
		)

public class MyTestRunner {

	
	
}

