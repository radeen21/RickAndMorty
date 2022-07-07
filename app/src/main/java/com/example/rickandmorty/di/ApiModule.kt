package com.example.rickandmorty.di

import com.example.rickandmorty.MyApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideWebApiBasicProvider(): WebApiOAuthProvider = WebApiOAuthProvider

    @Singleton
    @Provides
    fun provideRetrofit(
        webApiOauthProvider: WebApiOAuthProvider,
        myApplication: MyApplication
    ): Retrofit = webApiOauthProvider.getRetrofit(myApplication.getBaseUrl())
}