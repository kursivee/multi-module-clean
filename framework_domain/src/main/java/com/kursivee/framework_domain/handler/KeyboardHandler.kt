package com.kursivee.framework_domain.handler

import android.app.Activity

interface KeyboardHandler {
    fun initKeyboardHandler(activity: Activity)
    fun hideKeyboard()
}