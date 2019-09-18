package com.kursivee.framework_presentation.fragment.news.udf

import com.kursivee.framework_data.udf.UdfStore
import javax.inject.Inject

class NewsStore @Inject constructor(
    reducer: NewsReducer,
    state: NewsState
): UdfStore<NewsAction, NewsReducer, NewsState>(reducer, state)