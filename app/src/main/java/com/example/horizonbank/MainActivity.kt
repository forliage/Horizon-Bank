package com.example.horizonbank // 请确保这里的包名和你项目的一致

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.horizonbank.ui.theme.HorizonBankTheme // 确保这个import路径正确

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // HorizonBankTheme 是我们App的主题，它包裹了整个UI
            HorizonBankTheme {
                // Surface 是一个带有背景色的容器
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen() // 这里调用我们自己创建的登录界面
                }
            }
        }
    }
}

// @Composable 注解表明这是一个UI组件函数
@Composable
fun LoginScreen() {
    // Column 是一个垂直布局的容器，它会让里面的元素从上到下排列
    Column(
        modifier = Modifier
            .fillMaxSize() // 充满整个屏幕
            .padding(32.dp), // 在四周添加32dp的内边距
        verticalArrangement = Arrangement.Center, // 垂直居中
        horizontalAlignment = Alignment.CenterHorizontally // 水平居中
    ) {
        // 1. App Logo/Title
        Text(
            text = "Horizon Bank",
            fontSize = 32.sp, // 字体大小
            fontWeight = FontWeight.Bold, // 字体加粗
            color = MaterialTheme.colorScheme.primary // 使用主题的主颜色
        )

        Spacer(modifier = Modifier.height(48.dp)) // 添加一个垂直间距

        // 2. Username Input Field
        var username by remember { mutableStateOf("") } // 创建一个变量来“记住”输入框的内容
        OutlinedTextField(
            value = username, // 输入框的当前值
            onValueChange = { username = it }, // 当用户输入时，更新变量的值
            label = { Text("用户名") }, // 输入框的标签
            modifier = Modifier.fillMaxWidth() // 宽度充满父容器
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 3. Password Input Field
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("密码") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        // 4. Login Button
        Button(
            onClick = { /* 登录逻辑暂时留空 */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "登 录", fontSize = 18.sp)
        }
    }
}

// @Preview 注解能让你在Android Studio中直接预览UI，无需运行到手机或模拟器上
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    HorizonBankTheme {
        LoginScreen()
    }
}