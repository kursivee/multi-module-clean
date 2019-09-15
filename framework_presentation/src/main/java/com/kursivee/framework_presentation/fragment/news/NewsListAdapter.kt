package com.kursivee.framework_presentation.fragment.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kursivee.framework_presentation.R
import com.kursivee.network_domain.news.model.Article

class NewsListAdapter(
    private var articles: MutableList<Article> = mutableListOf(),
    private val onClick: (String) -> Unit
): RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val container = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_layout, parent, false)
        return NewsViewHolder(container, onClick)
    }

    override fun getItemCount(): Int = articles.size

    fun updateList(articles: List<Article>) {
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }
}