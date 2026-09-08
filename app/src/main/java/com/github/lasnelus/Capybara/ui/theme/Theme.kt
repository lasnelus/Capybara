package com.github.lasnelus.Capybara.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = Blue800,
    surface = Blue600,
    primary = Blue300,
    primaryContainer = Blue600,
    secondary = Gray500,
    onSecondary = White,
    tertiary = Gray500
)

private val LightColorScheme = lightColorScheme(
    background = Gray400,
    surface = White,
    primary = Blue400,
    primaryContainer = Blue100,
    secondary = Blue600,
    onSecondary = White,
    tertiary = Gray700
)

@Composable
fun CapybaraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content:@Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}