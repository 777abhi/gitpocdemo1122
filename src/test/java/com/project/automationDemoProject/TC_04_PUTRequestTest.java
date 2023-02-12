package com.project.automationDemoProject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_04_PUTRequestTest extends ConfigFileReader{

	
    @Test
	public void putRequestTest() {
		
		RestAssured.baseURI=ConfigFileReader.getBaseURI();
		RequestSpecification request=RestAssured.given();
	
		JSONObject jsonObj=new JSONObject();
		String empidEmailRandomValue=UtilityPage.emailId();
		jsonObj.put("id","322325");
		jsonObj.put("name", UtilityPage.empname());
		jsonObj.put("email", empidEmailRandomValue);
		jsonObj.put("gender", "Male");
		jsonObj.put("status", "Active");
		
		request.header("Content-Type","application/json");
		request.header("Authorization",ConfigFileReader.getCredential());
		request.body(jsonObj.toJSONString());
		
		System.out.println(jsonObj.toJSONString());
		
		Response response=request.request(Method.PUT, ConfigFileReader.getEndPoint()+"322325");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is ####"+ responseBody);
		
		System.out.println("Response Status code is ####"+ response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		String Empemail=response.getBody().jsonPath().getString("email");
		System.out.println("EmpId ######## "+ Empemail); 
		
		
		System.out.println("empidRandomValue "+empidEmailRandomValue);
		Assert.assertTrue(Empemail.contains(empidEmailRandomValue));
		
	}
}
