package com.kursivee.framework_data.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale

abstract class CustomViewHolder(view: View): RecyclerView.ViewHolder(view) {
    protected fun render(textView: TextView, data: String?) {
        data?.let {
            textView.isVisible = true
            textView.text = data
        } ?: run {
            textView.isVisible = false
        }
    }

    protected fun render(imageView: ImageView, data: String?) {
        data?.let {
            imageView.isVisible = true
            imageView.load(data) {
                scale(Scale.FIT)
            }
        } ?: run {
            imageView.isVisible = false
        }
    }
}