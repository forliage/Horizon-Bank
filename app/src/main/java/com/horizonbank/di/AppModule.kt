package com.horizonbank.di

import android.content.Context
import com.horizonbank.data.local.AppDatabase
import com.horizonbank.data.remote.api.BankApiService
import com.horizonbank.data.repository.AccountRepositoryImpl
import com.horizonbank.domain.repository.AccountRepository
import com.horizonbank.domain.usecase.GetAccountDetailsUseCase
import com.horizonbank.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Hilt依赖注入模块，用于提供在整个应用程序生命周期内存在的单例依赖。
 *
 * @InstallIn(SingletonComponent::class) 表示这个模块中的依赖项将在Application级别创建，
 * 并且是单例的。
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * 提供 AccountRepository 的实现。
     * 当有地方需要注入 AccountRepository 接口时，Hilt会使用这个方法创建并提供 AccountRepositoryImpl 实例。
     *
     * @param apiService Retrofit网络服务接口，由Hilt自动提供。
     * @param db AppDatabase数据库实例，由Hilt自动提供。
     * @return 返回AccountRepository的实现类实例。
     */
    @Provides
    @Singleton
    fun provideAccountRepository(apiService: BankApiService, db: AppDatabase): AccountRepository {
        // 在这里，我们返回了接口的实现类。
        // 这是依赖倒置原则的体现：高层模块(app)不直接依赖低层模块(data)的具体实现，而是依赖抽象(domain)。
        return AccountRepositoryImpl(apiService, db.transactionDao())
    }

    /**
     * 提供 LoginUseCase 的实例。
     * UseCase通常不需要是单例，但如果它没有内部状态，作为单例也无妨，可以节省对象创建开销。
     *
     * @param repository AccountRepository，由上面的 provideAccountRepository 方法提供。
     * @return 返回LoginUseCase的实例。
     */
    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AccountRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    /**
     * 提供 GetAccountDetailsUseCase 的实例。
     *
     * @param repository AccountRepository，由Hilt自动提供。
     * @return 返回GetAccountDetailsUseCase的实例。
     */
    @Provides
    @Singleton
    fun provideGetAccountDetailsUseCase(repository: AccountRepository): GetAccountDetailsUseCase {
        return GetAccountDetailsUseCase(repository)
    }

    // =================================================================================
    // 注意：下面的 provide... 方法应该移动到更合适的模块中（例如 `data` 模块的 DataModule）。
    // 这里暂时放置，是为了演示 AppModule 的完整性。
    // 在一个成熟的多模块项目中，`AppModule` 通常只保留需要 Context 的依赖项。
    // =================================================================================

    /**
     * 这是一个应该在 data 模块中定义的 provide 方法的示例。
     * 这里提供 Retrofit 的 ApiService 实例。
     * 实际实现会包含 Retrofit.Builder() 的逻辑。
     *
     * 返回值 `BankApiService` 是一个由 Retrofit 创建的接口实例。
     */
    @Provides
    @Singleton
    fun provideBankApiService(): BankApiService {
        // 占位代码：实际项目中这里会配置Retrofit客户端。
        // 例如:
        // return Retrofit.Builder()
        //     .baseUrl("https://api.horizonbank.com/")
        //     .addConverterFactory(GsonConverterFactory.create())
        //     .build()
        //     .create(BankApiService::class.java)

        // 目前我们返回一个占位对象，这会让代码可以编译通过。
        // 当你真正实现网络请求时，需要替换这部分。
        return object : BankApiService { /* TODO: 实现所有接口方法 */ }
    }

    /**
     * 这是一个应该在 data 模块中定义的 provide 方法的示例。
     * 这里提供 Room 数据库的实例。
     *
     * @param context Application的上下文，由Hilt通过@ApplicationContext自动提供。
     * @return 返回AppDatabase的单例实例。
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        // 占位代码：实际项目中这里会使用 Room.databaseBuilder() 创建数据库实例。
        // 例如:
        // return Room.databaseBuilder(
        //     context,
        //     AppDatabase::class.java,
        //     "horizon_bank_db"
        // ).build()

        // 目前我们返回一个占位的抽象类实例，以便编译。
        // 当你真正实现数据库时，需要替换这部分。
        return object : AppDatabase() {
            override fun transactionDao(): com.horizonbank.data.local.dao.TransactionDao {
                // 返回一个空的DAO实现
                return object : com.horizonbank.data.local.dao.TransactionDao { /* TODO: 实现所有DAO方法 */ }
            }
        }
    }
}