package com.example.kotlin1hm2ram.common.extensions

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

fun <T, D : RecyclerView.ViewHolder> ListAdapter<T, D>.submitData(data: List<T>) {
    val dataList =
        ArrayList<T>(currentList)
    dataList.addAll(data)
    submitList(dataList)
}