package com.kursivee.network_data.repository

import arrow.core.Either
import com.kursivee.network_domain.api.IPApi
import com.kursivee.network_domain.model.*
import com.kursivee.network_domain.repostiory.IPRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class IPRepositoryImpl @Inject constructor(
    private val api: IPApi
): IPRepository {
    override suspend fun getIPInformation(request: IPRequest): Either<NetworkError, IPResponse> {
        delay(1000)
        return api.getIPAddress(request)
    }
}