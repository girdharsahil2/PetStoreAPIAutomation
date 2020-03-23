package com.PetStoreAPI.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PetStoreAPI.Base.TestBase;
import com.PetStoreAPI.Utilities.RandomData_API;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC005_LogoutUser_Test extends TestBase
{
	
	@BeforeClass
	void loginAPI() throws Exception
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		httpRequest=RestAssured.given();
		//JSONObject loginrequestParam = new JSONObject();
		//loginrequestParam.put("username", username);
		//loginrequestParam.put("password", password);
		httpRequest.header("content-type","application/json");
		//httpRequest.body(loginrequestParam.toJSONString());
		
		response=httpRequest.request(Method.GET,"/user/logout");
		Thread.sleep(5000);
	}
	@Test
	void validateLogout_ResponseBody() 
	{
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("The repsonse body is ="+responseBody);
		AssertJUnit.assertTrue(responseBody!=null);
	}
	
	@Test
	void validateLogout_code() 
	{
		//status Code validation
				int logout_responseCode=response.getStatusCode();
				System.out.println("The Response Code is ="+logout_responseCode);
				AssertJUnit.assertEquals(logout_responseCode, 200);
				System.out.println("Success Code is verified");
	}
	
	@Test
	void validateLogout_time() 
	{
		//status Code validation 
				long logout_responsetime=response.getTime();
				System.out.println("The Response time is ="+logout_responsetime);
				AssertJUnit.assertTrue(logout_responsetime<3000);
				System.out.println("API is executed under mentioned timeframe i.e. "+logout_responsetime);
	}
}
