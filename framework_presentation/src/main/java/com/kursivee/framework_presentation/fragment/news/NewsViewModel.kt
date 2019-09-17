package com.kursivee.framework_presentation.fragment.news

import com.kursivee.framework_domain.viewmodel.UdfViewModel
import com.kursivee.framework_presentation.fragment.news.udf.NewsAction
import com.kursivee.framework_presentation.fragment.news.udf.NewsReducer
import com.kursivee.framework_presentation.fragment.news.udf.NewsState
import com.kursivee.framework_presentation.fragment.news.udf.NewsStore
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.usecase.GetTopHeadlines
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getIpInformation: GetTopHeadlines,
    val store: NewsStore
) : UdfViewModel<NewsAction, NewsState, NewsReducer>(store) {

    override val loadingAction: NewsAction = NewsAction.Request()

    fun getTopHeadlines(country: String) {
        request {
            val response = getIpInformation.execute(NewsRequest(country))
            response.fold(
                ifLeft = {
                    store.dispatch(NewsAction.RequestNewsFailure(error = it.message))
                },
                ifRight = {
                    store.dispatch(NewsAction.RequestNewsSuccess(articles = it.articles.toList()))
                }
            )
        }
    }
}
