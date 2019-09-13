package com.kursivee.framework_domain.activity

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.kursivee.framework_domain.injector.Injector

abstract class BaseActivity<T>(
    private val loadingId: Int? = null
): AppCompatActivity(), Injector<T> {
    fun showSpinner() {
        loadingId?.let {
            findViewById<ProgressBar>(it).apply {
                visibility = View.VISIBLE
            }
        }
    }

    fun hideSpinner() {
        loadingId?.let {
            findViewById<ProgressBar>(it).visibility = View.GONE
        }
    }
}