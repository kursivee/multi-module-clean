package com.kursivee.framework_domain.udf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class UdfStore<A: Action, R: UdfReducer<A, S>, S: State> constructor(
    private val reducer: R,
    defaultState: S
) {
    private val mutableState: MutableLiveData<S> = MutableLiveData(defaultState)
    val state: LiveData<S> = mutableState

    fun dispatch(action: A) {
        reducer.reduce(mutableState.value!!, action).run {
            mutableState.postValue(this)
        }
    }
}