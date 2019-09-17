package com.kursivee.framework_presentation.fragment.news.di

import com.kursivee.framework_presentation.fragment.di.FragmentScope
import com.kursivee.framework_presentation.fragment.news.NewsFragment
import dagger.Subcomponent

object NewsDagger {
    @Subcomponent(
        modules = [
            ViewModelModule::class,
            UdfModule::class
        ]
    )
    @FragmentScope
    interface NewsComponent {
        fun inject(newsFragment: NewsFragment)

        @Subcomponent.Builder
        interface Builder {
            fun build(): NewsComponent
        }
    }

    interface AppGraph {
        fun p3builder(): NewsComponent.Builder
    }
}

