package com.kursivee.network_presentation.di

import com.kursivee.network_data.news.api.NewsApi
import com.kursivee.network_presentation.ApiKeyInterceptor
import com.kursivee.network_presentation.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object RetrofitModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideOkHttpClient(@Named("apiKey") apiKey: String): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiKeyInterceptor(apiKey))
        .build()

    @Provides
    @JvmStatic
    @Singleton
    @Named("apiKey")
    fun provideApiKey(): String = BuildConfig.API_KEY

    @Provides
    @Singleton
    @JvmStatic
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://newsapi.org")
        .build()

    @Provides
    @Singleton
    @JvmStatic
    fun provideMoshi() = Moshi.Builder().build()

    @Provides
    @JvmStatic
    fun provideIPApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
}