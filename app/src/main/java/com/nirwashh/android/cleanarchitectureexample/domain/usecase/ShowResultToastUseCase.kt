package com.nirwashh.android.cleanarchitectureexample.domain.usecase

import com.nirwashh.android.cleanarchitectureexample.domain.models.ResultOfSaving

class ShowResultToastUseCase {

    fun execute(flag: Boolean): ResultOfSaving {
        return if (flag) {
            ResultOfSaving("Name saved")
        } else {
            ResultOfSaving("Nothing saved")
        }
    }
}