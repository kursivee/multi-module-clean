package com.kursivee.framework_domain.injector

interface Injector<out T> {
    val injector: T
}