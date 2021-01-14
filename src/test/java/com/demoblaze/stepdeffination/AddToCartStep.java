package com.demoblaze.stepdeffination;

import com.demoblaze.factory.DriverFactory;
import com.demoblaze.pages.HomePage;
import com.demoblaze.utill.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AddToCartStep {

	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	ConfigReader read = new ConfigReader();

	@Given("User navigates to home page")
	public void user_Navigates_HomePage() {
		String url = read.init_prop().getProperty("url");
		homePage.getUrl(url);
	}

	@When("User select laptops from categories")
	public void user_Select_Laptops() {
		homePage.clickOnlaptopButton();
	}

	@And("User select laptop Sony vaio i5")
	public void user_Select_Sony_Laptop() {
		homePage.userSelectSonyLaptop();
	}

	@And("User add the device to cart")
	public void user_Add_Laptop_to_Cart() {
		homePage.userClicksOnAddToCart();
		;
	}

	@And("User clicks on home button")
	public void user_Clicks_On_Home_Page() {
		homePage.userClicksOnHomeButton();
	}

	@And("User select laptop Dell i7 8gb")
	public void user_Select_Dell_Laptop() {
		homePage.userSelectDellLaptop();
	}

	@And("User click on cart")
	public void user_Clicks_On_Cart_Button() {
		homePage.clickOnCartButton();
	}
}
