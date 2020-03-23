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

public class TC004_UpdateUser_Test extends TestBase
{

	String username=RandomData_API.username();
	String firstname =RandomData_API.firstname();
	
	@BeforeClass
	void UpdateUser() throws Exception
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		httpRequest=RestAssured.given();
		JSONObject Update_requestParams = new JSONObject();
		Update_requestParams.put("firstname", firstname);
		
		
		httpRequest.header("content-type","application/json");
		httpRequest.body(Update_requestParams.toJSONString());
		
		response=httpRequest.request(Method.PUT,"/user/"+username);
		Thread.sleep(5000);
	}
	
	@Test
	void validateUpdateUser_ResponseBody()
	{
		String responseBody=response.getBody().asString();
		System.out.println("The repsonse body is ="+responseBody);
		AssertJUnit.assertTrue(responseBody!=null);
	}
	
	@Test
	void validateUpdateUser_ResponseCode()
	{
		//status Code validation
		int responseCode=response.getStatusCode();
		System.out.println("The Response Code is ="+responseCode);
		AssertJUnit.assertEquals(responseCode, 200);
		System.out.println("Success Code is verified");
	}
	
	@Test
	void validateUpdateUser_ResponseTime() 
	{
		//status Code validation 
				long Fetchuser_responsetime=response.getTime();
				System.out.println("The Response time is ="+Fetchuser_responsetime);
				AssertJUnit.assertTrue(Fetchuser_responsetime<3000);
				System.out.println("API is executed under mentioned timeframe i.e. "+Fetchuser_responsetime);
	}
}
