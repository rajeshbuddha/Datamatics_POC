package TestNGListeners;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ConfigReader;
import Utilities.InitDriver;
import Utilities.ReportManager;
import Utilities.VideoReord;

public class WebEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();
	
	
	public void onTestStart(ITestResult arg0) {
		ReportManager.startTest(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_Web"));
		try {
			
			initDriver.startWebDriver();
			VideoReord.startRecord(arg0.getMethod().getMethodName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());

		ReportManager.logPass("Test case passed");
		ReportManager.endCurrentTest();
		try {
			VideoReord.stopRecord();
			initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFail("Test case Fail");
		ReportManager.endCurrentTest();
		try {
			VideoReord.stopRecord();
			initDriver.tearDownWebDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	
	public void onStart(ITestContext arg0) {

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
