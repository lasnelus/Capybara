package com.github.lasnelus.Capybara.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.github.lasnelus.Capybara.R

private val NunitoFontFamily: FontFamily = FontFamily(
    Font(resId = R.font.nunitoblack, weight = FontWeight.Black),
    Font(resId = R.font.nunitobold, weight = FontWeight.Bold),
    Font(resId = R.font.nunitomedium, weight = FontWeight.Medium),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = NunitoFontFamily,
        fontSize = 70.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Black
    ),
    titleMedium = TextStyle(
        fontFamily = NunitoFontFamily,
        fontSize = 50.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontFamily = NunitoFontFamily,
        fontSize = 70.sp,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Medium
    ),
)