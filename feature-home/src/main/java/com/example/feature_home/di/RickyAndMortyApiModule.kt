package com.example.feature_home.di

import com.example.data.api.ApiService
import com.example.data.mapper.RickyAndMortyMapper
import com.example.data.repoimpl.RickyAndMortyRepoImpl
import com.example.domain.repository.RickyAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RickyAndMortyApiModule {

    @Singleton
    @Provides
    fun provideRickyAndMortyRepository(apiService: ApiService): RickyAndMortyRepository =
        RickyAndMortyRepoImpl(
            apiService, RickyAndMortyMapper()
        )

    @Singleton
    @Provides
    fun provideRickyAndMortyApi(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java
    )

}