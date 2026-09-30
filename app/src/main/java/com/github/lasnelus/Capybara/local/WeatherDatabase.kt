package com.github.lasnelus.Capybara.local

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.github.lasnelus.Capybara.local.dao.HourlyForecastDAO
import com.github.lasnelus.Capybara.local.entity.HourlyForecastEntity

@Database(
    entities = [/*DailyForecastEntity::class,*/ HourlyForecastEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WeatherDatabase : RoomDatabase() {
    //    abstract fun dailyForecastDao() : DailyForecastDao
    abstract fun hourlyForecastDao(): HourlyForecastDAO

    companion object {
        private const val DB_NAME = "Capybara.db"

        @Volatile
        private var INSTANCE: WeatherDatabase? = null

        fun get(context: Context): WeatherDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    Room.databaseBuilder(context, WeatherDatabase::class.java, DB_NAME).build()
                        .also { INSTANCE = it }
                }
            }
            return INSTANCE!!
        }
    }
}

data object WeatherDatabaseHolder {
    var database: WeatherDatabase? = null

    fun initialize(context: Context) {
        database = WeatherDatabase.get(context)
    }
}