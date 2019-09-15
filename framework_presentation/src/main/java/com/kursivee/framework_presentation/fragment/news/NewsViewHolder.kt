package com.kursivee.framework_presentation.fragment.news

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.kursivee.framework_data.recyclerview.CustomViewHolder
import com.kursivee.framework_presentation.R
import com.kursivee.network_domain.news.model.Article

class NewsViewHolder(
    private val container: View,
    private val onClick: (String) -> Unit
): CustomViewHolder(container) {

    private val image: ImageView = container.findViewById(R.id.iv_article)
    private val title: TextView = container.findViewById(R.id.tv_title)
    private val author: TextView = container.findViewById(R.id.tv_author)

    fun bind(article: Article) {
        render(image, article.urlToImage)
        render(title, article.title)
        render(author, article.author)
        article.url?.let { url ->
            container.setOnClickListener {
                onClick(url)
            }
        }
    }
}