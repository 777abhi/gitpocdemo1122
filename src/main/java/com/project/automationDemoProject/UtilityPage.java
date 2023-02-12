package com.project.automationDemoProject;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilityPage {


	public static String empname() {
		String generateString =RandomStringUtils.randomAlphabetic(1);
		return ("RestDummyName"+generateString);
	}
	
	public static String emailId() {
		String generateString =RandomStringUtils.randomAlphabetic(5);
		return ("DummyEmail"+generateString+"@gmail.com");
	}
	public static String employeeId() {
		String generateString =RandomStringUtils.randomNumeric(6);
		return (generateString);
	}
	public static String dateTimeGenerate(){
	    Format formatter = new SimpleDateFormat("YYYYMMdd_HHmmssSSS");
	    Date date = new Date(System.currentTimeMillis());
	   return formatter.format(date);
	}
}
