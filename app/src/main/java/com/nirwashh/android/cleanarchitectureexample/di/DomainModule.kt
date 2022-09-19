package com.nirwashh.android.cleanarchitectureexample.di

import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }

}


