package com.kursivee.framework_presentation.fragment.news

import com.kursivee.framework_data.recyclerview.CustomViewHolder
import com.kursivee.framework_presentation.databinding.ArticleLayoutBinding
import com.kursivee.network_domain.news.model.Article

class NewsViewHolder(
    private val binding: ArticleLayoutBinding,
    private val onClickArticle: (String?) -> Unit
): CustomViewHolder<Article>(binding.root), OnArticleClickListener {

    override fun bind(data: Article) {
        binding.article = data
        binding.onClickArticle = this
        binding.executePendingBindings()
    }

    override fun onClick(url: String?) {
        onClickArticle(url)
    }
}