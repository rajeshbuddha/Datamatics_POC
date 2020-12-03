package WebTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.GetWeatherHomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_001_Get_Weather_Max_Report_For_WeekDay {
	@Test(description = "This is simple test", groups = { "smoke", "regression", "WebApplication" })
	public void TC_001_Get_Weather_Max_Report_For_WeekDays() throws InterruptedException {
		GetWeatherHomePage weatherHomePage = new GetWeatherHomePage();
		weatherHomePage.user_should_enter_the_cityname("Edinburgh");
		weatherHomePage.getDailyWeatherMaxForecastReport();

	}

}