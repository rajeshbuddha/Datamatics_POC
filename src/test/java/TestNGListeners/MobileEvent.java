package TestNGListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilities.ConfigReader;
import Utilities.InitDriver;
import Utilities.ReportManager;

public class MobileEvent implements ITestListener {

	InitDriver initDriver = new InitDriver();
	private static final String KEY = "platform";
	private static final String KEY1 = "udid";
	private static final String KEY2 = "systemPort";
	private static final String KEY3 = "deviceName";

	public String Platform;
	public String Udid;
	public String SystemPort;
	public String DeviceName;

	
	public void onTestStart(ITestResult arg0) {
		ReportManager.startTestMobile(arg0.getMethod().getMethodName(), arg0.getMethod().getDescription(),
				ConfigReader.getValue("Execution_Mobile"));
		try {
			System.out.println("key: " + Platform);
			System.out.println("key1: " + Udid);
			System.out.println("key2: " + SystemPort);
			initDriver.startMobileDriver(Platform, Udid, SystemPort, DeviceName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Test Success: " + iTestResult.getMethod().getMethodName());
		ReportManager.logPassMobile("Test case passed");
		ReportManager.endCurrentTestMobile();
		initDriver.tearDownMobileDriver();

	}

	
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Test Fail: " + iTestResult.getMethod().getMethodName());
		ReportManager.logFailMobile("Test case Fail");
		ReportManager.endCurrentTestMobile();
		initDriver.tearDownMobileDriver();

	}

	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	
	public void onStart(ITestContext arg0) {
		Platform = arg0.getCurrentXmlTest().getParameter(KEY);
		Udid = arg0.getCurrentXmlTest().getParameter(KEY1);
		SystemPort = arg0.getCurrentXmlTest().getParameter(KEY2);
		DeviceName = arg0.getCurrentXmlTest().getParameter(KEY3);

	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}
