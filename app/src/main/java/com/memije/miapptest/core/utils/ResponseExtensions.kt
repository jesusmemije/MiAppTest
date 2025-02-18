package com.memije.miapptest.core.utils

fun <T, R> Response<T>.map(transform: (T) -> R): Response<R> {
    return when (this) {
        is Response.Success -> Response.Success(transform(this.data))
        is Response.Error -> Response.Error(this.message, this.exception)
        is Response.Loading -> Response.Loading
    }
}
