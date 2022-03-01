package com.rest.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.framework.rest.RestImpl;
import com.jayway.restassured.response.Response;
import com.rest.commonutils.ParseResponseUtils;
import com.rest.commonutils.PropertiesFile;
import com.rest.constants.ConfigurationPath;
import com.rest.constants.EndPoints;

public class MakeListUserUtils extends RestImpl {

	private static Logger logger = LogManager.getLogger(MakeListUserUtils.class);
	ParseResponseUtils gsonObj = new ParseResponseUtils();
	Response response;

	public Response listUser(String userID) {
System.out.println("userID "+userID);
String URL = PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL")+EndPoints.USERS+userID;
System.out.println("URL "+URL);
		response = getRequest(PropertiesFile.getPropertyValue(ConfigurationPath.CONFIG_PATH, "BASE_URL"), EndPoints.USERS+userID);

		return response;
	}

}
