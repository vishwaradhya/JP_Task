@jp
Feature:  Backend Testing Make posts
  
  Background:
  Given social network server is up and running

 	  @listUsers
  Scenario: Verify user is able to List of users request to server and validate the response 
 		Given user list users for user id "<id>"
 		And user verifies the status code as 201
 		Then user verifes the following details for user id "<id>"
 		|postId	|id		|name									|email	|Phone							|website|
 		|		1		|101	|		make post titile	|a@a.com|		make post body	|	|