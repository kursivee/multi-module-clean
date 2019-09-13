package com.kursivee.network_domain.usecase

import arrow.core.Either
import com.kursivee.network_domain.model.IPRequest
import com.kursivee.network_domain.model.IPResponse
import com.kursivee.network_domain.model.NetworkError
import com.kursivee.network_domain.repostiory.IPRepository
import javax.inject.Inject

class GetIpInformation @Inject constructor(
    private val repository: IPRepository
): BaseUseCase<Either<NetworkError, IPResponse>, IPRequest>() {
    override suspend fun execute(params: IPRequest): Either<NetworkError, IPResponse> =
        repository.getIPInformation(params)
}