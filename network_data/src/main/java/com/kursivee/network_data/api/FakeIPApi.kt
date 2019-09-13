package com.kursivee.network_data.api

import arrow.core.Either
import com.kursivee.network_domain.api.IPApi
import com.kursivee.network_domain.model.IPRequest
import com.kursivee.network_domain.model.IPResponse
import com.kursivee.network_domain.model.NetworkError
import kotlinx.coroutines.delay
import javax.inject.Inject

class FakeIPApi @Inject constructor(): IPApi {
    override suspend fun getIPAddress(ipRequest: IPRequest): Either<NetworkError, IPResponse> {
        delay(1000)
        return Either.right(IPResponse("123", "type", "host"))
    }
}