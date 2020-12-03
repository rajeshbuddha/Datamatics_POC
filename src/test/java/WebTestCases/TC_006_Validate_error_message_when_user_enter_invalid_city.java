package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.GetWeatherHomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_006_Validate_error_message_when_user_enter_invalid_city {

	@Test(description = "This is simple test", groups = { "smoke", "regression", "WebApplication" })
	public void TC_006_Validate_Error_Message_When_User_Enter_Invalid_City() throws InterruptedException {
		GetWeatherHomePage weatherHomePage = new GetWeatherHomePage();
		weatherHomePage.user_should_enter_the_cityname("Mumbai");
		weatherHomePage.validateErrorMessage("Error retrieving the forecast");
	}

}