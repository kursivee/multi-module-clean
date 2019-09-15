package com.kursivee.framework_presentation.fragment.news.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kursivee.framework_presentation.fragment.news.NewsViewModel
import com.kursivee.framework_presentation.fragment.viewmodel.ViewModelFactory
import com.kursivee.framework_presentation.fragment.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun provdieViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun provideNewsViewModel(newsViewModel: NewsViewModel): ViewModel
}