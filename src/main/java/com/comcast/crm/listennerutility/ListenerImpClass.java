package com.comcast.crm.listennerutility;

import java.io.File;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseutility.BaseClass1;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporterConfig spark;
	public ExtentTest test;
	public static ExtentReports report;

	public void onStart(ISuite suite) {
		System.out.println("Report configuration");

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// spark report configure
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// add Env information &create test
		report = new ExtentReports();
		report.attachReporter(spark);
		// create testcase
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backUP");
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		System.out.println("======>>" + result.getMethod().getMethodName() + ">===START====");
		test = report.createTest(result.getMethod().getMethodName() + "started");

		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName() + "started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("======>>" + result.getMethod().getMethodName() + ">===END===");
		test.log(Status.PASS, result.getMethod().getMethodName() + "end");

	}

	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		// 1.create an object for Takes screenshot
		TakesScreenshot ts = (TakesScreenshot) BaseClass1.sdriver;
		// 2.use getScreenshot()
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);

		test.log(Status.FAIL, result.getMethod().getMethodName() + "fail");

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, result.getMethod().getMethodName() + "skipped");
	}

}
