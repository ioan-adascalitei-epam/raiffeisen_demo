package com.raiffeisen.app.util

import com.raiffeisen.app.domain.model.ErrorInfo


sealed class Result<T>(
    val data: T?,
    val error: ErrorInfo?
) {
    data class Success<T>(val info: T) : Result<T>(info, null)
    data class Error<T>(val errorInfo: ErrorInfo?) : Result<T>(null, errorInfo)
}