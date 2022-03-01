package com.rest.stepdefinitions;

import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.pojos.listusers.ListUserResponse;
import com.rest.pojos.makeposts.MakePostResponse;
import com.rest.utils.MakeCommentsUtils;
import com.rest.utils.MakeListUserUtils;
import com.rest.utils.MakePostsUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ListOfUsersStepDefinitions {

	private static Logger logger = LogManager.getLogger(ListOfUsersStepDefinitions.class);
	private static Response response;
	MakeListUserUtils makeListUserObj = new MakeListUserUtils();
	ListUserResponse responseOutput;
	ParseResponseUtils parseResponse = new ParseResponseUtils();
	
	@Given("^user list users for user id \"([^\"]*)\"$")
	public void listUserDetails(String userID) throws Throwable {
	   
		System.out.println("userID >> "+userID);
		response = makeListUserObj.listUser(userID);
		
		System.out.println("response > "+response.statusCode());
		System.out.println("response > "+response.asString());
		
		responseOutput = parseResponse.getListUserResponse(response.asString());
	}

	@Then("^user verifes the following details for user id \"([^\"]*)\"$")
	public void verifyUser(String userID, DataTable dataTable) throws Throwable {
	   
		
		
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
		
			
			assertTrue("name mismatch expected " + row.get("name") + " actual " + responseOutput.getName(),
					row.get("name").equals((responseOutput.getName())));
			
			
			assertTrue("username mismatch expected " + row.get("username") + " actual " + responseOutput.getUsername(),
					row.get("username").equals((responseOutput.getUsername())));
			
			
			assertTrue("email mismatch expected " + row.get("email") + " actual " + responseOutput.getEmail(),
					row.get("email").equals((responseOutput.getEmail())));
			
			
			assertTrue("address-street mismatch expected " + row.get("address-street") + " actual " + responseOutput.getAddress().getStreet(),
					row.get("address-street").equals((responseOutput.getAddress().getStreet())));
		
		}
		
		System.out.println("Name "+ responseOutput.getName());
		System.out.println("UserName "+ responseOutput.getUsername());
		System.out.println("Email "+ responseOutput.getEmail());
		System.out.println("Name "+ responseOutput.getPhone());
		System.out.println("Name "+ responseOutput.getWebsite());
		
		System.out.println("COMPANY -------->>");
		System.out.println("company Name "+ responseOutput.getCompany().getName());
		System.out.println("company catchPhrase "+ responseOutput.getCompany().getCatchPhrase());
		System.out.println("company bs "+ responseOutput.getCompany().getBs());

		
		System.out.println("ADDRESS -------->>");
		
		System.out.println("Address street "+responseOutput.getAddress().getStreet());
		System.out.println("Address suite "+responseOutput.getAddress().getSuite());
		System.out.println("Address city "+responseOutput.getAddress().getCity());
		System.out.println("Address zipcode "+responseOutput.getAddress().getZipcode());
		System.out.println("Address Lat "+responseOutput.getAddress().getGeo().getLat());
		System.out.println("Address lng "+responseOutput.getAddress().getGeo().getLng());
		
		
	}


}