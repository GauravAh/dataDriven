package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BasePackage.SetUpClass;

public class ListenersClass extends SetUpClass implements ITestListener {
	
	ExtentTest test;
	ExtentReports reports;

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			test.log(LogStatus.PASS, "Test Passed" + test.addScreenCapture(TakeSS()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_");
		reports = new ExtentReports("./Reports/" + filename + context.getName()+  ".html");
		test = reports.startTest("Hrm Project");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.endTest(test);
		reports.flush();
	}
	
	public String TakeSS() throws Exception {
		Date dd = new Date();
		String erString = dd.toString().replace(":", "_").replace(" ", "_");
		TakesScreenshot Tss1 = (TakesScreenshot)getBrowser();
		File FileSrc = Tss1.getScreenshotAs(OutputType.FILE);
		String filepath = System.getProperty("user.dir") + "\\Reports\\" + erString + ".png";
		File FileDest = new File(filepath);
		FileUtils.copyFile(FileSrc, FileDest);
		return filepath;
	}

}
