package com.kursivee.framework_presentation.fragment.news.di

import com.kursivee.framework_presentation.fragment.di.FragmentScope
import com.kursivee.framework_presentation.fragment.news.udf.NewsState
import dagger.Module
import dagger.Provides

@Module
object UdfModule {
    @Provides
    @JvmStatic
    @FragmentScope
    fun provideNewsState(): NewsState = NewsState()
}