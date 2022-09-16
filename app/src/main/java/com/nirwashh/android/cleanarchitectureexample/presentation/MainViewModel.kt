package com.nirwashh.android.cleanarchitectureexample.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase

class MainViewModel(private val saveUserNameUseCase: SaveUserNameUseCase, private val getUserNameUseCase: GetUserNameUseCase ) : ViewModel() {

    private val resultLiveMutable = MutableLiveData<String>()
    val result: LiveData<String> = resultLiveMutable

    fun save(text: String) {
        val params = SaveUserNameParam(firstName = text)
        val resultData = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "Save result: $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"
    }
}