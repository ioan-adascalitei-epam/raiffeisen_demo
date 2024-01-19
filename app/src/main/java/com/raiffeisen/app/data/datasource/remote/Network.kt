package com.raiffeisen.app.data.datasource.remote

import com.raiffeisen.app.domain.model.ErrorInfo
import retrofit2.HttpException
import java.net.UnknownHostException
import com.raiffeisen.app.util.Result

suspend fun <T : Any> apiCall(call: suspend () -> T): Result<T> =
    try {
        Result.Success(call())
    } catch (e: Exception) {
        Result.Error(mapError(e))
    }

private fun mapError(e: Exception): ErrorInfo = when (e) {
    is HttpException -> {
        if (e.code() == 404) {
            ErrorInfo.NotFound(e.message())
        } else {
            ErrorInfo.GenericInfo(e.message())
        }
    }

    is UnknownHostException -> ErrorInfo.NoInternet(e.message.orEmpty())
    else -> ErrorInfo.GenericInfo(e.message.orEmpty())
}
