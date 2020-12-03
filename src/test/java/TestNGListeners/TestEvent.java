/*package TestNGListeners;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ConfigReader;
import Utilities.InitDriver;
import Utilities.ReportManager;

public class TestEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();
	private static final String KEY = "platform";
	private static final String KEY1 = "udid";
	private static final String KEY2 = "systemPort";
	public String Platform;
	public String Udid;
	public String SystemPort;

	@Override
	public void onTestStart(ITestResult arg0) {
		ReportManager.startTest(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_type"));
		try {
			System.out.println("key: "+Platform);
			System.out.println("key1: "+Udid);
			System.out.println("key2: "+SystemPort);
			
			initDriver.startDriver(Platform, Udid, SystemPort);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());

		ReportManager.logPass("Test case passed");
		ReportManager.endCurrentTest();
		try {
			initDriver.tearDownDriver();
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFail("Test case Fail");
		ReportManager.endCurrentTest();
		try {
			initDriver.tearDownDriver();
		} catch (MalformedURLException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext arg0) {
		Platform = arg0.getCurrentXmlTest().getParameter(KEY);
		Udid = arg0.getCurrentXmlTest().getParameter(KEY1);
		SystemPort = arg0.getCurrentXmlTest().getParameter(KEY2);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
*/