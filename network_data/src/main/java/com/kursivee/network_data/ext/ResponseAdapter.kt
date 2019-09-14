package com.kursivee.network_data.ext

import arrow.core.Either
import com.kursivee.network_domain.common.model.NetworkError
import retrofit2.Response

inline fun <reified T> Response<*>.adapt(): Either<NetworkError, T> =
    if(isSuccessful) {
        body()?.let {
            Either.right(it as T)
        } ?: Either.left(NetworkError())
    } else {
        Either.left(NetworkError())
    }
