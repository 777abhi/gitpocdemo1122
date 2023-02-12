package com.project.automationDemoProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.runtime.misc.ParseCancellationException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_05_DELETERequestTest extends ConfigFileReader{

	@Test
	public void deleteRequestTest() {
		
		RestAssured.baseURI=ConfigFileReader.getBaseURI();
		RequestSpecification request=RestAssured.given();
		String endpoint=ConfigFileReader.getEndPoint()+Integer.parseInt(ConfigFileReader.getEmpID());
		System.out.println("endpoint   "+endpoint);
		Response response=request.request(Method.DELETE, ConfigFileReader.getEndPoint()+Integer.parseInt(ConfigFileReader.getEmpID()));
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is ####"+ responseBody);
		Assert.assertTrue(responseBody.contains("Resource not found"));
		
		String EmpId=response.getBody().jsonPath().getString("id");
		System.out.println("EmpId ######## "+ EmpId); 
		
		Assert.assertNull(EmpId);
		
	}
	
}
