package com.nirwashh.android.cleanarchitectureexample.di

import com.nirwashh.android.cleanarchitectureexample.presentation.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}