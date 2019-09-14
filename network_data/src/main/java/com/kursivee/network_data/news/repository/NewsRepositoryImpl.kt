package com.kursivee.network_data.news.repository

import arrow.core.Either
import com.kursivee.network_data.ext.adapt
import com.kursivee.network_data.news.api.NewsApi
import com.kursivee.network_domain.common.model.NetworkError
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.model.NewsResponse
import com.kursivee.network_domain.news.repostiory.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
): NewsRepository {
    override suspend fun getTopHeadlines(request: NewsRequest): Either<NetworkError, NewsResponse> =
        api.getTopHeadlines(request.country).adapt()
}