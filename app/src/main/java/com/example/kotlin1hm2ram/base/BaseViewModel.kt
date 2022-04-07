package com.example.kotlin1hm2ram.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin1hm2ram.common.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel(){
    protected fun <T> Flow<Resource<T>>.collect(
        state: MutableLiveData<T>,
        addition: (() -> Unit)? = null

    ) {

        viewModelScope.launch {
            collect {
                when (it) {
                    is Resource.Loading -> {
                        Log.e("hentai", " ")
                    }
                    is Resource.Error -> {
                        Log.e(" milf", it.message.toString())
                    }
                    is Resource.Success -> {
                        addition?.let { addition() }
                        state.postValue(it.data)

                    }
                }
            }
        }


    }
}
