package TestNGListeners;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ConfigReader;
import Utilities.InitDriver;
import Utilities.ReportManager;

public class DesktopEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();

	
	public void onTestStart(ITestResult arg0) {
		ReportManager.startTest(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_Desktop"));
		try {
			initDriver.startDesktopDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());

		ReportManager.logPass("Test case passed");
		ReportManager.endCurrentTest();
		try {
			initDriver.tearDownDesktopDriver();
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFail("Test case Fail");
		ReportManager.endCurrentTest();
		try {
			initDriver.tearDownDesktopDriver();
		} catch (MalformedURLException | InterruptedException e) {
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
