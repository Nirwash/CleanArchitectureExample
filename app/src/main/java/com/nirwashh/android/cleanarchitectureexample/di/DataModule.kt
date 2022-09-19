package com.nirwashh.android.cleanarchitectureexample.di

import android.content.Context
import com.nirwashh.android.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.nirwashh.android.cleanarchitectureexample.data.storage.UserStorage
import com.nirwashh.android.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}

