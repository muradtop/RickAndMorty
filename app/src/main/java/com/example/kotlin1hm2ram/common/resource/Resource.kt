package com.example.kotlin1hm2ram.common.resource


sealed class Resource<out T>(
    val data: T? = null,
    val message: String? = null,
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data = data, message = message)
}