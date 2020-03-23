package com.PetStoreAPI.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.AssertJUnit;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.PetStoreAPI.Base.TestBase;
import com.PetStoreAPI.Utilities.RandomData_API;

import io.restassured.RestAssured;
import io.restassured.http.Method;

@Listeners(com.PetStoreAPI.Utilities.Listners.class)
public class TC003_fetchUserDetails_Test extends TestBase
{

	String username=RandomData_API.username();
	@BeforeClass
	void fetchUserDetaisl() throws Exception
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		httpRequest=RestAssured.given();
		JSONObject fetch_requestParams = new JSONObject();
		fetch_requestParams.put("username", username);
		
		httpRequest.header("content-type","application/json");
		httpRequest.body(fetch_requestParams.toJSONString());
		
		response=httpRequest.request(Method.GET,"/user/"+username);
		Thread.sleep(25000);
	}
	
	@Test
	void validateFetchUser_responseBody()
	{
		String responseBody=response.getBody().asString();
		System.out.println("The repsonse body is ="+responseBody);
		AssertJUnit.assertTrue(responseBody!=null);
	}
	
	@Test
	void validateFetchUser_ResponseCode()
	{
		//status Code validation
		int responseCode=response.getStatusCode();
		System.out.println("The Response Code is ="+responseCode);
		AssertJUnit.assertEquals(responseCode, 200);
		System.out.println("Success Code is verified");
	}
	
	@Test
	void validateFetchuser_ResponseTime() 
	{
		//status Code validation 
				long Fetchuser_responsetime=response.getTime();
				System.out.println("The Response time is ="+Fetchuser_responsetime);
				AssertJUnit.assertTrue(Fetchuser_responsetime<3000);
				System.out.println("API is executed under mentioned timeframe i.e. "+Fetchuser_responsetime);
	}
	
}
