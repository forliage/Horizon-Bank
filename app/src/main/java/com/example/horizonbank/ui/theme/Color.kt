package com.example.horizonbank.ui.theme // 确保包名正确

import androidx.compose.ui.graphics.Color

// 这是Android Studio默认生成的颜色，可以保留也可以删除
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


// ---------------- 我们为 Horizon Bank 设计的颜色 ----------------

// --- 浅色模式 (Light Mode) 颜色 ---
// 主色调：体现信任和专业的蓝色系
val NavyBlue = Color(0xFF0D47A1)   // 深海军蓝，用作Primary主色，非常稳重
val DeepBlue = Color(0xFF1976D2)   // 深蓝色，用作Secondary次要色
val SkyBlue = Color(0xFF42A5F5)    // 天蓝色，可以用于一些提示或背景

// 强调色：用于需要用户注意的操作，如关键按钮或高亮提示
val VibrantOrange = Color(0xFFFF6D00) // 充满活力的橙色

// 中性色
val LightGrey = Color(0xFFF5F5F5) // 柔和的浅灰色，作为背景色，比纯白更护眼
val DarkGrey = Color(0xFF333333)  // 深灰色，用于正文文字
val MediumGrey = Color(0xFF888888) // 中度灰色，用于辅助性文字


// --- 深色模式 (Dark Mode) 颜色 ---
// 主色调
val DarkNavy = Color(0xFF1A237E)  // 深色模式下的主色，比浅色模式的NavyBlue更暗一些
val DarkSurface = Color(0xFF121212) // Material Design推荐的深色背景色，不是纯黑
val DarkCard = Color(0xFF1E1E1E)  // 深色模式下卡片的颜色，比背景稍亮

// 强调色在深色模式下可以保持不变，因为其本身就很醒目
// val VibrantOrange = Color(0xFFFF6D00) // 和浅色模式共用