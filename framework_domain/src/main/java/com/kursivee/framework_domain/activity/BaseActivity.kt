package com.kursivee.framework_domain.activity

import androidx.appcompat.app.AppCompatActivity
import com.kursivee.framework_domain.injector.Injector
import android.os.Bundle
import com.kursivee.framework_domain.handler.ActivityKeyboardHandler
import com.kursivee.framework_domain.handler.ActivityProgressBarHandler
import com.kursivee.framework_domain.handler.KeyboardHandler
import com.kursivee.framework_domain.handler.ProgressBarHandler


abstract class BaseActivity<T>(
    private val loadingId: Int? = null
): AppCompatActivity(),
    Injector<T>,
    ProgressBarHandler by ActivityProgressBarHandler(),
    KeyboardHandler by ActivityKeyboardHandler() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initKeyboardHandler(this)
        loadingId?.let { initProgressBarHandler(findViewById(it)) }
    }
}