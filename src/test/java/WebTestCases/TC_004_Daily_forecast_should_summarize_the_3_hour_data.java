package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.GetWeatherHomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_004_Daily_forecast_should_summarize_the_3_hour_data {

	

	@Test(description = "This is simple test", groups = { "smoke", "regression", "WebApplication" })
	public void TC_004_Daily_Forecast_Should_Summarize_The_3_Hour_Data() throws InterruptedException {
		GetWeatherHomePage weatherHomePage = new GetWeatherHomePage();
		weatherHomePage.user_should_enter_the_cityname("Edinburgh");
		weatherHomePage.getHourlyDaTaRainFallForDay("Tue");
		weatherHomePage.getHourlyWindSpeedDaTaForDay("Tue");
		weatherHomePage.getHourlyMinAndMaxDaTaForDay("Tue");
	}

}