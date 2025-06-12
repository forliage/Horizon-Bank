package com.horizonbank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.horizonbank.ui.theme.HorizonBankTheme // 确保你的主题文件路径正确

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 使用我们自定义的HorizonBankTheme主题
            HorizonBankTheme {
                // Surface是Compose中一个基本的带背景色的容器
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // 这里是未来整个App的入口
                    // 当你写好 AppNavigation.kt 后，就可以在这里调用它了
                    // 比如: AppNavigation()
                    
                    // 目前，我们先显示一个占位屏幕
                    DevelopmentPlaceholderScreen()
                }
            }
        }
    }
}

/**
 * 一个用于占位的Composable函数，提示App正在开发中。
 */
@Composable
fun DevelopmentPlaceholderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        // 垂直居中
        verticalArrangement = Arrangement.Center,
        // 水平居中
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Logo 或名称
        Text(
            text = "Horizon Bank",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 欢迎信息
        Text(
            text = "欢迎来到未来的银行",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 状态提示
        Text(
            text = "🚀 功能正在火速开发中...",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) // 使用一点透明度
        )
    }
}

/**
 * Preview注解可以让你在Android Studio的设计视图中实时预览Composable函数的效果，
 * 无需运行整个App。
 */
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HorizonBankTheme {
        DevelopmentPlaceholderScreen()
    }
}