package com.nirwashh.android.cleanarchitectureexample.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nirwashh.android.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.nirwashh.android.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }
}