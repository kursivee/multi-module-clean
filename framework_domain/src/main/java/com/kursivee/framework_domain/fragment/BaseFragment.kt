package com.kursivee.framework_domain.fragment

import androidx.fragment.app.Fragment
import com.kursivee.framework_domain.injector.Injector
import com.kursivee.framework_domain.activity.BaseActivity

abstract class BaseFragment<T>: Fragment(), Injector<T> {
    fun showSpinner() {
        (activity as BaseActivity<*>).showSpinner()
    }

    fun hideSpinner() {
        (activity as BaseActivity<*>).hideSpinner()
    }
}