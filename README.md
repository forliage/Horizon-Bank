# Horizon Bank - 现代银行客户端App

一个基于 Kotlin 和 Jetpack Compose 构建的现代化、界面美观的安卓银行App客户端。此项目旨在作为学习和实践最新Android技术的范例。

## ✨ 核心功能

*   **安全认证:** 支持用户名密码、生物识别（指纹/面容）登录。
*   **账户总览:** 在主页清晰展示总资产和各个账户（储蓄卡、信用卡）的详情。
*   **快捷操作:** 提供转账、付款、扫一扫等常用功能的快速入口。
*   **交易流水:** 查看完整的交易历史，并支持筛选和搜索。
*   **智能分析:** (亮点功能) 对消费进行自动分类，并通过图表进行可视化展示。
*   **个性化设置:** 支持深色/浅色主题切换。

## 🛠️ 技术栈与架构

本项目采用业界推荐的现代化技术栈和架构，确保代码的健壮性、可维护性和可扩展性。

*   **开发语言:** [Kotlin](https://kotlinlang.org/) (100% Kotlin First)
*   **UI框架:** [Jetpack Compose](https://developer.android.com/jetpack/compose) - 用于构建声明式、响应迅速的精美UI。
*   **架构模式:** **MVVM (Model-View-ViewModel)** 结合 **Clean Architecture** (多模块)。
    *   **`app` (Presentation Layer):** UI层，负责界面展示和用户交互。
    *   **`data` (Data Layer):** 数据层，负责从网络或本地数据库获取数据。
    *   **`domain` (Domain Layer):** 领域层，包含核心业务逻辑和模型，完全独立于Android框架。
*   **核心Jetpack组件:**
    *   **ViewModel:** 管理UI相关的状态和逻辑。
    *   **Navigation Component:** 管理App内的导航流程。
    *   **Room:** 用于本地数据持久化。
    *   **Hilt:** 用于依赖注入，解耦组件。
*   **异步处理:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) + [Flow](https://developer.android.com/kotlin/flow) - 处理所有异步任务。
*   **网络请求:** [Retrofit2](https://square.github.io/retrofit/) + [OkHttp3](https://square.github.io/okhttp/)
*   **UI设计:** [Material 3](https://m3.material.io/) - 遵循最新的Google设计规范，支持动态颜色。

## 🚀 如何开始

1.  **克隆仓库**
    ```bash
    git clone https://your-repository-url.git
    ```
2.  **打开项目**
    使用最新版的 [Android Studio](https://developer.android.com/studio) 打开项目。
3.  **Gradle同步**
    等待Android Studio自动完成Gradle同步和依赖下载。
4.  **构建和运行**
    点击 `Run 'app'` 按钮，在模拟器或真实设备上运行App。

## 📸 截图 (待添加)

<!-- 在这里添加你的App截图 -->
<p align="center">
  <img src="path/to/screenshot1.png" width="200" alt="登录页">
  <img src="path/to/screenshot2.png" width="200" alt="主页">
  <img src="path/to/screenshot3.png" width="200" alt="消费分析">
</p>

## 📄 许可

[MIT License](LICENSE)