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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.PetStoreAPI.Utilities.Listners.class)
public class TC001_CreateUser_Test extends TestBase
{
	//RequestSpecification httpRequest;
	//Response response;

	String username=RandomData_API.username();
	String firstname =RandomData_API.firstname();
	String lastname=RandomData_API.lastname();
	String email=RandomData_API.email();
	String password=RandomData_API.password();
	String phone=RandomData_API.phone();
	
	@BeforeClass
	void CreateUser() throws InterruptedException 
	{
		
		//Specify Base URI
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		//Request Object
		httpRequest=RestAssured.given();
		
		//Request body
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", username);
		requestParams.put("firstName", firstname);
		requestParams.put("lastName", lastname);
		requestParams.put("email", email);
		requestParams.put("password", password);
		requestParams.put("phone", phone);
		
		httpRequest.header("content-type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		response=httpRequest.request(Method.POST,"/user");
		Thread.sleep(3000);
	}
		
	@Test
	void validateCreateUser_ResponseBody() 
	{
		System.out.println("The Username is "+username);
		System.out.println("The firstname is "+firstname);
		System.out.println("The lastname is "+lastname);
		System.out.println("The email is "+email);
		System.out.println("The password is "+password);
		System.out.println("The phone is "+phone);
		
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("The repsonse body is ="+responseBody);
		AssertJUnit.assertTrue(responseBody!=null);
	}
	
	
	@Test
	void validateCreateUser_ResponseCode()
	{
		//status Code validation
		int responseCode=response.getStatusCode();
		System.out.println("The Response Code is ="+responseCode);
		AssertJUnit.assertEquals(responseCode, 200);
		System.out.println("Success Code is verified");
	}
		
	@Test
	void validateCreateUser_time() 
	{
		//status Code validation 
				long CreateUser_responsetime=response.getTime();
				System.out.println("The Response time is ="+CreateUser_responsetime);
				AssertJUnit.assertTrue(CreateUser_responsetime<3000);
				System.out.println("API is executed under mentioned timeframe i.e. "+CreateUser_responsetime);
	}

	/*@org.testng.annotations.DataProvider(name="createuserdata")
	String [][] DataProvider() {
		String CreateUserData [][]= {{"sahilgirdhar","sahil","girdhar","girdhar.sahil2@gmail.com","Welcome1","3185471838"}, {"sahilgirdhar1","sahil1","girdhar1","girdhar.sahil2@gmail.com","Welcome1","3185471838"} };
		return(CreateUserData);
	}*/
	
}
