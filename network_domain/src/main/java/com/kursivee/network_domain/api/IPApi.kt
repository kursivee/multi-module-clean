package com.kursivee.network_domain.api

import arrow.core.Either
import com.kursivee.network_domain.model.IPRequest
import com.kursivee.network_domain.model.IPResponse
import com.kursivee.network_domain.model.NetworkError

interface IPApi {
    suspend fun getIPAddress(ipRequest: IPRequest): Either<NetworkError, IPResponse>
}