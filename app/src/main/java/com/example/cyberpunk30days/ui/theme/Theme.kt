package com.example.cyberpunk30days.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    background = backgroundLight,
    surface = containerIdleLight,
    surfaceVariant = containerSelectedLight,
    onSurface = textIdleLight,
    onSurfaceVariant = textSelectedLight,
    primary = displayFontLight,
    outline = outlineIdleLight,
    outlineVariant = outlineSelectedLight
)

private val DarkColorScheme = darkColorScheme(
    background = backgroundDark,
    surface = containerIdleDark,
    surfaceVariant = containerSelectedDark,
    onSurface = textIdleDark,
    onSurfaceVariant = textSelectedDark,
    primary = displayFontDark,
    outline = outlineIdleDark,
    outlineVariant = outlineSelectedDark
)

@Composable
fun Cyberpunk30DaysTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}