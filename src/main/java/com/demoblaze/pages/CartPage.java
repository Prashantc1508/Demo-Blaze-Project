package com.demoblaze.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	WebDriver driver;

	// private By getText = By.xpath("//div[@class='table-responsive']");
	private By getText = By.xpath("//tr[@class='success']");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void deleteCart(String device) {
		driver.findElement(By.xpath("//*[text()='" + device + "']//following-sibling::td[2]//a")).click();
		System.out.println("Lapop is deleted");
	}

	public List<WebElement> getAllDevice() {
		// String allDevice = driver.findElement(getText).getText();
		List<WebElement> deviceList = driver.findElements(getText);
		return deviceList;
	}

}
