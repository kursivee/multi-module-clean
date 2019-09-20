package com.kursivee.network_domain.news.usecase

import arrow.core.Either
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.model.NewsResponse
import com.kursivee.network_domain.common.model.NetworkError
import com.kursivee.network_domain.common.usecase.BaseUseCase
import com.kursivee.network_domain.news.repostiory.NewsRepository
import javax.inject.Inject

class GetTopHeadlines @Inject constructor(
    private val repository: NewsRepository
): BaseUseCase<Either<NetworkError, NewsResponse>, NewsRequest>() {
    override suspend operator fun invoke(params: NewsRequest): Either<NetworkError, NewsResponse> =
        repository.getTopHeadlines(params)
}