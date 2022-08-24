package com.nirwashh.android.cleanarchitectureexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.nirwashh.android.cleanarchitectureexample.databinding.ActivityMainBinding
import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.ShowResultToastUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()
    private val showResultToastUseCase = ShowResultToastUseCase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonSaveUserName = binding.btnGetUserName
        val buttonGetUserName = binding.btnGetUserName

        buttonSaveUserName.setOnClickListener {
            val text = binding.edEnterUserName.text.toString()
            val params = SaveUserNameParam(name = text)
            val result = saveUserNameUseCase.execute(param = params)
            val resultText = showResultToastUseCase.execute(flag = result).text
            binding.tvShowUserName.text = resultText
        }
        buttonGetUserName.setOnClickListener {
            val text = getUserNameUseCase.execute().toString()
            binding.tvShowUserName.text = text
        }
    }
}