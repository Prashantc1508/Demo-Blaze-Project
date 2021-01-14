package com.demoblaze.stepdeffination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.demoblaze.factory.DriverFactory;
import com.demoblaze.pages.CartPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DeleteCartStep {

	private CartPage cartPage = new CartPage(DriverFactory.getDriver());

	@And("User delete device {string} from cart")
	public void user_Deletes_Laptop(String laptop) {
		cartPage.deleteCart(laptop);
	}

	@Then("User validate that device {string} is deleted from cart")
	public void user_Validate_Device(String laptop) {
		List<WebElement> deviceList = cartPage.getAllDevice();
		int size = deviceList.size();

		for (int i = 0; i < size; i++) {
			String deviceName = deviceList.get(i).getText();
			System.out.println(deviceName);
			Assert.assertFalse("Device is not deleted", deviceName.equals(laptop));
		}
	}

}
