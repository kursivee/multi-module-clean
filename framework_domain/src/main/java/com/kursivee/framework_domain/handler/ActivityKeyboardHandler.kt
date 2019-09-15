package com.kursivee.framework_domain.handler

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

class ActivityKeyboardHandler: KeyboardHandler {

    private lateinit var activity: Activity
    private lateinit var imm: InputMethodManager

    override fun initKeyboardHandler(activity: Activity) {
        this.activity = activity
        imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    override fun hideKeyboard() {
        val view = activity.currentFocus ?: View(activity)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        view.clearFocus()
    }
}