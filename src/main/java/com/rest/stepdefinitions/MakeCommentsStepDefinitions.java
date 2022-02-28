package com.rest.stepdefinitions;

import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.pojos.makecomments.MakeCommentResponse;
import com.rest.pojos.makeposts.MakePostResponse;
import com.rest.utils.MakeCommentsUtils;
import com.rest.utils.MakePostsUtils;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MakeCommentsStepDefinitions {

	private static Logger logger = LogManager.getLogger(MakeCommentsStepDefinitions.class);
	private static int statusCode;
	private static Response response;
	MakeCommentsUtils makeCommentObj = new MakeCommentsUtils();
	ParseResponseUtils parseResponse = new ParseResponseUtils();
	
	MakeCommentResponse responseOutput = new MakeCommentResponse();
	
	@Given("^user makes comment posts with following details to server$")
	public void makeComments(DataTable dataTable) throws Throwable {

	
		response = makeCommentObj.makeComment(dataTable);
		statusCode = response.getStatusCode();
		
		responseOutput = parseResponse.getCommentResponse(response.asString());
	}

	@Then("^user verifes the following details from the comment posts for sucessfull post in the server$")
	public void verifyComments(
			DataTable dataTable) throws Throwable {

		
		for (final Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
			assertTrue("name mismatch expected " + row.get("name") + " actual " + responseOutput.getName(),
					row.get("name").equals((responseOutput.getName())));
			assertTrue("body mismatch expected " + row.get("body") + " actual " + responseOutput.getBody(),
					row.get("body").equals((responseOutput.getBody().toString())));
			assertTrue("email mismatch expected " + row.get("email") + " actual " + responseOutput.getEmail(),
					row.get("email").equals((responseOutput.getEmail().toString())));
			
			assertTrue("postID mismatch expected " + row.get("postId") + " actual " + responseOutput.getPostId(),
					row.get("postId").equals(Integer.toString((responseOutput.getPostId()))));
			
			assertTrue("id mismatch expected " + row.get("id") + " actual " + responseOutput.getId(),
					row.get("id").equals(Integer.toString((responseOutput.getId()))));
		}
	}


@Given("^user verifies the status code for make post as (\\d+)$")
public void user_verifies_the_status_code_for_make_post_as(int code) throws Throwable {
	assertTrue("Status code mismatch Expected " + code + " Actual is " + statusCode, statusCode == code);

}
}