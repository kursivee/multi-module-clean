package com.kursivee.framework_data.udf

import androidx.lifecycle.viewModelScope
import com.kursivee.framework_domain.viewmodel.BaseViewModel
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