package com.nirwashh.android.cleanarchitectureexample.domain.usecase

import com.nirwashh.android.cleanarchitectureexample.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "John", lastName = "Doe")
    }
}