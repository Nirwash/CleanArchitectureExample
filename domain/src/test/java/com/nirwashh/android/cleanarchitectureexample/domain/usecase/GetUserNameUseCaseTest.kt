package com.nirwashh.android.cleanarchitectureexample.domain.usecase

import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.models.UserName
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class GetUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @Test
    fun `should return the same data as in repository`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)


        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first name", lastName = "test last name")
        assertEquals(expected, actual)
    }
}