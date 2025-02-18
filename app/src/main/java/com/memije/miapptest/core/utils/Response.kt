package com.memije.miapptest.core.utils

sealed class Response<out T> {
    data class Success<T>(val data: T) : Response<T>()
    data class Error(val message: String, val exception: Throwable? = null) : Response<Nothing>()
    data object Loading : Response<Nothing>()
}