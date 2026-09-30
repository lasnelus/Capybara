package com.github.lasnelus.Capybara.local.entity

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.github.lasnelus.Capybara.domain.data.HourlyForecast
import com.github.lasnelus.Capybara.domain.data.WeatherCondition

@Entity(tableName = "hourly_forecast")
data class HourlyForecastEntity(
    @PrimaryKey @ColumnInfo(name = "hour") val hour: String,
    @ColumnInfo(name = "temperature") val temperature: Int,
    @ColumnInfo(name = "condition") val condition: WeatherCondition
) {
    fun toHourlyForecast(): HourlyForecast {
        return HourlyForecast(hour, temperature, condition)
    }

    companion object {
        fun fromHourlyForecast(forecast: HourlyForecast): HourlyForecastEntity {
            return HourlyForecastEntity(
                forecast.heure,
                forecast.temp,
                forecast.condition
            )
        }
    }
}
