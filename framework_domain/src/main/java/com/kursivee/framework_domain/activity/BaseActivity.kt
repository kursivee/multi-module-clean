package com.kursivee.framework_domain.activity

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.kursivee.framework_domain.injector.Injector
import android.os.Bundle
import com.kursivee.framework_domain.handler.ActivityKeyboardHandler
import com.kursivee.framework_domain.handler.KeyboardHandler


abstract class BaseActivity<T>(
    private val loadingId: Int? = null
): AppCompatActivity(), Injector<T>, KeyboardHandler by ActivityKeyboardHandler() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKeyboardHandler(this)
    }
}