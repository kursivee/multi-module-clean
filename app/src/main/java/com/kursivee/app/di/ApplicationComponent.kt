package com.kursivee.app.di

import com.kursivee.framework_data.activity.ActivityDagger
import com.kursivee.network_presentation.NetworkModule
import dagger.Component

@Component(modules = [
    NetworkModule::class
])
@ApplicationScope
interface ApplicationComponent: ActivityDagger.AppGraph