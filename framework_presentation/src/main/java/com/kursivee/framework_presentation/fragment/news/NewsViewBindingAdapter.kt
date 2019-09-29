package com.kursivee.framework_presentation.fragment.news

import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object NewsViewBindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(view: ImageView, url: String?) {
        com.kursivee.framework_data.recyclerview.render(view, url)
    }

    @BindingAdapter("renderText")
    @JvmStatic
    fun render(view: TextView, data: String?) {
        data?.let {
            view.isVisible = true
            view.text = data
        } ?: run {
            view.isVisible = false
        }
    }
}