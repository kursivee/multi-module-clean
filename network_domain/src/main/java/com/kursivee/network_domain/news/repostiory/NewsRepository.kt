package com.kursivee.network_domain.news.repostiory

import arrow.core.Either
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.model.NewsResponse
import com.kursivee.network_domain.common.model.NetworkError

interface NewsRepository {
    suspend fun getTopHeadlines(request: NewsRequest): Either<NetworkError, NewsResponse>
}