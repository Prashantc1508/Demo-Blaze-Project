package com.demoblaze.stepdeffination;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import org.junit.Assert;

import com.demoblaze.petstore.Petstore;
import com.demoblaze.utill.ConfigReader;
import com.microsoft.schemas.office.x2006.encryption.STSaltSize;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PetstoreStep {

	public Petstore pet = new Petstore();
	public ConfigReader config = new ConfigReader();
	boolean flag = false;
	
	@Given("User get the available pets and verify {string} in response")
	public void user_Get_Available_Pet(String resValue) throws NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
		String availableetsURL = config.init_prop().getProperty("getAvailablePetsURL");
		pet.ConnectGETService(availableetsURL);
		String Response = pet.SendGETService();
		Assert.assertTrue("Get available pet resonse is not correct",Response.contains(resValue));
	}
	
	@And("User added new pet to store and verify id {string} in response")
	public void user_Add_New_Pet(String id) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
		String addPetURL = config.init_prop().getProperty("addNewPetURL");
		String bodyHeader = config.init_prop().getProperty("PostHedderAddNewPetURL");
		String postResponse = pet.SendPOSTServiceNew(addPetURL,bodyHeader);
		Assert.assertTrue("New added pet response is not correct", postResponse.contains(id));
	}
	
	@And("User update status to sold and status is {string} in response")
	public void user_Update_Status(String status) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
		String addPetURL = config.init_prop().getProperty("addNewPetURL");
		String updatedBodyHeader = config.init_prop().getProperty("putHedderAddNewPetURL");
		String updatedPUTResponse = pet.SendPUTServiceNew(addPetURL, updatedBodyHeader);
		Assert.assertTrue("Updated Response is not correct", updatedPUTResponse.contains(status));
	}
	
	@And("User deletes the pet")
	public void user_Delete_Pet() {
		String deletePetURL = config.init_prop().getProperty("deletePet");
		String deletedResponse = pet.deleteService(deletePetURL);
		System.out.println("Deleted response is not correct" + deletedResponse);
	}
	
	@Then("User validate that pet is deleted")
	public void verifyResponse() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
		String availablePetsURL = config.init_prop().getProperty("verifyDeletedPet");
		pet.ConnectGETService(availablePetsURL);
		String Response = pet.SendGETService();
		Assert.assertTrue("Verify resonse is not correct",Response.contains("Pet not found"));
	}
	
	
}
