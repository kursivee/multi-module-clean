package com.kursivee.framework_presentation.fragment.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kursivee.framework_domain.viewmodel.BaseViewModel
import com.kursivee.network_domain.news.model.Article
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.usecase.GetTopHeadlines
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getIpInformation: GetTopHeadlines
) : BaseViewModel() {
    private val mutableS: MutableLiveData<List<Article>> = MutableLiveData(emptyList())
    val s: LiveData<List<Article>> = mutableS

    fun getTopHeadlines(ipAddress: String) {
        request {
            val response = getIpInformation.execute(NewsRequest(ipAddress))
            response.fold(
                ifLeft = {
                    mutableError.postValue(it.message)
                },
                ifRight = {
                    mutableS.postValue(it.articles.toList())
                }
            )
        }
    }
}
