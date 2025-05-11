package com.example.jetpackcomposeassignment1.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Pink80 = Color(0xFFE1BEE7)
val Pink40 = Color(0xFFCE93D8)

private val LightColorScheme = lightColorScheme(
    primary = Pink40, // Using a lighter pink as primary
    onPrimary = Color.White,
    surface = Color(0xFFF3E5F5),
    onSurface = Color.Black,
    background = Color(0xFFF3E5F5),
    onBackground = Color.Black,
)


private val DarkColorScheme = darkColorScheme(
    primary = Pink80, // Using a darker pink as primary in dark mode
    onPrimary = Color.White,
    surface = Color(0xFF1C1B27),
    onSurface = Color.White,
    background = Color(0xFF121118),
    onBackground = Color.White,
)

@Composable
fun JetpackComposeAssignment1Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}