package com.kursivee.framework_domain.handler

import android.view.View
import android.widget.ProgressBar

class ActivityProgressBarHandler: ProgressBarHandler {

    private lateinit var progressBar: ProgressBar

    override fun initProgressBarHandler(progressBar: ProgressBar) {
        this.progressBar = progressBar
    }

    override fun startProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun stopProgress() {
        progressBar.visibility = View.GONE
    }
}