package WebUtil;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.DriverFactory;
import Utilities.ReportManager;

public class WebActions {

	JavascriptExecutor scrollBarPresent = (JavascriptExecutor) DriverFactory.getInstance().getWebDriver();
	Actions action = new Actions(DriverFactory.getInstance().getWebDriver());

	@SuppressWarnings("deprecation")
	public WebElement waitForVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	@SuppressWarnings("deprecation")
	public WebElement waitForVisible_MilliSeconds(By locator) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getWebDriver(), 100);
		wait.pollingEvery(500, TimeUnit.MILLISECONDS);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void openURL(String URL) {
		DriverFactory.getInstance().getWebDriver().get(URL);
		String strActualText = DriverFactory.getInstance().getWebDriver().getCurrentUrl();
		verifyText(strActualText, URL);
		ReportManager.logInfo("Successfully Entered URL - " + URL);
		System.out.println("Successfully Entered URL - " + URL);
	}

	public void Click(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		elm.click();
		ReportManager.logInfo("Successfully clicked on - " + info);
		System.out.println("Successfully clicked on - " + info);
	}

	public void sendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.sendKeys(text);
		ReportManager.logInfo("Successfully Entered text - " + text);
		System.out.println("Successfully Entered text - " + text);
	}

	public String getElmText(By locator) {
		WebElement elm = waitForVisible(locator);
		String elamText = elm.getText();
		ReportManager.logInfo("Successfully get element text - " + elamText);
		System.out.println("Successfully get element text - " + elamText);
		return elamText;
	}
	
	public boolean isDisplayed(By locator, String info) {
		WebElement elm = waitForVisible(locator);
		boolean isPresent = elm.isDisplayed();
		if (isPresent) {
			ReportManager.logInfo("Successfully element displayed: " + info);
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);
		}
		return isPresent;
	}

	public void clearAndSendKeys(By locator, String text) {
		WebElement elm = waitForVisible(locator);
		elm.clear();
		elm.sendKeys(text);
		elm.sendKeys(Keys.ENTER);
		ReportManager.logInfo("Successfully Entered text - " + text);
		System.out.println("Successfully Entered text - " + text);
	}
	
	public void waitToLoad(int timeInSeconds) throws InterruptedException {
		Thread.sleep(timeInSeconds);
	}

	public void verifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + actualText);
		ReportManager.logInfo("Expected Text - " + expectedText);
		System.out.println("Actual Text - " + actualText);
		System.out.println("Expected Text - " + expectedText);
		assertEquals(actualText, expectedText);
	}

	public void verifyIntValues(int actualValue, int expectedValue) {
		ReportManager.logInfo("Actual Value - " + actualValue);
		ReportManager.logInfo("Expected Value - " + expectedValue);
		System.out.println("Actual Value - " + actualValue);
		System.out.println("Expected Value - " + expectedValue);
		assertEquals(actualValue, expectedValue);
	}
	
	public String getAttributeValue(By locator, String name) {
		WebElement elm = waitForVisible(locator);
		String attributeText = elm.getAttribute(name);
		ReportManager.logInfo("Successfully get attribute text - " + attributeText);
		System.out.println("Successfully get attribute text - " + attributeText);
		return attributeText;
	}

	public boolean isScrollPresent() throws Exception {
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		Boolean isScroll_Present = (Boolean) (scrollBarPresent.executeScript(execScript));
		return isScroll_Present;

	}

	public void mouseHover(By locator) throws Exception {
		WebElement elm = waitForVisible_MilliSeconds(locator);
		action.moveToElement(elm).build().perform();
		String elmText = elm.getText();		
		ReportManager.logInfo("Successfully mouse hover and get text - " + elmText);
		System.out.println("Successfully mouse hover and get text - " + elmText);
	}
	
	public void switchToFrame(By locator) throws Exception {
		WebElement elm = waitForVisible(locator);
		DriverFactory.getInstance().getWebDriver().switchTo().frame(elm);
		ReportManager.logInfo("Successfully switched to frame ");
		System.out.println("Successfully switched to frame ");
	}
	
	public List<WebElement> getListofElements(By locator, String name) {
		waitForVisible(locator);
		List<WebElement> lst_Elements = DriverFactory.getInstance().getWebDriver().findElements(locator);
		ReportManager.logInfo("Successfully get element size - " + lst_Elements.size());
		System.out.println("Successfully get element size - " +lst_Elements.size());
		return lst_Elements;
	}
	
	public void verifyPaymentStatusOnUI(String Status) {
		DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//ul[@class = 'progress-tracker']//h5[contains(., '"+Status+"')]")).click();
		boolean isStatus = DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//ul[@class = 'progress-tracker']//h5[contains(., '"+Status+"')]")).isEnabled();
		if(isStatus) {
			//DriverFactory.getInstance().getWebDriver().findElement(By.xpath("//ul[@class = 'progress-tracker']//h5[contains(., '"+Status+"')]")).click();
			ReportManager.logInfo("<b style=\"color:green;\"> Element is Enabled : "+Status+"</b>");
			System.out.println("Enabled");
		}else {
			ReportManager.logInfo("<b style=\"color:red;\"> Element is Disabled : "+Status+"</b>");
			System.out.println("Disabled");
			Assert.assertEquals(true, isStatus);			
		}
	}


}
