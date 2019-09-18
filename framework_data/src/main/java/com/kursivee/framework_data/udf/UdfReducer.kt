package com.kursivee.framework_data.udf

abstract class UdfReducer<A: Action, S: State> {
    abstract fun reduce(state: S, action: A): S
}