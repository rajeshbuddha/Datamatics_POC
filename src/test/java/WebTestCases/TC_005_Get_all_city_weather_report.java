package WebTestCases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNGListeners.SuiteEvent;
import TestNGListeners.WebEvent;
import WebPages.GetWeatherHomePage;

@Listeners({ SuiteEvent.class, WebEvent.class })
public class TC_005_Get_all_city_weather_report {

	

	@Test(description = "This is simple test", groups = { "smoke", "regression", "WebApplication" })
	public void TC_005_Get_All_City_Weather_Report() throws InterruptedException {
		GetWeatherHomePage weatherHomePage = new GetWeatherHomePage();
		Map<String, String> Table = new HashMap<String, String>();
		Table.put("Edinburgh", "Tue");
		Table.put("Aberdeen", "Tue");
		Table.put("Dundee", "Tue");
		Table.put("Glasgow", "Tue");
		Table.put("Perth", "Tue");
		Table.put("Stirling", "Tue");
		for (Map.Entry table : Table.entrySet()) {
			System.out.println(table.getKey().toString() + " " + table.getValue().toString());
			String city_value = table.getKey().toString();
			String day_value = table.getValue().toString();
			weatherHomePage.user_should_enter_the_cityname(city_value);
			weatherHomePage.getDailyWeatherMaxForecastReport();
			weatherHomePage.getHourlyDaTaRainFallForDay(day_value);
			weatherHomePage.getHourlyWindSpeedDaTaForDay(day_value);
			weatherHomePage.getHourlyMinAndMaxDaTaForDay(day_value);
		}
		/*
		 * for (int i = 0; i < Table.size(); i++) { String city_value = Table.get(i).;
		 * String day_value = Table.get(i);
		 * weatherHomePage.user_should_enter_the_cityname(city_value);
		 * weatherHomePage.getDailyWeatherMaxForecastReport();
		 * weatherHomePage.getHourlyDaTaRainFallForDay(day_value);
		 * weatherHomePage.getHourlyWindSpeedDaTaForDay(day_value);
		 * weatherHomePage.getHourlyMinAndMaxDaTaForDay(day_value); }
		 */
	}

}