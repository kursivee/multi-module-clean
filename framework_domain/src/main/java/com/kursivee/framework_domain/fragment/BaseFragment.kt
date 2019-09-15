package com.kursivee.framework_domain.fragment

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.kursivee.framework_domain.injector.Injector
import com.kursivee.framework_domain.activity.BaseActivity
import com.kursivee.framework_domain.viewmodel.BaseViewModel

abstract class BaseFragment<T, VM: BaseViewModel>: Fragment(), Injector<T> {
    lateinit var vm: VM

    private fun showSpinner() {
        (activity as BaseActivity<*>).showSpinner()
    }

    private fun hideSpinner() {
        (activity as BaseActivity<*>).hideSpinner()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm.loading.observe(viewLifecycleOwner, Observer {
            if(it) {
                showSpinner()
            } else {
                hideSpinner()
            }
        })
        vm.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            onError()
        })
    }

    open fun onError() {}
}