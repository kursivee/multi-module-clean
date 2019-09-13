package com.kursivee.framework_domain.injector.ext

import com.kursivee.framework_domain.injector.Injector

inline fun <reified T> Any.injector(): T =
    (this as Injector<*>).injector as T