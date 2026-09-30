package com.github.lasnelus.Capybara.ui.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.lasnelus.Capybara.domain.data.HourlyForecast
import com.github.lasnelus.Capybara.domain.usecase.GetHourlyForecastUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _hourlyForecast = MutableStateFlow<List<HourlyForecast>>(emptyList())
    val hourlyForecast = _hourlyForecast.asStateFlow()

    fun fetchHourlyForecast(date: String) {
        viewModelScope.launch {
            _hourlyForecast.value = GetHourlyForecastUseCase.invoke(date)
        }
    }
}