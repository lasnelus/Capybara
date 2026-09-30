package com.github.lasnelus.Capybara.domain.usecase

import com.github.lasnelus.Capybara.domain.data.HourlyForecast
import com.github.lasnelus.Capybara.domain.data.WeatherCondition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object GetHourlyForecastUseCase {
    fun invoke(): Flow<List<HourlyForecast>> {
        return flowOf(
            listOf(

            )
        )
    }
}