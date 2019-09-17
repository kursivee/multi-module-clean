package com.kursivee.framework_presentation.fragment.news

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.kursivee.framework_domain.viewmodel.BaseViewModel
import com.kursivee.network_domain.news.model.Article
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.usecase.GetTopHeadlines
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getIpInformation: GetTopHeadlines
) : BaseViewModel() {
    private val mutableArticles: MutableLiveData<List<Article>> = MutableLiveData(emptyList())
    val articles: LiveData<List<Article>> = mutableArticles

    fun getTopHeadlines(ipAddress: String) {
        request {
            val response = getIpInformation.execute(NewsRequest(ipAddress))
            response.fold(
                ifLeft = {
                    mutableError.postValue(it.message)
                },
                ifRight = {
                    mutableArticles.postValue(it.articles.toList())
                }
            )
        }
    }
}
