package com.nirwashh.android.cleanarchitectureexample.domain.usecase

import com.nirwashh.android.cleanarchitectureexample.domain.models.SaveUserNameParam
import com.nirwashh.android.cleanarchitectureexample.domain.models.UserName
import com.nirwashh.android.cleanarchitectureexample.domain.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.kotlin.*

class SaveUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() = reset(userRepository)

    @Test
    fun `should not save data if name was already saved`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        `when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserNameParam(firstName = "test first name")
        val actual = useCase.execute(testParams)
        val expected = true

        assertEquals(expected, actual)

        verify(userRepository, never()).saveName(saveParam = any())
    }

    @Test
    fun `should return true if save was successful`() {
        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        `when`(userRepository.getName()).thenReturn(testUserName)


        val testParams = SaveUserNameParam(firstName = "new first name")

        val expected = true
        `when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)
        val useCase = SaveUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute(testParams)
        assertEquals(expected, actual)
        verify(userRepository, times(1)).saveName(saveParam = testParams)
    }
//    @Test
//    fun `should return false if save was successful`() {
//        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
//        `when`(userRepository.getName()).thenReturn(testUserName)
//
//
//        val testParams = SaveUserNameParam(firstName = "new first name")
//
//        val expected = false
//        `when`(userRepository.saveName(saveParam = testParams)).thenReturn(expected)
//        val useCase = SaveUserNameUseCase(userRepository = userRepository)
//        val actual = useCase.execute(testParams)
//        assertEquals(expected, actual)
//        verify(userRepository, times(1)).saveName(saveParam = testParams)
//    }
//}