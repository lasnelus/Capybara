package com.github.lasnelus.Capybara.repository

import com.github.lasnelus.Capybara.domain.data.HourlyForecast
import com.github.lasnelus.Capybara.domain.data.WeatherCondition
import com.github.lasnelus.Capybara.local.WeatherDatabaseHolder
import com.github.lasnelus.Capybara.local.entity.HourlyForecastEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

object WeatherRepository {
    suspend fun setHourlyForecast() {
        WeatherDatabaseHolder.database?.hourlyForecastDao()?.upsert(
            listOf(
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("0h", 18, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("1h", 17, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("2h", 17, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("3h", 17, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("4h", 16, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("5h", 16, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("6h", 15, WeatherCondition.Moon) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("7h", 16, WeatherCondition.Cloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("8h", 17, WeatherCondition.Cloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("9h", 18, WeatherCondition.Cloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("10h", 18, WeatherCondition.SunCloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("11h", 19, WeatherCondition.SunCloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("12h", 20, WeatherCondition.Sunny) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("13h", 20, WeatherCondition.Sunny) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("14h", 21, WeatherCondition.Sunny) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("15h", 21, WeatherCondition.Sunny) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("16h", 20, WeatherCondition.SunCloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("17h", 20, WeatherCondition.Cloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("18h", 20, WeatherCondition.Rain) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("19h", 20, WeatherCondition.Rain) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("20h", 19, WeatherCondition.Rain) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("21h", 19, WeatherCondition.Cloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("22h", 18, WeatherCondition.Cloud) ),
                HourlyForecastEntity.fromHourlyForecast( HourlyForecast("23h", 18, WeatherCondition.Cloud) ),
                )
        )
    }

    fun getHourlyForecast(): Flow<List<HourlyForecast>> {
        return WeatherDatabaseHolder.database?.hourlyForecastDao()?.getForecast()
            ?.map { it.map { it.toHourlyForecast() } } ?: flowOf( emptyList())
    }
}