package com.nirwashh.android.cleanarchitectureexample.data.repository

import com.nirwashh.android.cleanarchitectureexample.data.storage.models.User
import com.nirwashh.android.cleanarchitectureexample.data.storage.UserStorage
import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.models.UserName
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.firstName, lastName = "")
    }
}