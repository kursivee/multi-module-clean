package com.kursivee.framework_presentation.activity

import com.kursivee.framework_presentation.fragment.news.di.NewsDagger
import dagger.Subcomponent

object ActivityDagger {
    @Subcomponent
    @ActivityScope
    interface ActivityComponent: NewsDagger.AppGraph {

        @Subcomponent.Builder
        interface Builder {
            fun build(): ActivityComponent
        }
    }

    interface AppGraph {
        fun p3Builder(): ActivityComponent.Builder
    }
}