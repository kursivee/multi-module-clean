package com.kursivee.framework_data.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class DataAdapter<T, VH: CustomViewHolder<T>>(
    private val data: MutableList<T>,
    @LayoutRes private val layoutId: Int
): RecyclerView.Adapter<VH>() {

    abstract fun initViewHolder(view: View, viewType: Int): VH

    override fun getItemCount(): Int = data.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(layoutId, parent, false)
        return initViewHolder(view, viewType)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(data[position])
    }

    fun updateList(data: List<T>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }
}