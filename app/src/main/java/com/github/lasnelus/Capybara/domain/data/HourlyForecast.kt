package com.github.lasnelus.Capybara.domain.data

class HourlyForecast(
    var heure: String,
    var temp: Int,
    var condition: WeatherCondition
) {
    override fun toString(): String {
        return "$heure - $temp°C - $condition"
    }
}