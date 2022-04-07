package com.example.kotlin1hm2ram.base

 import com.example.kotlin1hm2ram.common.resource.Resource
 import kotlinx.coroutines.flow.flow
 import java.lang.Exception

open class BaseRepository {
    protected fun <T> doRequest(
        request: suspend () -> T,
        writeDatabase: suspend (data: T) -> Unit
    ) = flow {
        emit(Resource.Loading())
        try {
            request().let {
                writeDatabase(it)
                emit(Resource.Success(data = it))
            }
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null, message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null, message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }
}
