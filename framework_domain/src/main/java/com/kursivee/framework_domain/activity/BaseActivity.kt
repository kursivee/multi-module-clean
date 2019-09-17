package com.kursivee.framework_domain.activity

import androidx.appcompat.app.AppCompatActivity
import com.kursivee.framework_domain.injector.Injector
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.kursivee.framework_domain.handler.ActivityKeyboardHandler
import com.kursivee.framework_domain.handler.ActivityProgressBarHandler
import com.kursivee.framework_domain.handler.KeyboardHandler
import com.kursivee.framework_domain.handler.ProgressBarHandler


abstract class BaseActivity<T>(
    @IdRes private val loadingId: Int? = null,
    @LayoutRes private val contentView: Int
): AppCompatActivity(),
    Injector<T>,
    ProgressBarHandler by ActivityProgressBarHandler(),
    KeyboardHandler by ActivityKeyboardHandler() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView)
        initKeyboardHandler(this)
        loadingId?.let { initProgressBarHandler(findViewById(it)) }
    }
}