package com.github.lasnelus.Capybara.domain.usecase

import com.github.lasnelus.Capybara.domain.data.HourlyForecast
import com.github.lasnelus.Capybara.domain.data.WeatherCondition

object GetHourlyForecastUseCase {
    fun invoke(date: String): List<HourlyForecast> {
        return listOf(
            HourlyForecast("0h", 18, WeatherCondition.Moon),
            HourlyForecast("1h", 17, WeatherCondition.Moon),
            HourlyForecast("2h", 17, WeatherCondition.Moon),
            HourlyForecast("3h", 17, WeatherCondition.Moon),
            HourlyForecast("4h", 16, WeatherCondition.Moon),
            HourlyForecast("5h", 16, WeatherCondition.Moon),
            HourlyForecast("6h", 15, WeatherCondition.Moon),
            HourlyForecast("7h", 16, WeatherCondition.Cloud),
            HourlyForecast("8h", 17, WeatherCondition.Cloud),
            HourlyForecast("8h", 17, WeatherCondition.Cloud),
            HourlyForecast("9h", 18, WeatherCondition.Cloud),
            HourlyForecast("10h", 18, WeatherCondition.SunCloud),
            HourlyForecast("11h", 19, WeatherCondition.SunCloud),
            HourlyForecast("12h", 20, WeatherCondition.Sunny),
            HourlyForecast("13h", 20, WeatherCondition.Sunny),
            HourlyForecast("14h", 21, WeatherCondition.Sunny),
            HourlyForecast("15h", 21, WeatherCondition.Sunny),
            HourlyForecast("16h", 20, WeatherCondition.SunCloud),
            HourlyForecast("17h", 20, WeatherCondition.Cloud),
            HourlyForecast("18h", 20, WeatherCondition.Rain),
            HourlyForecast("19h", 20, WeatherCondition.Rain),
            HourlyForecast("20h", 19, WeatherCondition.Rain),
            HourlyForecast("21h", 19, WeatherCondition.Cloud),
            HourlyForecast("22h", 18, WeatherCondition.Cloud),
            HourlyForecast("23h", 18, WeatherCondition.Cloud),
        )
    }
}