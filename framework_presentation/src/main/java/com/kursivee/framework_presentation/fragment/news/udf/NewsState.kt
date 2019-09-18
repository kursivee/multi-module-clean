package com.kursivee.framework_presentation.fragment.news.udf

import com.kursivee.framework_data.udf.State
import com.kursivee.network_domain.news.model.Article

data class NewsState(
    val loading: Boolean = false,
    val country: String = "",
    val articles: List<Article> = emptyList(),
    val error: String = ""
): State