package com.kursivee.network_presentation.di

import com.kursivee.network_data.news.repository.NewsRepositoryImpl
import com.kursivee.network_domain.news.repostiory.NewsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkModule {
    @Binds
    abstract fun provideIPRepository(repository: NewsRepositoryImpl): NewsRepository
}