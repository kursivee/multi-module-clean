package com.kursivee.framework_domain.viewmodel

import androidx.lifecycle.viewModelScope
import com.kursivee.framework_domain.udf.Action
import com.kursivee.framework_domain.udf.UdfReducer
import com.kursivee.framework_domain.udf.State
import com.kursivee.framework_domain.udf.UdfStore
import kotlinx.coroutines.launch

abstract class UdfViewModel<A: Action, S: State, R: UdfReducer<A, S>>(
    private val store: UdfStore<A, R, S>
): BaseViewModel() {
    abstract val loadingAction: A
    val state: S
        get() { return store.state.value!! }

    protected fun dispatch(action: A) {
        store.dispatch(action)
    }

    override fun request(block: suspend () -> Unit) {
        dispatch(loadingAction)
        viewModelScope.launch {
            block()
        }
    }
}