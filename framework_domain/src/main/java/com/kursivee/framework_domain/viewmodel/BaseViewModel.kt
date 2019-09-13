package com.kursivee.framework_domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {
    protected val mutableLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val loading: LiveData<Boolean> = mutableLoading

    fun request(block: suspend () -> Unit) {
        mutableLoading.postValue(true)
        viewModelScope.launch {
            block()
            mutableLoading.postValue(false)
        }
    }
}