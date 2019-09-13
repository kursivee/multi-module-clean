package com.kursivee.app

import com.kursivee.app.di.ApplicationComponent
import com.kursivee.app.di.DaggerApplicationComponent
import com.kursivee.framework_domain.application.BaseApplication

class Application: BaseApplication<ApplicationComponent>() {
    override val injector: ApplicationComponent by lazy {
        DaggerApplicationComponent.create()
    }
}