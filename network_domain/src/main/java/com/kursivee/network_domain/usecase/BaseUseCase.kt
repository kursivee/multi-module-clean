package com.kursivee.network_domain.usecase

abstract class BaseUseCase<out T, in P> where T: Any {
    abstract suspend fun execute(params: P): T
}