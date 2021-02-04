package com.crm.autodesk.extentReport;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ItestListnersIMP implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS,result.getMethod().getMethodName()+"is passed");
		
	}

	/*
	 * public void onTestFailure(ITestResult result) { WebDriver driver=null;
	 * 
	 * test.log(Status.FAIL,result.getMethod().getMethodName()+"is passed");
	 * test.log(Status.FAIL,result.getThrowable()); EventFiringWebDriver event =new
	 * EventFiringWebDriver(driver); File src
	 * =event.getScreenshotAs(OutputType.FILE); String screenShotPath=
	 * "./screenshot/"+result.getMethod().getMethodName()+".png"; File dest = new
	 * File(screenShotPath); try { Files.copy(src, dest); }catch (IOException e) {
	 * e.printStackTrace(); } test.addScreenCaptureFromPath(screenShotPath);
	 * 
	 * 
	 * 
	 * }
	 */
	public void onTestFailure(ITestResult result) {					
        test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
        test.log(Status.FAIL, result.getThrowable());
		try {
			//String path = WebDriverUtiity.takeScreenshot(BaseClass.staticDriver, result.getMethod().getMethodName());
			//test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		
       
        		
    }		

	public void onTestSkipped(ITestResult result) {
	test.log(Status.SKIP, result.getMethod().getMethodName()+ "is Skipped");
	test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * public void onStart(ITestContext context) { ExtentSparkReporter htmlReport =
	 * new ExtentSparkReporter(new File("./ExtentReport.html")) ;
	 * htmlReport.config().setDocumentTitle("V Tiger Application");
	 * htmlReport.config().setTheme(Theme.STANDARD);
	 * htmlReport.config().getTimeStampFormat();
	 * htmlReport.config().setReportName("Smoke Test");
	 * 
	 * ExtentReports report = new ExtentReports();
	 * report.attachReporter(htmlReport); report.setSystemInfo("Test Url, ",
	 * "http://localhost:8888"); report.setSystemInfo("browser","Chrome");
	 * report.setSystemInfo("Reporter Name", " Ashok Chandra Singh");
	 * 
	 * }
	 */
	 public void onStart(ITestContext arg0) {					
	        ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(new File(".\\ExtentReport\\report.html"));				
	        htmlReport.config().setDocumentTitle("Extent Report");
	        htmlReport.config().setTheme(Theme.DARK);
	        htmlReport.config().setReportName("Functional Test");
	         report=new ExtentReports();
	        report.attachReporter(htmlReport);
	        report.setSystemInfo("TestURL", "https://example.com");
	        report.setSystemInfo("Platform", "Windows 10");
	        report.setSystemInfo("Reporter Name", "Nithesh");
	    }		

	public void onFinish(ITestContext context) {
	
		report.flush();
		
		
	}

}
