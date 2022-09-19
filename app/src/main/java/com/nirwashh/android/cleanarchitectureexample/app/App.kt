package com.nirwashh.android.cleanarchitectureexample.app

import android.app.Application
import com.nirwashh.android.cleanarchitectureexample.di.appModule
import com.nirwashh.android.cleanarchitectureexample.di.dataModule
import com.nirwashh.android.cleanarchitectureexample.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}