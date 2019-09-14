package com.kursivee.network_data.news.api

import com.kursivee.network_domain.news.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(@Query("country") country: String): Response<NewsResponse>
}