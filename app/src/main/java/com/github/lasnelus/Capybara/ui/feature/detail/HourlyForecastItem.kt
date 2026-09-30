package com.github.lasnelus.Capybara.ui.feature.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.github.lasnelus.Capybara.R
import com.github.lasnelus.Capybara.domain.data.HourlyForecast
import com.github.lasnelus.Capybara.domain.data.WeatherCondition

@Composable
fun HourlyForecastItem(
    forecast: HourlyForecast,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(15.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = forecast.heure,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "${forecast.temp}°C",
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(end = 5.dp)
        )

        Image(
            painter = painterResource(
                when (forecast.condition) {
                    WeatherCondition.Sunny -> R.drawable.il_sunny
                    WeatherCondition.SunCloud -> R.drawable.il_sun_cloud
                    WeatherCondition.Cloud -> R.drawable.il_cloud
                    WeatherCondition.Fog -> R.drawable.il_fog
                    WeatherCondition.Rain -> R.drawable.il_rain
                    WeatherCondition.Snow -> R.drawable.il_snow
                    WeatherCondition.SnowStorm -> R.drawable.il_snow_storm
                    WeatherCondition.Moon -> R.drawable.il_moon
                }
            ),
            contentDescription = forecast.condition.raw,
            modifier = Modifier.size(50.dp)
        )
    }
}