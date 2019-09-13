package com.kursivee.framework_data.fragment.lookup.di

import com.kursivee.framework_data.fragment.di.FragmentScope
import com.kursivee.framework_data.fragment.lookup.LookupFragment
import dagger.Subcomponent

object LookupDagger {
    @Subcomponent(
        modules = [
            ViewModelModule::class
        ]
    )
    @FragmentScope
    interface LookupComponent {
        fun inject(lookupFragment: LookupFragment)

        @Subcomponent.Builder
        interface Builder {
            fun build(): LookupComponent
        }
    }

    interface AppGraph {
        fun p3builder(): LookupComponent.Builder
    }
}

