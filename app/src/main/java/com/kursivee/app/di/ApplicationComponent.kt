package com.kursivee.app.di

import com.kursivee.framework_presentation.activity.ActivityDagger
import com.kursivee.network_presentation.di.NetworkModule
import com.kursivee.network_presentation.di.RetrofitModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    NetworkModule::class,
    RetrofitModule::class
])
@Singleton
interface ApplicationComponent: ActivityDagger.AppGraph