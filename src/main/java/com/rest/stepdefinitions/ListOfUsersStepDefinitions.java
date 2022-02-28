package com.rest.stepdefinitions;

import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.pojos.makeposts.MakePostResponse;
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


	@Given("^user list users for user id \"([^\"]*)\"$")
	public void listUserDetails(String userID) throws Throwable {
	   
	}

	@Then("^user verifes the following details for user id \"([^\"]*)\"$")
	public void verifyUser(String userID, DataTable arg2) throws Throwable {
	   
	}


}