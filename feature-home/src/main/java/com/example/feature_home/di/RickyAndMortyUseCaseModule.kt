package com.example.feature_home.di

import com.example.domain.PostExecutionThread
import com.example.domain.interactor.RickyAndMortyUseCase
import com.example.domain.repository.RickyAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RickyAndMortyUseCaseModule {

    @Provides
    @ViewModelScoped
    fun providePostRequestRickyAndMorty(
        repository: RickyAndMortyRepository,
        postExecutionThread: PostExecutionThread
    ): RickyAndMortyUseCase {
        return RickyAndMortyUseCase(repository, postExecutionThread)
    }
}