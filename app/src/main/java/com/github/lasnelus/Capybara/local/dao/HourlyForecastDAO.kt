package com.github.lasnelus.Capybara.local.dao

import androidx.room3.Dao
import androidx.room3.Upsert
import androidx.room3.Query
import com.github.lasnelus.Capybara.local.entity.HourlyForecastEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HourlyForecastDAO {

    @Upsert
    suspend fun upsert(forecast: List<HourlyForecastEntity>) {
    }

    @Query("SELECT * FROM hourly_forecast")
    fun getForecast() : Flow<List<HourlyForecastEntity>>

}