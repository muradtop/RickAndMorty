package com.example.kotlin1hm2ram.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil


class BaseDiffUtil<T : BaseDiffModel> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) =
        oldItem.id == newItem.id


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) =
        oldItem == newItem

}