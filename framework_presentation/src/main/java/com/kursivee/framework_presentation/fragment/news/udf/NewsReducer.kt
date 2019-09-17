package com.kursivee.framework_presentation.fragment.news.udf

import com.kursivee.framework_domain.udf.UdfReducer
import javax.inject.Inject

class NewsReducer @Inject constructor(): UdfReducer<NewsAction, NewsState>() {
    override fun reduce(state: NewsState, action: NewsAction): NewsState =
        when(action) {
            is NewsAction.Request -> state.copy(loading = action.loading)
            is NewsAction.RequestNewsSuccess -> state.copy(loading = action.loading, articles = action.articles)
            is NewsAction.RequestNewsFailure -> state.copy(loading = action.loading, error = action.error)
        }
}