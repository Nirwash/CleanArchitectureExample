package com.nirwashh.android.cleanarchitectureexample.data.storage

import com.nirwashh.android.cleanarchitectureexample.data.storage.models.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}