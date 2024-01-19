package com.raiffeisen.app.di

import com.raiffeisen.app.BuildConfig
import com.raiffeisen.app.data.datasource.UserDataSource
import com.raiffeisen.app.data.datasource.remote.RemoteUserDataSource
import com.raiffeisen.app.data.datasource.remote.api.UserApi
import com.raiffeisen.app.data.datasource.repository.UserRepository
import com.raiffeisen.app.data.datasource.repository.UserRepositoryImpl
import com.raiffeisen.app.domain.model.UserModelMapper
import com.raiffeisen.app.domain.usecase.GetUserListUseCase
import com.raiffeisen.app.domain.usecase.GetUserListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Singleton
    @Provides
    fun providesUserDataSource(userApi: UserApi): UserDataSource = RemoteUserDataSource(userApi)

    @Singleton
    @Provides
    fun providesUserRepository(dataSource: UserDataSource): UserRepository =
        UserRepositoryImpl(dataSource)

    @Singleton
    @Provides
    fun provideUserModelMapper() = UserModelMapper

    @Singleton
    @Provides
    fun provideGetUserModelListUseCase(
        repository: UserRepository,
        modelMapper: UserModelMapper
    ): GetUserListUseCase = GetUserListUseCaseImpl(repository, modelMapper)
}