package com.kursivee.framework_presentation.fragment.lookup.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kursivee.framework_presentation.fragment.lookup.LookupViewModel
import com.kursivee.framework_domain.viewmodel.ViewModelFactory
import com.kursivee.framework_domain.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun provdieViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LookupViewModel::class)
    abstract fun provideLookupViewModel(lookupViewModel: LookupViewModel): ViewModel
}