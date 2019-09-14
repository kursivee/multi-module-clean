package com.kursivee.framework_presentation.activity

import com.kursivee.framework_presentation.fragment.lookup.di.LookupDagger
import dagger.Subcomponent

object ActivityDagger {
    @Subcomponent
    @ActivityScope
    interface ActivityComponent: LookupDagger.AppGraph {

        @Subcomponent.Builder
        interface Builder {
            fun build(): ActivityComponent
        }
    }

    interface AppGraph {
        fun p3Builder(): ActivityComponent.Builder
    }
}