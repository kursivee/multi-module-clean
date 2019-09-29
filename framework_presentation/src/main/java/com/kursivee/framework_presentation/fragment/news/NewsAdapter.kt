package com.kursivee.framework_presentation.fragment.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.kursivee.framework_data.recyclerview.DataAdapter
import com.kursivee.framework_presentation.databinding.ArticleLayoutBinding
import com.kursivee.network_domain.news.model.Article

class NewsAdapter(
    @LayoutRes layoutId: Int,
    articles: MutableList<Article> = mutableListOf(),
    private inline val onClick: (String?) -> Unit
): DataAdapter<Article, NewsViewHolder>(articles, layoutId) {

    override fun initViewHolder(parent: ViewGroup, view: View, viewType: Int): NewsViewHolder =
        ArticleLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).run {
            NewsViewHolder(this, onClick)
        }
}