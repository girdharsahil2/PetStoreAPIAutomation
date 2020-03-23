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
public class TC002_loginAPI_Test extends TestBase{

	String username=RandomData_API.username();
	String password=RandomData_API.password();
	
	@BeforeClass
	void loginAPI() throws Exception
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		httpRequest=RestAssured.given();
		JSONObject loginrequestParam = new JSONObject();
		loginrequestParam.put("username", username);
		loginrequestParam.put("password", password);
		httpRequest.header("content-type","application/json");
		httpRequest.body(loginrequestParam.toJSONString());
		
		response=httpRequest.request(Method.GET,"/user/login");
		Thread.sleep(5000);
	
	}
	
	@Test
	void validateLogin_responsebody()
	{
		String responseBody=response.getBody().asString();
		System.out.println("The repsonse body is ="+responseBody);
		AssertJUnit.assertTrue(responseBody!=null);
	}
	
	@Test
	void validateLogin_ResponseCode() 
	{
		//status Code validation
				int login_responseCode=response.getStatusCode();
				System.out.println("The Response Code is ="+login_responseCode);
				AssertJUnit.assertEquals(login_responseCode, 200);
				System.out.println("Success Code is verified");
	}
	
	@Test
	void validateLogin_ResponseTime() 
	{
		//status Code validation 
				long Login_responsetime=response.getTime();
				System.out.println("The Response time is ="+Login_responsetime);
				AssertJUnit.assertTrue(Login_responsetime<3000);
				System.out.println("API is executed under mentioned timeframe i.e. "+Login_responsetime);
	}
	
}
