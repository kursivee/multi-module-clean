package com.kursivee.login_presentation.di

import com.kursivee.login_presentation.LoginFragment
import dagger.Subcomponent

object LoginDagger {
    @Subcomponent
    @LoginScope
    interface LoginComponent {
        fun inject(loginFragment: LoginFragment)

        @Subcomponent.Builder
        interface Builder {
            fun build(): LoginComponent
        }
    }

    interface AppGraph {
        fun p3builder(): LoginComponent.Builder
    }
}