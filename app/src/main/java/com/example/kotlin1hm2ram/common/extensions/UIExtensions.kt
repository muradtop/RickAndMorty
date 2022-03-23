package com.example.kotlin1hm2ram.common.extensions

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide

fun ImageView.setImage(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)

