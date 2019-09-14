package com.kursivee.framework_presentation.fragment.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kursivee.framework_domain.viewmodel.BaseViewModel
import com.kursivee.network_domain.news.model.NewsRequest
import com.kursivee.network_domain.news.usecase.GetTopHeadlines
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val getIpInformation: GetTopHeadlines
) : BaseViewModel() {
    private val mutableS: MutableLiveData<String> = MutableLiveData("")
    val s: LiveData<String> = mutableS

    fun getIPInfo(ipAddress: String) {
        request {
            val response = getIpInformation.execute(NewsRequest(ipAddress))
            response.fold(
                ifLeft = {
                    mutableS.postValue(it.message)
                },
                ifRight = {
                    mutableS.postValue(it.toString())
                }
            )
        }
    }
}
