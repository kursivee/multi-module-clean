package com.kursivee.framework_domain.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.kursivee.framework_domain.handler.ProgressBarHandler
import com.kursivee.framework_domain.injector.Injector
import com.kursivee.framework_domain.viewmodel.BaseViewModel

abstract class BaseFragment<T, VM: BaseViewModel>: Fragment(), Injector<T> {
    protected lateinit var vm: VM

    /**
     * Handles triggering the progress bar from activity
     */
    private val progressBarHandler: ProgressBarHandler by lazy {
        (requireActivity() as ProgressBarHandler)
    }
    protected fun startProgress() { progressBarHandler.startProgress() }
    protected fun stopProgress() { progressBarHandler.stopProgress() }

    /**
     * Contains default logic for handling on error or loading
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm.loading.observe {
            if(it) {
                startProgress()
            } else {
                stopProgress()
            }
        }
        vm.error.observe(::onError)
    }

    /**
     * Utility function that wraps viewLifecycleOwner and Observer around lambda
     */
    protected fun <R> LiveData<R>.observe(block: (R) -> Unit) {
        observe(viewLifecycleOwner, Observer {
            block(it)
        })
    }

    /**
     * Overridable function that executes when an error is observed.
     */
    protected open fun onError(message: String) {}
}