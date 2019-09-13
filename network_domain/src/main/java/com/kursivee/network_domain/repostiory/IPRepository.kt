package com.kursivee.network_domain.repostiory

import arrow.core.Either
import com.kursivee.network_domain.model.IPRequest
import com.kursivee.network_domain.model.IPResponse
import com.kursivee.network_domain.model.NetworkError

interface IPRepository {
    suspend fun getIPInformation(request: IPRequest): Either<NetworkError, IPResponse>
}