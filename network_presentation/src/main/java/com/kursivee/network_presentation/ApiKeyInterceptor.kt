package com.kursivee.network_presentation

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.request().run {
            val url = url().newBuilder()
                .addQueryParameter("apiKey", apiKey)
                .build()
            val request = newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        }
}