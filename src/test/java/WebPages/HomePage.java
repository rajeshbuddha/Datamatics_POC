package WebPages;

import org.openqa.selenium.By;
import Utilities.ReportManager;
import WebUtil.WebActions;

public class HomePage {

	WebActions webActions = new WebActions();

	// =====================Login=====================
	By userName = By.name("user_name");
	By password = By.name("user_password");
	By login = By.id("submitButton");

	// ====================Logout=====================
	By accountImg = By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/im");
	By logout = By.linkText("Sign Out");

	public void Login() {
		ReportManager.logInfo("Test started login");
		webActions.sendKeys(userName, "admin");
		webActions.sendKeys(password, "password");
		webActions.Click(login, "login");

	}

	public void Logout() {
		webActions.Click(accountImg, "My account");
		webActions.Click(logout, "Logout");

	}

}
