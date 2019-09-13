package com.kursivee.framework_domain.application

import android.app.Application
import com.kursivee.framework_domain.injector.Injector

abstract class BaseApplication<T>: Application(), Injector<T> {
}