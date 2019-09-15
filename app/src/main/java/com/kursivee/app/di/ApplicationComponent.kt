package com.kursivee.app.di

import android.content.Context
import com.kursivee.framework_presentation.activity.ActivityDagger
import com.kursivee.network_presentation.di.NetworkModule
import com.kursivee.network_presentation.di.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    NetworkModule::class,
    RetrofitModule::class
])
@Singleton
interface ApplicationComponent: ActivityDagger.AppGraph {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(context: Context): Builder
        fun build(): ApplicationComponent
    }
}