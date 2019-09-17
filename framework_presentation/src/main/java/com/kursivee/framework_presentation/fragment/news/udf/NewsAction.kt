package com.kursivee.framework_presentation.fragment.news.udf

import com.kursivee.framework_domain.udf.Action
import com.kursivee.network_domain.news.model.Article

sealed class NewsAction: Action {
    data class Request(val loading: Boolean = true): NewsAction()
    data class RequestNewsSuccess(
        val loading: Boolean = false,
        val articles: List<Article>
    ): NewsAction()
    data class RequestNewsFailure(
        val loading: Boolean = false,
        val error: String
    ): NewsAction()
}