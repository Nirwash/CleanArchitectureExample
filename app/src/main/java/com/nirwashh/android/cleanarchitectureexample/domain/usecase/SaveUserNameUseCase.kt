package com.nirwashh.android.cleanarchitectureexample.domain.usecase

import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam) = param.name.isNotEmpty()

}