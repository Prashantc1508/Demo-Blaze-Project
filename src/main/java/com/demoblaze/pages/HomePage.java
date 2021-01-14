package com.demoblaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	private By laptops = By.xpath("//a[text()='Laptops']");
	private By selectLaptopSonyViaoi5 = By.linkText("Sony vaio i5");
	private By addToCarButton = By.linkText("Add to cart");
	private By homeButton = By.xpath("//a[text()='Home ']");
	private By selectLaptopDelli78gb = By.linkText("Dell i7 8gb");
	private By cartButton = By.linkText("Cart");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getUrl(String url) {
		driver.get(url);
	}

	public void clickOnlaptopButton() {
		driver.findElement(laptops).click();
	}

	public void userSelectSonyLaptop() {
		driver.findElement(selectLaptopSonyViaoi5).click();
	}

	public void userClicksOnAddToCart() {
		driver.findElement(addToCarButton).click();
		clickOnAlert();
	}

	public void clickOnAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}

	public void userClicksOnHomeButton() {
		driver.findElement(homeButton).click();
	}

	public void userSelectDellLaptop() {
		driver.findElement(selectLaptopDelli78gb).click();
	}
	
	public void clickOnCartButton() {
		driver.findElement(cartButton).click();
	}

}
