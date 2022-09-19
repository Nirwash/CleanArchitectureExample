package com.nirwashh.android.cleanarchitectureexample.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.nirwashh.android.cleanarchitectureexample.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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