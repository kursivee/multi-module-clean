package com.kursivee.framework_data.recyclerview

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kursivee.framework_domain.handler.KeyboardHandler

/**
 * Recycler view that automatically hides keyboard on scroll
 */

class CustomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
): RecyclerView(
    context, attrs, defStyle
) {
    var isHideKeyboard: Boolean = true

    fun init(adapter: Adapter<*>, layoutManager: LayoutManager = LinearLayoutManager(context as Activity)) {
        this.adapter = adapter
        this.layoutManager = layoutManager
        setOnTouchListener { _, _ -> false }
    }

    fun setOnTouchListener(block: (View?, MotionEvent?) -> Boolean) {
        val listener = OnTouchListener { view, motionEvent ->
            if(isHideKeyboard) {
                (context as KeyboardHandler).hideKeyboard()
            }
            block(view, motionEvent)
        }
        super.setOnTouchListener(listener)
    }
}