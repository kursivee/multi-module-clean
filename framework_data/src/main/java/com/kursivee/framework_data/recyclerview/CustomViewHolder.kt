package com.kursivee.framework_data.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale

abstract class CustomViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(data: T)
}

// TODO: Move to better location
fun render(imageView: ImageView, data: String?) {
    data?.let {
        imageView.isVisible = true
        imageView.load(data) {
            scale(Scale.FIT)
        }
    } ?: run {
        imageView.isInvisible = true
    }
}