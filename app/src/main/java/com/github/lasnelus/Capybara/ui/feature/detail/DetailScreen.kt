package com.github.lasnelus.Capybara.ui.feature.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.github.lasnelus.Capybara.R
import com.github.lasnelus.Capybara.domain.usecase.GetHourlyForecastUseCase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onBackClick : () -> Unit,
    date: String
) {
    val forecast = GetHourlyForecastUseCase.invoke(date)
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = date,
                    color = MaterialTheme.colorScheme.onBackground,
                    style  = MaterialTheme.typography.bodyLarge
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {onBackClick()}
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back_arrow),
                        contentDescription = ""
                    )
                }
            }
        )
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(forecast) {
                forecast ->
                Text(
                    text = forecast.toString(),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}