package com.kursivee.framework_presentation.fragment.news

import android.view.View
import androidx.annotation.LayoutRes
import com.kursivee.framework_data.recyclerview.DataAdapter
import com.kursivee.network_domain.news.model.Article

class NewsAdapter(
    @LayoutRes layoutId: Int,
    articles: MutableList<Article> = mutableListOf(),
    private val onClick: (String) -> Unit
): DataAdapter<Article, NewsViewHolder>(articles, layoutId) {
    override fun initViewHolder(view: View, viewType: Int): NewsViewHolder = NewsViewHolder(view, onClick)
}