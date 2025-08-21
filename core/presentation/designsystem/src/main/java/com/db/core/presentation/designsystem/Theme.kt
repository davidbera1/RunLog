package com.db.core.presentation.designsystem

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val DarkColorScheme = darkColorScheme(
    primary = RunLogGreen,
    background = RunLogBlack,
    surface = RunLogDarkGray,
    secondary = RunLogWhite,
    tertiary = RunLogWhite,
    primaryContainer = RunLogGreen30,
    onPrimary = RunLogBlack,
    onBackground = RunLogWhite,
    onSurface = RunLogWhite,
    onSurfaceVariant = RunLogGray,
    error = RunLogDarkRed,
    errorContainer = RunLogDarkRed5
)

@Composable
fun RunLogTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}