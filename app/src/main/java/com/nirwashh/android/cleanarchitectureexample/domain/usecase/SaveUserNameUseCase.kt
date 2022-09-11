package com.nirwashh.android.cleanarchitectureexample.domain.usecase

import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName != param.firstName) {
            userRepository.saveName(saveParam = param)
        }
        return true
    }

}