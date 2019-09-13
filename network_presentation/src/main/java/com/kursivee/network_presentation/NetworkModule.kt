package com.kursivee.network_presentation

import com.kursivee.network_data.api.FakeIPApi
import com.kursivee.network_data.repository.IPRepositoryImpl
import com.kursivee.network_domain.api.IPApi
import com.kursivee.network_domain.repostiory.IPRepository
import dagger.Binds
import dagger.Module

@Module
abstract class NetworkModule {
    @Binds
    abstract fun provideIPRepository(repository: IPRepositoryImpl): IPRepository

    @Binds
    abstract fun provideIPApi(mockIPApi: FakeIPApi): IPApi
}