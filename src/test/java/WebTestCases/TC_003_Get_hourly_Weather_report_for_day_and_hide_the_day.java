package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.GetWeatherHomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_003_Get_hourly_Weather_report_for_day_and_hide_the_day {

	

	@Test(description = "This is simple test", groups = { "smoke", "regression", "WebApplication" })
	public void TC_003_Get_Hourly_Weather_Report_For_Day_And_Hide_The_Day() throws InterruptedException {
		GetWeatherHomePage weatherHomePage = new GetWeatherHomePage();
		weatherHomePage.user_should_enter_the_cityname("Edinburgh");
		weatherHomePage.hideTheDayAfterExpanding("Tue");
	}

}