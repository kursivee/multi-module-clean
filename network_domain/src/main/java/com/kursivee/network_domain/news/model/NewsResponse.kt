package com.kursivee.network_domain.news.model

data class NewsResponse(
    val status: String?,
    val totalResults: Int,
    val articles: Array<Article>
) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}