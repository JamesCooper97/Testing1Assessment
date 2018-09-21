package com.QA.RevisedAssessment;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportUtils {
	private static int a;
	
	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void createReport() {
		if (report != null) {
			report = new ExtentReports(Constants.SCREENSHOT_LOCATION + "report.html");
		}
	}
	
	public static void createTest(String name) {
		if(test == null) {
			test = report.startTest(name);
		}
	}
	
	public static void logTest(String information) {
		test.log(LogStatus.INFO,information);
	}
	
	//Function that takes and logs the screen shot
	public static void logScreenShot(WebDriver driver) {
		String imageLocation = Constants.SCREENSHOT_LOCATION + a++ + ".png";
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(imageLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCapture(imageLocation);
	}
	
	public static void endTest() {
		report.endTest(test);
		test = null;
	}
	
	public static void flushReport() {
		report.flush();
	}
}