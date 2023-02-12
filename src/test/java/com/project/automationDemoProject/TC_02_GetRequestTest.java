package com.project.automationDemoProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_GetRequestTest extends ConfigFileReader {
  
	
	@Test
	public void GetRequestTest() {
		
		RestAssured.baseURI=ConfigFileReader.getBaseURI();
		RequestSpecification request=RestAssured.given();
		Response response=request.request(Method.GET, ConfigFileReader.getEndPoint());
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is ####"+ responseBody);

		Assert.assertEquals(response.getStatusCode(), 200);
		
		String EmpId=response.getBody().jsonPath().getString("id");
		System.out.println("EmpId ######## "+ EmpId); 
		
		Assert.assertNotNull(EmpId);
		
	}
	
	
	
}
