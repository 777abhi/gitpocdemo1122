package com.project.automationDemoProject;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listeners extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/UI_API_AutomationExtentReport"+UtilityPage.dateTimeGenerate()+".html");
		htmlReporter.config().setDocumentTitle("Automation Extent Report");
		htmlReporter.config().setReportName("Automation Test");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sunny Kumar");
		
	}
	
	public void onTestSuccess(ITestResult testResult)
	{
         test=extent.createTest(testResult.getName());
         test.log(Status.PASS, "TestCase passed "+testResult.getName());
         
	}
	public void onTestFailure(ITestResult testResult)
	{
		 test=extent.createTest(testResult.getName());	
		 test.log(Status.FAIL, "TestCase Failed "+testResult.getName());
		 test.log(Status.FAIL, "TestCase Failed "+testResult.getThrowable());
	}
	public void onTestSkipped(ITestResult testResult)
	{
		 test=extent.createTest(testResult.getName());	
		 test.log(Status.SKIP, "TestCase SKIPPED "+testResult.getName());
		
	}
	public void onFinish(ITestContext testContext)
	{
         extent.flush();
         
	}
}
