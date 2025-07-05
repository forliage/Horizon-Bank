package com.example.horizonbank.ui.theme // 确保包名正确

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// 我们为深色模式定义的颜色方案
private val DarkColorScheme = darkColorScheme(
    primary = DeepBlue,        // 在深色背景下，使用一个稍亮的主色调会更突出
    secondary = SkyBlue,
    tertiary = VibrantOrange,
    background = DarkSurface,  // 使用我们定义的深色背景
    surface = DarkCard,        // 使用我们定义的卡片颜色
    onPrimary = Color.White,   // 主色上的文字颜色
    onSecondary = Color.Black,
    onTertiary = Color.Black,
    onBackground = Color.White, // 背景上的文字颜色
    onSurface = Color.White,    // 卡片上的文字颜色
)

// 我们为浅色模式定义的颜色方案
private val LightColorScheme = lightColorScheme(
    primary = NavyBlue,
    secondary = DeepBlue,
    tertiary = VibrantOrange,
    background = LightGrey, // 使用我们定义的浅灰色背景
    surface = Color.White,  // 卡片等表面使用纯白，形成对比
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = DarkGrey,  // 背景上的文字使用深灰色
    onSurface = DarkGrey,     // 卡片上的文字使用深灰色
)

@Composable
fun HorizonBankTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // 动态颜色功能，在Android 12及以上版本可用
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Typography.kt 我们还没修改，暂时用默认的
        content = content
    )
}