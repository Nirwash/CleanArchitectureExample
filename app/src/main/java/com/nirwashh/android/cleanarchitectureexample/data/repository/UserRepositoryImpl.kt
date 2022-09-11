package com.nirwashh.android.cleanarchitectureexample.data.repository

import android.content.Context
import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.models.UserName
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"

class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.firstName).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "") ?: ""
        return UserName(firstName = firstName, lastName = lastName)
    }
}