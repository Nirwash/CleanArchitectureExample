package com.nirwashh.android.cleanarchitectureexample.app

import android.app.Application
import com.nirwashh.android.cleanarchitectureexample.di.AppComponent
import com.nirwashh.android.cleanarchitectureexample.di.AppModule
import com.nirwashh.android.cleanarchitectureexample.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this@App))
            .build()

    }
}