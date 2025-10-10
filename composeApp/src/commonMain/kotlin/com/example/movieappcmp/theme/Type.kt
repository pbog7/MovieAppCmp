package com.example.movieappcmp.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import movieappcmp.composeapp.generated.resources.Res
import movieappcmp.composeapp.generated.resources.roboto_bold
import movieappcmp.composeapp.generated.resources.roboto_medium
import movieappcmp.composeapp.generated.resources.roboto_regular
import org.jetbrains.compose.resources.Font


@Composable
fun getAppTypography(): Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = regularFontFamily()),
    displayMedium = baseline.displayMedium.copy(fontFamily = regularFontFamily()),
    displaySmall = baseline.displaySmall.copy(fontFamily = regularFontFamily()),

    headlineLarge = baseline.headlineLarge.copy(fontFamily = boldFontFamily()),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = boldFontFamily()),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = boldFontFamily()),

    titleLarge = baseline.titleLarge.copy(fontFamily = mediumFontFamily()),
    titleMedium = baseline.titleMedium.copy(fontFamily = mediumFontFamily()),
    titleSmall = baseline.titleSmall.copy(fontFamily = mediumFontFamily()),

    bodyLarge = baseline.bodyLarge.copy(fontFamily = regularFontFamily()),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = regularFontFamily()),
    bodySmall = baseline.bodySmall.copy(fontFamily = regularFontFamily()),

    labelLarge = baseline.labelLarge.copy(fontFamily = regularFontFamily()),
    labelMedium = baseline.labelMedium.copy(fontFamily = regularFontFamily()),
    labelSmall = baseline.labelSmall.copy(fontFamily = regularFontFamily())
)


@Composable
fun boldFontFamily() = FontFamily(
    Font(Res.font.roboto_bold, weight = FontWeight.Bold)
)

@Composable
fun regularFontFamily() = FontFamily(
    Font(Res.font.roboto_regular, weight = FontWeight.Normal)
)

@Composable
fun mediumFontFamily() = FontFamily(
    Font(Res.font.roboto_medium, weight = FontWeight.Medium)
)
val baseline = Typography()



