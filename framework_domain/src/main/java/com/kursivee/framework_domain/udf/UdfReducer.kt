package com.kursivee.framework_domain.udf

abstract class UdfReducer<A: Action, S: State> {
    abstract fun reduce(state: S, action: A): S
}