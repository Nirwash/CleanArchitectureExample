package com.nirwashh.android.cleanarchitectureexample.di

import com.nirwashh.android.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.nirwashh.android.cleanarchitectureexample.data.storage.UserStorage
import com.nirwashh.android.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {
    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}