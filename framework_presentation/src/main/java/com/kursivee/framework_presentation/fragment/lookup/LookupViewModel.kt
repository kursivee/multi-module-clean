package com.kursivee.framework_presentation.fragment.lookup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kursivee.framework_domain.viewmodel.BaseViewModel
import com.kursivee.network_domain.model.IPRequest
import com.kursivee.network_domain.usecase.GetIpInformation
import javax.inject.Inject

class LookupViewModel @Inject constructor(
    private val getIpInformation: GetIpInformation
) : BaseViewModel() {
    private val mutableS: MutableLiveData<String> = MutableLiveData("")
    val s: LiveData<String> = mutableS

    fun getIPInfo(ipAddress: String) {
        request {
            val response = getIpInformation.execute(IPRequest(ipAddress))
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
