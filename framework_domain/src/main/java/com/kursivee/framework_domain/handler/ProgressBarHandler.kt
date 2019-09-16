package com.kursivee.framework_domain.handler

import android.widget.ProgressBar

interface ProgressBarHandler {
    fun initProgressBarHandler(progressBar: ProgressBar)
    fun startProgress()
    fun stopProgress()
}