package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.GetWeatherHomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_002_Get_hourly_Weather_report_for_day {

	

	@Test(description = "This is simple test", groups = { "smoke", "regression", "WebApplication" })
	public void TC_002_Get_Hourly_Weather_Report_For_Day() throws InterruptedException {
		GetWeatherHomePage weatherHomePage = new GetWeatherHomePage();
		weatherHomePage.user_should_enter_the_cityname("Edinburgh");
		weatherHomePage.getHourlyWeatherMaxForecastReportForADay("Wed");

	}

}