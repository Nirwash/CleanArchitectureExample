package com.nirwashh.android.cleanarchitectureexample.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nirwashh.android.cleanarchitectureexample.R
import com.nirwashh.android.cleanarchitectureexample.app.App
import com.nirwashh.android.cleanarchitectureexample.data.repository.UserRepositoryImpl
import com.nirwashh.android.cleanarchitectureexample.data.storage.UserStorage
import com.nirwashh.android.cleanarchitectureexample.data.storage.sharedprefs.SharedPrefUserStorage
import com.nirwashh.android.cleanarchitectureexample.databinding.ActivityMainBinding
import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.GetUserNameUseCase
import com.nirwashh.android.cleanarchitectureexample.domain.usecase.SaveUserNameUseCase
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (applicationContext as App).appComponent.inject(mainActivity = this)

        vm = ViewModelProvider(this, vmFactory)[MainViewModel::class.java]

        vm.result.observe(this) { text ->
            binding.tvShowUserName.text = text
        }

        binding.btnSaveUserName.setOnClickListener {
            val input = binding.edEnterUserName.text.toString()
            vm.save(input)
            hideKeyboard(this, binding.edEnterUserName)
        }

        binding.btnGetUserName.setOnClickListener {
            vm.load()
        }
    }


    private fun hideKeyboard(context: Context, view: View) {
        val imm =
            context.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}